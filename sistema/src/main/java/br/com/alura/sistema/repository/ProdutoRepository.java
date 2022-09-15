package br.com.alura.sistema.repository;

import br.com.alura.sistema.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository <Produto,Long> {

    Produto findByNumeracao(int numeracao);
}
