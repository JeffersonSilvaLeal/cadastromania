package br.com.cadastromania.services.exceptions;

// Erro personalizado
public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	// Recebe uma msg de exceção
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	// Recebe A msg e Outra exceção causa de algo que ocorreu antes
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
