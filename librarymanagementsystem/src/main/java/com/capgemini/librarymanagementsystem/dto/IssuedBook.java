package com.capgemini.librarymanagementsystem.dto;

import java.sql.Date;
import java.time.LocalDate;

public class IssuedBook {
	private int registrationNo;
	private int bookId;
	private Date issueDate;
	private Date returnDate;
	public int getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	

}
