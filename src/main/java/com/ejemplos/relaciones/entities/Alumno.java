package com.ejemplos.relaciones.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ejemplos.relaciones.anotations.Tamaño;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="alumnos",uniqueConstraints =
@UniqueConstraint(columnNames = {"email","num_control"}))
public class Alumno implements Serializable {


    private static final long serialVersionUID = 4269472065718953165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;


    @NotEmpty (message = "El nombre no puede ir vacio")
    private String nombre;


    @NotEmpty(message = "El apellido no puede ir vacio ")
    private String apellido;

    @NotNull
    @Email
    @UniqueElements(message = "valor duplicado")
    private String email;


    @Tamaño(min=0,max=8,message ="Num Ctrl")
    @Column(name="num_control",nullable = false,length = 8)
    private int numControl;


    @Tamaño(min=0,max=3,message ="Edad incorrecta")
    @Column(length = 3)
    private int edad;



    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist(){
        this.createAt=new Date();
    }


}
