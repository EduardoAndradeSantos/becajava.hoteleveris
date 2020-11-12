package br.hoteleveris.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Comodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	
	@ManyToMany
	@JoinTable(name = "QuartoComodidade", 
	inverseJoinColumns = @JoinColumn(name = "comodidadeId"),
	joinColumns = @JoinColumn(name = "quartoId"))
	Set<Quarto> quarto;


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


	public Set<Quarto> getQuarto() {
		return quarto;
	}


	public void setQuarto(Set<Quarto> quarto) {
		this.quarto = quarto;
	}
	
}