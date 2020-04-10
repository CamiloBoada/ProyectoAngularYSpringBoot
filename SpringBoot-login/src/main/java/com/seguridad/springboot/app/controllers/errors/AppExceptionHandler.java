package com.seguridad.springboot.app.controllers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.classic.Logger;


@ControllerAdvice
public class AppExceptionHandler{
	
	Logger logger;
	
	public static final String INTERNAL_ERROR_CUSTOM_MESSAGE = "Error";

	@ExceptionHandler()
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error")
	public void everyException(EntityNotFoundException e) {
		logger.info(INTERNAL_ERROR_CUSTOM_MESSAGE);
	}

}
