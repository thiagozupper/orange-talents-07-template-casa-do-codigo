package br.com.zupacademy.thiago.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {VerificaEstadoObrigatorioValidator.class})
public @interface VerificaEstadoObrigatorio {

    String message() default "É necessário informar o campo estado ou o estado informado não pertence ao país";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
