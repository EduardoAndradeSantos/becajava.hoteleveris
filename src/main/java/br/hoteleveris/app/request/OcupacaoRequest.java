package br.hoteleveris.app.request;

public class OcupacaoRequest {
	private String data;
	private int diaria;
	private String situacaoPagamento;
	private Long clienteId;
	private Long QuartoId;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getDiaria() {
		return diaria;
	}

	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}

	public String getSituacaoPagamento() {
		return situacaoPagamento;
	}

	public void setSituacaoPagamento(String situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getQuartoId() {
		return QuartoId;
	}

	public void setQuartoId(Long quartoId) {
		QuartoId = quartoId;
	}

}
