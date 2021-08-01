package br.com.zupacademy.thiago.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueColumnValueValidator.class)
public @interface UniqueColumnValue {

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String message() default "Valor repetido";
    Class<?> modelo();
    String campo();

}
