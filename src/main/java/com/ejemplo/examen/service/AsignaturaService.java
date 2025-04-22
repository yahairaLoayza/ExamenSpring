package com.ejemplo.examen.service;

import com.ejemplo.examen.model.Asignatura;
import com.ejemplo.examen.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository repository;

    public Asignatura save(Asignatura asignatura) {
        return repository.save(asignatura);
    }

    public Optional<Asignatura> findById(int id) {
        return repository.findById(id);
    }
}