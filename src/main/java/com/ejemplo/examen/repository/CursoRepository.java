package com.ejemplo.examen.repository;

import com.ejemplo.examen.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}