package ru.perm.v.family.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonServiceImpIntegrationTest {
    @Autowired
    PersonRepository personRepository;
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(personRepository);
    }

    @Test
    void getByIdFromRepository() {
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(0L);
        expectedPerson.setName("-");
        PersonEntity person = personRepository.getReferenceById(0L);
        assertEquals(expectedPerson, person);
    }

    @Test
    void getById() {
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(0L);
        expectedPerson.setName("-");
        PersonEntity person = personService.getById(0L);
        assertEquals(expectedPerson, person);
    }
}
