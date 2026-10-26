package ru.perm.v.family.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.mapper.MapperPerson;
import ru.perm.v.family.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер семьи
 */
@RestController
@RequestMapping("/person")
@Slf4j
@Validated
@Api(tags = "Person Controller")
public class PersonCtrl {

    @Autowired
    PersonService personService;

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

    @GetMapping("/n/{n}")
    public ResponseEntity<?> getByN(
            @ApiParam("N person") @PathVariable Long n) {
        log.info("Request n={}", n);
        if (n == null) {
            String error = "n is null";
            log.error(error);
            return ResponseEntity.internalServerError().body(error);
        }
        PersonEntity personEntity = personService.getByN(n);
        PersonDto personDto = MapperPerson.toDto(personEntity);
        return ResponseEntity.ok(personDto);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Добавить нового человека", notes = "Создает новый объект PersonEntity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Человек успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    public ResponseEntity<?> add(
            @ApiParam("Объект PersonDto для добавления") @Valid @RequestBody PersonDto personDto) {
        log.info("Request to add person: {}", personDto);
        try {
            PersonEntity personEntity = MapperPerson.toEntity(personDto);
            PersonEntity savedEntity = personService.save(personEntity);
            PersonDto responseDto = MapperPerson.toDto(savedEntity);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            log.error("Error saving person: ", e);
            return ResponseEntity.badRequest().body("Error saving person: " + e.getMessage());
        }
    }

    @PostMapping("/add-all")
    @ApiOperation(value = "Добавить список людей", notes = "Создает несколько объектов PersonEntity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список людей успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    public ResponseEntity<?> addAll(
            @ApiParam("Список объектов PersonDto для добавления") @Valid @RequestBody List<PersonDto> personDtos) {
        log.info("Request to add {} persons", personDtos.size());
        try {
            List<PersonDto> savedDtos = personDtos.stream()
                    .map(dto -> {
                        PersonEntity entity = MapperPerson.toEntity(dto);
                        PersonEntity saved = personService.save(entity);
                        return MapperPerson.toDto(saved);
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(savedDtos);
        } catch (Exception e) {
            log.error("Error saving persons: ", e);
            return ResponseEntity.badRequest().body("Error saving persons: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Получить всех людей", notes = "Возвращает список PersonDto")
    public ResponseEntity<List<PersonDto>> getAll() {
        log.info("Request to get all persons");
        List<PersonEntity> entities = personService.findAll();
        List<PersonDto> dtos = entities.stream()
                .map(MapperPerson::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}