package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.implement.QuartoServiceImp;

@SpringBootTest
public class QuartoTest {

		@Autowired
		private QuartoServiceImp service;

		public int getNumeroRandomico(int min, int max) {
			Random random = new Random();
			return random.ints(min, max).findFirst().getAsInt();
		}

		@Test
		public void criarQuarto() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(2);
			request.setIdTipoQuarto(1L);
			request.setSituacao("A");
			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(nq);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(201, response.getStatusCode());
		}
		
		@Test
		public void criarQuartoSemAndar() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(0);
			request.setIdTipoQuarto(1L);
			request.setSituacao("A");
			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(nq);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void criarQuartoNumeroZero() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(2);
			request.setIdTipoQuarto(1L);
			request.setSituacao("A");
//			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(0);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void criarQuartoNumeroMenorQueZero() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(2);
			request.setIdTipoQuarto(1L);
			request.setSituacao("A");
//			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(-1);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void criarQuartoSituacaoVazia() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(2);
			request.setIdTipoQuarto(0L);
			request.setSituacao("");
			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(nq);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void criarQuartoSituacaoNull() {

			QuartoRequest request = new QuartoRequest();
			request.setAndar(2);
			request.setIdTipoQuarto(1L);
			request.setSituacao(null);
			int nq = this.getNumeroRandomico(1, 1000);
			request.setNumero(nq);
			
			List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
			ComodidadeRequest obj = new ComodidadeRequest();
			obj.setId(1L);
			comodidades.add(obj);
			
			request.setComodidades(comodidades);
			
			BaseResponse response = service.criar(request);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void obterPorId() {			
			BaseResponse response = service.obter(1L);
			Assertions.assertEquals(200, response.getStatusCode());
		}
		
		@Test
		public void obterPorIdzero() {
			BaseResponse response = service.obter(0L);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void obterPorIdTipoQuarto() {
			BaseResponse response = service.listar(1L);
			Assertions.assertEquals(200, response.getStatusCode());
		}
		
		@Test
		public void atualizarSituacaoQuartoPorId() {
			SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
			sr.setSituacao("A");
			
			BaseResponse response = service.atualizar(1L, sr);
			Assertions.assertEquals(200, response.getStatusCode());
		}
		
		@Test
		public void atualizarSituacaoQuartoSituacaoVazia() {
			SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
			sr.setSituacao("");
			
			BaseResponse response = service.atualizar(1L, sr);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void atualizarSituacaoQuartoSituacaoNull() {
			SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
			sr.setSituacao(null);
			
			BaseResponse response = service.atualizar(1L, sr);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void atualizarSituacaoQuartoIdZero() {
			SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
			sr.setSituacao("A");
			
			BaseResponse response = service.atualizar(0L, sr);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		
		@Test
		public void atualizarSituacaoQuartoIdMenorQueZero() {
			SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
			sr.setSituacao("A");
			
			BaseResponse response = service.atualizar(-1L, sr);
			Assertions.assertEquals(400, response.getStatusCode());
		}
		

}
