package ru.perm.v.family.repository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.perm.v.family.entity.PersonEntity;

/**
 * Интерфейс репозитория для сущности человека
 */
@Repository
@Transactional
public interface PersonRepository extends ARepository<PersonEntity> {

}
