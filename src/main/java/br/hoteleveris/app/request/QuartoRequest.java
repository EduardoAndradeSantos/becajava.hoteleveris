package br.hoteleveris.app.request;

public class QuartoRequest {
	private int andar;
	private int numero;
	private String situacao;
	private Long tipoQuartoId;

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

	public Long getTipoQuartoId() {
		return tipoQuartoId;
	}

	public void setTipoQuartoId(Long tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}

}
