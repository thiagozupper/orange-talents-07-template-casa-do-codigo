package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Livro;
import org.springframework.data.domain.Page;

public class LivroDTO {

    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<LivroDTO> toPageLivroDTO(Page<Livro> livros) {
        return livros.map(LivroDTO::new);
    }
}
