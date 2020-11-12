package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ComodidadeService;

@RestController
@RequestMapping("/comodidades")
public class ComodidadeController extends BaseController {
	
	@Autowired 
	ComodidadeService _service;
	
	// POST - CRIAR UM CLIENTE
		@PostMapping
		public ResponseEntity<BaseResponse> criar(@RequestBody ComodidadeRequest request) {
			try {
				BaseResponse response = _service.criar(request);
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}

		// GET - OBTER POR ID
		@GetMapping(path = "/{id}")
		public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
			try {
				BaseResponse response = _service.obter(id);
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}

}
