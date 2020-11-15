package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.QuartoComodidade;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoComodidadeRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository _repository;
	
	@Autowired
	private QuartoComodidadeRepository quartoComodidadeRepository;

	// INSERIR UM QUARTO COM COMODIDADES
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
			response.message = "Situação não pode ser vazia";
			return response;
		}
		
		TipoQuarto tipoQuarto = new TipoQuarto(request.getIdTipoQuarto());
		
		Quarto quarto = new Quarto(
				request.getAndar(), 
				request.getNumero(), 
				request.getSituacao(), 
				tipoQuarto);

		_repository.save(quarto);
		
		Long idQuarto = _repository.findByNumero(request.getNumero()).get().getId();

		for (ComodidadeRequest objeto : request.getComodidades()) {
			
			QuartoComodidade quartoComodidade = new QuartoComodidade(
					new Comodidade(objeto.getId()), 
					new Quarto(idQuarto)
					);
			
			quartoComodidadeRepository.save(quartoComodidade);
		}
		
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

	// ATUALIZAR APENAS SITUAÇÃO DO QUARTO (USANDO PATCH DO REST)
	public BaseResponse atualizar(Long id, SituacaoQuartoRequest request) {
		BaseResponse response = new BaseResponse();

		Optional<Quarto> quarto = _repository.findById(id);
 
		if (request.getSituacao().isEmpty()) {
			response.statusCode = 400;
			response.message = "Situação do quarto não pode ser vazia";
			return response;
		} else if (quarto.isEmpty() || id <= 0) {
			response.statusCode = 400;
			response.message = "Id do quarto não pode ser zero ou vazio";
			return response;
		}

		quarto.get().setSituacao(request.getSituacao());

		_repository.save(quarto.get());

		response.message = "Situação do quarto atualizado com sucesso";
		response.statusCode = 200;

		return response;

	}

}
