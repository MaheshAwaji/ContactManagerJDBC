        package com.jspiders.contactmanager.operations;

import java.util.Scanner;

import com.jspiders.contactmanager.jdbcOperations.JDBCOperations;

public class ContactOperation {
	public static void addContact(Scanner scanner) {
	System.out.println("Enter Id");
	int id = 0;
	boolean Idcheck = false;
	while (!Idcheck) {
		try {
			id = scanner.nextInt();
			Idcheck = true;

		} catch (Exception e) {
			System.err.println("Enter Valid Id!!!!!!!!");
			scanner.nextLine();
		}
	}
	scanner.nextLine();
	System.out.println("Enter First Name");
	String FirstName = scanner.nextLine();
	System.out.println("Enter Last Name");
	String LastName = scanner.nextLine();
	System.out.println("Enter mobile Number");
	long MobileNumber = 0;
	long validMob = 0;
	boolean checkMobile = false;
	while (!checkMobile) {
		try {
			validMob = scanner.nextLong();
			checkMobile = true;
		} catch (Exception e) {
			System.err.println("Enter Valid Mobile Number!!!!!!!!");
			scanner.nextLine();
		}
	}
	int length = String.valueOf(validMob).length();
	boolean MobCheck = true;
	while (MobCheck) {
		if (length == 10) {
			MobileNumber = validMob;
			MobCheck = false;
		} else {
			System.err.println("Enter valid 10-digit Mobile Number!!!!!");
			boolean Check = true;
			while (Check) {
				try {
					validMob = scanner.nextLong();
					Check = false;
				} catch (Exception e) {
					System.err.println("Enter Valid Mobile Number!!!!!!!!");
					scanner.nextLine();
				}
			}
			length = String.valueOf(validMob).length();
		}
	}
	scanner.nextLine();
	System.out.println("Enter Email Id");
	String email = scanner.nextLine();
	System.out.println("Enter category");
	String Category = getCategory();
	
	try {
		JDBCOperations.insertContact(id, FirstName, LastName, MobileNumber, email, Category);
		
	} catch (Exception e) {
		System.err.println("Already Exist");
	}
}

private static String getCategory() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("1.Family\n2.Friend\n3.Collegue");
	int choice = 0;
	boolean checkChoice = true;
	while (checkChoice) {
		try {
			choice = scanner.nextInt();
			checkChoice = false;
		} catch (Exception e) {
			System.err.println("Enter Valid Choice");
			scanner.nextLine();
		}
	}
	String Category = null;
	switch (choice) {
	case 1:
		Category = "Family";

		break;
	case 2:
		Category = "Friend";
		break;
	case 3:
		Category = "Collegue";
		break;

	default:
		System.err.println("Enter valid category");
		getCategory();
		break;
	}

	return Category;
}

public static void deleteContact() {
	viewContacts();
	System.out.println("Enter The Id to delete contact!!");
	Scanner scanner = new Scanner(System.in);
	int id=0;
	boolean condition=true;
	while (condition) {
		try {
			id = scanner.nextInt();
			condition=false;
		} catch (Exception e) {
			System.err.println("Enter Valid Choice");
			scanner.nextLine();
		} 
	}
	JDBCOperations.deleteContact(id);
}



public static void viewContacts() {
	JDBCOperations.showContact();
}

public static void searchContact() {
	boolean check =false ;
	if ( check) {
		System.err.println("Contact List is Empty!!!!");

	} else {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		System.out.println("Search By??????");
		System.out.println("1.Id\n2.First Name\n3.Last Name\n4.Mobile Number\n5.Email\n6.Category");
		boolean Idcheck = true;
		while (Idcheck) {
			try {
				choice = scanner.nextInt();
				Idcheck = false;
			} catch (Exception e) {
				System.err.println("Enter Valid search Option");
				scanner.nextLine();
			}
		}
		switch (choice) {
		case 1:
			System.out.println("Enter Id");
			int Nid = 0;
			try {
				Nid = scanner.nextInt();
			} catch (Exception e) {
				System.err.println("Enter Valid Id");
				break;
			}
			JDBCOperations.searchContactById(Nid);
			break;
		case 2:
			System.out.println("Enter First Name");
			scanner.nextLine();
			String NFirstName = scanner.nextLine();
			JDBCOperations.searchContactByFirstname(NFirstName);
			break;
		case 3:
			System.out.println("Enter Last Name");
			scanner.nextLine();
			String NLastName = scanner.nextLine();
			JDBCOperations.searchContactByLastname(NLastName);
			break;
		case 4:
			System.out.println("Enter Mobile Number");
			
			long NMobileNumber=0;
			boolean condition=true;
			while (condition) {
				try {
					NMobileNumber = scanner.nextLong();
					condition=false;
				} catch (Exception e) {
					System.err.println("Enter Valid Mobile number.");
					scanner.nextLine();
				} 
			}
			JDBCOperations.searchContactByMobileNumber(NMobileNumber);
			break;
		case 5:
			System.out.println("Enter Email Id");
			scanner.nextLine();
			String NEmail = scanner.nextLine();
			JDBCOperations.searchContactByEmailId(NEmail);

			break;
		case 6:
			System.out.println("Choose category");
			System.out.println("1.Family\n2.Friend\n3.Collegue");
			int choice1 = 0;
			
			boolean checkCat = true;
			while (checkCat) {
				try {
					choice1 = scanner.nextInt();
					checkCat = false;

				} catch (Exception e) {
					System.err.println("Enter Valid Category");
					scanner.nextLine();

				}
			}
			switch (choice1) {
			case 1:
				JDBCOperations.searchContactByCategory("Family");
				break;
			case 2:
				JDBCOperations.searchContactByCategory("Friend");
				break;
			case 3:
				JDBCOperations.searchContactByCategory("Collegue");
				break;
			default:
				System.err.println("This contact is not present");
				break;
			}
			break;
		default:
			System.err.println("Enter Valid Choice");
			searchContact();
			break;

		}

	}
}



