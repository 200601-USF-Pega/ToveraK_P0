package com.revature.usedcardealership.menu;

public class MenuFactory {
	
	public IMenu changeMenu(String menuName) {
		IMenu newMenu;
		
		switch(menuName) {
			
			case "Salesperson":
				newMenu = new SalesPersonMenu();
				return newMenu;
			case "Manager":
				newMenu = new ManagerMenu();
				return newMenu;
			case "Login Menu": 
				newMenu = new LogInMenu();
				return newMenu;
			case "Selection Menu":
				newMenu = new SelectionMenu();
				return newMenu;
			case "Test or Buy":
				newMenu = new TestDriveBuyMenu();
				return newMenu;
			case "Buy Menu":
				newMenu = new BuyMenu();
				return newMenu;
			default:
				System.out.println("Thanks for using this app Good Bye!");
				System.exit(0);
	
		}
		
		return null;
	}
}
