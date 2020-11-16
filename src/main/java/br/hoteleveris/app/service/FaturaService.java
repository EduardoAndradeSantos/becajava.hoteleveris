package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class FaturaService {

	@Autowired
	private OcupacaoRepository ocupacaoRepository;

	// PROPRIEDADES
	private String hashContaHotel = "H0T3L3V3R1S";

	// METODO DE INSERIR FATURA
	public BaseResponse transferencia() {
		BaseResponse response = new BaseResponse();

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacoes/transferencia";

		// ENCHE O OBJETO LISTA COM OCUPAÇÕES QUE NÃO FORAM PAGAS
		List<Ocupacao> lista = ocupacaoRepository.findBySituacaoPagamento("N");

		if (lista.isEmpty()) {
			response.statusCode = 400;
			response.message = "Não existem clientes em divida";
			return response;
		}
		
		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getDiaria();

			TransferenciaRequest objtransferencia = new TransferenciaRequest();
			objtransferencia.setHashDestino(hashContaHotel);
			objtransferencia.setHashOrigem(ocupacao.getCliente().getHash());
			objtransferencia.setValor(valor);

			restTemplate.postForObject(uri, objtransferencia, BaseResponse.class);

			ocupacao.setSituacaoPagamento("P");
			ocupacaoRepository.save(ocupacao);
		}
		response.statusCode = 200;
		response.setMessage("Transação feita com sucesso");
		return response;
	}

}
