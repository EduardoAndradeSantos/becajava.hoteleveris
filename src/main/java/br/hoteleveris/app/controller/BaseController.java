package br.hoteleveris.app.controller;

import br.hoteleveris.app.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.message = "Erro inesperado";
		errorBase.statusCode = 500;
	}
}
