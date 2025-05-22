package org.serratec.trabalho.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex,
	    HttpHeaders headers,
	    HttpStatusCode status,
	    WebRequest request) {

	    List<String> erros = new ArrayList<>();
	    for (FieldError e: ex.getBindingResult().getFieldErrors()) {
	        erros.add(e.getField() + ": " + e.getDefaultMessage());
	    }

	    return super.handleExceptionInternal(
	        ex,
	        new ResponseFuncionarioException(status.value(), "Campos inválidos", LocalDateTime.now(), erros),
	        headers,
	        status,
	        request
	    );
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
	    HttpMessageNotReadableException ex,
	    HttpHeaders headers,
	    HttpStatusCode status,
	    WebRequest request) {

	    List<String> erros = new ArrayList<>();
	    erros.add(ex.getMostSpecificCause().getMessage());

	    return super.handleExceptionInternal(
	        ex,
	        new ResponseFuncionarioException(status.value(), "erro de leitura", LocalDateTime.now(), erros),
	        headers,
	        status,
	        request
	    );
	}
}