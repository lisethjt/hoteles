package com.hoteles.infraestructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hoteles.infraestructure.exception.HotelException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(HotelException.class)
	public ResponseEntity<String> handleEmptyInput(HotelException emptyInputException) {
		return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
	}
}