package br.com.cadastromania.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastromania.domain.Categoria;

// Camada de acesso a dados
@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

}
