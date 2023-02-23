package com.example.groovyrestcrudsample.service.impl

import com.example.groovyrestcrudsample.entity.Person
import com.example.groovyrestcrudsample.repository.PersonRepository
import com.example.groovyrestcrudsample.service.PersonService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl implements PersonService<Person> {

    private final PersonRepository personRepository;

    @Autowired
    PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository
    }

    @Override
    Person save(final Person entity) throws Exception {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null!")
        }

        try {
            return this.personRepository.save(entity)
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error while saving the entity!", e)
        }
    }

    @Override
    Person update(final Long id, final Person entity) throws Exception {
        var savedPerson = this.personRepository.findById(id)
                                 .orElseThrow(() -> new EntityNotFoundException("Entity not found!"))

        savedPerson.firstName  = entity.firstName
        savedPerson.lastName   = entity.lastName
        savedPerson.age        = entity.age

        try {
            return this.personRepository.save(savedPerson)
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error while updating the entity!", e)
        }
    }

    @Override
    Person findById(final Long id) throws Exception {
        return this.personRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Entity not found!"))
    }

    @Override
    Iterable<Person> findAll() throws Exception {
        return this.personRepository.findAll();
    }

    @Override
    void deleteById(final Long id) throws Exception {
        var person = this.personRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Entity not found!"))
        try {
            this.personRepository.deleteById(person.id)
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error while deleting the entity by its id!", e)
        }
    }
}
