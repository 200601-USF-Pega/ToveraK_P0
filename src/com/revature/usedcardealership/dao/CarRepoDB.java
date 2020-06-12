package com.revature.usedcardealership.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.usedcardealership.models.Vehicle;


public class CarRepoDB implements ICarRepo{
	
	Connection connection;
	
	public CarRepoDB() {
		try  {
			connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/kqvninng", 
					"kqvninng", "0zQV9mbqXy_URCIpNEQFgiVg-mqGyvZT");
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		
			try {
				
				
				PreparedStatement vehicleStatement = connection.prepareStatement("INSERT INTO vehicles VALUES (?, ?, ?, ?, ?)");
				vehicleStatement.setInt(1, vehicle.getId());
				vehicleStatement.setString(2, vehicle.getMake());
				vehicleStatement.setString(3, vehicle.getModel());
				vehicleStatement.setInt(4, vehicle.getYear());
				//vehicleStatement.setBoolean(5, vehicle.isForSale()?1:0);
				vehicleStatement.setInt(5, vehicle.salePrice());
				vehicleStatement.executeUpdate();
		
				return vehicle;
				
			} catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
			
			return null;
			
		}

	@Override
	public void getAllCars() {
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT car_year, make, model  FROM vehicles");
			while (rs.next()) {
				String model = rs.getString("model");
				String make = rs.getString("make");
				int year = rs.getInt("car_year");
				
				System.out.println(year + " " + make + " " + model);
			}
		}catch (Exception e) {
			
		}
	}

}
