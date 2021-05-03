package com.ejemplos.relaciones.anotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class TamañoValidator implements ConstraintValidator<Tamaño, Integer> {

    private int minAsignado;
    private int maxAsignado;

    @Override
    public void initialize(Tamaño tamaño) {
        this.minAsignado=tamaño.min();
        this.maxAsignado=tamaño.max();
    }

    @Override
    public boolean isValid(Integer valor_atributo, ConstraintValidatorContext context) {
        return String.valueOf(valor_atributo).length() >= minAsignado && String.valueOf(valor_atributo).length() <= maxAsignado;
    }
}
