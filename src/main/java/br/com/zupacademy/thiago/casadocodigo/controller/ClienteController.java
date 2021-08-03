package br.com.zupacademy.thiago.casadocodigo.controller;

import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormCliente;
import br.com.zupacademy.thiago.casadocodigo.controller.dto.FormEstado;
import br.com.zupacademy.thiago.casadocodigo.model.Cliente;
import br.com.zupacademy.thiago.casadocodigo.model.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Map<String, Long>> cadastrar(@RequestBody @Valid FormCliente formCliente) {
        Cliente cliente = formCliente.toCliente(entityManager);
        entityManager.persist(cliente);
        Map<String, Long> novoCliente = new HashMap<>();
        novoCliente.put("clienteId", cliente.getId());
        return ResponseEntity.ok(novoCliente);
    }
}
