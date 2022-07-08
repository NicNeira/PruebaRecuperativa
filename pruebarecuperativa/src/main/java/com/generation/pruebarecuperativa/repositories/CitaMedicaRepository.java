package com.generation.pruebarecuperativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.pruebarecuperativa.models.CitaMedica;

@Repository
public interface CitaMedicaRepository extends JpaRepository < CitaMedica, Long> {
    
}
