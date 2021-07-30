package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class FormCategoria {

    @NotBlank
    private String nome;

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
    
    public String getNome() {
        return nome;
    }
}
