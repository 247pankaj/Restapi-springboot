package com.pankaj.restapidemo.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(Long id) {
		super("Unable to get details for " + id);
	}

}
