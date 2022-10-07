package br.com.alura.sistema.controller;

import br.com.alura.sistema.controller.dto.ProdutoDTO;
import br.com.alura.sistema.controller.form.ProdutoForm;
import br.com.alura.sistema.modelo.Produto;
import br.com.alura.sistema.repository.ProdutoRepository;
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
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoDTO> lista( ) {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoDTO.converter(produtos);
    }

    @GetMapping("/{id}")
    public ProdutoDTO detalhar(@PathVariable Long id){

        Produto produto = produtoRepository.getReferenceById(id);
        return new ProdutoDTO(produto);

    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastra(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
    }


}


