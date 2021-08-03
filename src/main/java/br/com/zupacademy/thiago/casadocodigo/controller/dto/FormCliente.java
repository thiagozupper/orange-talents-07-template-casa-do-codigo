package br.com.zupacademy.thiago.casadocodigo.controller.dto;

import br.com.zupacademy.thiago.casadocodigo.controller.ClienteController;
import br.com.zupacademy.thiago.casadocodigo.model.Cliente;
import br.com.zupacademy.thiago.casadocodigo.model.Estado;
import br.com.zupacademy.thiago.casadocodigo.model.Pais;
import br.com.zupacademy.thiago.casadocodigo.validator.CpfOrCnpj;
import br.com.zupacademy.thiago.casadocodigo.validator.IdExists;
import br.com.zupacademy.thiago.casadocodigo.validator.UniqueColumnValue;
import br.com.zupacademy.thiago.casadocodigo.validator.VerificaEstadoObrigatorio;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@VerificaEstadoObrigatorio
public class FormCliente {

    @NotBlank
    @Email
    @UniqueColumnValue(modelo = Cliente.class, campo = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    /**
     * CPF ou CNPJ
     */
    @NotBlank
    @CpfOrCnpj
    @UniqueColumnValue(modelo = Cliente.class, campo = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @IdExists(modelo = Pais.class, campo = "id")
    private Long paisId;

    @IdExists(modelo = Estado.class, campo = "id")
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public FormCliente(String email, String nome, String sobrenome,
                       String documento, String endereco, String complemento,
                       String cidade, Long paisId, Long estadoId,
                       String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente toCliente(EntityManager entityManager) {

        Pais pais = entityManager.find(Pais.class, paisId);

        Estado estado = null;
        if (estadoId != null) {
            estado = entityManager.find(Estado.class, estadoId);
        }

        return new Cliente(email, nome, sobrenome,
                documento, endereco, complemento,
                cidade, pais, estado, telefone,
                cep);
    }
}
