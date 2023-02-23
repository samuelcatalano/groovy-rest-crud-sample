package com.example.groovyrestcrudsample.service

import com.example.groovyrestcrudsample.entity.base.BaseEntity

interface PersonService<E extends BaseEntity> {

    E save(E entity) throws Exception;
    E update(Long id, E entity) throws Exception;
    E findById(Long id) throws Exception;
    Iterable<E> findAll() throws Exception;
    void deleteById(Long id) throws Exception;
}