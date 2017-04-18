/*
 * Trent's Design:
 * 		A linker is an object of ArrayLists that contain
 * 		the int ids of associated objects, but the int ids
 * 		are wrapped as Integer objects.  In this format,
 * 		all objects will need a linker with associated methods,
 * 		but this will remove a couple of the "associated" attributes
 * 		in a couple classes.
 */

package util;

import java.io.Serializable;
import java.util.*;

public class Linker implements Serializable {
	
	/*
	 * Interface block:
	 * 	Linker()
	 * 	void addLink(String objectToBeLinked, int id)
	 * 	void removeLink(String objectToBeUnlinked, int id)
	 * 	ArrayList<Integer> getContacts()
	 *  ArrayList<Integer> getCalendarEvents()
	 *  ArrayList<Integer> getCourses()
	 *  ArrayList<Integer> getNotes()
	 */

/* The basic idea is to store the id's that link together. I had a thought to
    store them in an array list of each type of id but i want to run that past
    you guys first. */

 // private int idCon;
 // private int idEve;
 // private int idCour;
 // private int idNote;
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 4185349939767314107L;
private ArrayList<Integer> contactIds;
  private ArrayList<Integer> eventIds;
  private ArrayList<Integer> courseIds;
  private ArrayList<Integer> noteIds;

  public Linker(){
    //still very unsure if there is anyway to build a variable sized constructor
    //need to discuss and look into this some more
	  contactIds = new ArrayList<Integer>();
	  eventIds = new ArrayList<Integer>();
	  courseIds = new ArrayList<Integer>();
	  noteIds = new ArrayList<Integer>();
  }
  
  public void addLink(String objectToBeLinked, int linkingId) {
	  if (objectToBeLinked.equals("contact")) {
		  contactIds.add(new Integer(linkingId));
	  } else if (objectToBeLinked.equals("calendarEvent")) {
		  eventIds.add(new Integer(linkingId));
	  } else if (objectToBeLinked.equals("course")) {
		  courseIds.add(new Integer(linkingId));
	  } else if (objectToBeLinked.equals("note")) {
		  noteIds.add(new Integer(linkingId));
	  }
  }
  
  public void removeLink(String collectionToCheck, int linkingId) {
	  Integer comparator = new Integer(linkingId);
	  if (collectionToCheck.equals("contact")) {
		  if (contactIds.contains(comparator)) {
			  contactIds.remove(comparator);
		  }
	  } else if (collectionToCheck.equals("calendarEvent")) {
		  if (eventIds.contains(comparator)) {
			  contactIds.remove(comparator);
		  }
	  } else if (collectionToCheck.equals("course")) {
		  if (courseIds.contains(comparator)) {
			  courseIds.remove(comparator);
		  }
	  } else if (collectionToCheck.equals("note")) {
		  if (noteIds.contains(comparator)) {
			  noteIds.remove(comparator);
		  }
	  }
  }
  
  public ArrayList<Integer> getContacts() {
	  return this.contactIds;
  }
  
  public ArrayList<Integer> getCalendarEvents() {
	  return this.eventIds;
  }
  
  public ArrayList<Integer> getCourses() {
	  return this.courseIds;
  }
  
  public ArrayList<Integer> getNotes() {
	  return this.noteIds;
  }
  
  /*
  private void setContact(int conId){
    idCon = conId;
  }

  private void setEvent(int eveId){
    idEve = eveId;
  }

  private void setCourse(int corsId){
    idCour = corsId;
  }

  private void setNote(int notId){
    idNote = notId;
  }

  private int getContact(){
    return idCon;
  }

  private int getEvent(){
    return idEve;
  }

  private int getCourse(){
    return idCour;
  }

  private int getNote(){
    return idNote;
  }
  */
  
}
