package com.ejemplo.examen.controller;

import com.ejemplo.examen.model.Matricula;
import com.ejemplo.examen.dto.ResponseBase;
import com.ejemplo.examen.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @PostMapping("/save")
    public ResponseBase<Matricula> save(@RequestBody Matricula matricula) {
        return new ResponseBase<>(200, "Matricula guardada", service.save(matricula));
    }

    @GetMapping("/get/{id}")
    public ResponseBase<?> get(@PathVariable int id) {
        return service.findById(id)
                .map(m -> new ResponseBase<>(200, "Matricula encontrada", m))
                .orElseGet(() -> new ResponseBase<>(404, "Matricula no encontrada", null));
    }
}
