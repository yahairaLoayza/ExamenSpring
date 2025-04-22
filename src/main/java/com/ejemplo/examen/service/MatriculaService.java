package com.ejemplo.examen.service;

import com.ejemplo.examen.model.Matricula;
import com.ejemplo.examen.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    public Matricula save(Matricula matricula) {
        return repository.save(matricula);
    }

    public Optional<Matricula> findById(int id) {
        return repository.findById(id);
    }
}
