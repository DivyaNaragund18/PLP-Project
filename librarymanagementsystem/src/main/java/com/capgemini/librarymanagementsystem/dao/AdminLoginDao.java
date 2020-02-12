package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface AdminLoginDao {
	public AdminLogin login(AdminLogin admin);
	public UserInfo registerStudent(UserInfo user);
	public BookInfo addBook(BookInfo book);
	public BookInfo removeBook(BookInfo book);
	BookInfo issueBook(IssuedBook issue);
}
