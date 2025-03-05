package com.microservicios.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.microservicios.usuarios.models.Alumno;



public interface IAlumnoService {
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
}
