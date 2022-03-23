/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 02/16/2021
 * Program: Book Class  
 * Description:
 * 	 This class will be used to store each catalog item as an 
 * 	 book object. Each item will also be stored as instance 
 * 	 variables located in the book object's parameters.
 * 	 It shows the method called bookSearch which searches for the given
 * 	 book's ID and contents (ISBN, title, etc.).
 */
package assg3_lopezs20;

public class Book {
	
	/**
	 * Instance variables of private data type
	 * Represents each catalog item to be stored. 
	 */
	private int bookID;
	private String title, ISBN, author;
	private char genreType;
	
	
	/**
	 * Default Constructor for the Book class.
	 */
	public Book() {
	}
	
	/**
	 * Book constructor that contains the instance variables 
	 * Received from the catalog file. The instance variables
	 * represent each catalog item. 
	 * @param id
	 * @param recievedBookTitle
	 * @param givenISBN
	 * @param recievedAuthor
	 * @param genre
	 */
	public Book(int id, String recievedBookTitle, String givenISBN, String recievedAuthor, char genre) {
		
		bookID = id;
		title = recievedBookTitle;
		ISBN = givenISBN;
		author = recievedAuthor;
		genreType = genre;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's ID number. 
	 * @return book's ID.
	 */
	public int getBookID() {
		return bookID;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's title. 
	 * @return book's title.
	 */
	public String getBookTitle() {
		return title;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's ISBN number. 
	 * @return book's ISBN.
	 */
	public String getISBN() {
		return ISBN;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's author/writer last name. 
	 * @return book's author.
	 */
	
	public String getAuthor() {
		return author;
	}
	
	
	/**
	 * A getter method for retrieving the String equivalent 
	 * of the book's genre. 
	 * This is required as stated in assignment directions.
	 * @return the String "Fiction" if char is F
	 * @return the String "Non-Fiction" if char is otherwise
	 * According to assignment directions is accurate. 
	 */
	public String getGenreType() {
		char F = 'F'; 
		if(this.genreType == F) {
			return "Fiction";
		} else return "Non-Fiction";
	}
	
	/**
	 * A toString method with no parameters that returns the 
	 * information of the given book as an entire
	 * String object. It includes every getter method 
	 * of the book class. 
	 * @return string equivalent of input line from text file.
	 * Also shows the getter methods being tested below.
	 */
	public String toString() {
		return ("Book ID: " + getBookID() 
		+ "\tBook title: " + getBookTitle()
		+ "\tISBN: " + getISBN()
		+ "\tAuthor: " + getAuthor()
		+ "\tGenre: " + getGenreType());
	}
	
	
	/**
	 * A static method called BookSearch that access
	 * the entire catalog of books (including number of items) 
	 * to search for a specific or given book's ID.
	 * @param library[] --- an array of books in entire catalog
	 * @param size --- how many books are in catalog 
	 * @param idNum --- the ID of the specific book
	 */
	public static int bookSearch(Book[] library, int size, int idNum) throws BookNotFoundException {
		int index = 0;
		boolean foundBook = false;
		
		if(foundBook != true ) {
			for(int i = 0; i < size; i++) {
				if(library[i].getBookID() == idNum ) {
					foundBook = true; 
					index = i;
					break;
				}
			}
		} 
		if(foundBook == false) {
			throw new BookNotFoundException();
		}
		return index; 	
	}
	
	
	
	
}	
