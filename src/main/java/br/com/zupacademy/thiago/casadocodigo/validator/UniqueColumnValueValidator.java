package br.com.zupacademy.thiago.casadocodigo.validator;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueColumnValueValidator implements ConstraintValidator<UniqueColumnValue, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> modelo;
    private String campo;

    @Override
    public void initialize(UniqueColumnValue constraintAnnotation) {
        this.modelo = constraintAnnotation.modelo();
        this.campo = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        StringBuilder jpql = new StringBuilder();
        jpql.append(" SELECT m FROM ");
        jpql.append(this.modelo.getSimpleName());
        jpql.append(" m WHERE ");
        jpql.append(this.campo);
        jpql.append(" = ");
        jpql.append("'" + value + "'");

        List<Object> result = this.entityManager.createQuery(jpql.toString()).getResultList();

        return result.size() == 0 ? true : false;
    }
}
