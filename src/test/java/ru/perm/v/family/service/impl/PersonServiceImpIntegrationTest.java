package ru.perm.v.family.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Тестовая БД создаётся из schema.sql (копия миграций Flyway),
     * но без строки с n=0, поэтому вставляем её явно.
     */
    @BeforeAll
    public static void setUpData(@Autowired JdbcTemplate jdbc) {
        jdbc.update("MERGE INTO person(n, name, phone) KEY(n) VALUES (0, '-', '-')");
    }
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(personRepository);
    }

    @Test
    void getByIdFromRepository() {
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setN(0L);
        expectedPerson.setName("-");
        expectedPerson.setPhone("-");
        PersonEntity person = personRepository.getReferenceById(0L);
        assertEquals(expectedPerson, person);
    }

    @Test
    void testGetByN() {
        PersonEntity gettedPerson = personService.getByN(0L);

        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setN(0L);
        expectedPerson.setName("-");
        expectedPerson.setPhone("-");
        assertEquals(expectedPerson, gettedPerson);
    }
}
