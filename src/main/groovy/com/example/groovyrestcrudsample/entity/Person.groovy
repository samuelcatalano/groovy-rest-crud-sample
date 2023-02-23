package com.example.groovyrestcrudsample.entity

import com.example.groovyrestcrudsample.entity.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "person")
class Person extends BaseEntity{

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "age")
    Integer age;
}
