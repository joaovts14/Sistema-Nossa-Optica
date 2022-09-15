package br.com.alura.sistema.controller.dto;

import br.com.alura.sistema.modelo.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<ClienteDTO> converter(List<Cliente> topicos){
        return topicos.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
