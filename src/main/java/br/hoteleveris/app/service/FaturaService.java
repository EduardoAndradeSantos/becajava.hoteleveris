package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class FaturaService {
	
	@Autowired
	private OcupacaoRepository ocupacaoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private TipoQuartoRepository tipoQuartoRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	// PROPRIEDADES
	private String hashContaHotel = "H0T3L3V3R1S";
	
	// METODO DE INSERIR FATURA
	public void inserir() {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacoes/transferencia";
		
		// ENCHE O OBJETO LISTA COM OCUPAÇÕES QUE NÃO FORAM PAGAS
		List<Ocupacao> lista = ocupacaoRepository.findBySituacaoPagamento("N");
		
		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getDiaria();
			
			TransferenciaRequest objtransferencia = new TransferenciaRequest();
			objtransferencia.setHashDestino(hashContaHotel);
			objtransferencia.setHashOrigem(ocupacao.getCliente().getHash());
			objtransferencia.setValor(valor);
			
			BaseResponse response = restTemplate.postForObject(uri, objtransferencia, BaseResponse.class);
			
			ocupacao.setSituacaoPagamento("P");
			ocupacaoRepository.save(ocupacao);
			
		}
	}
	

}
