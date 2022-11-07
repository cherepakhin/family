/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

package ru.perm.v.family.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.perm.v.family.entity.AEntity;

/**
 * Абстрактный интерфейс для репозиториев сущностей c уникальным id
 */
@NoRepositoryBean
public interface ARepository<E extends AEntity> extends JpaRepository<E, Long> {

}
