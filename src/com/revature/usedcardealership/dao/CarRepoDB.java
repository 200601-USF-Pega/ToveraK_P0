package com.revature.usedcardealership.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.revature.usedcardealership.menu.IMenu;
import com.revature.usedcardealership.menu.MenuFactory;
import com.revature.usedcardealership.models.Vehicle;
import com.revature.usedcardealership.service.ConnectionService;
import com.revature.usedcardealership.service.ValidationService;


public class CarRepoDB implements ICarRepo{
	
//	ConnectionService connectionService;
//	public CarRepoDB(ConnectionService connectionService) {
//		this.connectionService = connectionService;
//	}
	
	ConnectionService connectionService = new ConnectionService();
	
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
				
				try {
					connection.close();
				} catch(Exception e) {
					
				}
		
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
				try {
					connection.close();
				} catch(Exception e) {
					
				}
			}
		}catch (Exception e) {
			
		}
		
	}
	
	public void buyVehicle() {
		ValidationService inputValidation = new ValidationService();
		int salesId = inputValidation.getValidInt("--Please enter sales #id to process sale--");
		int vehicleId = inputValidation.getValidInt("--Please enter vehicle #id to finish processing--");
		String cFirstName = inputValidation.getValidString("--Enter customer first name--");
		String cLastName = inputValidation.getValidString("--Enter customer last name--");
		int paidPrice = inputValidation.getValidInt("--Enter amount paid--");
		
		try {
			
			
			PreparedStatement vehicleStatement = connection.prepareStatement("INSERT INTO transactions (sales_id, vehicle_id, customer_fname, customer_lname, paid_price) VALUES (?, ?, ?, ?, ?)");
			vehicleStatement.setInt(1, salesId);
			vehicleStatement.setInt(2, vehicleId);
			vehicleStatement.setString(3, cFirstName);
			vehicleStatement.setString(4, cLastName);
			vehicleStatement.setInt(5, paidPrice);
			vehicleStatement.executeUpdate();
			
			try {
				connection.close();
			} catch(Exception e) {
				
			}
	
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
//	public void getPrice() {
//		ValidationService inputValidation = new ValidationService();
//		int vehicleId = inputValidation.getValidInt("--Enter vehicle #id to confirm purchase--");
//		
//		
//		try {
//			Statement st = connection.createStatement();
//			ResultSet rs = st.executeQuery("SELECT sale_price  FROM vehicles WHERE vehicle_id =" + vehicleId +";");
//			while (rs.next()) {
//				String price = rs.getString("sale_price");
//				
//				System.out.println(price);
//				try {
//					connection.close();
//				} catch(Exception e) {
//					
//				}
//			}
//		}catch (Exception e) {
//			
//		}
//		
//	}
	
	
	
	public void deleteCar() throws FileNotFoundException, IOException {
		
		ValidationService inputValidation = new ValidationService();
		int vehicleId = inputValidation.getValidInt("\n--Input vehicle id# to delete vehicle-- \n");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		
		while(true) {
		try {
			
			PreparedStatement vehicleStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vehicle_id = (?)");
			vehicleStatement.setInt(1, vehicleId);
			vehicleStatement.executeUpdate();
			
			System.out.println("\n Vehicle id:" + vehicleId + " deleted! \n");
//			return vehicle;
			
			try {
				connection.close();
			} catch(Exception e) {
				
			}
			
			this.getAllCars();
			currentMenu = menuFactory.changeMenu("Manager");
			currentMenu.menuStart();
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		}
//		return null;
	}
	
	public void viewTransactions() {
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT customer_id, sales_id, vehicle_id, customer_fname, customer_lname, paid_price, timestamp FROM transactions");
			while (rs.next()) {
				int customerId = rs.getInt("customer_id");
				int salesId = rs.getInt("sales_id");
				int vehicleId = rs.getInt("vehicle_id");
//				String firstName = rs.getString("customer_fname");
//				String lastName = rs.getString("custom_lname");
				int price = rs.getInt("paid_price");
				String timeStamp = rs.getString("timestamp");
				
				
				
				System.out.println("Recent transactions: \n\n" + "[Customer #ID] = " + customerId + " [Associate #ID] = " + salesId + " [VIN#] = " + vehicleId + " [Price paid] = $" + price + " [Timestamp] = " + timeStamp + "\n\n\n");
				
				try {
					connection.close();
				} catch(Exception e) {
					
				}
			}
		}catch (Exception e) {
			
		}
	}
	
}
















