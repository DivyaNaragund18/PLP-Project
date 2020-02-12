package com.capgemini.librarymanagementsystem.controller;

import java.sql.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dao.AdminLoginDao;
import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.exception.BookNotFoundException;
import com.capgemini.librarymanagementsystem.exception.EmptyInsertionException;
import com.capgemini.librarymanagementsystem.exception.IssueBookException;
import com.capgemini.librarymanagementsystem.exception.LoginFailedException;
import com.capgemini.librarymanagementsystem.factory.Factory;
import com.capgemini.librarymanagementsystem.service.ServiceLMS;
import com.capgemini.librarymanagementsystem.service.ServiceLMSImpl;

public class AdminController {
	static ServiceLMS service = new ServiceLMSImpl();
	static Scanner sc = new Scanner(System.in);
	static Logger log = Logger.getLogger(AdminController.class);

	public static AdminLogin login(AdminLogin admin) throws LoginFailedException {
		log.info("------WELCOME ADMIN-------");
		log.info(" Enter RegistrationNo");
		int registrationNo = sc.nextInt();
		log.info("Enter Name");
		String name = sc.next();
		log.info("Enter Password");
		String password = sc.next();
		AdminLoginDao dao = Factory.getAdmDao();
		AdminLogin ad = dao.login(admin);
		if (registrationNo == ad.getRegistrationNo() && password.equals(ad.getPassword())) {
			log.info("Admin Login Successfull");
		} else {
			throw new LoginFailedException();
		}
		return ad;
	}

	public static BookInfo addBook(BookInfo book) throws EmptyInsertionException {
		log.info("enter Book Id");
		book.setBookId(sc.nextInt());
		log.info("enter Book Name");
		book.setBookName(sc.next());
		log.info("enter author");
		book.setAuthor(sc.next());
		log.info("enter category");
		book.setCategory(sc.next());
		log.info("enter price");
		book.setPrice(sc.nextDouble());
		AdminLoginDao dao = Factory.getAdmDao();
		BookInfo info = dao.addBook(book);
		if (info != null) {
			log.info("Added Book Sucessfully");
		} else {
			throw new EmptyInsertionException();
		}
		return book;
	}

	public static BookInfo issueBook(IssuedBook issue) {
		BookInfo book = new BookInfo();
		log.info("Enter BookId");
		issue.setBookId(sc.nextInt());
		log.info("Enter Registration No");
		issue.setRegistrationNo(sc.nextInt());
		log.info("Enter IssueDate");
		issue.setIssueDate(Date.valueOf(sc.next()));
		log.info("Enter Return Date");
		issue.setReturnDate(Date.valueOf(sc.next()));
		AdminLoginDao dao = Factory.getAdmDao();
		BookInfo isB = dao.issueBook(issue);
		if (isB != null) {
			log.info("Issued Book successfully for" + " " + issue.getRegistrationNo());
		} else {
			throw new IssueBookException();
		}
		return book;

	}

	public static BookInfo removeBook(BookInfo book1) {
		log.info("Enter the BookId to be removed");
		book1.setBookId(sc.nextInt());
		AdminLoginDao dao = Factory.getAdmDao();
		BookInfo rmv = dao.removeBook(book1);
		if (rmv != null) {
			log.info("Removed" + " " + rmv.getBookId() + "from Library");
		} else {
			log.info("Unable to remove book");
		}
		return rmv;

	}

}
