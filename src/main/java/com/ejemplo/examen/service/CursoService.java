package com.ejemplo.examen.service;

import com.ejemplo.examen.model.Curso;
import com.ejemplo.examen.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public Optional<Curso> findById(int id) {
        return repository.findById(id);
    }
}
