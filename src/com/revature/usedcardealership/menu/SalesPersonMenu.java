package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.dao.CarRepoDB;
import com.revature.usedcardealership.inventory.Inventory;
import com.revature.usedcardealership.service.ValidationService;

public class SalesPersonMenu implements IMenu{

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("| Welcome to our Dealership! |");
		System.out.println("==============================");
		System.out.println("| Please select:             |");
		System.out.println("|                            |");
		System.out.println("|  0 -- Browse inventory     |");
		System.out.println("|  1 -- Return to log-in menu|");
		System.out.println("|                            |");
		System.out.println("==============================");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		CarRepoDB carRepoDB = new CarRepoDB();
		
		while (true) {
		int choice = inputValidation.getValidInt("Enter input here:");
		switch (choice) {
		
			case 0:
				carRepoDB.getAllCars();
//				carInventory.showInventory();
				currentMenu = menuFactory.changeMenu("Selection Menu");
				currentMenu.menuStart();
				break;
				
			case 1:
				currentMenu = menuFactory.changeMenu("Login Menu");
				currentMenu.menuStart();
				break;
				
			default:
		}
		}
	}

}
