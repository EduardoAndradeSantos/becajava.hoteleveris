package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;

@SpringBootTest
public class OcupacaoTest {

	@Autowired
	private OcupacaoService service;
	
	@Test
	public void criarOcupacao() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("P");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(201,response.getStatusCode());
	}
	
	@Test
	public void situacaoPagamentoVazio() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(201,response.getStatusCode());
	}
	
	@Test
	public void semData() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("");
	request.setDiaria(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void dataNull() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData(null);
	request.setDiaria(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void DiariaZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(0);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("P");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void DiariaMenorQueZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(-1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("P");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void QuartoIdZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(1);
	request.setQuartoId(0L);
	request.setClienteId(1L);
	request.setSituacaoPagamento("P");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void ClienteIdZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("00/00/0000");
	request.setDiaria(1);
	request.setQuartoId(1L);
	request.setClienteId(0L);
	request.setSituacaoPagamento("P");

	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void pegaLista() {
	ListOcupacaoResponse obj = new ListOcupacaoResponse();
	obj.setOcupacoes(obj.getOcupacoes());
	
	BaseResponse response = service.listar();
	Assertions.assertEquals(200,response.getStatusCode());
	}
	
}
