package br.com.alura.sistema.controller;

import br.com.alura.sistema.controller.dto.ClienteDTO;
import br.com.alura.sistema.controller.form.ClienteForm;
import br.com.alura.sistema.modelo.Cliente;
import br.com.alura.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {


    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDTO> lista( ) {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDTO.converter(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastra(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter();
        clienteRepository.save(cliente);
//        topicoRepository.save(topicoRepositoryco);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }


}


