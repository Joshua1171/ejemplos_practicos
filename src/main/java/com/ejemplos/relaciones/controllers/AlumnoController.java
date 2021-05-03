package com.ejemplos.relaciones.controllers;

import com.ejemplos.relaciones.entities.Alumno;
import com.ejemplos.relaciones.entities.Respuesta1;
import com.ejemplos.relaciones.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/alumnos")
    public List<Alumno> index(){
        return alumnoService.findAll();
    }


    @GetMapping("/alumnos/filtro2/{terminaCon}/{mayorQue}/{iniciaCon}")
    public List<Respuesta1> filtro2(@PathVariable String terminaCon,@PathVariable int mayorQue,@PathVariable String iniciaCon){
        return alumnoService.findRespuesta1(terminaCon,mayorQue,iniciaCon);
    }



    @PostMapping("/alumnos")
    public ResponseEntity<?> crear(@Valid @RequestBody Alumno alumno, BindingResult result){
        Alumno a =null;

        Map<String,Object> response = new HashMap<>();
        if (result.hasErrors()){

            /*
            *  List<String> errors = new ArrayList<>();
            for(FieldError err: result.getFieldErrors()) {
                errors.add("El campo '" + err.getField() +"' "+ err.getDefaultMessage());
            }
            * */
            List<String> errors=result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo "+err.getField()+""+err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors",errors);
           return new ResponseEntity<Map<String,Object>>(response, BAD_REQUEST);
        }
        try{
            a=alumnoService.save(alumno);
        }catch (DataAccessException e){
            response.put("mensaje","No se pudo insertar en la base de datos");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            new ResponseEntity<Map<String,Object>>(response,INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El cliente fue creado satisfactoriamente");
        response.put("alumnos",a);
        return new ResponseEntity<Map<String,Object>>(response,CREATED);
    }

}
