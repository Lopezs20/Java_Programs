/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/1/2021
 * Program: Event Class  
 * Description:
 * 	This class performs the main operations for the bank simulation.
 * 	This also includes the methods seen in the EventList and Event class.
 */
package assg7_lopezs20;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Simulation {
	
	// private instances
	public static int totalSize = 0;
	private static final String nameOfFile = "input.txt";
	private static int totalTime = 0;
	private static double averTime = 0.0;
	private static int totalArrival = 0;
	private static int totalDeparture = 0;
	private static boolean teller = true;
	private static int cTime = 0;
	
	/**
	 * Loads the operations for creating the simulation
	 * @param fileName
	 * @return EventList
	 * @throws IOException
	 */
	public static EventList loader(String fileName) throws IOException {
		
		EventList list = new EventList();
		Queue<Event> bankLine = new LinkedList<Event>();
		
		File read = new File(fileName);
		Scanner input;
		String line  = "";
		
		input = new Scanner(read);
		
		while (input.hasNext()) {
			if(line != null) {
				int arrive = input.nextInt();
				int trns = input.nextInt();
				
				// Every new event is an Arrival event
				Event first = new Event('A',arrive,trns);
				list.append(first); 

				
				while (!list.isEmpty()) {
					Event current = list.retrieveTop();
					
					cTime = current.getArrive();
					if (current.checkEvent() == 'A') {
						arrivalProcess(current, list, bankLine);
						totalSize++;
					}
					else if (current.checkEvent() == 'D') {
						departProcess(current, list, bankLine);
					}
				  }
			}
		}
		if (totalSize > 0) {
			averTime = (double) (totalTime - totalArrival- totalDeparture)/totalSize; 
		}
		System.out.println("Simulation Finished");
	    System.out.println("\nStatistics:");
	    System.out.println("Total number of people processed: " + totalSize);
	    System.out.println("Average amount of time spent waiting: " + averTime);
	
		
		input.close();
		return list;	
	}
	
	
	/**
	 * The departing process by definition
	 * @param curr
	 * @param list
	 * @param bankQ
	 */
	public static void departProcess(Event curr, EventList list, Queue<Event> bankQ) {
		teller = bankQ.isEmpty();
		
		list.remove(curr);
		
		 if (teller != true) {
			Event peekr = bankQ.peek();
			bankQ.poll();
			int dTime = curr.getArrive() + peekr.getTransact();
			Event dept = new Event('D', dTime);
			list.append(dept);
			
		 }
		 
		 totalDeparture += curr.getArrive();
			System.out.println("Processing depature time at:  " + curr.getArrive());
	}
		
	/**
	 * The arrival process by definition.
	 * @param curr
	 * @param list
	 * @param bankQ
	 */
	public static void arrivalProcess(Event curr, EventList list, Queue<Event> bankQ) {
		
		teller = bankQ.isEmpty();
		
		// update the event list by deleting current event.
		list.remove(curr);
		
		if(teller) {
			int dTime = cTime + curr.getTransact();
			Event dept = new Event('D', dTime);
			list.append(dept);
			
		}
		else { 
			// update the bank line queue by adding current event.
			bankQ.add(curr); 
		}
		
		System.out.println("Processing an arrival time at:  " +  curr.getArrive());
		totalArrival += curr.getArrive();
		totalTime = totalTime + curr.getTransact();
	}
	
	/**
	 * Using the main method to call the loader method
	 * so that the file can be read. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("_______Steven's Bank Simulator_______");
		System.out.println("Simulator Starting...");
		try {
			loader(nameOfFile);
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
