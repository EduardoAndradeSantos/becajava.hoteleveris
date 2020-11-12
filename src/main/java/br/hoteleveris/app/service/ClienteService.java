package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository _repository;

	// CRIAR UM CLIENTE
	public BaseResponse criar(ClienteRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome().isEmpty()) {
			response.message = "O nome não pode ser vazio";
			return response;
		} else if (request.getCpf().isEmpty()) {
			response.message = "O cpf não pode ser vazio";
			return response;
		} else if (request.getHash().isEmpty()) {
			response.message = "o hash não pode ser vazio";
			return response;
		}

		Cliente cliente = new Cliente();
		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());

		_repository.save(cliente);

		response.message = "Cliente criado com sucesso!";
		response.statusCode = 200;

		return response;
	}

	// OBTER UM CLIENTE POR POR ID
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);

		ClienteResponse response = new ClienteResponse();

		if (cliente.get().getId() == 0) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.statusCode = 200;
		response.message = "Conta obtida com sucesso.";
		return response;
	}
}
