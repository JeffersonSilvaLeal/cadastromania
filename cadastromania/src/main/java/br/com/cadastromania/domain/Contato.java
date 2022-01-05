package br.com.cadastromania.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String telefone;
	@Column(unique = true)
	private String celular;
	
	
	// vários contatos para um cliente
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cliente cliente;
	
	public Contato() {
		
	}       

	public Contato(Integer id, String telefone, String celular,Cliente cliente) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.celular = celular;
		this.cliente = cliente;

	}



	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", telefone=" + telefone + ", celular=" + celular + "]";
	}
	
	
	


	
	
}
