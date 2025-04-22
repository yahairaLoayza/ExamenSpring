package com.ejemplo.examen.controller;

import com.ejemplo.examen.dto.ResponseBase;
import com.ejemplo.examen.model.Profesor;
import com.ejemplo.examen.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping("/save")
    public ResponseBase<Profesor> save(@RequestBody Profesor profesor) {
        return profesorService.saveProfesor(profesor);
    }

    @GetMapping("/get/{dni}")
    public ResponseBase<Profesor> get(@PathVariable String dni) {
        return profesorService.getProfesor(dni);
    }
}
