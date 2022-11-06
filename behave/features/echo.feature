Feature: Проверка echo

  Scenario: Тест echo/aaa
    Given Запрос на dev family/echo/aaa
    When the request sends GET
    Then the response status is Ok
    And Получена aaa
