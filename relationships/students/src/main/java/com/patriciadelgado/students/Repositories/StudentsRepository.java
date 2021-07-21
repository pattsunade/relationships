package com.patriciadelgado.students.Repositories;

import java.util.List;

import com.patriciadelgado.students.Models.Students;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Long> {
    List<Students> findAll();
}
