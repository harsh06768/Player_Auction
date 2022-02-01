package com.player.auction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String message; 
	
	public ResourceNotFoundException() {
		super();
		
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message; 
		
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
	
}
