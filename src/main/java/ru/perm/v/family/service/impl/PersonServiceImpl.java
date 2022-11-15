package ru.perm.v.family.service.impl;

import org.springframework.stereotype.Service;
import ru.perm.v.family.entity.PersonEntity;
import ru.perm.v.family.repository.PersonRepository;
import ru.perm.v.family.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonEntity getById(Long id) {
        return personRepository.getReferenceById(id);
    }

    @Override
    public PersonEntity save(PersonEntity entity) {
        return personRepository.save(entity);
    }

    @Override
    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void delete(PersonEntity enity) {
        personRepository.delete(enity);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
