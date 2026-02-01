package ru.perm.v.family.entity;


import lombok.*;

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

    public PersonEntity(Long id) {
        super(id);
    }

    public PersonEntity(Long id, String name, String phone) {
        super(id);
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
                "id=" + id +
                ", name=" + name +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("this:" + this);
        System.out.println("o:" + o);
        System.out.println("============");
        if (this == o) return true;
        if (!(o instanceof PersonEntity that)) return false;
        System.out.println("o:" + o);
        PersonEntity that1 = (PersonEntity) o;
        System.out.println("that:" + that1);
        if (!super.equals(o)) return false;
        //boolean result = this.id.longValue() == aEntity.getId();
        //if (this.id.longValue()!=o.getId()) return false;
        System.out.println("this.name:" + this.name);
        System.out.println("that.name:" + that.name);
        System.out.println("that1.name:" + that1.name);
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, phone);
    }
}
