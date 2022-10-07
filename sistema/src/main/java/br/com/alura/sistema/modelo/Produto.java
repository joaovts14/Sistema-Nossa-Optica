package br.com.alura.sistema.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descricao;
    private String numeroNF;
    private Date dataDeEmissaoNF;
    private Float preco;
    private Float valorDeCompra;
    @JsonIgnore
    @ManyToOne
    private Venda venda;

    public Produto() {
    }

    public Produto(String codigo, String descricao, String numeroNF,
                   Date dataDeEmissaoNF, Float preco, Float valorDeCompra) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.numeroNF = numeroNF;
        this.dataDeEmissaoNF = dataDeEmissaoNF;
        this.preco = preco;
        this.valorDeCompra = valorDeCompra;
        this.venda = venda;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }

    public Date getDataDeEmissaoNF() {
        return dataDeEmissaoNF;
    }

    public void setDataDeEmissaoNF(Date dataDeEmissaoNF) {
        this.dataDeEmissaoNF = dataDeEmissaoNF;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(Float valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
