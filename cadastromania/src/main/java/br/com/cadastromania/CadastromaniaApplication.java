package br.com.cadastromania;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cadastromania.domain.Categoria;
import br.com.cadastromania.domain.Produto;
import br.com.cadastromania.repositories.CategoriaRepository;
import br.com.cadastromania.repositories.ProdutoRepository;

@SpringBootApplication
public class CadastromaniaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CadastromaniaApplication.class, args);
	}

	// CommandLineRunner executa uma ação ao iniciar a aplicação usamos para inserir dados no banco de dados
	@Override
	public void run(String... args) throws Exception {
		                               // Id gerado automaticamente, adicionamos apenas 'INFORMÀTICA' e 'ESCRITÒRIO'
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
						
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		// associação categoria com produto
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		// associação protuco com cada categoria
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		                         // Modo para criar uma lista automático e inserir quantos elementos quisermos
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
