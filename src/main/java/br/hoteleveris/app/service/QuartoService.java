package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;

import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {

	@Autowired
	QuartoRepository _repository;

	// INSERIR UM QUARTO (FUNCIONA, MAS FALTA COMODIDADES)
	public BaseResponse criar(QuartoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getAndar() <= 0) {
			response.message = "Andar não pode ser vazio ou zero";
			return response;
		} else if (request.getNumero() <= 0) {
			response.message = "Numero não pode ser vazio ou zero";
			return response;
		} else if (request.getSituacao().isEmpty()) {
			response.message = "Situação não pode ser vazio";
			return response;
		}

		Quarto quarto = new Quarto();
		quarto.setAndar(request.getAndar());
		quarto.setNumero(request.getNumero());
		quarto.setSituacao(request.getSituacao());

		// Colocar id em um ManyToOne
		TipoQuarto obj = new TipoQuarto();
		obj.setId(request.getIdTipoQuarto());
		quarto.setTipoQuarto(obj);

		// colocar id em um ManyToOne PROBLEMA POR SER LISTA
//		Comodidade obj2 = new Comodidade();
//		obj2.setId(request.getIdComodidade());
//		quarto.setComodidade(obj2);

		_repository.save(quarto);

		response.message = "Quarto criado com sucesso!";
		response.statusCode = 200;

		return response;
	}

	// OBTER UM QUARTO (FUNCIONA, MAS FALTA OBTER COMODIDADES)
	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = _repository.findById(id);

		QuartoResponse response = new QuartoResponse();

		if (quarto.get().getId() == 0) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setId(quarto.get().getId());
		response.setAndar(quarto.get().getAndar());
		response.setNumero(quarto.get().getNumero());
		response.setSituacao(quarto.get().getSituacao());
		response.setIdTipoQuarto(quarto.get().getTipoQuarto().getId());

		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso.";
		return response;
	}

	// OBTER LISTA DE IDs POR TIPO DE QUARTO
	public ListQuartoResponse listar(Long id) {

		ListQuartoResponse response = new ListQuartoResponse();
		List<Quarto> lista = _repository.findBuscarQuartos(id);

		response.setQuartos(lista);
		response.statusCode = 200;
		response.message = "Quartos obtidos com sucesso.";

		return response;
	}

	// ATUALIZAR APENAS SITUAÇÃO DO QUARTO (utilizar o verbo PATCH do Rest)
}
