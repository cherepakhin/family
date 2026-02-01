package ru.perm.v.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static java.lang.String.format;

/**
 * Абстрактная сущность id сущностей
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler",
    "fieldHandler"}, ignoreUnknown = true)
@MappedSuperclass
@ToString
public abstract class AEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public AEntity() {
        this.id = -1L;
    }

    public AEntity(Long id) {
        this.id = id;
        System.out.println(format("AEntity(Long id) id: %s", id));
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        AEntity aEntity = (AEntity) o;
        System.out.println(format("aEntity.id: %s", ((AEntity) o).getId()));
        System.out.println(format("this.id: %s", this.id));
        boolean result = this.id.longValue() == aEntity.getId();
        System.out.println(format("Equals: %s", result));
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
