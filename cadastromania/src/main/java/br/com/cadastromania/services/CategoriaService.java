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
	
	// Lança uma  exceção caso o id não exista
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		// se o obj não existe, lança uma exeção recebe uma função que instância uma exeção
		return Optional.of(obj.orElseThrow(() -> new br.com.cadastromania.services.exceptions.ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName())));
	}
}
