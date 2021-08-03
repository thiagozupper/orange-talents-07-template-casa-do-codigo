package br.com.zupacademy.thiago.casadocodigo.validator;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormCliente;
import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormEstado;
import br.com.zupacademy.thiago.casadocodigo.model.Estado;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class VerificaEstadoObrigatorioValidator
        implements ConstraintValidator<VerificaEstadoObrigatorio, FormCliente> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(VerificaEstadoObrigatorio constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(FormCliente formCliente, ConstraintValidatorContext context) {

        Long estadoId = formCliente.getEstadoId();
        Long paisId = formCliente.getPaisId();

        Query query = em.createQuery("SELECT e FROM Estado e WHERE e.pais.id = " + paisId);
        List estadosDoPais = query.getResultList();

        if (estadosDoPais.size() > 0 && estadoId == null) {
            return false;
        }

        Boolean estadoPertenceAoPais = false;
        for (Object object : estadosDoPais) {
            Estado estado = (Estado) object;
            if (estado.getId().equals(estadoId)) {
                estadoPertenceAoPais = true;
                break;
            }
        }

        if (estadosDoPais.size() > 0 && !estadoPertenceAoPais) {
            return false;
        }

        return true;
    }
}
