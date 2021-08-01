package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Autor;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueColumnValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class FormAutor {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueColumnValue(modelo = Autor.class, campo = "email")
    private String email;

    @NotBlank @Size(max = 400)
    private String descricao;

    public FormAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao, Instant.now());
    }
}
