package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Categoria;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueColumnValue;

import javax.validation.constraints.NotBlank;

public class FormCategoria {

    @NotBlank
    @UniqueColumnValue(modelo = Categoria.class, campo = "nome")
    private String nome;

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
    
    public String getNome() {
        return nome;
    }
}
