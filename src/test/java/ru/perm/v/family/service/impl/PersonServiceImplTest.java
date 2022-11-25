package ru.perm.v.family.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    PersonRepository mockPersonRepository = mock(PersonRepository.class);
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(mockPersonRepository);
    }

    @Test
    void getById() {
        Long ID = 100L;
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(ID);
        expectedPerson.setName("--");
        when(mockPersonRepository.getReferenceById(ID)).thenReturn(expectedPerson);

        PersonEntity person = personService.getById(ID);

        assertEquals(expectedPerson, person);
        verify(mockPersonRepository, times(1)).getReferenceById(ID);
    }
}