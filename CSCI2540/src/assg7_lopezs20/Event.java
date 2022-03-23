/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/1/2021 12:30pm
 * Program: Event Class  
 * Description:
 * 	This class provides the blueprint of the Event object for
 * 	the EventList class. Definitions for what type of event 
 * 	happens are written here. Also getters/setters are included.
 */
package assg7_lopezs20;

public class Event implements Comparable<Event>   {
	
	// Event's final/instance variables
	private static final char ARRIVAL = 'A';
	private static final char DEPARTURE = 'D';
	
	private int arrive , transact, departure;
	private char stage;
	
	/**
	 * Initializes an empty Event constructor
	 */
	public Event() {	
		arrive = 0;
		transact = 0;
		departure = 0;
		stage = ' ';
	}
	
	/**
	 * A constructor with 3 parameters for 
	 * defining an Arrival Event.
	 * @param State
	 * @param arriveTime
	 * @param transaction
	 */
	public Event(char State, int arriveTime, int transaction) {
		
		if (State == ARRIVAL) {
			stage = State;
			arrive = arriveTime;
			transact = transaction;
		}
		else 
			System.out.println("Invalid Event State");
		
	}
	/**
	 * A constructor with 2 parameters
	 * defining an Departure Event.
	 * @param State
	 * @param departTime
	 */
	public Event(char State , int departTime) {
		
		if (State == DEPARTURE) {
			this.stage = State;
			this.departure = departTime;
		}
		else 
			System.out.println("Invalid Event State.");
	}
	
	/**
	 * Checks what type of event the current 
	 * object holds.
	 * @return event types
	 */
	public char checkEvent() {
		
		if (this.getState() == ARRIVAL) {
			return this.getState();
		}
		else if (this.getState() == DEPARTURE) {
			return this.getState();
		}
		return ' ';
	}
	
	/**
	 * To String method that writes an event data 
	 * into a String format for printing. 
	 * @returns String formatted event
	 */
	@Override
	public String toString() {
		
		if (this.getState() == ARRIVAL) {
			return (this.getState() + ", " 
					+ this.getArrive() + ", "
					+ this.getTransact()) ;
		} else
			return ("Processing event: " + this.getState() + ", " 
					+ this.departure);
	}
	
	/**
	 * A getter for event's transaction time.
	 * @return transaction.
	 */
	public int getTransact() {
		return this.transact;
	}
	
	// setter for the given event's transaction.
	public void setTransact(int newTransact) {
		this.transact = newTransact;
	}
	
	/**
	 * A getter for event's arrival time.
	 * @return arrival 
	 */
	public int getArrive() {
		return this.arrive;
	}
	
	// setter for given event's arrival.
	public void setArrive(int newArrival) {
		this.arrive = newArrival;
	}

	/**
	 * A getter for the event's departure time.
	 * @return
	 */
	public int getDeparture() {
		return this.departure;
	}
	
	// setter for a given event's departure. 
	public void setDeparture(int newTime) {
		this.departure = newTime;
	}
	
	/**
	 * A getter for the event's type/stage.
	 * @return
	 */
	public char getState() {
		return this.stage ;
	}
	
	// setter for the event's type/stage.
	public void setState(char newState) {
		this.stage = newState;
	}
	/**
	 * Compares the two events to determine
	 * the time between departures. 
	 */
	@Override
	public int compareTo(Event comp) {
		
		if (comp != null) {
			if (comp instanceof Event) {
				return this.departure - comp.arrive;
				}
			}
		return 0;
		}
}