public static void editContacts() {
	viewContacts();
	System.out.println("Enter Id");
	Scanner scanner = new Scanner(System.in);
	int id = 0;
	boolean check1 = true;
	while (check1) {
		try {
			id = scanner.nextInt();
			check1 = false;
		} catch (Exception e) {
			System.err.println("Enter Valid Input");
			scanner.nextLine();
		}
	}
	
	
	int choice = editMenu();
	switch (choice) {
	case 1:
		System.out.println("Enter Updated Name");
		scanner.nextLine();
		String NewName = scanner.nextLine();
		JDBCOperations.updateFirstName(NewName, id);
		System.out.println("\u001B[32mName updated successfully!!! \u001B[0m");
		break;
	case 2:
		System.out.println("Enter Updated Last Name");
		scanner.nextLine();
		String NewLastName = scanner.nextLine();
		JDBCOperations.updateLastName(NewLastName, id);
		System.out.println("\u001B[32mLast Name updated successfully!!! \u001B[0m");

		break;
	case 3:
		System.out.println("Enter Updated Mobile Number");
		scanner.nextLine();
		long MobileNumber = 0;
		long validMob = 0;
		boolean checkMobile = false;
		while (!checkMobile) {
			try {
				validMob = scanner.nextLong();
				checkMobile = true;
				break;
			} catch (Exception e) {
				System.err.println("Enter Valid Mobile Number!!!!!!!!");
				scanner.nextLine();
			}
		}
		int length = String.valueOf(validMob).length();
		boolean MobCheck = true;
		while (MobCheck) {
			if (length == 10) {
				JDBCOperations.updateMobileNumber(validMob, id);
				MobCheck = false;
			} else {
				System.err.println("Enter valid 10-digit Mobile Number!!!!!");
				boolean Check = true;
				while (Check) {
					try {
						validMob = scanner.nextLong();
						Check = false;
					} catch (Exception e) {
						System.err.println("Enter Valid Mobile Number!!!!!!!!");
						scanner.nextLine();
					}
				}
				length = String.valueOf(validMob).length();
			}
		}
		System.out.println("\u001B[32mMobile Number updated successfully!!!\u001B[0m");
		break;
	case 4:
		System.out.println("Enter Updated Email");
		scanner.nextLine();
		String NewEmail = scanner.nextLine();
		JDBCOperations.updateEmailId(NewEmail, id);
		System.out.println("\u001B[32mEmail updated successfully!!!\u001B[0m");
		break;
	case 5:
		System.out.println("Select New Ctaegory");
		System.out.println("1.Family\n2.Friend\n3.Collegue");
		int choice1 = 0;
		boolean check = true;
		while (check) {
			try {
				choice1 = scanner.nextInt();
				check = false;
			} catch (Exception e) {
				System.err.println("Enter Valid Input");
				scanner.nextLine();
			}
		}
		switch (choice1) {
		case 1:
			JDBCOperations.updateCategory("Family", id);
			System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
			break;
		case 2:
			JDBCOperations.updateCategory("Friend", id);
			System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
			break;
		case 3:
			JDBCOperations.updateCategory("Collegue", id);
			System.out.println("\u001B[32mCategory updated successfully!!!\u001B[0m");
			break;
		default:
			System.err.println("Enter Valid Input");
			break;
		}
		break;
	default:
		System.err.println("Enter valid choice!!");
		break;
	}
	
	
  }

public static int editMenu() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter What you want to change.");
	System.out.println("1.First Name:" );
	System.out.println("2.Last Name:" );
	System.out.println("3.Mobile Number:");
	System.out.println("4.Email:" );
	System.out.println("5.Category:" );
	int choice = 0;
	boolean check = true;
	while (check) {
		try {
			choice = scanner.nextInt();
			check = false;
		} catch (Exception e) {
			System.err.println("Enter valid Input");
			scanner.nextLine();
		}
	}
	return choice;

}

}
