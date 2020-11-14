package br.hoteleveris.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Comodidade() {
		
	}
	
	//CONSTRUTOR SO PARA ID E NOME
	public Comodidade(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	//CONSTRUTOR SO PARA ID
	public Comodidade(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}