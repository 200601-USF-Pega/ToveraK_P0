package com.revature.usedcardealership.service;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.revature.usedcardealership.dao.ICarRepo;
import com.revature.usedcardealership.models.Vehicle;

public class AddVehicles {
	String fileName = "C:\\Users\\19252\\eclipse-workspace\\UsedCarDealership2\\src\\Resources\\Inventory.txt";
	Vehicle newCar;
	ValidationService inputValidation = new ValidationService();
	ICarRepo repo;
	public AddVehicles(ICarRepo repo) {
		this.repo = repo;
	}
	
	public void addVehicle() throws FileNotFoundException, IOException {
		boolean success = false;
		do {
			int id = inputValidation.getValidInt("Please enter id of your vehicle");
			String make = inputValidation.getValidString("Please enter make of your vehicle:");
			String model = inputValidation.getValidString("Please enter model of your vehicle:");
			int year = inputValidation.getValidInt("Please enter year of your vehicle:");
			int salePrice = inputValidation.getValidInt("Please enter sale price");
			
			try {
				Vehicle newVehicle = new Vehicle(id, make, model, year, salePrice);
				System.out.println("Creating new vehicle...");
				System.out.println(newVehicle);
				this.newCar = newVehicle;
				System.out.println("New vehicle added");
				repo.addVehicle(newVehicle);
				
				success = true;
			} catch(Exception e) {
				
			}
	
		} while (!success);
		
//		
//		PrintWriter writer = null;
//		try {
//			FileWriter fileWriter = new FileWriter(fileName, true);
//			writer = new PrintWriter(fileWriter);
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		writer.print("\n"+newCar);
//		writer.close();
	}
}
