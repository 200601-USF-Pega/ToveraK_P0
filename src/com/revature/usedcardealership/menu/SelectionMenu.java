package com.revature.usedcardealership.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.revature.usedcardealership.inventory.Inventory;
import com.revature.usedcardealership.service.ValidationService;

public class SelectionMenu implements IMenu{

	@Override
	public void menuStart() throws FileNotFoundException, IOException {
		ValidationService inputValidation = new ValidationService();
		Inventory carInventory = new Inventory();
		String carSelection;
		
		MenuFactory menuFactory = new MenuFactory();
		IMenu currentMenu;

		int choice = inputValidation.getValidInt("\n Enter [0] to input vehicle selected... \n Enter [1] to exit ...");
		
		while (true) {
		switch (choice) {
			
			case 0:
				Scanner scan = new Scanner(System.in);
				
				carSelection = inputValidation.getValidString("\n--Please input vehicle selected-- \n");
				try {
					carInventory.selectInventory(carSelection);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentMenu = menuFactory.changeMenu("Test or Buy");
				currentMenu.menuStart();
				break;
				
			case 1:
				break;
			
			case 2:
				System.out.println("Thanks for using this app Good Bye!");
				System.exit(0);
				
			default:
				System.out.println("Please enter valid input...");
				choice = 0;
				continue;
		}
		}
		
	}

}
