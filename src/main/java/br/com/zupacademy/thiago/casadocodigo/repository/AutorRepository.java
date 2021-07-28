package br.com.zupacademy.thiago.casadocodigo.repository;

import br.com.zupacademy.thiago.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
