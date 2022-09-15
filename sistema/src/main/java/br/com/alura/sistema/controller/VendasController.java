package br.com.alura.sistema.controller;

import br.com.alura.sistema.controller.dto.VendaDTO;
import br.com.alura.sistema.controller.dto.VendaPorClienteDTO;
import br.com.alura.sistema.controller.form.VendaForm;
import br.com.alura.sistema.modelo.Cliente;
import br.com.alura.sistema.modelo.Venda;
import br.com.alura.sistema.repository.ClienteRepository;
import br.com.alura.sistema.repository.ProdutoRepository;
import br.com.alura.sistema.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendasController {


    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("/vendas-por-cliente/{id}")
    public VendaPorClienteDTO buscaVendasPorClientes(@PathVariable Long id){
        return VendaPorClienteDTO.buscaVendasPorCliente(vendaRepository,id);
    }



    @PostMapping
    public ResponseEntity<VendaDTO> registraVenda(@RequestBody @Valid VendaForm form, UriComponentsBuilder uriBuilder) {
        Venda venda = form.converter(clienteRepository,produtoRepository,vendaRepository);

        URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(new VendaDTO(venda));

    }




}


