/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 03/11/2021
 * Program: Book Catalog Class
 * Description:
 * 	This program is designed with user-interactivity. They can receive
 * 	a set of options to relating to a Book Catalog library. 
 * 	The user has the choice to add, remove, update, or save a catalog of books. 
 * 	These choices are implemented here.
 */
package assg5_lopezs20;

import java.io.*;
import java.util.*;

public class BookCatalog implements BookCatalogInterface {
	
	//Default constructor
	public BookCatalog() {}
	
	// Library is the data structure.
	private ArrayList<Book> library = new ArrayList<Book>();
	private static ArrayList<Book> copyLibrary = new ArrayList<Book>();
	private String itemISBN, itemTitle, itemAuthor, itemPub, itemYear;
	
	/**
	 * LoadData method reads the data from the text file into
	 * book objects from the Book class. It utilizes
	 * the private variables above as temporary extraction for
	 * each Book's parameters defined in its constructor.
	 * @param String fileName
	 */
	public void loadData(String fileName) {
		FileReader readIn;
		String line  = "";
		try {
			readIn = new FileReader(fileName);
			BufferedReader scanIn = new BufferedReader(readIn);
			
			while ((line = scanIn.readLine()) != null){
				if(line.isBlank()) {
					line = scanIn.readLine();
				}
				
				if(line == null) {
					break;
				}
				
				if(!line.isBlank()) {
				itemISBN = line;
				line = scanIn.readLine();
				itemTitle = line;
				line = scanIn.readLine();
				itemAuthor = line;
				line = scanIn.readLine();
				itemPub = line;
				line = scanIn.readLine();
				itemYear = line;
				
				library.add(new Book(itemISBN,itemTitle,itemAuthor,itemPub,itemYear));
				// stores the original catalog into copy
				copyLibrary.add(new Book(itemISBN,itemTitle,itemAuthor,itemPub,itemYear)); 
				}	
			}
			scanIn.close();
			 
		} catch (IOException e) {
			System.err.println(e);
		}	
	}	
	
	/**
	 * Displays the entire catalog 
	 * (every book including its contents).
	 * Returns nothing, prints the entire library ArrayList.
	 */
	public void displayCatalog() {
		for(int i = 0; i< library.size(); i++) {
			System.out.println(library.get(i));
		}
	}
	
	/**
	 * Searches the Book Catalog for a Book that
	 * the user specified.
	 * @param String
	 * @return Book, Null
	 */
	public Book searchForBook(String title) {
		
		for(int i  = 0; i < library.size(); i++) {
			if((library.get(i).getBookTitle()).equals(title)) {
				return library.get(i);
				}
			library.get(i);
			}
		return null;
		
	}
	
	/**
	 * Adds an entire Book into the book catalog with all 
	 * corresponding info. Returns false if book was  
	 * already in book catalog.
	 * @param addISBN
	 * @param addTitle
	 * @param addAuthor
	 * @param addPub
	 * @param addYear
	 * @return boolean value
	 */
	public boolean addBook(String addISBN, String addTitle, String addAuthor, String addPub, String addYear) {
		
		for(int i  = 0; i < library.size(); i++) {
			if((library.get(i).getBookTitle()).equals(addTitle)) {
				System.out.println("The book being added already exists.");
				return false;
			}
		}
		
		library.add(new Book(addISBN,addTitle,addAuthor,addPub,addYear));
		return true;
}
	
	/**
	 * Updates a part or whole of a book's contents. 
	 * Essentially it stores the modified content 
	 * back into the book and the book catalog.
	 * @param addISBN
	 * @param addTitle
	 * @param addAuthor
	 * @param addPub
	 * @param addYear
	 * @return boolean value
	 */
	public boolean updateBook(String addISBN, String addTitle, String addAuthor, String addPub, String addYear) {
		
		for(int i  = 0; i < library.size(); i++) {
			if((library.get(i).getBookTitle()).equals(addTitle)) {
				Book temp = new Book (addISBN,addTitle,addAuthor,addPub,addYear);
				library.set(i, temp);
				return true;
			}
		}
		System.out.println("Book doesn't exist in catalog");
		return false;
	}	

	/**
	 * Removes a user specified book from the catalog.
	 * Does nothing if book was not found.
	 * @param title
	 * @return boolean value
	 */
	public boolean removeBook(String title) {
		
		for(int i  = 0; i < library.size(); i++) {
			if((library.get(i).getBookTitle()).equals(title)) {
				library.remove(i);
				return true;
			}
		}
		System.out.println("Book was not found.");
		return false;
	}	
	
	/**
	 * Retrieves a set of books from a user requested publisher.
	 * Only books with that publisher are shown to the user.
	 * @param publisher
	 * @return  pLibrary -- new ArrayList
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher){
		
		ArrayList<Book> pLibrary = new ArrayList<Book>();
		for(int i  = 0; i < library.size(); i++) {
			
			if((library.get(i).getBookPub()).equals(publisher)) {
				
				pLibrary.add(library.get(i));
			}
		}
		return pLibrary;
	}
	
	/**
	 * Sort method that uses the Collections.sort() method. 
	 * Sorts the catalog of books in alphabetically order.
	 */
	public void sort() {
		Collections.sort(library, Comparator.comparing(Book::getBookTitle));
	}
	
	/**
	 * Saves the current order and state of the ArrayList library
	 * and overwrites it into the file.
	 */
	public void save() {
		
		final String CONSTFILE = "assg5_BookCatalog.txt";
		FileWriter fileIN;
		BufferedWriter writer;
		
		// check if library changed.
		if(copyLibrary.equals(library)) {
			System.out.println("Copy is already up-to-date");
		}
		else {
		try {
			fileIN = new FileWriter(CONSTFILE);
			writer = new BufferedWriter(fileIN);
			
			for(int i = 0; i < library.size(); i++) {
				writer.write(library.get(i).writeInfo());
				writer.newLine();
			}
			writer.close();
			} catch (IOException e) {
			System.err.println(e + "Error at Save");
			}
		}
		
	}
	
	
	
}





