package ru.perm.v.family.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.perm.v.family.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    PersonEntity getByN(Long n);

    PersonEntity save(PersonEntity entity);

    List<PersonEntity> findAll();

    void deleteByN(Long n);

    void delete(PersonEntity enity);

    void deleteAll();

}
