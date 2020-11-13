package br.hoteleveris.app.response;

import java.util.List;

import br.hoteleveris.app.model.Quarto;

public class ListQuartoResponse extends BaseResponse {

	private List<Quarto> quarto;

	public List<Quarto> getQuarto() {
		return quarto;
	}

	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}

}
