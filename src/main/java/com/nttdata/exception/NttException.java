package com.nttdata.exception;

public class NttException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NttException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    
    public NttException(String errorMessage) {
        super(errorMessage);
    }
}
