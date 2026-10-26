package ru.perm.v.family.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

public class PersonDto {

    private Long n = 0L;
    private String name = "";
    private String phone = "";

    public PersonDto() {
    }

    public PersonDto(Long n, String name, String phone) {
        this.n = n;
        this.name = name;
        this.phone = phone;
    }

    public Long getN() {
        return n;
    }

    public void setN(Long n) {
        this.n = n;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(n, personDto.n) && Objects.equals(name, personDto.name) && Objects.equals(phone, personDto.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, name, phone);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "n=" + n +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
