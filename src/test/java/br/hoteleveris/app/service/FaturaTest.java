package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class FaturaTest {

	@Autowired
	private FaturaService service;
	
	@Test
	 public void fazTransferenciaComDevedores() {
		BaseResponse response = service.transferencia();
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
//	@Test
//	 public void fazTransferenciaSemDevedores() {
//		BaseResponse response = service.transferencia();
//		Assertions.assertEquals(400,response.getStatusCode());
//	}
}
