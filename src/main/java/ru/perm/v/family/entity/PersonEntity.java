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
@EqualsAndHashCode(callSuper = true)
public class PersonEntity extends AEntity {

    @Column(name = "name")
    protected String name = "";

    public PersonEntity(Long id, String name) {
        super(id);
        if (Objects.nonNull(name)) {
            if (!name.isEmpty()) {
                this.name = name;
            }
        }
    }

    @Override
    public String toString() {
            return "PersonEntity(" +
                    "id=" + id +
                    ", name=" + name +
                    ')';
    }
}
