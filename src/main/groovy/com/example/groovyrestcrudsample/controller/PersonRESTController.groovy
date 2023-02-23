package com.example.groovyrestcrudsample.controller

import com.example.groovyrestcrudsample.entity.Person
import com.example.groovyrestcrudsample.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/persons")
class PersonRESTController {

    private final PersonService personService

    @Autowired
    PersonRESTController(final PersonService personService) {
        this.personService = personService
    }

    @GetMapping
    Iterable<Person> list() {
        return personService.findAll()
    }

    @PostMapping
    ResponseEntity<Person> update(@RequestBody Person person) {
        var entity = personService.save(person)
        return ResponseEntity.ok(entity as Person)
    }

    @GetMapping("/{id}")
    ResponseEntity<Person> get(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id) as Person)
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        var entity = personService.update(id, person);
        return ResponseEntity.ok(entity as Person)
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        personService.deleteById(id)
    }
}