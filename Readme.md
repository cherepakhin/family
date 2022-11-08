#### Тестовый проект "Семья". 

Поженить двух людей ( People ). Мужчину и женщину. Пусть нарожают детей.

План: Mockito, error controller, db, kafka, Spring Security, Camunda.<br/>

Сделано:
 rest, behave, allure, Swagger(OpenApi), actuator (monitoring)

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
#### Логгирование
Настройка в [application.yaml](src/main/resources/application.yaml)
````
logging:
  level:
    root: info
  file:
    name: log/app.log
````
Логи будут в log/api.log
И также по через [http://127.0.0.1:8780/api/log](http://127.0.0.1:8780/api/log)
<br/> [http://127.0.0.1:8781/actuator/logfile](http://127.0.0.1:8781/actuator/logfile) <br/>
Не всегда есть доступ к логам. Поэтому показаны несколько способов.
#### Behave тесты (они же интеграционные)
Сделаны с помощью утилиты [behave](https://behave.readthedocs.io/en/stable/).
Настройки и сами тесты лежат в папке [/behave](https://github.com/cherepakhin/family/tree/dev/behave) 

Запуск тестов
````
cd behave
behave
````
[результаты](/behave/doc/behave.png)

Красиво посмотреть на результаты 
````
cd behave
allure serve reports/
````
Откроется браузер со страницей результатов тестирования
![страницей результатов тестирования](/behave/doc/allure.png)

#### Документация javadoc
Генерация
````shell
mvn javadoc:javadoc
````
Документация будет сгенерирована в [target/site/apidocs/index.html](/target/site/apidocs/index.html)

#### Swagger
Запустить приложение
````shell
 mvn spring-boot:run
````
Документация будет доступна<br/>
В формате swagger [http://127.0.0.1:8780/api/swagger-ui/index.html]http://127.0.0.1:8780/api/swagger-ui/index.html)
<br/>
В формате OpenApi [http://127.0.0.1:8780/api/v3/api-docs](http://127.0.0.1:8780/api/v3/api-docs)

#### Мониторинг
Actuator spring
http://127.0.0.1:8781/actuator <br/>
Метрики для prometeus
http://127.0.0.1:8781/actuator/health
