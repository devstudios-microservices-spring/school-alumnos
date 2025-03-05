package com.microservicios.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.usuarios.models.Alumno;
import com.microservicios.usuarios.repositories.IAlumnoRepository;




@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
