package com.microservicios.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.usuarios.models.Alumno;


public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {}
