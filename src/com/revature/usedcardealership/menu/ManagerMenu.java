package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.dao.CarRepoDB;
import com.revature.usedcardealership.inventory.Inventory;
import com.revature.usedcardealership.service.AddVehicles;
import com.revature.usedcardealership.service.ValidationService;

public class ManagerMenu implements IMenu{
	AddVehicles addCar = new AddVehicles(new CarRepoDB());
	
	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
//		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("| Welcome to our Dealership! |");
		System.out.println("==============================");
		System.out.println("| Please select:             |");
		System.out.println("|                            |");
		System.out.println("| 0 -- Browse inventory      |");
		System.out.println("| 1 -- Add a vehicle         |");
		System.out.println("| 2 -- Remove a vehicle      |");
		System.out.println("| 3 -- View transactions     |");
		System.out.println("| 4 -- Return to log-in menu |");
		System.out.println("|                            |");
		System.out.println("==============================");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		//Inventory carInventory = new Inventory();
		CarRepoDB carRepoDB = new CarRepoDB();

		
		
		while (true) {
		int choice = inputValidation.getValidInt("\n Enter input here: \n");
		switch (choice) {
		
			case 0:
				carRepoDB.getAllCars();
				currentMenu = menuFactory.changeMenu("Selection Menu");
				currentMenu.menuStart();
				break;
				
			case 1:
				addCar.addVehicle();
				currentMenu = menuFactory.changeMenu("Manager");
				currentMenu.menuStart();
				break;
			case 2:
				carRepoDB.deleteCar();
				currentMenu = menuFactory.changeMenu("Manager");
				currentMenu.menuStart();
				break;
			case 3:
				carRepoDB.viewTransactions();
				currentMenu = menuFactory.changeMenu("Manager");
				currentMenu.menuStart();
				break;
			case 4:
				currentMenu = menuFactory.changeMenu("Login Menu");
				currentMenu.menuStart();
				break;
				
			default:
				System.out.println("Please enter valid input...");
				choice = 0;
				continue;
		}
		}
	}

}























