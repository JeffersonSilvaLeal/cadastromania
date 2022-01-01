package br.com.cadastromania.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastromania.domain.Estado;

// Camada de acesso a dados => Camada de serviço
@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{

}
