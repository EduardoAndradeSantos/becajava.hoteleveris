package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class QuartoTest {

	@Autowired
	private QuartoService service;
	
	@Test
    public void criarQuarto() {
        QuartoRequest request =  new QuartoRequest();
        request.setAndar(50);
        request.setNumero(777);
        request.setSituacao("Ativo");
        request.setIdTipoQuarto(1L);

        BaseResponse response = service.criar(request);
       
        Assertions.assertEquals(201, response.getStatusCode());

    }

	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
	}

}
