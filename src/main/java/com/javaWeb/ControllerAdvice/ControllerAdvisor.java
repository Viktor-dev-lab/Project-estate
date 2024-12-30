package com.javaWeb.ControllerAdvice;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaWeb.Exception.FeldRequiredException;
import com.javaWeb.model.ErrorResponeDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            ArithmeticException ex, WebRequest request) 
	{
		ErrorResponeDTO errorResponseDTO = new ErrorResponeDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Integer cannot be divided by 0.");
		errorResponseDTO.setDetails(details);
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		
    }
	
	@ExceptionHandler(FeldRequiredException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
    		FeldRequiredException ex, WebRequest request) 
	{
		ErrorResponeDTO errorResponseDTO = new ErrorResponeDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Lỗi định dạng đầu vào.");
		errorResponseDTO.setDetails(details);
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
		
    }
}
