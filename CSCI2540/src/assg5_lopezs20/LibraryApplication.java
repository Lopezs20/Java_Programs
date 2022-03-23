/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 03/11/2021
 * Program: Library Application
 * Description:
 * 	This program is designed with user-interactivity.
 * 	This is where the user can make their own decisions about what the 
 * 	program should do regarding the Book Catalog's functions.
 * 
 */
package assg5_lopezs20;

import java.util.Scanner;

public class LibraryApplication {
	
	/**
	 * Main Method that initiates the user menu. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BookCatalog inventory = new BookCatalog();
		inventory.loadData("assg5_BookCatalog.txt"); 
		
		System.out.println("**********Welcome to Book Catalog!***********");
		System.out.println("To get you started, type any number from the menu "
				+ "\nof select options:");
		
		String isbn, btitle, auth, pub, year;
		
		// iterates menu forever until a system exit command occurs.
		while(true) {
			System.out.println("\n1. Display all the books"
				+ "\n2. Search for a book"
				+ "\n3. Add a new book"
				+ "\n4. Update an existing book"
				+ "\n5. Remove a book"
				+ "\n6. Search for books by publisher"
				+ "\n7. Sort all the books based on title"
				+ "\n8. Save data"
				+ "\n9. Exit");
			
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
			
		// switch case for all 9 options.
		switch(choice) {
		
			case 1:
				inventory.displayCatalog();
				
				System.out.println("Press enter to continue");
				
				Scanner state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
				
				
			case 2:
				System.out.println("Enter the name of the Book you would like to search: ");
				userInput.nextLine();
				
				String title = userInput.nextLine();
				Book found = inventory.searchForBook(title);
				
				if (found == null) {
					System.out.println("Sorry your book isn't in our catalog! :(");
					break;
				}
				System.out.println("Your Book has been found!"+ "\n" +found);
				
				System.out.println("Press enter to continue");
				
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
			
				
			case 3:
				System.out.println("Type the following contents below: ");
				
				System.out.println("ISBN: ");
				userInput.nextLine(); 
				isbn = userInput.nextLine(); 
				
				System.out.println("Title: ");
				btitle = userInput.nextLine(); 
				
				System.out.println("Author: "); 
				auth = userInput.nextLine(); 
				
				System.out.println("Publisher: ");
				pub = userInput.nextLine(); 
				
				System.out.println("Publish Year: ");
				year = userInput.nextLine(); 
				
				
				boolean addConfirm = inventory.addBook(isbn, btitle, auth, pub, year);
				if(addConfirm == true) {
					System.out.println("Your book has been added! :)");
				} else System.out.println("Your book could not be added");
				
				System.out.println("Press enter to continue");
				
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
				
			case 4:
				
				int choice2;
				
				System.out.println("Update your book by typing a book title: ");
				userInput.nextLine();
				String answer = userInput.nextLine();
				
				found = inventory.searchForBook(answer);
				
				// mini-menu for updating book details.
				while(found != null) {
					
					System.out.println("Enter what you would like to do: ");
					System.out.println("\n1. Change the ISBN");
					System.out.println("\n2. Change the author");
					System.out.println("\n3. Change the publisher");
					System.out.println("\n4. Change the year");
					System.out.println("\n0. Go back to Menu");
					
					while(userInput.hasNextInt() != true) {
						if(userInput.hasNextInt()) {
							break;
						}
						System.out.println("Please enter a valid choice");
						userInput.nextLine();
					}
					
					choice2 = userInput.nextInt();
					
					if(choice2 == 0) {
						break;
					}
					
				switch(choice2) {
					
					case 1:  
							userInput.nextLine();
							System.out.println("ISBN: ");
							isbn = userInput.nextLine();
							found.setISBN(isbn);
							inventory.updateBook(found.getBookISBN(), found.getBookTitle(), found.getBookAuthor(), found.getBookPub(), found.getBookYear());
							break;
	
					case 2:
						userInput.nextLine();
						System.out.println("Author: ");
							auth = userInput.nextLine();
							found.setAuthor(auth);
							inventory.updateBook(found.getBookISBN(), found.getBookTitle(), found.getBookAuthor(), found.getBookPub(), found.getBookYear());
							break;
						//author = found.getBookAuthor();
						
					case 3:
						userInput.nextLine();
						System.out.println("Publisher: ");
							pub = userInput.nextLine();
							found.setPublisher(pub);
							inventory.updateBook(found.getBookISBN(), found.getBookTitle(), found.getBookAuthor(), found.getBookPub(), found.getBookYear());
							break;
						// pub = found.getBookPub();
						
					case 4:
						userInput.nextLine();
						System.out.println("Year: ");
							year = userInput.nextLine();
							found.setYear(year);
							inventory.updateBook(found.getBookISBN(), found.getBookTitle(), found.getBookAuthor(), found.getBookPub(), found.getBookYear());
							break;
						//year = found.getBookYear();
							
					case 0:
							break;
						}
					}
				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
				
			case 5:
				System.out.println("Which book would you like to delete?");
				userInput.nextLine();
				answer = userInput.nextLine();
				
				boolean check;
				
				check = inventory.removeBook(answer);
				
				if( check == false) {
					System.out.println("Press enter to continue");
					state = new Scanner(System.in);
					state.nextLine();
					break;
				}
				System.out.println("Entry removed!");
				
				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
				
			case 6:
				System.out.println("Type a publisher name: ");
				userInput.nextLine();
				answer = userInput.nextLine();
				
				System.out.println((inventory.getBooksByPublisher(answer)).toString());
				
				
				if((inventory.getBooksByPublisher(answer)).isEmpty()) {
					System.out.println("No Book was found by that publisher.");
					
					System.out.println("Press enter to continue");
					state = new Scanner(System.in);
					state.nextLine();
					break;
				}
				break;
				
			case 7 :
				System.out.println("Sorting all books...");
				inventory.sort();
				System.out.println("Sorting Complete!");
				inventory.displayCatalog();

				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
				
			case 8:
				System.out.println("Saving data...");
				inventory.save();
				System.out.println("Data Saved!");
				
				System.out.println("Press enter to continue");
				state = new Scanner(System.in);
				state.nextLine();
				break;
				
			case 9:
				inventory.save();
				userInput.close();
				System.exit(0);
				
				}
			}
	}
		
		
}

