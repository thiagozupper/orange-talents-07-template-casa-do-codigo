package br.com.zupacademy.thiago.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueEstadoValidator.class})
public @interface UniqueEstado {

    String message() default "Esse estado já foi cadastrado para esse país";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
