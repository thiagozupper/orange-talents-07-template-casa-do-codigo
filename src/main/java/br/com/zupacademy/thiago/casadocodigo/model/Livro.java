package br.com.zupacademy.thiago.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    @Lob
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false, unique = true)
    private String isbn;
    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getResumo() {
        return this.resumo;
    }

    public String getSumario() {
        return this.sumario;
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

    public Autor getAutor() {
        return autor;
    }
}
