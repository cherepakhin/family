# BDD тестирование

Для проведения тестирования нужно установить python >3.6

Использован  
- [behave](https://behave.readthedocs.io/en/stable/)
- [allure](https://docs.qameta.io/allure/)

### Установка
```shell script
pip3 install -r requirements.txt
```

Настройка хоста в файле [features/conf.yaml](features/conf.yaml)

### Запуск тестов

Выполнять в каталоге **behave(!!!)**. Результаты тестов будут в каталоге reports

````shell script
cd behave
behave -f allure_behave.formatter:AllureFormatter -o reports
allure serve reports/
````
---
Пободался с behave. Разрулил так

````bash
pip3 install FullLoader
pip3 install -U PyYAML
````

