package br.com.cadastromania.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// Método customizado para saber se o qual tipo de cliente foi escolhido
	@SuppressWarnings("unlikely-arg-type")
	public static TipoCliente toEnum(Integer id) {

		if (id == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (id.equals(x.getClass())) {
				return x;
			}
		}

		throw new IllegalArgumentException("id inválido" + id);
	}
}
