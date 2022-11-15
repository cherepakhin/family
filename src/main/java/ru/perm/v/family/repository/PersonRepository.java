package ru.perm.v.family.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.perm.v.family.entity.PersonEntity;

/**
 * Интерфейс репозитория для сущности человека
 */
@Repository
@Transactional
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
