package ru.perm.v.family.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class PersonDto {
    private Long id = 0L;
    private String name = "";
}
