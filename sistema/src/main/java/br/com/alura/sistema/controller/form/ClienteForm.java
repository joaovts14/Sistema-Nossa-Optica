package br.com.alura.sistema.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.sistema.modelo.Cliente;
import org.hibernate.validator.constraints.Length;

public class ClienteForm {


    @NotNull @NotEmpty @Length(min = 10)
    private String nome;

    @NotNull @NotEmpty
    private String email;


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

    public Cliente converter() {
        return new Cliente(nome, email);
    }

}