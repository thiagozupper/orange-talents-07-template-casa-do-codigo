package br.com.zupacademy.thiago.casadocodigo.repository;

import br.com.zupacademy.thiago.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
