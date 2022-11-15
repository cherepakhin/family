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
        PersonService personServiceMock = new PersonServiceImpl(mockPersonRepository);
        PersonEntity person = personServiceMock.getById(0L);
        assertEquals(expectedPerson,person);
    }

    @Test
    void getByIdMockRepository() {
        PersonRepository mockRepository = mock(PersonRepository.class);
        personService = new PersonServiceImpl(mockRepository);
        Long ID= 0L;
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(ID);
        expectedPerson.setName("-");
        when(mockRepository.getReferenceById(ID)).thenReturn(expectedPerson);

        PersonEntity actualPerson = personService.getById(ID);
        assertEquals(expectedPerson,actualPerson);
        verify(mockRepository, times(1)).getReferenceById(ID);
    }
}