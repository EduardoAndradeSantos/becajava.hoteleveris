package br.hoteleveris.app.service;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;

public interface OcupacaoService {
	
	BaseResponse criar(OcupacaoRequest request);
	
	ListOcupacaoResponse listar();

}
