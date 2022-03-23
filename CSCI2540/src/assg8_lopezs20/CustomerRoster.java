/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/15/2021
 * Program: Customer Class  
 * Description:
 * 	This class will implement the structure of the Customer Roster.
 * 	Customer would have an ID, phone number, and name from the text file.
 * 	Each customer is stored within a binary tree and can be utilized 
 * 	in the roster class. 
 */
package assg8_lopezs20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerRoster {
	
	// Default Constructor
	public CustomerRoster() {}
	
	/**
	 * Data Structure using Binary Tree/Search tree
	 */
	private BinarySearchTree<Customer, String> C_roster = new BinarySearchTree<Customer,String>();
	
	private static BinarySearchTree<Customer,String> C_copy = new BinarySearchTree<Customer,String>();
	
	TreeIterator<Customer> displayRoster = new TreeIterator<Customer>(C_roster);
	
	// Private instances
	private String itemName, itemID, itemPhone;
	
	// final instance variable to protect the file name from editing/syntax error.
	final String CONSTFILE = "assg8_CustomerRoster.txt"; 
	
	/**
	 * Load method to retrieve file info into Binary Search Tree.
	 */
	public void loader() {
		FileReader readIn;
		String line  = "";
		
		
		try {
			readIn = new FileReader(CONSTFILE);
			BufferedReader scanIn = new BufferedReader(readIn);
			
			while ((line = scanIn.readLine()) != null){
				if(line.isBlank()) {
					line = scanIn.readLine();
				}
				
				if(line == null) {
					break;
				}
				
				if(!line.isBlank()) {
					
					String[] info = line.split("\\s+");
					
				// for itemName there must be a last name in file or OutofIndexBound error. 
					itemID = info[0];
					itemName = info[1] + " " + info[2]; // "first + last name"
					itemPhone = info[3];
					
					C_roster.insert(new Customer(itemID,itemName,itemPhone));
					C_copy.insert(new Customer(itemID,itemName,itemPhone));
					
				}
			}	scanIn.close();
		} catch (IOException e) {
			System.err.println(e);
		}	
	}
	
	/**
	 * Method for saving user edits into text file. 
	 */
	public void saveData() {
		
		FileWriter fileIN;    
		BufferedWriter writer;
		
		if(C_copy.equals(C_roster)) {
			System.out.println("Roster is already up-to-date.");
		}
		else {
			try {                                       
				fileIN = new FileWriter(CONSTFILE);     
				writer = new BufferedWriter(fileIN); 
				
				Customer print;
				displayRoster.setInorder();
				
				while (displayRoster.hasNext() != false) {
					print = (Customer) displayRoster.next();
					writer.write(print.writeInfo());
				}
				writer.close();
			} catch (IOException e) {               
				System.err.println(e + "Error at Save...");
			}
		} 
		
	}
	
	/**
	 * Method for searching a customer's information using ID.
	 * @param customerID
	 * @return Cutomer searched
	 */
	public Customer searchFor(String customerID) {
		
		if(C_roster.retrieve(customerID) != null) {
		return C_roster.retrieve(customerID);
		}
		else 
			System.out.println("Person not found");
		return null;
	}
	
	/**
	 * Method for updating customer's information using ID. 
	 * @param id
	 * @param name
	 * @param number
	 */
	public void update(String id, String name, String number) {
		if (C_roster.retrieve(id) != null) {
			C_roster.delete(id);
			addCustomer(id,name,number);
		} 
		else {
			System.out.println("Person not found ");
		}
		
	}
	
	/**
	 * Method for adding a customer into the Binary Tree.
	 * @param passID
	 * @param passName
	 * @param passPhone
	 * @return boolean value 
	 */
	public boolean addCustomer(String passID, String passName, String passPhone) {
		
		if(C_roster.retrieve(passID) != null ) {
			System.out.println("This customer has already been registered.");
			return false;
		}
		else {
		C_roster.insert(new Customer(passID, passName, passPhone));
		return true;
		}
	}
	/**
	 * method for deleting customer from binary tree. 
	 * @param id
	 */
	public void deleteCustomer(String id) {
		
		if(C_roster.retrieve(id) != null) {
			C_roster.delete(id);
			System.out.println("Deletion success!");
		}
		else
			System.out.println("Cannot delete this customer, not in system...");
	}
	
	/**
	 * Displays the entire binary tree. 
	 */
	public void display() {
		displayRoster.setInorder();
		
		while(displayRoster.hasNext() == true) {
			Customer person = (Customer) displayRoster.next();
			System.out.println(person.toString());
		}	
	}
}
