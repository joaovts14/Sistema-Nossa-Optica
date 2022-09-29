package br.com.alura.sistema.controller.dto;

import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.modelo.Venda;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    private int numeracao;

    private Long preco;

    private Long valorDeCompra;

    private Venda venda;

    public ProdutoDTO(Produto produto) {
        this.numeracao = produto.getNumeracao();
        this.preco = produto.getPreco();
        this.valorDeCompra = produto.getValorDeCompra();
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

    public static List<ProdutoDTO> converter(List<Produto> topicos){
        return topicos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
