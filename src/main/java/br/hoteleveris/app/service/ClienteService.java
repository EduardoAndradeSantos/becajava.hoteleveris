package br.hoteleveris.app.service;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

public interface ClienteService {
	
	BaseResponse criar(ClienteRequest request);
	
	ClienteResponse obter(Long id);

}
