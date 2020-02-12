package com.capgemini.librarymanagementsystem.factory;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminLoginDao;
import com.capgemini.librarymanagementsystem.dao.AdminLoginDaoImpl;
import com.capgemini.librarymanagementsystem.dao.UserInfoDao;
import com.capgemini.librarymanagementsystem.dao.UserInfoDaoImpl;
import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public class Factory {
	private Factory() {

	}

	public static AdminLoginDao getAdmDao() {
		AdminLoginDao dao = new AdminLoginDaoImpl();
		return dao;
	}

	public static AdminLogin getAdmBean() {
		AdminLogin bean = new AdminLogin();
		return bean;
	}

	public static UserInfo getUserBean() {
		UserInfo user = new UserInfo();
		return user;
	}

	public static BookInfo getBookBean() {
		BookInfo bean = new BookInfo();
		return bean;
	}

	public static UserInfoDao getUserDaoBean() {
		UserInfoDao usd = new UserInfoDaoImpl();
		return usd;
	}

	public static IssuedBook getIsuBean() {
		IssuedBook book = new IssuedBook();
		return book;
	}

}
