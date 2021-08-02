package br.com.zupacademy.thiago.casadocodigo.controller;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.DetalhesLivroDTO;
import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormLivro;
import br.com.zupacademy.thiago.casadocodigo.controller.dto.LivroDTO;
import br.com.zupacademy.thiago.casadocodigo.model.Livro;
import br.com.zupacademy.thiago.casadocodigo.repository.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid FormLivro form) {
        Livro livro = form.toLivro();
        livroRepository.save(livro);
    }

    @GetMapping
    public ResponseEntity<Page<LivroDTO>> buscar(
            @PageableDefault(page = 0, size = 10, sort = "dataPublicacao", direction = Sort.Direction.DESC)
            Pageable pageable) {

        Page<Livro> livros = livroRepository.findAll(pageable);
        Page<LivroDTO> livrosDto = LivroDTO.toPageLivroDTO(livros);
        return ResponseEntity.ok(livrosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesLivroDTO> detalhesLivro(@PathVariable Long id) {
        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            Livro livro = optional.get();
            return ResponseEntity.ok(new DetalhesLivroDTO(livro));
        }
        return ResponseEntity.notFound().build();
    }

}