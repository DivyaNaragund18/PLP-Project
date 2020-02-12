package com.capgemini.librarymanagementsystem.exception;

public class BookNotFoundException extends RuntimeException {
	String msg="Requested Book Is Not Avaliable in Library";

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	

}
