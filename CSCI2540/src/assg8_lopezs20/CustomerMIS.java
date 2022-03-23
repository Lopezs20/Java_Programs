/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/15/2021
 * Program: Customer Class  
 * Description:
 * 	This class will implement the main method that displays a digital menu.
 * 	Customer would have an ID, phone number, and name from the text file 
 * 	and be stored into a Customer roster. Here the user can manipulate the info. 
 */
package assg8_lopezs20;

import java.util.Scanner;

public class CustomerMIS {
	// main method 
	public static void main(String[] args) {
		
		System.out.println("***********Database Finder! ************ ");
		System.out.println("To get you started, type any number from the menu "
				+ "\nof select options:");
		
		String _id, _name, _phone;
		
		CustomerRoster inventory = new CustomerRoster();
		inventory.loader();
		
		// infinite loop till system exits...
		while(true) {
			System.out.println("\n1. Display all customers."
				+ "\n2. Add a Customer"
				+ "\n3. Delete a Customer"
				+ "\n4. Search a Customer"
				+ "\n5. Update Customer's info"
				+ "\n6. Save and Exit");
			
			Scanner userInput = new Scanner(System.in);
			
			
			// Test case for incorrect user inputs.
			while(userInput.hasNextInt() != true) {
				if(userInput.hasNextInt()) {
					break;
				}
				System.out.println("Please enter a valid choice");
				userInput.nextLine();
			}
			
			int choice = userInput.nextInt();
			
		// switch case for all 6 options.
		switch(choice) {
		
			case 1:
				inventory.display();
				System.out.println("Press enter to continue");
				
				Scanner state = new Scanner(System.in);
				state.nextLine();
				break;
				
			case 2:
				System.out.println("Enter the customer's ID:");
				userInput.nextLine();
				
				_id = userInput.nextLine();
				
				System.out.println("Customer's name: ");
				_name = userInput.nextLine();
				
				System.out.println("Customer's phone number: ");
				_phone = userInput.nextLine();
				
				boolean checker = inventory.addCustomer(_id, _name, _phone);
				
				if(checker) {
					System.out.println("Your customer has been added!");
				}
				else {
					System.out.println("Your customer could not be added!");
				}
				
				System.out.println("Press enter to continue");
				
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
			case 3:
				System.out.println("Enter Customer's ID for deletion");
				userInput.nextLine();
				
				String line = userInput.nextLine();
				
				inventory.deleteCustomer(line);
				System.out.println("Press enter to continue");
				
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
			case 4:
				
				System.out.println("Search by entering a customer's ID: ");
				userInput.nextLine();
				
				String user = userInput.nextLine();
				
				if(user.isBlank() == false) {
					System.out.println(inventory.searchFor(user));
				}
				
				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
			case 5:
				System.out.println("Update by entering a customer's ID: ");
				userInput.nextLine();
				
				user = userInput.nextLine();
				
				Customer temp = inventory.searchFor(user);
				
				// Mini-menu for updating customer's id.
				while(temp != null) {
					System.out.println("Enter what you would like to update: ");
					System.out.println("\n1. Change the name");
					System.out.println("\n2. Change the phone number");
					System.out.println("\n0. Go back to Menu");
					
					while(userInput.hasNextInt() != true) {
						if(userInput.hasNextInt()) {
							break;
						}
						System.out.println("Please enter a valid choice");
						userInput.nextLine();
					}
					
					int choice2 = userInput.nextInt();
					
					if(choice2 == 0) {
						break;
					}
					
					switch(choice2) {
					
						case 1:  
							userInput.nextLine();
							System.out.println("Enter new Name: ");
							_name = userInput.nextLine();
							
							temp.setName(_name);
							inventory.update(temp.getId(), temp.getNameOfCustomer(), temp.getPhone());
							break;
							
						case 2:
							userInput.nextLine();
							System.out.println("Enter new phone number: ");
							
							_phone = userInput.nextLine();
							temp.setPhone(_phone);
							inventory.update(temp.getId(), temp.getNameOfCustomer(), temp.getPhone());
							break;
					}
				}
				
				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
			case 6:
				System.out.println("Saving data...");
			
				inventory.saveData();
				System.out.println("Closing Application...");
				userInput.close();
				System.exit(0);
				
				
				}
			} 
		}
	}

