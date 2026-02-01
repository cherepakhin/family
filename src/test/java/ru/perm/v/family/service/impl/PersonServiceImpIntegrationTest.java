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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testGetById() {
        PersonEntity gettedPerson = personService.getById(0L);

        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(0L);
        expectedPerson.setName("-");
        System.out.println("------------------");
        System.out.println("gettedPerson: " + gettedPerson);
        System.out.println("expectedPerson: " + expectedPerson);
        System.out.println("equals:" + gettedPerson.equals(expectedPerson));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        //assertTrue(expectedPerson.equals(gettedPerson));
        assertEquals(expectedPerson, gettedPerson);;
        //assertEquals(expectedPerson, person);
    }
}
