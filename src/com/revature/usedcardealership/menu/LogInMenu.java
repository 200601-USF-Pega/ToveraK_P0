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
		System.out.println("|   #1 USED CAR DEALERSHIP   |");
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
				
				String user, pass;
				
				while(true) {
				user = inputValidation.getValidString("Enter your username: ");
				
				pass = inputValidation.getValidString("Enter your password: ");
				
				if(user.equals("manager") && (pass.equals("password"))) {
					currentMenu = menuFactory.changeMenu("Manager");
					
					currentMenu.menuStart();
				}else {
					System.out.println("\nInvalid input... Please try again. \n");
				}
				
				}

			case 1:
				
				String userSales, passSales;
				
				while(true) {
				userSales = inputValidation.getValidString("Enter your username: ");
				
				passSales = inputValidation.getValidString("Enter your password: ");
				
				if(userSales.equals("sales") && (passSales.equals("password"))) {
					currentMenu = menuFactory.changeMenu("Salesperson");
					
					currentMenu.menuStart();
				}else {
					System.out.println("\nInvalid input... Please try again. \n");
				}
				
				}
				
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


















