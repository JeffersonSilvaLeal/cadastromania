package br.com.cadastromania;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cadastromania.domain.Categoria;
import br.com.cadastromania.repositories.CategoriaRepository;

@SpringBootApplication
public class CadastromaniaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CadastromaniaApplication.class, args);
	}

	// CommandLineRunner executa uma ação ao iniciar a aplicação usamos para inserir dados no banco de dados
	@Override
	public void run(String... args) throws Exception {
		// Id gerado automaticamente, adicionamos apenas 'INFORMÀTICA' e 'ESCRITÒRIO'
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
							// Modo para criar uma lista automático e inserir quantos elementos quisermos
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
