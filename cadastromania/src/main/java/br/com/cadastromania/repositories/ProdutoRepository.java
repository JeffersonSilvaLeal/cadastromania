package br.com.cadastromania.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.cadastromania.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
