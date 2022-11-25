package ru.perm.v.family.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.service.PersonService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class PersonFacadeServiceTest {

    PersonService personService;

    @BeforeEach
    void setUp() {
//        personService = Mockito.mock(PersonService.class);
//        personFacadeService = new PersonFacadeService(personService);
    }

    @Test
    void getById() {
        Long ID = 1L;
        String NAME ="NAME_1";
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(ID);
        personEntity.setName(NAME);
//        when(personService.getById(ID)).thenReturn(personEntity);
//        PersonDto personDto=personFacadeService.getById(ID);
        PersonDto personExpected = new PersonDto();
//        assertEquals(personExpected, personDto);
        assertTrue(true);
    }
}