package com.ejemplo.examen.repository;

import com.ejemplo.examen.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
