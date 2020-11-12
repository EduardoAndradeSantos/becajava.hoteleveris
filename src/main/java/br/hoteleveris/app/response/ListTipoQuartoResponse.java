package br.hoteleveris.app.response;

import java.util.List;

import br.hoteleveris.app.model.TipoQuarto;

public class ListTipoQuartoResponse extends BaseResponse{

	private List<TipoQuarto> tipoQuarto;

	public List<TipoQuarto> getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(List<TipoQuarto> tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	
	
}
