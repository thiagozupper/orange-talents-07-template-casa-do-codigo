package br.com.zupacademy.thiago.casadocodigo.controller;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormCategoria;
import br.com.zupacademy.thiago.casadocodigo.model.Categoria;
import br.com.zupacademy.thiago.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public void cadastrarCategoria(@RequestBody @Valid FormCategoria form) {
        Categoria categoria = form.toCategoria();
        categoriaRepository.save(categoria);
    }
}
