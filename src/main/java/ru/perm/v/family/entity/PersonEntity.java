package ru.perm.v.family.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PersonEntity extends AEntity {

    @Column(name = "name")
    protected String name = "";

}
