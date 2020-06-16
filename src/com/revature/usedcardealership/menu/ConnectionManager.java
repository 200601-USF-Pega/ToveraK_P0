package com.revature.usedcardealership.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.usedcardealership.service.ConnectionService;

public class ConnectionManager {
	
	public static Connection getConnection() {
		
		Connection connection;
		
		try  {
			connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/kqvninng", 
					"kqvninng", "0zQV9mbqXy_URCIpNEQFgiVg-mqGyvZT");
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return connection;
	}
	
	public static void closeConnection() {

		try {
			ConnectionManager.getConnection().close();
		} catch(Exception e) {
			
		}
	}

}
