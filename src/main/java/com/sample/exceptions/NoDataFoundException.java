package com.sample.exceptions;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = -1664467873590351601L;

	private final String message;

	public NoDataFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
