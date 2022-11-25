package ru.perm.v.family.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
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
@NoArgsConstructor
public abstract class AEntity implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AEntity aEntity = (AEntity) o;
        return id.equals(aEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
