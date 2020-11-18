package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	private ClienteService service;
	
	@Test
	public void criarClienteCompleto(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("nome");
		request.setCpf("12345678");
		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(201,response.getStatusCode());
	}
	
	@Test
	public void criarSemNome(){
		ClienteRequest request = new ClienteRequest();
//		request.setNome("nome");
		request.setCpf("12345678");
		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarSemCpf(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("nome");
//		request.setCpf("12345678");
		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarSemHash(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("nome");
		request.setCpf("12345678");
//		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarNomeNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome(null);
		request.setCpf("12345678");
		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarCpfNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("nome");
		request.setCpf(null);
		request.setHash("HAUSHAAUEHIJD");
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarHashNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("nome");
		request.setCpf("12345678");
		request.setHash(null);
		
		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400,response.getStatusCode());
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
