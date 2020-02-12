package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;

public interface UserInfoDao {
	public UserInfo userLogin(UserInfo user);
	public List<BookInfo> requestBook(BookInfo book);
	List<BookInfo> searchBook();
}
