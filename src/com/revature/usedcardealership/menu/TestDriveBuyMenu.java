package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.service.ValidationService;

public class TestDriveBuyMenu implements IMenu{

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============================");
		System.out.println("| Would you like to:         |");
		System.out.println("|                            |");
		System.out.println("| 0 -- Test Drive vehicle    |");
		System.out.println("| 1 -- Purchase vehicle      |");
		System.out.println("| 2 -- Exit                  |");
		System.out.println("|                            |");
		System.out.println("==============================");
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;
		while(true) {
		int choice = inputValidation.getValidInt(" ");
		switch(choice) {
			
			case 0:
				System.out.println("Vroom! Vroom!");
				break;
			case 1:
				System.out.println("$$$!");
				break;
			case 2:
				System.out.println("Thanks for using this app Good Bye!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid input...");
				choice = 0;
				continue;
		}
		}
	}

}