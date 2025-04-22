package com.ejemplo.examen.service;

import com.ejemplo.examen.model.Estudiante;
import com.ejemplo.examen.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public Estudiante save(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Optional<Estudiante> findById(String dni) {
        return repository.findById(dni);
    }
}
