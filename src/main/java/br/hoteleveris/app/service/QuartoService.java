package br.hoteleveris.app.service;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

public interface QuartoService {
	
	BaseResponse criar(QuartoRequest request);
	
	QuartoResponse obter(Long id);
	
	ListQuartoResponse listar(Long id);
	
	BaseResponse atualizar(Long id, SituacaoQuartoRequest request);

}
