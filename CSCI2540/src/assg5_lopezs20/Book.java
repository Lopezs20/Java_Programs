/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 03/11/2021
 * Program: Book Class  
 * Description:
 * 	This class will implement the structure of the Object Book.
 * 	Here the object specifies everything that exist within a Book. 
 * 	Only the Book Class has access to Book like data types (ISBN,author,etc).
 */
package assg5_lopezs20;

public class Book implements Comparable<Book>  {
	
	
	 //Instance variables for each catalog item to be stored. 
	private String ISBN, title, authorName, publisher, pYear;
	
	/**
	 * Default Book constructor
	 */
	public Book() {
	}
	
	/**
	 * Book Constructor with 5 parameters.
	 * Skeleton of creating Book object
	 * @param givenISBN
	 * @param NameOfAuthor
	 * @param pub
	 * @param year
	 */
	public Book(String givenISBN, String givenTitle, String NameOfAuthor, String pub, String year) {
		ISBN = givenISBN;
		title = givenTitle;
		authorName = NameOfAuthor;
		publisher = pub;
		pYear = year;
		
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's ISBN number. 
	 * @return ISBN.
	 */
	public String getBookISBN() {
		return ISBN;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's title/name. 
	 * @return title.
	 */
	public String getBookTitle() {
		return title;
	}
	
	
	/**
	 * A getter method for retrieving the 
	 * book's author. 
	 * @return Author/NameOfAuthor.
	 */
	public String getBookAuthor() {
		return authorName;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's publisher name. 
	 * @return publisher.
	 */
	public String getBookPub() {
		return publisher;
	}
	
	/**
	 * A getter method for retrieving the 
	 * book's publishing year. 
	 * @return publish year.
	 */
	public String getBookYear() {
		return pYear;
	}
	
	/**
	 * A setter method for setting the 
	 * book's ISBN number.
	 * @param newISBN
	 * @return new ISBN.
	 */
	public String setISBN(String newISBN) {
		this.ISBN = newISBN;
		return ISBN;
	}
	
	/**
	 * A setter method for setting the 
	 * book's author. 
	 * @param newAuthor
	 * @return new author.
	 */
	public String setAuthor(String newAuthor) {
		this.authorName = newAuthor;
		return authorName;
	}
	
	/**
	 * A setter method for setting the 
	 * book's publisher. 
	 * @param newPub
	 * @return new publisher.
	 */
	public String setPublisher(String newPub) {
		this.publisher = newPub;
		return publisher;
	}
	
	/**
	 * A setter method for setting the 
	 * book's year. 
	 * @param newYear
	 * @return new year.
	 */
	public String setYear(String newYear) {
		this.pYear = newYear;
		return pYear;
	}
	
	
	/**
	 * The toString method that returns the 
	 * information of the given book.  
	 * @return String of Book's contents.
	 */
	public String toString() {
		return ("Book ISBN: " + getBookISBN() 
		+ "\nBook title: " + getBookTitle()
		+ "\nAuthor: " + getBookAuthor()
		+ "\nPublisher: " + getBookPub()
		+ "\nYear: " + getBookYear() + "\n");
	}
	
	/**
	 * This method prints the information from a
	 *	given Book into a input-file friendly String. 
	 * 	This method is only used for saving data properly 
	 * 	in the SAVE method.
	 * @return String of input
	 */
	public String writeInfo() {
		return(	getBookISBN() 
				+ "\n" + getBookTitle()
				+ "\n" + getBookAuthor()
				+ "\n" + getBookPub()
				+ "\n" + getBookYear() 
				+ "\n");
	}
	
	/**
	 * Equals method that compares two book's titles
	 * to check if they are the same.
	 * @param passable
	 * @return boolean value
	 */
	public boolean equals(Object passable) {
		if (passable == null) {
			return false;
		}
		
		if (passable != null) {	
		 Book temp = new Book();
			if(passable instanceof Book) {
				temp = (Book) passable;
				if((this.title.equals(temp.getBookTitle()))) {
					return true;	
				}
			}
		}
		return false; 
	}
	
	/**
	 * CompareTo method that takes 2 Books and compares
	 * their title alphabetically
	 * @param temp
	 * @return 1, 0,-1
	 */
	@Override
	public int compareTo(Book temp) {
		
		char book1, book2;
		String size = temp.getBookTitle();
		
		for(int i = 0; i < size.length(); i++ ) {
			 book1 = this.title.charAt(i);
			 book2 = temp.title.charAt(i);
			 if (book1 < book2 ) { // ASCII value deduction
				return 1;   // references Book1 as first in alphabetical order. 
			}
			else if (book2 < book1) {
				return -1; 	// references Book2 as first in alphabetical order.
			}
		}
		return 0; // if Book 1 and 2 are invalid comparisons (equal).
	}
	
	
}
