package com.capgemini.librarymanagementsystem.exception;

public class IssueBookException extends RuntimeException {
	String msg="Without Requesting Cannot Issue Book";

	public IssueBookException() {
		super();
	}

	public IssueBookException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

	

	
}
