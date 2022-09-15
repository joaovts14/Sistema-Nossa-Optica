package br.com.alura.sistema.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Cliente cliente;
    private Long valorTotalCompra;
    @OneToMany(mappedBy = "venda")
    private List<Produto> produtos = new ArrayList<>();

    private LocalDateTime dataVenda = LocalDateTime.now();

    public Venda() {
    }

    public Venda(Cliente cliente, Long valorCompra, List<Produto> produtos) {
        this.cliente = cliente;
        this.valorTotalCompra = valorCompra;
        this.produtos = produtos;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Long valorCompra) {
        this.valorTotalCompra = valorCompra;
    }

}
