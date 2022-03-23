/**
 * @author Steven Lopez 
 * Class: CSCI 2540
 * Date Due: 04/1/2021
 * Program: Event Class  
 * Description:
 * 	This class is designed to be used during the simulation class. 
 * 	It uses a LinkedList of event objects to store the order and time
 * 	of each event during any processes within the simulation class.
 * 	This class has defined methods for using the ADT. 
 */
package assg7_lopezs20;

import java.util.LinkedList;
import java.util.List;

public class EventList { 
	
	// protected linked-list data type.
	protected List<Event> storageList;
	
	// Event-list constructor for an event type empty LinkedList.
	public EventList() {
		storageList = new LinkedList<Event>();
	}
	
	/**
	 * Adds a defined event into event-list.
	 * @param event
	 */
	public void append(Event e) {
		if (e.getState() == 'A') {
			this.storageList.add(e);
		}
		else {
		this.storageList.add(0,e);
		}
	}
	
	/**
	 * Removes the given event from the event-list.
	 * @param event
	 */
	public void remove(Event e) {
		this.storageList.remove(e);
	}
	
	/**
	 * Deletes the first event of the LinkedList.
	 */
	public void deleteTop() {
		this.storageList.remove(0);
	}
	
	/**
	 * Retrieve method only gets the first 
	 * event in the LinkedList. 
	 * @return -- top event in the list.
	 */
	public Event retrieveTop() {
		return this.storageList.get(0);
	}
	
	/**
	 * Checks to see if the LinkedList is not
	 * empty or is empty
	 * @return -- boolean value
	 */
	public boolean isEmpty() {
		if(storageList.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
}
