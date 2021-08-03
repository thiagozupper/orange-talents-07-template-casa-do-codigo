package br.com.zupacademy.thiago.casadocodigo.controller;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormPais;
import br.com.zupacademy.thiago.casadocodigo.model.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid FormPais formPais) {
        Pais pais = formPais.toPais();
        entityManager.persist(pais);
    }
}
