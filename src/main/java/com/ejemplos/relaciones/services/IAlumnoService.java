package com.ejemplos.relaciones.services;

import com.ejemplos.relaciones.entities.Alumno;
import com.ejemplos.relaciones.entities.Respuesta1;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();
    public Alumno save(Alumno a);
    public List<Respuesta1> findRespuesta1(String a,int b,String c);
    public List<Respuesta1> findRespuesta2(String a,int b,int c);
}
