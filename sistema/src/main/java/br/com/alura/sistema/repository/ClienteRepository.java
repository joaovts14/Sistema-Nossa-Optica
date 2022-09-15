package br.com.alura.sistema.repository;

import br.com.alura.sistema.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    List<Cliente> findAll();

    Cliente findByNome(String nome);

//    Cliente ;
}
