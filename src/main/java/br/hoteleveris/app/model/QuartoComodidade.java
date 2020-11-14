package br.hoteleveris.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuartoComodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public QuartoComodidade() {
		
	}

	@ManyToOne
	@JoinColumn(name = "comodidadeId")
	private Comodidade comodidade;

	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quarto;

	// CONTRUTOR QUE SÓ PEGA QUARTO E COMODIDADE
	public QuartoComodidade(Comodidade comodidade, Quarto quarto) {
		super();
		this.comodidade = comodidade;
		this.quarto = quarto;
	}
	
	//CONSTRUTOR QUE SÓ PEGA ID
	public QuartoComodidade(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comodidade getComodidade() {
		return comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
