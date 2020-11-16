package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ComodidadeTest {

	@Autowired
	ComodidadeService service;

	@Test
	public void criarComodidade() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setId(1L);
		request.setNome("NomeComodidadeTeste");

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeSemNome() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setId(1L);
//		request.setNome("NomeComodidadeTeste");

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeNomeNulo() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setId(1L);
		request.setNome(null);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeNomeVazio() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setId(1L);
		request.setNome("");

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void obterPorId() {
		BaseResponse response = service.obter(1L);
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void obterPorIdNaoExistente() {
		BaseResponse response = service.obter(999999L);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	
	
}