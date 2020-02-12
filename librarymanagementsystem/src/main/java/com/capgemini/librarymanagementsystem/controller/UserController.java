package com.capgemini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dao.UserInfoDao;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.LoginFailedException;
import com.capgemini.librarymanagementsystem.factory.Factory;
import com.capgemini.librarymanagementsystem.service.ServiceLMS;
import com.capgemini.librarymanagementsystem.service.ServiceLMSImpl;

public class UserController {
	static ServiceLMS service = new ServiceLMSImpl();
	static Scanner sc = new Scanner(System.in);
	static Logger log = Logger.getLogger(UserController.class);
	
	public static UserInfo userLogin(UserInfo user) throws LoginFailedException {
		log.info("Enter Your Valid Registration Number");
		int registrationNo = sc.nextInt();
		log.info("Enter valid password"); 
		String password = sc.next();
		UserInfoDao dao=Factory.getUserDaoBean();
		UserInfo info=dao.userLogin(user);
		 if(registrationNo == info.getRegistrationNo() && password.equals(info.getPassword())) {
			 System.out.println("Login Successfully");
		 }else {
			 throw new LoginFailedException();
		 }
		return info;
	}
	public static List<BookInfo> searchBook(){
		log.info("Available BOOKS");
		UserInfoDao dao=Factory.getUserDaoBean();
		List<BookInfo> info= dao.searchBook();
		for(BookInfo b:info) {
			log.info(b.getBookId());
			log.info(b.getBookName());
			log.info(b.getAuthor());
			log.info(b.getCategory());
			log.info(b.getPrice());
			log.info("************************");
			
		}
		
		
		return null;
		
	}
}
