package com;

import util.*;
import java.util.*;

public class Note extends PIPEntity {
	
	/*
	 * Interface block up top for ease of access
	 * 
	 * Interface:
	 * 	int getID()
	 * 	void setID()
	 * 	void setTitle()
	 * 	String getTitle()
	 *  void setBody()
	 *  String getBody()
	 *  void setDateCreated()
	 *  Date getDateCreated()
	 *  void setDateModded()
	 *  Date getDateModded()
	 *  void setVisible()
	 *  boolean getVisible()
	 *  void addLink()
	 *  void removeLink()
	 *  Linker get
	 *  void addContact()
	 *  void removeContact()
	 *  ArrayList<Contact> getAssociatedContacts()
	 *  void addEvent()
	 *  void removeEvent()
	 *  ArrayList<CalendarEvent> getAssociatedEvents()
	 *  void setModified()
	 *  boolean getModified()
	 *  void addTag()
	 *  void removeTag()
	 *  ArrayList<String> getAssociatedTags()
	 */
	private int id;
	protected String title;
	protected String body;
	protected Date dateCreated;
	protected Date dateModded;
	protected boolean isVisible;
	//protected ArrayList<Contact> associatedContacts;
	//protected ArrayList<CalendarEvent> associatedEvents;
	protected boolean isModified;
	protected ArrayList<String> associatedTags;
	protected Linker associatedPIPEntities;
	
	// Constructor
	public Note() {
		//this.associatedContacts = new ArrayList<Contact>();
		//this.associatedEvents = new ArrayList<CalendarEvent>();
		this.associatedTags = new ArrayList<String>();
		this.associatedPIPEntities = new Linker();
		this.dateCreated = new Date();
		this.dateModded = new Date();
	}
	
	// Sets object id
	public void setID(int id) {
		this.id = id;
	}
	
	// gets id
	public int getID() {
		return this.id;
	}
	
	// sets title
	public void setTitle(String title) {
		this.title = title;
	}
	
	// gets title
	public String getTitle() {
		return this.title;
	}
	
	// sets body
	public void setBody(String body) {
		this.body = body;
	}
	
	// gets body
	public String getBody() {
		return this.body;
	}
	
	// sets creation date
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	// gets creation date
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	// sets date modded
	public void setDateModded(Date dateModded) {
		this.dateModded = dateModded;
	}
	
	// gets date modded
	public Date getDateModded() {
		return this.dateModded;
	}
	
	// sets note visibility
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	// sets note visibility
	public boolean getVisible() {
		return this.isVisible;
	}
	
	// adds a link to this object
	public void addLink(String typeToBeLinked, int idToBeLinked) {
		this.getAssociatedPIPEntities().addLink(typeToBeLinked, idToBeLinked);
	}
	
	// removes a link from this object
	public void removeLink(String typeToBeUnlinked, int idToBeUnlinked) {
		this.getAssociatedPIPEntities().addLink(typeToBeUnlinked, idToBeUnlinked);
	}
	
	// gets the linker object associated with this linker
	public Linker getAssociatedPIPEntities() {
		return this.associatedPIPEntities;
	}
	
	/*
	// adds an associated contact
	public void addContact(Contact newContact) {
		this.associatedContacts.add(newContact);
	}
	
	// removes an associated contact with a linear search.
	// may be changed later
	public void removeContact(Contact removeContact) {
		ListIterator<Contact> contactListIterator = this.associatedContacts.listIterator();
		while (contactListIterator.hasNext()) {
			Contact comparator = contactListIterator.next();
			if (comparator.getID() == removeContact.getID()) {
				this.associatedContacts.remove(comparator);
				break;
			}
		}
	}
	
	// retrieves the list of associated contacts
	public ArrayList<Contact> getAssociatedContacts() {
		return this.associatedContacts;
	}
	
	// adds an associated event
	public void addEvent(CalendarEvent event) {
		this.associatedEvents.add(event);
	}
	
	// removes an event
	public void removeEvent(CalendarEvent event) {
		ListIterator<CalendarEvent> calendarEventListIterator = this.associatedEvents.listIterator();
		while (calendarEventListIterator.hasNext()) {
			CalendarEvent comparator = calendarEventListIterator.next();
			if (comparator.getID() == event.getID()) {
				this.associatedContacts.remove(comparator);
				break;
			}
		}
	}
	
	// gets the list of associated events
	public ArrayList<CalendarEvent> getAssociatedEvents() {
		return this.associatedEvents;
	}
	*/
	
	// sets modified
	public void setModified(boolean modified) {
		this.isModified = modified;
	}
	
	// gets modified
	public boolean getModified() {
		return this.isModified;
	}
	
	// adds an associated tag
	public void addTag(String tag) {
		this.associatedTags.add(tag);
	}
	
	// removes a tag from associated tags
	// subject to change
	public void removeTag(String removedTag) {
		if (this.associatedTags.contains(removedTag)) {
			this.associatedTags.remove(removedTag);
		}
	}
	
	// gets the list of associated tags
	public ArrayList<String> getAssociatedTags() {
		return this.associatedTags;
	}
	
	public String toString() {
		String returnedString = "";
		returnedString += "Title: " + this.getTitle() + "\n";
		returnedString += "Date Created: " + this.getDateCreated().toString() + "\n";
		returnedString += "Last Modified: " + this.getDateModded().toString() + "\n";
		returnedString += "Tags: " + this.getAssociatedTags().toString() + "\n";
		returnedString += "Description: " + this.getBody() + "\n";
		return returnedString;
	}
}
