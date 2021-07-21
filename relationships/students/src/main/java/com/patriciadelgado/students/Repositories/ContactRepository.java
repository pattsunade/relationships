package com.patriciadelgado.students.Repositories;

import java.util.List;

import com.patriciadelgado.students.Models.Contact;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAll();
    
}
