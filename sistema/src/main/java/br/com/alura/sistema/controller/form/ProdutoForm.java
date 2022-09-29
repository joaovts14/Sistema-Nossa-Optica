package br.com.alura.sistema.controller.form;

import br.com.alura.sistema.modelo.Produto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProdutoForm {


    @NotNull @Min(0)
    private int numeracao;

    @NotNull @Min(0)
    private Long preco;

    @NotNull @Min(0)
    private Long valorDeCompra;


    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Long getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(Long valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public Produto converter() {
        return new Produto(numeracao, preco, valorDeCompra);
    }

}