package com.revature.usedcardealership.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

	private Connection connection;
	
	public ConnectionService() {
//		try  {
//			connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/kqvninng", 
//					"kqvninng", "0zQV9mbqXy_URCIpNEQFgiVg-mqGyvZT");
//			
//		} catch (SQLException e) {
//			System.out.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {
			
		}
   }
}
