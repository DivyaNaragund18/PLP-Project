package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface ServiceLMS {
	UserInfo registerStudent(UserInfo user);
	AdminLogin login(AdminLogin admin);
	BookInfo addBook(BookInfo book);
	public BookInfo issueBook(IssuedBook issue);
	
}
