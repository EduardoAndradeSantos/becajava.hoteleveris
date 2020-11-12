package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository _repository;

	
	// CRIAR UM CLIENTE
//		public BaseResponse criar(ClienteRequest request) {
//			BaseResponse response = new BaseResponse();
//			response.statusCode = 400;
}
