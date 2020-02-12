package com.capgemini.librarymanagementsystem.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.IssuedBook;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.BookNotFoundException;
import com.capgemini.librarymanagementsystem.exception.IssueBookException;
import com.capgemini.librarymanagementsystem.factory.Factory;

public class AdminLoginDaoImpl implements AdminLoginDao {

	static Logger log = Logger.getLogger(AdminLoginDaoImpl.class);

	FileInputStream input;
	Properties prop;
	AdminLogin bean = Factory.getAdmBean();

	public AdminLoginDaoImpl() {
		try {
			input = new FileInputStream("db.properties");
			prop = new Properties();
			prop.load(input);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AdminLogin login(AdminLogin admin) {
		admin = new AdminLogin();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root",
					"divya");
			stmt = conn.createStatement();
			String query1 = "SELECT registrationNo,password from login where type='admin'";

			ResultSet rs = stmt.executeQuery(query1);
			if (rs.next()) {
				admin = new AdminLogin();
				admin.setRegistrationNo(rs.getInt(1));
				admin.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public UserInfo registerStudent(UserInfo user) {
		AdminLogin admin = null;
		String query1 = "INSERT INTO login values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root",
					"divya");
			pstmt = conn.prepareStatement(query1);

			pstmt.setInt(1, user.getRegistrationNo());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmailId());
			pstmt.setLong(5, user.getMobileNo());
			pstmt.setString(6, user.getType());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public BookInfo addBook(BookInfo book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = " insert into bookinfo values(?,?,?,?,?) ";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root",
					"divya");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getCategory());
			pstmt.setDouble(5, book.getPrice());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return book;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	@Override
	public BookInfo issueBook(IssuedBook issue) {
		BookInfo book = new BookInfo();
		IssuedBook isbook = Factory.getIsuBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String Query = "insert into issuedBook values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			conn = DriverManager.getConnection(dburl, "root", "divya");
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, isbook.getBookId());
			pstmt.setInt(2, isbook.getRegistrationNo());
			pstmt.setDate(3, isbook.getIssueDate());
			pstmt.setDate(4, isbook.getReturnDate());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return book;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new IssueBookException();
		}
	}

	@Override
	public BookInfo removeBook(BookInfo book) {
		BookInfo rmvbook = Factory.getBookBean();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			conn = DriverManager.getConnection(dburl, "root", "divya");
			String Query = "Delete from bookinfo where bookId=?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, book.getBookId());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return book;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

}
