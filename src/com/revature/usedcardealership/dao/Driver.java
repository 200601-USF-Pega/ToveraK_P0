package com.revature.usedcardealership.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.revature.usedcardealership.menu.IMenu;
import com.revature.usedcardealership.menu.LogInMenu;
import com.revature.usedcardealership.menu.ManagerMenu;
import com.revature.usedcardealership.menu.SalesPersonMenu;
import com.revature.usedcardealership.service.ValidationService;

public class Driver {
	
    static Handler fileHandler = null;
    private static final Logger LOGGER = Logger.getLogger(Driver.class
            .getClass().getName());

    public static void setup() {

        try {
            fileHandler = new FileHandler("./logfile.log");
            SimpleFormatter simple = new SimpleFormatter();
            fileHandler.setFormatter(simple);

            LOGGER.addHandler(fileHandler);

        } catch (IOException e) {
            // TODO Auto-generated catch block
        }

    }

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		 setup();
		    LOGGER.info("--Ran usedDealer app--");
		
		IMenu currentMenu = new LogInMenu();
		
		currentMenu.menuStart();
		
//		CarRepoDB crdb = new CarRepoDB();
//		crdb.viewTransactions();
	}

}
