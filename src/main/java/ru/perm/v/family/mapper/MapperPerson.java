package ru.perm.v.family.mapper;

import ru.perm.v.family.dto.PersonDto;
import ru.perm.v.family.entity.PersonEntity;

public class MapperPerson {

    public static PersonDto toDto(PersonEntity personEntity) {
        return new PersonDto(personEntity.getId(), personEntity.getName(), personEntity.getPhone());
    }

    public static PersonEntity toEntity(PersonDto personDto) {
        return new PersonEntity(personDto.getId(), personDto.getName(), personDto.getPhone());
    }
}
