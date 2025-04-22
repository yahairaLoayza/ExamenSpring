package com.ejemplo.examen.service;

import com.ejemplo.examen.model.Profesor;
import com.ejemplo.examen.repository.ProfesorRepository;
import com.ejemplo.examen.dto.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public ResponseBase<Profesor> saveProfesor(Profesor p) {
        profesorRepository.save(p);
        return new ResponseBase<>(200, "Profesor guardado", p);
    }

    public ResponseBase<Profesor> getProfesor(String dni) {
        return profesorRepository.findById(dni)
                .map(p -> new ResponseBase<>(200, "Profesor encontrado", p))
                .orElseGet(() -> new ResponseBase<>(404, "Profesor no encontrado", null));
    }
}
