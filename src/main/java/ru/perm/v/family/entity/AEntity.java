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
    @Column(name = "n")
    protected Long n;

    public AEntity() {

    }

    public AEntity(Long n) {
        this();
        this.n = n;
    }

    public Long getN() {
        return this.n;
    }

    public void setN(Long n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof AEntity) {
            AEntity other = (AEntity) o;
            if (!this.getN().equals(other.getN())) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.n);
    }
}
