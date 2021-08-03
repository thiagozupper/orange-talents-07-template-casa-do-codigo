package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Pais;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueColumnValue;

import javax.validation.constraints.NotBlank;

public class FormPais {

    @NotBlank
    @UniqueColumnValue(modelo = Pais.class, campo = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toPais() {
        return new Pais(this.nome);
    }
}
