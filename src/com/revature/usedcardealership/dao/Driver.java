package com.revature.usedcardealership.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.revature.usedcardealership.menu.IMenu;
import com.revature.usedcardealership.menu.LogInMenu;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		IMenu currentMenu = new LogInMenu();
		
		currentMenu.menuStart();
		
//		CarRepoDB crdb = new CarRepoDB();
//		crdb.viewTransactions();
	}

}
