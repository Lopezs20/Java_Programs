/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 02/16/2021
 * Program: Book Class  
 * Description:
 * 	 This class will be used to store each catalog item as an 
 * 	 book object.  It will test every method within book class.
 * 	 It runs the bookSearch method that searches for a given
 * 	 book's ID and contents (ISBN, title, etc.).
 */
package assg3_lopezs20;

import java.io.*;
import java.util.*;

public class BookDemo {
	
	// The main method that simulates the Book Search program for the user.
	public static void main(String[] args) {
		
		System.out.println("***********Welcome to Book Finder! ************ ");
		System.out.println("Here you can search for books by entering the book's ID.");
		System.out.println("Enter 0 to quit the program if finished.");
		
	// Using FileReader and BufferedReader for reading the input file.
		FileReader read;
		Scanner input = new Scanner(System.in);
		int userBookID = -1;
		
		
		try {
			read = new FileReader("catalog.txt");
			BufferedReader br = new BufferedReader(read);
			String line = ""; 
			
			Book[] catalog = new Book[100];
			int pos = 0;
			while((line = br.readLine()) != null) {	
				
	// Removing all white-space characters from line to store in String variables.
				String[] strData = line.split("\\s+"); 
			        String dataBookID = strData[0];
			        String dataBookTitle = strData[1];
			        String dataISBN = strData[2];
			        String dataAuthor = strData[3];
			        String dataGenre = strData[4];
			        
	// Parsing the integers of dataBookID to get integers, similar with dataGenre for char.		        
			        int intID = Integer.parseInt(dataBookID);
			        char cGenre = dataGenre.charAt(0);
			        
	// Storing the book object into the catalog array.		        
			        catalog[pos] = new Book(intID, dataBookTitle, dataISBN, dataAuthor, cGenre);     
			        pos++;
			    } 
			br.close();
			
		System.out.println("Enter Book ID: ");
		userBookID = input.nextInt();
			while (userBookID != 0) {
				try {
	// Calling the bookSearch method to find the user's book (if exists).				
				int checkPos = Book.bookSearch(catalog, pos, userBookID);
				if ((checkPos != -1)) {
					System.out.println(catalog[checkPos].toString());
					System.out.println("Enter Book ID: ");
					userBookID = input.nextInt();
					} 
				} catch (BookNotFoundException e)
				{
					System.err.println(e);
					System.out.println("Enter Book ID: ");
					userBookID = input.nextInt();
					continue;
				} 
			}
			
		if (userBookID == 0) {	
			input.close();
			System.exit(0);
		}
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

}
