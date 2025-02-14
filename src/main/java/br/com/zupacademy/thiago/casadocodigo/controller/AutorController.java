package br.com.zupacademy.thiago.casadocodigo.controller;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormAutor;
import br.com.zupacademy.thiago.casadocodigo.model.Autor;
import br.com.zupacademy.thiago.casadocodigo.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("autores")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrarAutor(@RequestBody @Valid FormAutor form) {
        Autor autor = form.toAutor();
        autorRepository.save(autor);
    }

}
