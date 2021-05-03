package com.ejemplos.relaciones.services;

import com.ejemplos.relaciones.dao.IAlumnoDao;
import com.ejemplos.relaciones.entities.Alumno;
import com.ejemplos.relaciones.entities.Respuesta1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

    @Autowired
    private IAlumnoDao alumnoDao;
    @Override
    @Transactional(readOnly=true)
    public List<Alumno> findAll() {
        return (List<Alumno>) alumnoDao.findAll();
    }

    @Override
    @Transactional
    public Alumno save(Alumno a) {
        return alumnoDao.save(a);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta1> findRespuesta1(String terminacion,int mayorQue,String empiezaCon) {
        return alumnoDao.findByEmailEndingWithAndEdadGreaterThanAndNumControlStartsWith(terminacion, mayorQue, empiezaCon);
    }

    @Override
    public List<Respuesta1> findRespuesta2(String a, int b, int c) {
        return alumnoDao.filtrar(a,b,c);
    }
}
