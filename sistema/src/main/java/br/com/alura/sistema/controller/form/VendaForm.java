package br.com.alura.sistema.controller.form;

import br.com.alura.sistema.modelo.Cliente;
import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.modelo.Venda;
import br.com.alura.sistema.repository.ClienteRepository;
import br.com.alura.sistema.repository.ProdutoRepository;
import br.com.alura.sistema.repository.VendaRepository;

;import java.util.ArrayList;
import java.util.List;

public class VendaForm {

    private String idCliente;
    private Long valorTotalCompra;
    private List<String> idsProdutos = new ArrayList<>();


    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Long getValorTotalCompra() {

        return valorTotalCompra;
    }

    public void setValorTotalCompra(Long valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public List<String> getProdutos() {
        return idsProdutos;
    }

    public void setProdutos(List<String> produtos) {
        this.idsProdutos = produtos;
    }

    public Venda converter(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        Cliente teste = clienteRepository.findByNome(idCliente);
        Cliente cliente = clienteRepository.getReferenceById(teste.getId());
        List<Produto> produtos = new ArrayList<>();
        idsProdutos.forEach(id ->{
            produtos.add(produtoRepository.getReferenceById(Long.parseLong(id)));

        });
        Venda venda = new Venda(cliente,valorTotalCompra,produtos);
        venda = vendaRepository.save(venda);
        Venda finalVenda = venda;
        idsProdutos.forEach(id ->{
            Produto produto2 = produtoRepository.getReferenceById(Long.parseLong(id));
            produto2.setVenda(finalVenda);
            produtoRepository.save(produto2);

        });

        return venda;
    }


}
