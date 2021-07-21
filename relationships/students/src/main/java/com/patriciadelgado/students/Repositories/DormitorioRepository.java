package com.patriciadelgado.students.Repositories;

import java.util.List;

import com.patriciadelgado.students.Models.Dormitorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitorioRepository extends CrudRepository <Dormitorio, Long> {
     List<Dormitorio> findAll();
}
