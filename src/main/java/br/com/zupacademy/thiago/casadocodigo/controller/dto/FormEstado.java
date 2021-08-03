package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Estado;
import br.com.zupacademy.thiago.casadocodigo.model.Pais;
import br.com.zupacademy.thiago.casadocodigo.validator.IdExists;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueEstado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueEstado
public class FormEstado {

    @NotBlank
    private String nome;

    @NotNull
    @IdExists(modelo = Pais.class, campo = "id")
    private Long paisId;

    public FormEstado(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toEstado(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
