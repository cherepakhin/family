/*
 * Copyright (c) 2021 MTS http://mts.ru
 */

package ru.perm.v.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Абстрактная сущность id сущностей
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler",
    "fieldHandler"}, ignoreUnknown = true)
@MappedSuperclass
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public abstract class AEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected
    Long id;

    public AEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
