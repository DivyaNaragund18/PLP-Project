package com.capgemini.librarymanagementsystem.util;

import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dto.IssuedBook;

public class BookFine {
	static Logger log = Logger.getLogger(BookFine.class);
	public void fine() {
		IssuedBook book = new IssuedBook();
		Scanner sc = new Scanner(System.in);
		int bookId = sc.nextInt();
		if (book.getBookId() == bookId) {
			Date issueDate = book.getIssueDate();
			Date todayDate = new Date();
			long diff = todayDate.getTime() - issueDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if (diffDays > 10) {
				int fine = (int) (diffDays - 10);
				fine = fine * 10;
				log.info("Total Fine " + fine + " Rs.");
			}
		}
	}
}
