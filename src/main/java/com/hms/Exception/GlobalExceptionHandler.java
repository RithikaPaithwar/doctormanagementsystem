package com.hms.Exception;

import java.util.Date;
import com.hms.Exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExHandling(ResourceNotFoundException exception,
			WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(), 
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

}}
