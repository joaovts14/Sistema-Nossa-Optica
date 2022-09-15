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
@RequestMapping("/clientes")
public class ClientesController {


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
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

//    @GetMapping("/compras")
//    public List<ClienteDTO> lista( ) {
//        List<Cliente> clientes = clienteRepository.findAll();
//        return ClienteDTO.converter(clientes);
//    }


    @GetMapping("/{id}")
    public ClienteDTO detalhar(@PathVariable Long id){

        Cliente cliente = clienteRepository.getReferenceById(id);
        return new ClienteDTO(cliente);

    }

}


