#### Тестовый проект "Семья". 

Поженить двух людей ( People ). Мужчину и женщину. Пусть нарожают детей.

План:
db, rest, kafka, Spring Security, Swagger<br/>
Сделано:
db, rest, behave, allure
#### Тесты
Echo тест
````
http GET :8888/api/family/echo/aaa
HTTP/1.1 200 
Connection: keep-alive
Content-Length: 3
Content-Type: text/plain;charset=UTF-8
Date: Fri, 21 Oct 2022 12:10:43 GMT
Keep-Alive: timeout=60

aaa
````

#### Работа с БД
Подключение
````
psql -U familyuser  --dbname=family --host=192.168.1.20 -W
````

Используется инструмент наката изменений в БД с использованием maven: [flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven).

Скрипты flyway находятся в папке [src/resources/db/migration/](https://github.com/cherepakhin/family/tree/master/src/main/resources/db/migration)  
Накат изменений в БД
````
mvn flyway:migrate
````

#### Behave тесты (они же интеграционные)
Сделаны с помощью утилиты [behave](https://behave.readthedocs.io/en/stable/) .<br/>
Настройки и сами тесты лежат в папке [src/behave/](https://github.com/cherepakhin/family/tree/master/src/behave/) 

Запуск тестов
````
cd behave
behave
````
![результаты](/behave/doc/behave.png)

Красиво посмотреть на результаты 
````
allure serve reports/
````
Откроется браузер со страницей результатов тестирования
![страницей результатов тестирования](/behave/doc/allure.png)

