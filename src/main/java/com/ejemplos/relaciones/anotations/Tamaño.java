package com.ejemplos.relaciones.anotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import com.ejemplos.relaciones.anotations.Tamaño.List;


@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(List.class)
@Constraint(validatedBy = TamañoValidator.class)
public @interface Tamaño {

    int min() default 0;
    int max() default 8;
    String message() default "El rango debe ser de {min} a {max}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Tamaño[] value();
    }
}
