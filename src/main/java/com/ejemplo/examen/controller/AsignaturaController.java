package com.ejemplo.examen.controller;

import com.ejemplo.examen.model.Asignatura;
import com.ejemplo.examen.dto.ResponseBase;
import com.ejemplo.examen.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService service;

    @PostMapping("/save")
    public ResponseBase<Asignatura> save(@RequestBody Asignatura asignatura) {
        return new ResponseBase<>(200, "Asignatura guardada", service.save(asignatura));
    }

    @GetMapping("/get/{id}")
    public ResponseBase<?> get(@PathVariable int id) {
        return service.findById(id)
                .map(a -> new ResponseBase<>(200, "Asignatura encontrada", a))
                .orElseGet(() -> new ResponseBase<>(404, "Asignatura no encontrada", null));
    }
}
