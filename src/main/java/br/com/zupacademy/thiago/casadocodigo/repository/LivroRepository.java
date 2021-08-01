package br.com.zupacademy.thiago.casadocodigo.repository;

import br.com.zupacademy.thiago.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
