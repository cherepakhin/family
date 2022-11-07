package ru.perm.v.family.entity;


@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PersonEntity extends AEntity {
    @Column(name = "name")
    protected String name = "";
}
