package br.com.alura.sistema.controller.dto;

import br.com.alura.sistema.modelo.Venda;
import br.com.alura.sistema.repository.VendaRepository;

import java.util.List;

public class VendaPorClienteDTO {

    private int numeroDeItens;
    private List<Venda> vendas;

    public VendaPorClienteDTO() {
    }

    public VendaPorClienteDTO(int numeroDeItens, List<Venda> vendas) {
        this.numeroDeItens = numeroDeItens;
        this.vendas = vendas;
    }

    public int getNumeroDeItens() {
        return numeroDeItens;
    }

    public void setNumeroDeItens(int numeroDeItens) {
        this.numeroDeItens = numeroDeItens;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

//    public List<Venda> buscaVendas(VendaRepository vendaRepository,Long id){
//
//
//    }

    public static VendaPorClienteDTO buscaVendasPorCliente(VendaRepository vendaRepository, Long id){
        List<Venda> vendas = vendaRepository.findByClienteId(id);
        return new VendaPorClienteDTO(vendas.size(),vendas);
    }
}
