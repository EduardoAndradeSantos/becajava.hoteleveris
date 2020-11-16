package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class QuartoTest {

	@Autowired
	private QuartoService service;
	
	@Test
    public void criar() {
        QuartoRequest request =  new QuartoRequest();
        request.setAndar(32);

        List<ComodidadeRequest> teste = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest comodidade = new ComodidadeRequest();
        comodidade.setId(1L);
        teste.add(comodidade);

        request.setComodidades(teste);
        request.setIdTipoQuarto(1L);
        request.setNumero(777);
        request.setSituacao("Ativo");

        BaseResponse response = service.criar(request);
        Assertions.assertEquals(201, response.getStatusCode());

    }

	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
	}

}
