package com.ejemplo.examen.repository;

import com.ejemplo.examen.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
}
