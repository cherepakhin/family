package ru.perm.v.family.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perm.v.family.service.PersonService;

/**
 * Контроллер семьи
 */
@RestController
@RequestMapping("/person")
@Slf4j
@Validated
@Api(tags = "Person Controller")
public class PersonCtrl {

//    @Autowired
//    @Qualifier("personService")
//    PersonService personService;

//    public PersonCtrl(PersonFacadeService personFacadeService) {
//        this.personFacadeService = personFacadeService;
//    }

    /**
     * Эхо контроллер для теста
     *
     * @param mes сообщение для теста. Любая строка.
     * @return принятое сообщение
     */
    @GetMapping("/echo/{mes}")
    @ApiOperation(value = "Простой echo запрос", notes = "Для проверки жив/нет")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Все OK (простая демонстрация аннотации @ApiResponse)")
    })
    public String echo(
        @ApiParam("любая тестовая строка. Должна вернуться в ответе.") @PathVariable String mes) {
        log.info("Request \"echo\" received: {}", mes);
        return mes;
    }
}
