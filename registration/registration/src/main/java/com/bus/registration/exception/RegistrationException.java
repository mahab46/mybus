package com.bus.registration.exception;

public class RegistrationException extends RuntimeException {
//It is a unique identifier for each version of a serializable class. If you modify the class (e.g., add a new field), you should change the serialVersionUID to reflect this change.
	private static final long serialVersionUID = 1L;

	public RegistrationException(String message) {
		super(message);
	}
	
	

}
