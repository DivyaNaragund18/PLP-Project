package com.capgemini.librarymanagementsystem.exception;

public class LoginFailedException extends RuntimeException {
	String msg="Unable to login,Please enter Valid Credentials ";

	public LoginFailedException() {
		super();
	}

	public LoginFailedException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
