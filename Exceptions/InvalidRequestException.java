package com.BookMyShow.Exceptions;

public class InvalidRequestException extends RuntimeException{
	
	public InvalidRequestException(String message) {
        super(message);
    }

}
