package com.fedex.shipment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBConnection {

	static String URL = "jdbc:mysql://localhost:3306/shipmentenq";
	static String USERNAME = "root";
	static String PASSWORD = "root";
	static Connection conn = null;
	static Logger log = Logger.getLogger(DBConnection.class.getName());
	//private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			System.out.println("Connection created");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
