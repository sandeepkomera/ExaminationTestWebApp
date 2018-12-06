package com.slokam.Examination.exception;

import java.io.IOException;import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OurExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception e) {
		System.out.println("we are in Exception Class");
		e.printStackTrace();
	}
	
	@ExceptionHandler(IOException.class)
	public void IoException(IOException io) {
		System.out.println("IoHandling Exception");
		io.printStackTrace();
	}
	@ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	public ResponseEntity<String> dBException(InvalidDataAccessResourceUsageException db) {
		System.out.println("InvalidDataAccessResourceUsageException");
		ResponseEntity<String> re= new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		db.printStackTrace();
		return re;
	}

}
