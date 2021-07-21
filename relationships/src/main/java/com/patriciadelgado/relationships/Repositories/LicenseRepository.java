package com.patriciadelgado.relationships.Repositories;

import java.util.List;

import com.patriciadelgado.relationships.Models.License;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
    
    List<License> findAll();
}
