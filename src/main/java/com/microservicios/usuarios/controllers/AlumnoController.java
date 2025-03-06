package com.microservicios.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.usuarios.models.Alumno;
import com.microservicios.usuarios.services.IAlumnoService;



@RestController
public class AlumnoController {


    @Autowired
    private IAlumnoService alumnoService;


    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Alumno> alumno = alumnoService.findById(id);

        if(alumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(alumno.get());
    }

    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
        return ResponseEntity.status(201).body(alumnoService.save(alumno));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> alumnoDb = alumnoService.findById(id);

        if(alumnoDb.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno a = alumnoDb.get();
        a.setName(alumno.getName());
        a.setApellido(alumno.getApellido());
        a.setEmail(alumno.getEmail());

        return ResponseEntity.ok().body(alumnoService.save(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

