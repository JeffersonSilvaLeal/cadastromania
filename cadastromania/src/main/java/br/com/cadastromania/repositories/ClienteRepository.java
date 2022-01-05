package br.com.cadastromania.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastromania.domain.Cliente;

// Camada de acesso a dados => Camada de serviço
@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
