package ru.perm.v.family.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "person")
public class PersonEntity extends AEntity {

    @Column(name = "name")
    private String name = "";

    @Column(name = "phone")
    private String phone = "";

    public PersonEntity() {
        super(-1L);
    }

    public PersonEntity(Long n) {
        super(n);
    }

    public PersonEntity(Long n, String name, String phone) {
        super(n);
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonEntity(" +
                "n=" + n +
                ", name=" + name +
                ", phone=" + phone +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonEntity)) return false;
        PersonEntity that = (PersonEntity) o;
        if (!Objects.equals(this.getN(), that.getN())) {
            return false;
        }
        if (!Objects.equals(this.getName(), that.getName())) {
            return false;
        }
        if (!Objects.equals(this.getPhone(), that.getPhone())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.n, this.name, this.phone);
    }
}
