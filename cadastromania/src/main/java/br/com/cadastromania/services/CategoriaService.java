package br.com.cadastromania.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastromania.domain.Categoria;
import br.com.cadastromania.repositories.CategoriaRepository;

// Camada de serviço => controladores Rest
@Service 
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj ;
	}
}
