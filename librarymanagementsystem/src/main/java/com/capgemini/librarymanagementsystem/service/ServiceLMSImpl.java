package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dao.AdminLoginDao;
import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.factory.Factory;

public class ServiceLMSImpl implements ServiceLMS {
	AdminLoginDao sdao = Factory.getAdmDao();

	@Override
	public UserInfo registerStudent(UserInfo user) {

		return sdao.registerStudent(user);
	}

	@Override
	public AdminLogin login(AdminLogin admin) {
		return sdao.login(admin);
	}

	@Override
	public BookInfo addBook(BookInfo book) {
		return sdao.addBook(book);
	}

	@Override
	public BookInfo issueBook(IssuedBook issue) {
		return sdao.issueBook(issue);
	}

}
