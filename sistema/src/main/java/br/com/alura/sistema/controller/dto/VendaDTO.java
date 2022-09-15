package br.com.alura.sistema.controller.dto;

import br.com.alura.sistema.modelo.Cliente;
import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.modelo.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDTO {

    private Cliente cliente;
    private Long valorCompra;
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Long valorCompra) {
        this.valorCompra = valorCompra;
    }

    public VendaDTO(Venda venda) {
        this.cliente = venda.getCliente();
        this.valorCompra = venda.getValorTotalCompra();
        this.produtos = venda.getProdutos();
    }
}
