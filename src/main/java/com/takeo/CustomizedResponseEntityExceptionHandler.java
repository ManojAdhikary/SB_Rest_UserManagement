package com.takeo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//defining excepion handling for all the excepiton
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>handleAllExcetions(Exception ex, WebRequest request){
		//creating exception response structure
		ExceptionResponse exceptionResoponse= new ExceptionResponse(request.getDescription(false), ex.getMessage(),new Date());
		//returning excepiton stru and specific status
		return new ResponseEntity<>(exceptionResoponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object>handleUserNotfoundExcetions(Exception ex, WebRequest request){
		//creating exception response structure
		ExceptionResponse exceptionResoponse= new ExceptionResponse(request.getDescription(false), ex.getMessage(),new Date());
		//returning excepiton stru and specific status
		return new ResponseEntity<>(exceptionResoponse,HttpStatus.NOT_FOUND);
	}

}
