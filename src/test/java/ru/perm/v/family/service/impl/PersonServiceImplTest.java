package ru.perm.v.family.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

class PersonServiceImplTest {

    final PersonRepository mockPersonRepository = mock(PersonRepository.class);
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonServiceImpl(mockPersonRepository);
    }

    @Test
    void getById() {
        Long ID = 0L;
        PersonEntity expectedPerson = new PersonEntity();
        expectedPerson.setId(ID);
        expectedPerson.setName("-");
        when(mockPersonRepository.getById(ID)).thenReturn(expectedPerson);

        PersonEntity person = personService.getById(ID);

        assertEquals(expectedPerson, person);
        verify(mockPersonRepository, times(1)).getById(ID);
    }

    @Test
    public void findAll() {
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.setId(1L);

        PersonEntity personEntity2 = new PersonEntity();
        personEntity2.setId(2L);

        when(mockPersonRepository.findAll()).thenReturn(List.of(personEntity1, personEntity2));

        List<PersonEntity> receivedPersons = personService.findAll();
        assertEquals(2, receivedPersons.size());
    }

    @Test
    public void save() {
        PersonEntity personEntity = new PersonEntity(1L, "NAME_1", "PHONE_1");

        when(mockPersonRepository.save(personEntity)).thenReturn(personEntity);

        PersonEntity savedPerson = personService.save(personEntity);

        assertEquals(personEntity, savedPerson);
        verify(mockPersonRepository, times(1)).save(personEntity);
    }

    @Test
    public void deleteById() {
        Long ID = 1L;

        doNothing().when(mockPersonRepository).deleteById(ID);

        personService.deleteById(ID);

        verify(mockPersonRepository, times(1)).deleteById(ID);
    }
}