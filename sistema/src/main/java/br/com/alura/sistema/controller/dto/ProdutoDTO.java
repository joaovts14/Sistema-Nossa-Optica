package br.com.alura.sistema.controller.dto;

import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.modelo.Venda;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {

    private Long id;

    private String codigo;

    private String descricao;

    private String numeroNF;

    private Date dataDeEmissaoNF;

    private Long preco;

    private Long valorDeCompra;

    private Venda venda;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.numeroNF = produto.getNumeroNF();
        this.dataDeEmissaoNF = produto.getDataDeEmissaoNF();
        this.preco = produto.getPreco();
        this.valorDeCompra = produto.getValorDeCompra();
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
