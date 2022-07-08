package com.generation.pruebarecuperativa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.pruebarecuperativa.models.Paciente;
import com.generation.pruebarecuperativa.repositories.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    //funcion para guardar
    public void savePaciente(@Valid Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    //Nos trae todos los pacientes
    public List<Paciente> findAll() {

        return pacienteRepository.findAll();
    }


}
