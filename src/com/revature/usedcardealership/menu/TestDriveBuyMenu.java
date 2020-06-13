package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.dao.CarRepoDB;
import com.revature.usedcardealership.service.ValidationService;

public class TestDriveBuyMenu implements IMenu{
	static String buyCar;

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		
		CarRepoDB carRepoDB = new CarRepoDB();
//		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("| Would you like to:         |");
		System.out.println("|                            |");
		System.out.println("| 0 -- Test Drive vehicle    |");
		System.out.println("| 1 -- Purchase vehicle      |");
		System.out.println("| 2 -- Back to log-in        |");
		System.out.println("|                            |");
		System.out.println("==============================");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		while(true) {
		int choice = inputValidation.getValidInt(" ");
		switch(choice) {
			
			case 0:
				System.out.println("\n Vroom! Vroom! \n");
				currentMenu = menuFactory.changeMenu("Login Menu");
				currentMenu.menuStart();
				break;
			case 1:
				System.out.println("\n You are about to purchase a " + buyCar);
				carRepoDB.buyVehicle();
				System.out.println("\n -- Thank you for shopping at our dealership-- \n\n\n");
				currentMenu = menuFactory.changeMenu("Login Menu");
				currentMenu.menuStart();
				break;
			case 2:
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
