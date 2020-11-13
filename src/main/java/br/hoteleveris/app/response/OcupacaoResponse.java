package br.hoteleveris.app.response;

public class OcupacaoResponse extends BaseResponse {
	public String data;
	public int diaria;
	public String situacaoPagamento;
	public Long clienteId;
	public Long quartoId;

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
		return quartoId;
	}

	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}

}
