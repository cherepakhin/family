Feature: Проверка echo

  Scenario: Тест echo/aaa
    Given Запрос на dev /family/echo/test_string
    When the request sends GET
    Then the response status is Ok
    And Получена test_string
