package br.com.zupacademy.thiago.casadocodigo.validator;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormCategoria;
import br.com.zupacademy.thiago.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NomeCategoriaDuplicadoValidador implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return FormCategoria.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        if (errors.hasErrors()) return;

        FormCategoria form = (FormCategoria) o;
        if (categoriaRepository.findByNome(form.getNome()).isPresent()) {
            errors.rejectValue("nome", null, "Já existe categoria com o nome " + form.getNome());
        }
    }
}
