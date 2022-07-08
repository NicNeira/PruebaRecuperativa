package com.generation.pruebarecuperativa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.pruebarecuperativa.models.CitaMedica;
import com.generation.pruebarecuperativa.repositories.CitaMedicaRepository;

@Service
public class CitaMedicaService {
    @Autowired
    CitaMedicaRepository citaMedicaRepository;

    public void saveCitaMedica(@Valid CitaMedica citaMedica) {
        citaMedicaRepository.save(citaMedica);
    }

    public List<CitaMedica> findAll() {
        return citaMedicaRepository.findAll();
    }
}
