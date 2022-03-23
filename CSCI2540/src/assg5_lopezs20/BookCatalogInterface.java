/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 03/112021
 * Program: Book Catalog Interface  
 * Description:
 * 	 This is an interface that the LibraryApplication class interacts with.
 * 	 This interface hides the implementation of the Book Catalog class along 
 * 	 with ADTs in the Book class.
 */
package assg5_lopezs20;

import java.util.ArrayList;

interface BookCatalogInterface {
	
	// loads the data from file.
	public void loadData(String fileName);
	
	// displays the entire catalog.
	public void displayCatalog();
	
	// searches for desired book.
	public Book searchForBook(String title);
	
	// adds desired book into catalog.
	public boolean addBook(String addISBN, String addTitle, String addAuthor, String addPub, String addYear);
	
	// updates any existing book within the catalog.
	public boolean updateBook(String addISBN, String addTitle, String addAuthor, String addPub, String addYear);
	
	// removes a particular book.
	public boolean removeBook(String title);
	
	// Retrieves a list of books made by same publisher.
	public ArrayList<Book> getBooksByPublisher(String publisher);
	
	// sorts the entire book catalog alphabetically.
	public void sort();
	
	// saves book catalog data into file.
	public void save();
	
}
