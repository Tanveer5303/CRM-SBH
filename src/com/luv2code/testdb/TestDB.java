package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
public static void main(String[] args) {
	String user = "springstudent";
	String pass = "springstudent";
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
	String driver = "com.mysql.cj.jdbc.Driver";

	try {
		System.out.println("Connecting...");
		Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("connected ...");
	}
	catch(Exception exc) {
		exc.printStackTrace();
	}

}
}
