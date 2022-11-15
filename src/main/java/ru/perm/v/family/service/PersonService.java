package ru.perm.v.family.service;

import ru.perm.v.family.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    PersonEntity getById(Long id);

    PersonEntity save(PersonEntity entity);

    List<PersonEntity> findAll();

    void deleteById(Long id);

    void delete(PersonEntity enity);

    void deleteAll();

}
