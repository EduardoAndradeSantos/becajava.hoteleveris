package br.hoteleveris.app.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;
import br.hoteleveris.app.service.ComodidadeService;

@Service
public class ComodidadeServiceImp implements ComodidadeService {

	@Autowired
	ComodidadeRepository _repository;

	// CRIAR UM TIPO DE QUARTO
	public BaseResponse criar(ComodidadeRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == null || request.getNome() == "") {
			response.message = "A comodidade não pode ser vazia";
			return response;
		}

		Comodidade comodidade = new Comodidade(
				request.getId(), 
				request.getNome());

		_repository.save(comodidade);

		response.message = "Nome da comodidade criada com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER UM TIPO DE QUARTO POR POR ID
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);

		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setId(comodidade.get().getId());
		response.setNome(comodidade.get().getNome());

		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso.";
		return response;
	}

}
