package com.capgemini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.AdditionFailedException;
import com.capgemini.librarymanagementsystem.exception.IssueBookException;
import com.capgemini.librarymanagementsystem.exception.LoginFailedException;
import com.capgemini.librarymanagementsystem.service.ServiceLMS;
import com.capgemini.librarymanagementsystem.service.ServiceLMSImpl;

public class LibraryMangementSystemApp {

	static Logger log = Logger.getLogger(LibraryMangementSystemApp.class);

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.info("------------WELCOME TO CENTRAL LIBRARY-----------------");
		while (true) {
			log.info("--------------------");
			log.info("Choose appropriate option.....!!!!!!");
			log.info("Press 1 for AdminLogin");
			log.info("Press 2 for AccountCreation");
			log.info("Press 3 for UserLogin");
			log.info("Press 0 to Close Application");
			log.info("---------------------");
			ServiceLMS service = new ServiceLMSImpl();
			int choice = Integer.parseInt(sc.next());
			if (choice == 1) {
				AdminLogin admin = null;
				try {
					admin = AdminController.login(admin);
				} catch (LoginFailedException e) {
					e.printStackTrace();
				}
				if (admin != null) {
					log.info("HELLO ADMIN!!!");
				boolean b = true;
				while (b) {
					log.info("*******************************");
					log.info("Enter Your Choice!!!!");
					log.info("1.AddBook to Library");
					log.info("2.Issue Book from Library");
					log.info("3.Remove Book from Library");
					log.info("4.Press for Fine");
					log.info("Press 0 for Logout");
					int ch = Integer.parseInt(sc.next());

					switch (ch) {
					case 1:
						BookInfo book = new BookInfo();
						try {
							book = AdminController.addBook(book);
						} catch (AdditionFailedException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						IssuedBook issue = new IssuedBook();
						try {

							AdminController.issueBook(issue);
						} catch (IssueBookException e) {
							e.printStackTrace();
						}
						break;
					case 3:
						BookInfo book1 = new BookInfo();
						try {
							AdminController.removeBook(book1);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 4:
						
					case 0:
						b = false;
						break;
					default:
						log.info("Choose Appropriate Option");
					}
				}
			}else {
				throw new LoginFailedException();
			}
		}else if(choice==3) {
			UserInfo user=null;
			try {
				user=UserController.userLogin(user);
			}catch(LoginFailedException e) {
				e.printStackTrace();
			}
			if(user!=null) {
				log.info("Hello"+user.getName());
				boolean b=true;
				while(b) {
					log.info("Press 1 to Search Book");
					log.info("Press 2 for requesting book");
					log.info("Press 0 to Logout");
					int option=Integer.parseInt(sc.next());
					switch(option) {
					case 1:
						List<BookInfo> book = null;
						
						try {
							book=UserController.searchBook();
						} catch (Exception e) {
							
						}
						
					}
				}
			}
		}
	}
}
}