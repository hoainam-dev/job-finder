package com.jobfinder.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
	
	public static void  main(String args[]) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/jobfinder?useSSL=false";
		String username = "root";
		String password = "410101";
		
		try {
			System.out.println("Connecting to the database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successfully !");
		} catch (Exception exc ) {
			System.out.println(exc);
		}
	}

}
