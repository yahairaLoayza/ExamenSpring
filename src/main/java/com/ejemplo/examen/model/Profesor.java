package com.ejemplo.examen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profesor {
    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    // Getters and setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
