import json
import datetime
import os
import webbrowser
from pprint import pprint

from behave import given, use_step_matcher, then, step, when
import jsonpath_ng
from jsonpath_ng.ext import parse
import requests
import behave_restful._lang_imp.response_validator as _validate
import time
dev_host='http://127.0.0.1:8780'
use_step_matcher("parse")


@given('Запрос на dev {test_url}')
def step_impl(context, test_url):
  context.execute_steps(
      'given a request url {}{}'.format(dev_host, test_url))


@given('Запрос с переменными на dev {test_url}')
def step_impl(context, test_url):
  global saved_vars
  print(saved_vars)
  req = test_url.format_map(saved_vars)
  context.execute_steps(
      'given a request url {}{}'.format(dev_host, req))


@then('Показать ответ')
def step_impl(context):
  # assert context.response.status_code == 200
  print('Получена строка:', context.response.text)

@then('Получена {mes}')
def step_impl(context, mes):
  assert context.response.status_code == 200
  # print('Получена строка:', context.response.text)
  # print('Ожидалось:', mes)
  assert context.response.text == mes, 'Получено %s не равно %s' % (
    context.response.text, mes)


@then('Получен какой-то json')
def step_impl(context):
  assert context.response.status_code == 200
  # print(context.response.text)
  print(json.dumps(json.loads(context.response.text), indent=2, ensure_ascii=False))

@then('Получен текст {text}')
def step_impl(context, text):
  assert context.response.status_code == 200
  # print('Получена строка:', context.response.text, 'Ожидалось:', text)
  assert context.response.text == text, 'Получено %s не равно %s' % (
    context.response.text, text)


@then('Ничего не получено')
def step_impl(context):
  assert context.response.status_code == 200
  print('Получена строка:', context.response.text)
  assert len(context.response.text) == 0, 'Получено %s' % (
    context.response.text)


@then('Не пустая')
def step_impl(context):
  assert context.response.status_code == 200
  # print(context.response.text)
  assert len(context.response.text) > 0, 'Получено %s' % (context.response.text)


@then('В ответе есть строка')
def step_impl(context):
  assert context.response.status_code == 200
  print('Получена строка:', context.response.text)
  substring = context.vars.resolve(context.text)
  print("Ожидалось:", substring.strip())
  assert substring.strip() in context.response.text, 'Строка %s не найдена в %s' % (
    substring, context.response.text)


@step("В json {path} равно {test_val}")
def step_impl(context, path, test_val):
  context.json = json.loads(context.response.text)
  # print(json.dumps(context.json, indent=2, ensure_ascii=False))
  jsonpath_expression = parse(path)
  matches = jsonpath_expression.find(context.json)
  assert len(matches) > 0, 'Ничего не нашлось %s' % path
  list_match_vals = ','.join(str(v.value) for v in matches)
  print(list_match_vals)
  assert list_match_vals == test_val, 'Полученое %s не равно %s' % (
    list_match_vals, test_val)


@step("Кол-во элементов в json {path} равно {test_val}")
def step_impl(context, path, test_val):
  context.json = json.loads(context.response.text)
  # print(json.dumps(context.json, indent=2, ensure_ascii=False))
  jsonpath_expression = jsonpath_ng.parse(path)
  match = jsonpath_expression.find(context.json)
  actual_len = str(len(match[0].value))
  assert actual_len == test_val, 'Получено %s не равно %s' % (
    actual_len, test_val)


@then('Ответ по схеме в файле {file_schema}')
def step_impl(context, file_schema):
  f = open(file_schema, "r")
  schema = f.read()
  f.close()
  _validate.response_json_matches(context.response, schema)


@step('сохранить {path} в {context_var}')
def step_impl(context, path, context_var):
  global saved_vars
  try:
    saved_vars
  except NameError:
    saved_vars = dict()

  context.json = json.loads(context.response.text)

  jsonpath_expression = jsonpath_ng.parse(path)
  match = jsonpath_expression.find(context.json)
  saved_vars[context_var] = match[0].value


@step('вызвать {path}')
def step_impl(context, path):
  global saved_vars
  print('---------')
  print(saved_vars)
  req = path.format_map(saved_vars)
  test_url = 'given a request url {}{}'.format(dev_host, req)
  context.execute_steps(
      'given a request url {}'.format(context.settings['dev_host'], test_url))


@then('Дата из {path} сегодня')
def step_impl(context, path):
  context.json = json.loads(context.response.text)
  jsonpath_expression = parse(path)
  matches = jsonpath_expression.find(context.json)
  assert len(matches) > 0, 'Ничего не нашлось %s' % path
  actual_ddate = matches[0].value
  today = datetime.datetime.utcnow().date()
  assert today.strftime('%Y-%m-%d') in actual_ddate


@then('Название заказа {name} соответствует дате {ddate}')
def step_impl(context, name, ddate):
  context.json = json.loads(context.response.text)

  jsonpath_name = parse(name)
  matches_name = jsonpath_name.find(context.json)
  assert len(matches_name) > 0, 'Ничего не нашлось name %s' % name
  actual_name = matches_name[0].value[:8]

  jsonpath_ddate = parse(ddate)
  matches_ddate = jsonpath_ddate.find(context.json)
  assert len(matches_ddate) > 0, 'Ничего не нашлось ddate %s' % ddate
  actual_ddate = matches_ddate[0].value.replace('-', '')[:8]
  assert actual_name == actual_ddate, 'Полученое %s не равно %s' % (
    actual_name, actual_ddate)


@when("Загрузить файл {file}")
def step_impl(context, file):
  # context.request_params
  files = {'file': open(file, 'rb')}
  context.response = requests.post(context.request_url, files=files, headers=context.request_headers)


@then('Полученный файл по {url} равен {file}')
def step_impl(context, url, file):
  download_url = '{}{}'.format(dev_host, url)
  r = requests.get(download_url, headers=context.request_headers)
  assert r.status_code == 200
  f = open(file, 'r')
  assert r.text == f.read()


@then('Подождать {sec} сек')
def step_impl(context, sec):
  time.sleep(int(sec))


@then('Показать файл')
def step_impl(context):
  temp_file = "temp/file.pdf"
  f = open(temp_file, "wb")
  f.write(context.response.content)
  f.close()
  webbrowser.open(r'file://' + os.path.abspath(temp_file))
