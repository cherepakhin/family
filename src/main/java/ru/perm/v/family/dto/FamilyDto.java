package ru.perm.v.family.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class FamilyDto {
    private Long id = 0L;
    private PersonDto husband = new PersonDto();
    private PersonDto wife = new PersonDto();
    private List<PersonDto> childs = new ArrayList<>();
}
