package com.capgemini.librarymanagementsystem.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.dto.AdminLogin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.UserInfo;
import com.capgemini.librarymanagementsystem.exception.BookNotFoundException;
import com.capgemini.librarymanagementsystem.factory.Factory;

public class UserInfoDaoImpl implements UserInfoDao {

	static Logger log = Logger.getLogger(AdminLoginDaoImpl.class);

	FileInputStream input;
	Properties prop;

	public UserInfoDaoImpl() {
		try {
			input = new FileInputStream("db.properties");
			prop = new Properties();
			prop.load(input);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("driver Can not");
		}
	}

	@Override
	public UserInfo userLogin(UserInfo user) {
		UserInfo usd = new UserInfo();
		String query1 = "SELECT registrationNo,password from login where type='user'";
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root",
					"divya");
			pstmt = conn.createStatement();

			rs = pstmt.executeQuery(query1);
			user = new UserInfo();
			if (rs.next()) {
				user.setRegistrationNo(rs.getInt(1));
				user.setPassword(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}

	@Override
	public List<BookInfo> searchBook() {
		List<BookInfo> list=new ArrayList<BookInfo>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String dburl="jdbc:mysql://localhost:3306/library_management_system";
			conn=DriverManager.getConnection(dburl,"root", "divya");
			String query =" select * from bookInfo ";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				BookInfo book = new BookInfo();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				list.add(book);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(SQLException e1) {
			  e1.printStackTrace();
			}	
		}
		return null;
	}

	@Override
	public List<BookInfo> requestBook(BookInfo book) {
		List<BookInfo> list=new ArrayList<BookInfo>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			String dburl="jdbc:mysql://localhost:3306/library_management_system";
			conn=DriverManager.getConnection(dburl,"root", "divya");
			String query =" select * from bookInfo where bookId=?";
			stmt=conn.prepareStatement(query);
			BookInfo bookInfo=new BookInfo();
			bookInfo.getBookId();
			bookInfo.getBookName();
			bookInfo.getAuthor();
			bookInfo.getCategory();
			bookInfo.getPrice();
			int count=stmt.executeUpdate();
			if(count>0 && count<=3) {
				log.info("Requested for"+ count + "Books");
			}else {
				throw new BookNotFoundException();
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
}



