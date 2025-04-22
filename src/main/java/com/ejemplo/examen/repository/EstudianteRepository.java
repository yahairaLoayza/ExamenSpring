package com.ejemplo.examen.repository;

import com.ejemplo.examen.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
