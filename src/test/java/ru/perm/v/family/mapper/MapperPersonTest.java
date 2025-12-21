package ru.perm.v.family.mapper;

import org.junit.jupiter.api.Test;
import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperPersonTest {
    @Test
    void toDto() {
        Long ID = 1L;
        String NAME = "test";
        PersonEntity personEntity1 = new PersonEntity(ID, NAME);

        PersonDto dto = MapperPerson.toDto(personEntity1);

        assertEquals(personEntity1.getId(), dto.getId());
        assertEquals(personEntity1.getName(), dto.getName()
        );
    }

    @Test
    void toEntity() {
        Long ID = 1L;
        String NAME = "test";
        PersonDto personDto = new PersonDto(ID, NAME);

        PersonEntity entity = MapperPerson.toEntity(personDto);

        assertEquals(ID, entity.getId());
        assertEquals(NAME, entity.getName());
    }
}
