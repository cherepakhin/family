package ru.perm.v.family.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.repository.PersonRepository;
import ru.perm.v.family.service.PersonService;

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
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(0L);
        expectedPerson.setName("-");
        when(mockPersonRepository.getReferenceById(0L)).thenReturn(expectedPerson);
        PersonEntity person = personService.getById(0L);
        assertEquals(expectedPerson,person);
    }

    @Test
    void getByIdMockRepository() {
        Long ID= 0L;
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(ID);
        expectedPerson.setName("-");
        when(mockPersonRepository.getReferenceById(ID)).thenReturn(expectedPerson);

        PersonEntity actualPerson = personService.getById(ID);
        assertEquals(expectedPerson,actualPerson);
        verify(mockPersonRepository, times(1)).getReferenceById(ID);
    }
}