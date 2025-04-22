package com.ejemplo.examen.controller;

import com.ejemplo.examen.model.Curso;
import com.ejemplo.examen.dto.ResponseBase;
import com.ejemplo.examen.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping("/save")
    public ResponseBase<Curso> save(@RequestBody Curso curso) {
        return new ResponseBase<>(200, "Curso guardado", service.save(curso));
    }

    @GetMapping("/get/{id}")
    public ResponseBase<?> get(@PathVariable int id) {
        return service.findById(id)
                .map(c -> new ResponseBase<>(200, "Curso encontrado", c))
                .orElseGet(() -> new ResponseBase<>(404, "Curso no encontrado", null));
    }
}
