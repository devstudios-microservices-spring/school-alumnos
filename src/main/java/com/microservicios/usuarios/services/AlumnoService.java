package com.microservicios.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.usuarios.models.Alumno;
import com.microservicios.usuarios.repositories.IAlumnoRepository;




@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository repository;


    @Override
    public List<Alumno> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
