package br.com.cadastromania.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastromania.domain.Cidade;

// Camada de acesso a dados => Camada de serviço
@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer>{

}
