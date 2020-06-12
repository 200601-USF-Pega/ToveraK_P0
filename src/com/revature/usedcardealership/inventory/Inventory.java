package com.revature.usedcardealership.inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.revature.usedcardealership.menu.SelectionMenu;

public class Inventory {
	public ArrayList<String> carList = new ArrayList<String>();
	SelectionMenu selectionMenu = new SelectionMenu();
	
	public void showInventory() {

		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\19252\\eclipse-workspace\\UsedCarDealership2\\src\\Resources\\Inventory.txt")))
		{
			String sCurrentLine;
			
			while((sCurrentLine = br.readLine()) != null) {
				carList.add(sCurrentLine);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		for (String cars : carList) {
			System.out.println(cars);
		}
	}
	
	public void selectInventory(String prompt) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\19252\\eclipse-workspace\\UsedCarDealership2\\src\\Resources\\Inventory.txt")))
		{
			String sCurrentLine;
			
			while((sCurrentLine = br.readLine()) != null) {
				carList.add(sCurrentLine);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		if(this.carList.stream().anyMatch(prompt::equalsIgnoreCase)) {
			System.out.println("You have selected: " + prompt);
			//System.out.println("Would you like to:");
			//System.out.println("0 -- Test drive " + prompt);
			//System.out.println("1 -- Purchase " + prompt);
		} else {
			System.out.println("We do not have " +prompt+ " in our inventory");
			System.out.println("Please try again...\n");
			selectionMenu.menuStart();
			//System.out.println("--Please select a vehicle-- \n");
			}
	}
	
}

