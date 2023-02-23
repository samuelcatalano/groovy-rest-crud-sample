package com.example.groovyrestcrudsample.repository

import com.example.groovyrestcrudsample.entity.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository extends CrudRepository<Person, Long> {
}
