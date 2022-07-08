package com.generation.pruebarecuperativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.pruebarecuperativa.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    
}
