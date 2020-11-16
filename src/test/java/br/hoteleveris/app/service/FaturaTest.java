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
	
//	@Test
//	 public void fazTransferencia() {
//		Assertions.assertEquals(200,"Faturas inseridas com sucesso");
//	}
}
