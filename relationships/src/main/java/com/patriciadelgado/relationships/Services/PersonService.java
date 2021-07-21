package com.patriciadelgado.relationships.Services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.relationships.Models.Person;
import com.patriciadelgado.relationships.Repositories.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPerson() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
           return optionalPerson.get(); 
       } else {
           return null;
        }
        
    }

}
