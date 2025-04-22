package com.ejemplo.examen.controller;

import com.ejemplo.examen.model.Estudiante;
import com.ejemplo.examen.dto.ResponseBase;
import com.ejemplo.examen.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping("/save")
    public ResponseBase<Estudiante> save(@RequestBody Estudiante estudiante) {
        return new ResponseBase<>(200, "Estudiante guardado", service.save(estudiante));
    }

    @GetMapping("/get/{dni}")
    public ResponseBase<?> get(@PathVariable String dni) {
        return service.findById(dni)
                .map(e -> new ResponseBase<>(200, "Estudiante encontrado", e))
                .orElseGet(() -> new ResponseBase<>(404, "Estudiante no encontrado", null));
    }
}
