package com.revature.usedcardealership.service;

import java.util.Scanner;

public class ValidationService {
	Scanner input = new Scanner(System.in);
	boolean invalid = true;
	
	public String getValidString(String prompt) {
		String userInput;
		do {
			System.out.println(prompt);
			userInput = input.nextLine();
			if(!userInput.isEmpty()) break;
			System.out.println("Please input a string");
		}while(invalid);
		return userInput;
	}
	
	public int getValidInt(String prompt) {
		int userInput = 0;
		do {
		try {	
			System.out.println(prompt);
			userInput = Integer.parseInt(input.nextLine());
			break;
			} catch (NumberFormatException ex) {
				System.out.println("Please input a valid number");
			}
		}while (invalid);
		return userInput;
	}
	
	public boolean getValidBoolean(String prompt) {
		invalid = true;
		String userInput;
		do {
			System.out.println(prompt);
			userInput = input.nextLine();
			if(userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("false")) break;
		} while (invalid);
		return Boolean.parseBoolean(userInput);
	}
}


























