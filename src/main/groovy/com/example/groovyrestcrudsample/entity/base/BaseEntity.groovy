package com.example.groovyrestcrudsample.entity.base

import jakarta.persistence.*

@MappedSuperclass
abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

}