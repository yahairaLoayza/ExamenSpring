package com.ejemplo.examen.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula_id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate fechaInscripcion = LocalDate.now();

    public int getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(int matricula_id) {
        this.matricula_id = matricula_id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
