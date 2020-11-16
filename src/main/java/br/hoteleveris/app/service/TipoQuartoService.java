package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListTipoQuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {

	@Autowired
	TipoQuartoRepository _repository;

	// CRIAR UM TIPO DE QUARTO
	public BaseResponse criar(TipoQuartoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getDescricao().isEmpty() || request.getDescricao() == "") {
			response.message = "A descricao não pode ser vazia";
			return response;
		} else if (request.getValor() <= 0) {
			response.message = "O valor não pode ser vazio ou zero";
			return response;
		}

		TipoQuarto tq = new TipoQuarto();
		tq.setDescricao(request.getDescricao());
		tq.setValor(request.getValor());
		
//		TipoQuarto tq = new TipoQuarto(
//				request.getDescricao(), 
//				request.getValor());

		_repository.save(tq);

		response.message = "Tipo de quarto criado com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER UM TIPO DE QUARTO POR POR ID
	public TipoQuartoResponse obter(Long id) {
		Optional<TipoQuarto> tq = _repository.findById(id);

		TipoQuartoResponse response = new TipoQuartoResponse();

		if (tq.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setId(tq.get().getId());
		response.setDescricao(tq.get().getDescricao());
		response.setValor(tq.get().getValor());
		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso.";
		return response;
	}

	// OBTER TODOS OS TIPOS DE QUARTO
	public ListTipoQuartoResponse listar() {

		List<TipoQuarto> lista = _repository.findAll();

		ListTipoQuartoResponse response = new ListTipoQuartoResponse();
		response.setTipoQuarto(lista);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";

		return response;
	}

}
