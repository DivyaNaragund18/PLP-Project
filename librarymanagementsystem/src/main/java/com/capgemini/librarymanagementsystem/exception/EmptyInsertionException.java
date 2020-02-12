package com.capgemini.librarymanagementsystem.exception;

public class EmptyInsertionException extends RuntimeException {
	String msg = "Please fill the Empty spaces left";

	public EmptyInsertionException(String msg) {
		super();
		this.msg = msg;
	}

	public EmptyInsertionException() {
		super();
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
