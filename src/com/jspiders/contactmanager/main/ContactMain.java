package com.jspiders.contactmanager.main;
import java.util.Scanner;

import com.jspiders.contactmanager.operations.ContactOperation;

public class ContactMain {
	static boolean check=true;
	public static void main(String[] args) {
		while (check) {
			menu();
		}
	}

	public static void menu() {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
         System.out.println();
		System.out.println("Welcome to contact Manager");
		System.out.println("Enter 1 for Create contact\n" + "Enter 2 for Delete contact\n" +"Enter 3 for Search Contact\n"+ "Enter 4 for View Contact\n"+"Enter 5 for Edit Contact\n"+"Enter 6 for Exit");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		try {
			 choice = scanner.nextInt();
			
		} catch (Exception e) {
			System.err.println("Enter Valid choice!!!!!!!!");
		}
		
		switch (choice) {
		case 1:
			ContactOperation.addContact(scanner);
			break;
		case 2:
			ContactOperation.deleteContact();
			break;
		case 3:
			ContactOperation.searchContact();
			break;
		case 4:
			ContactOperation.viewContacts();
			break;
		case 5:
			ContactOperation.editContacts();
			break;
		case 6:
			System.out.println("\u001B[32m-----------------------------------------------------------------------------------------Thank You---------------------------------------------------------------------------------------------------\u001B[0m");
			check=false;
			break;

		default:
			System.err.println("Enter valid Choice");
			break;
		}

	}

}
