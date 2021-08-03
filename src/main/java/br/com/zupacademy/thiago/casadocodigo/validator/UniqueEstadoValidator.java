package br.com.zupacademy.thiago.casadocodigo.validator;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormEstado;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueEstadoValidator implements ConstraintValidator<UniqueEstado, FormEstado> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(UniqueEstado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(FormEstado formEstado, ConstraintValidatorContext context) {

        String nomeEstado = formEstado.getNome();
        Long paisId = formEstado.getPaisId();

        Query query = em.createQuery("SELECT e FROM Estado e WHERE " +
                "e.nome = :nomeEstado AND e.pais.id = :paisId");
        query.setParameter("nomeEstado", nomeEstado);
        query.setParameter("paisId", paisId);

        List result = query.getResultList();
        return result.size() ==  0 ? true : false;
    }
}
