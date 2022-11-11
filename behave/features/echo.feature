Feature: Проверка echo

  Scenario: Тест echo/aaa через http
    Given a request url http://127.0.0.1:8780/api/family/echo/test_string
    When the request sends GET
    Then the response status is Ok
    And Получен текст test_string

