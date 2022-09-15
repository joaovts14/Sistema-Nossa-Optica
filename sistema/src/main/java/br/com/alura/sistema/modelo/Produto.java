package br.com.alura.sistema.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeracao;
    private Long preco;
    private Long valorDeCompra;
    @JsonIgnore
    @ManyToOne
    private Venda venda;

    public Produto() {
    }

    public Produto(int numeracao, Long preco, Long valorDeCompra) {
        this.numeracao = numeracao;
        this.preco = preco;
        this.valorDeCompra = valorDeCompra;
        this.venda = venda;
    }



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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
