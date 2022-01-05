package br.com.cadastromania;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cadastromania.domain.Categoria;
import br.com.cadastromania.domain.Cidade;
import br.com.cadastromania.domain.Cliente;
import br.com.cadastromania.domain.Contato;
import br.com.cadastromania.domain.Endereco;
import br.com.cadastromania.domain.Estado;
import br.com.cadastromania.domain.Produto;
import br.com.cadastromania.enums.TipoCliente;
import br.com.cadastromania.repositories.CategoriaRepository;
import br.com.cadastromania.repositories.CidadeRepository;
import br.com.cadastromania.repositories.ClienteRepository;
import br.com.cadastromania.repositories.EnderecoRepository;
import br.com.cadastromania.repositories.EstadoRepository;
import br.com.cadastromania.repositories.ProdutoRepository;

@SpringBootApplication
public class CadastromaniaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CadastromaniaApplication.class, args);
	}

	// CommandLineRunner executa uma ação ao iniciar a aplicação usamos para inserir
	// dados no banco de dados
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

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlãndia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "258.685.258-82", TipoCliente.PESSOA_FISICA);
		Cliente cli2 = new Cliente(null, "Patricia", "paty@gmail.com", "15789635822", TipoCliente.PESSOA_JURIDICA);

		// Endereço conhece cliente e cidade
		Endereco e1 = new Endereco(null, "Rua Barbalho bezerra", "2801", "casa", "Jardim São Paulo", "08461360", cli1,
				c1);
		Endereco e2 = new Endereco(null, "lopes", "800", "apto", "nazare", "852698547", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));

		Contato contato1 = new Contato(null, "(11)25534489", "(11)945269863", cli1);
		Contato contato2 = new Contato(null, "(11)25696987", "(11)958685475", cli2);

		cli1.getContatos().addAll(Arrays.asList(contato1));
		cli2.getContatos().addAll(Arrays.asList(contato2));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
