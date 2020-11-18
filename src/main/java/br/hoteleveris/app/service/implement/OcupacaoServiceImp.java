package br.hoteleveris.app.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.service.OcupacaoService;

@Service
public class OcupacaoServiceImp implements OcupacaoService {

	@Autowired
	OcupacaoRepository _repository;

	// CRIAR UMA OCUPACAO
	public BaseResponse criar(OcupacaoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getData() == "" || request.getData() == null) {
			response.message = "Data não pode ser vazia";
			return response;
		} else if (request.getDiaria() <= 0) {
			response.message = "Quatidade de diarias não pode zer 0 ou vazia";
			return response;
		} else if (request.getQuartoId() <= 0 || request.getQuartoId() == null) {
			response.message = "Id de quarto precisa ser inserido";
			return response;
		} else if (request.getClienteId() <= 0 || request.getClienteId() == null) {
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

		// COLOCAR ID DE RESPONSE EM UM MANYTOONE DO ID CLIENTE
		Cliente obj = new Cliente();
		obj.setId(request.getClienteId());
		ocupa.setCliente(obj);

		// COLOCAR ID DE RESPONSE EM UM MANYTOONE DO ID QUARTO
		Quarto obj2 = new Quarto();
		obj2.setId(request.getQuartoId());
		ocupa.setQuarto(obj2);

		_repository.save(ocupa);

		response.message = "Tipo de quarto criado com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER TODAS AS OCUPACOES
	public ListOcupacaoResponse listar() {

		List<Ocupacao> lista = _repository.findAll();

		ListOcupacaoResponse response = new ListOcupacaoResponse();
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Ocupações obtidas com sucesso.";

		return response;
	}

}
