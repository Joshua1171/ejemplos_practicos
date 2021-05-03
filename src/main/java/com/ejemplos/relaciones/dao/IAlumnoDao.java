package com.ejemplos.relaciones.dao;

import com.ejemplos.relaciones.entities.Alumno;
import com.ejemplos.relaciones.entities.Respuesta1;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoDao extends CrudRepository<Alumno,Long> {

    List<Respuesta1> findByEmailEndingWithAndEdadGreaterThanAndNumControlStartsWith(String terminaCon, int mayorQue, String iniciaCon);

   // @Query("SELECT a.email,a.edad,a.numControl  FROM Alumno a where a.email like '%?1' and a.edad > ?2 and a.numControl like '?3%'")
    //List<Respuesta1> filtrar(String terminaCon, int mayorQue, Integer iniciaCon);

}

