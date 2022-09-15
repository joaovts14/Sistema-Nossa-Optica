package br.com.alura.sistema.repository;

import br.com.alura.sistema.modelo.Cliente;
import br.com.alura.sistema.modelo.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VendaRepository extends JpaRepository<Venda,Long> {

//    Venda findById();
    List<Venda> findByClienteId(Long id);
}


