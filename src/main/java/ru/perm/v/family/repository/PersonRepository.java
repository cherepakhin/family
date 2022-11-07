package ru.perm.v.family.repository;

import org.springframework.stereotype.Repository;
import ru.perm.v.family.entity.PersonEntity;

import javax.transaction.Transactional;

/**
 * Интерфейс репозитория для сущности человека
 */
@Repository
@Transactional
public interface PersonRepository extends ARepository<PersonEntity> {

}
