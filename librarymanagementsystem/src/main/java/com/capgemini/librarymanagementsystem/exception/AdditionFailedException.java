package com.capgemini.librarymanagementsystem.exception;

public class AdditionFailedException extends RuntimeException {
	String msg = "Unable to add books to the table";

	public AdditionFailedException() {
		super();
	}

	public AdditionFailedException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
