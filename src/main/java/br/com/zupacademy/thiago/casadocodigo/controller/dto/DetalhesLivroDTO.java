package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class DetalhesLivroDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private String autorNome;
    private String autorDescricao;

    public DetalhesLivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.autorNome = livro.getAutor().getNome();
        this.autorDescricao = livro.getAutor().getDescricao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
    }
}
