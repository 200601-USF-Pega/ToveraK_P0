package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.service.ValidationService;

public class LogInMenu implements IMenu{

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("| Welcome to our Dealership! |");
		System.out.println("==============================");
		System.out.println("|                            |");
		System.out.println("|  Please select an option:  |");
		System.out.println("|                            |");
		System.out.println("|     [0] -- Manager         |");
		System.out.println("|     [1] -- Salesperson     |");
		System.out.println("|     [2] -- Exit            |");
		System.out.println("|                            |");
		System.out.println("==============================");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		while (true) {
		int choice = inputValidation.getValidInt("Enter input here:");
		switch (choice) {
			
			case 0:
				currentMenu = menuFactory.changeMenu("Manager");
				currentMenu.menuStart();
				break;
				
			case 1:
				currentMenu = menuFactory.changeMenu("Salesperson");
				currentMenu.menuStart();
				break;
			
			case 2:
				System.out.println("Thanks for using this app Good Bye!");
				System.exit(0);
				
			default:
				System.out.println("Please enter valid input...");
				continue;
		}
		}
	}

}


















