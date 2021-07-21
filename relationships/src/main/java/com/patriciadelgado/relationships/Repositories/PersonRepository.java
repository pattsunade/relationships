package com.patriciadelgado.relationships.Repositories;

import java.util.List;

import com.patriciadelgado.relationships.Models.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
    List<Person> findAll();
}
