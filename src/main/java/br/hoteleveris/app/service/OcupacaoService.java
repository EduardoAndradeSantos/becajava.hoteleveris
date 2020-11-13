package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class OcupacaoService {

	@Autowired
	OcupacaoRepository _repository;

	// CRIAR UMA OCUPACAO
	public BaseResponse criar(OcupacaoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
	
		if (request.getData().isEmpty()) {
			response.message = "Data não pode ser vazia";
			return response;
		} else if (request.getDiaria() <= 0) {
			response.message = "Quatidade de diarias não pode zer 0 ou vazia";
			return response;
		} else if (request.getQuartoId() <= 0) {
			response.message = "Id de quarto precisa ser inserido";
			return response;
		} else if (request.getClienteId() <= 0) {
			response.message = "Id de cliente precisa ser inserido";
			return response;
		}

		Ocupacao ocupa = new Ocupacao();
		ocupa.setData(request.getData());
		ocupa.setDiaria(request.getDiaria());
		
		ocupa.setSituacaoPagamento(request.getSituacaoPagamento());
		if (ocupa.getSituacaoPagamento().isEmpty()) {
			ocupa.setSituacaoPagamento("N");
		}

		// Colocar id de response em um ManyToOne do id Cliente
		Cliente obj = new Cliente();
		obj.setId(request.getClienteId());
		ocupa.setCliente(obj);

		// Colocar id de response em um ManyToOne do id Quarto
		Quarto obj2 = new Quarto();
		obj2.setId(request.getQuartoId());
		ocupa.setQuarto(obj2);

		_repository.save(ocupa);

		response.message = "Tipo de quarto criado com sucesso!";
		response.statusCode = 200;

		return response;
	}

}
