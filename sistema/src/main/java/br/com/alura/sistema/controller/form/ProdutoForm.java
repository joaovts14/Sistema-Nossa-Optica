package br.com.alura.sistema.controller.form;

import br.com.alura.sistema.modelo.Produto;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoForm {

    @NotNull @NotEmpty
    private String codigo;

    @NotNull @NotEmpty
    private String descricao;

    @NotNull @NotEmpty
    private String numeroNF;

    private Date dataDeEmissaoNF;

    @NotNull @Min(0)
    private Long preco;

    @NotNull @Min(0)
    private Long valorDeCompra;


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

    public Produto converter() {
        return new Produto(codigo, descricao, numeroNF, dataDeEmissaoNF, preco, valorDeCompra);
    }

}