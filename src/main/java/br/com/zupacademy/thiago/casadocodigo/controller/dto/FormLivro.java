package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.model.Autor;
import br.com.zupacademy.thiago.casadocodigo.model.Categoria;
import br.com.zupacademy.thiago.casadocodigo.model.Livro;
import br.com.zupacademy.thiago.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.thiago.casadocodigo.validator.IdExists;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueColumnValue;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FormLivro {

    @NotBlank
    @UniqueColumnValue(modelo = Livro.class, campo = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueColumnValue(modelo = Livro.class, campo = "isbn")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @IdExists(modelo = Categoria.class, campo = "id")
    private Long idCategoria;

    @NotNull
    @IdExists(modelo = Autor.class, campo = "id")
    private Long idAutor;

    public FormLivro(String titulo, String resumo, String sumario,
                     BigDecimal preco, Integer numeroPaginas, String isbn,
                     LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro toLivro() {

        Categoria categoria = new Categoria();
        categoria.setId(this.idCategoria);

        Autor autor = new Autor();
        autor.setId(this.idAutor);

        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao,
                categoria, autor);
    }
}
