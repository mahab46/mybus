package com.bus.booking_service.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class BookingException extends RuntimeException{
//It is a unique identifier for each version of a serializable class. If you modify the class (e.g., add a new field), you should change the serialVersionUID to reflect this change.
	private static final long serialVersionUID = 1L;


	public BookingException(String message) {
		super(message);
	}
}
