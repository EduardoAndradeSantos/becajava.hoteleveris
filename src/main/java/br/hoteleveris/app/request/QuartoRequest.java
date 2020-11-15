package br.hoteleveris.app.request;

import java.util.List;

public class QuartoRequest {
	private int andar;
	private int numero;
	private String situacao;
	private Long idTipoQuarto;

	private List<ComodidadeRequest> comodidades;
	

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getIdTipoQuarto() {
		return idTipoQuarto;
	}

	public void setIdTipoQuarto(Long idTipoQuarto) {
		this.idTipoQuarto = idTipoQuarto;
	}

	public List<ComodidadeRequest> getComodidades() {
		return comodidades;
	}

	public void setComodidades(List<ComodidadeRequest> comodidades) {
		this.comodidades = comodidades;
	}	

}
