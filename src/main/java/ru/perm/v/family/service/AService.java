/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

package ru.perm.v.family.service;

import java.util.List;
import ru.mts.dealer.persist.entity.AEntity;

/**
 * Интерфейс сервиса сущностей с уникальным полем id
 *
 * @param <E> сущность
 */
public interface AService<E extends AEntity> {

    E getById(Long id);

    E save(E entity);

    List<E> findAll();

    void deleteById(Long id);

    void delete(E enity);

    void deleteAll();
}