package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.usedcardealership.inventory.Inventory;
import com.revature.usedcardealership.service.ValidationService;

public class SelectionMenu implements IMenu{
	Connection connection;
	
	public SelectionMenu() {
		try  {
			connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/kqvninng", 
					"kqvninng", "0zQV9mbqXy_URCIpNEQFgiVg-mqGyvZT");
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		Inventory carInventory = new Inventory();
		List<Integer> yearList = new ArrayList<Integer>();
		int carYear;
		List<String> makeList = new ArrayList<String>();
		String carMake;
		List<String> modelList = new ArrayList<String>();
		String carModel;

		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT car_year, make, model  FROM vehicles");
			while (rs.next()) {
				String model = rs.getString("model");
				String make = rs.getString("make");
				int year = rs.getInt("car_year");
				
		//		System.out.println(year + " " + make + " " + model);
				yearList.add(year);
				makeList.add(make);
				modelList.add(model);
			}
			
		}catch (Exception e) {
			
		}

		while(true) {
		carYear = inputValidation.getValidInt("\n--Please input year of vehicle selected-- \n");
		carMake = inputValidation.getValidString("\n--Please input make of vehicle selected-- \n");
		carModel = inputValidation.getValidString("\n--Please input model of vehicle selected-- \n");
		
		if(yearList.contains(carYear) && makeList.contains(carMake) && modelList.contains(carModel)) {
			System.out.println("You have selected: " + carYear + " " + carMake + " " + carModel + "\n");
			TestDriveBuyMenu.buyCar = carYear + " " + carMake + " " + carModel + "\n";
			
			try {
				connection.close();
			} catch(Exception e) {
				
			}
			
			currentMenu = menuFactory.changeMenu("Test or Buy");
			currentMenu.menuStart();
		} else {
			System.out.println("--Invalid input please try again--");
		}
		}
	//	while (true) {
		
	//	int choice = inputValidation.getValidInt("\n Enter [0] to select vehicle... \n Enter [1] to exit ...");
	//	Scanner scan = new Scanner(System.in);		

		
		
//		switch (choice) {
//			
//			case 0:
//
//				try {
//					carInventory.selectInventory(carSelection);
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				currentMenu = menuFactory.changeMenu("Test or Buy");
//				currentMenu.menuStart();
//				break;
//				
//			case 1:
//				System.out.println("Thanks for using this app Good Bye!");
//				System.exit(0);
//				break;
//			
//			default:
//				System.out.println("Please enter valid input...");
//				choice = 0;
//				continue;
//		}
		}
		
	}