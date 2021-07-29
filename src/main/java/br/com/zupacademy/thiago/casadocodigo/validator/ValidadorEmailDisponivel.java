package br.com.zupacademy.thiago.casadocodigo.validator;

import br.com.zupacademy.thiago.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidadorEmailDisponivel implements ConstraintValidator<EmailDisponivel, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailDisponivel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !autorRepository.findByEmail(email).isPresent();
    }
}
