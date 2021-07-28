package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class FormAutor {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank @Size(max = 400)
    private String descricao;

    public FormAutor() {}

    public FormAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toAutor() {
        Autor autor = new Autor(this.nome, this.email, this.descricao, Instant.now());
        return autor;
    }
}
