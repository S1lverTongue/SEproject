
package com;

import util.*;

import java.io.Serializable;
import java.util.*;

public class Note extends PIPEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1015392238591684665L;
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
	protected String tag;
	protected Linker associatedPIPEntities;
	
	// Constructor
	public Note() {
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
	
	// sets modified
	public void setModified(boolean modified) {
		this.isModified = modified;
	}
	
	// gets modified
	public boolean getModified() {
		return this.isModified;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return this.tag;
	}
	
	public String toString() {
		String returnedString = "";
		returnedString += "Title: " + this.getTitle() + "\n";
		returnedString += "Date Created: " + this.getDateCreated().toString() + "\n";
		returnedString += "Last Modified: " + this.getDateModded().toString() + "\n";
		returnedString += "Tag: " + this.getTag() + "\n";
		returnedString += "Description: " + this.getBody() + "\n";
		return returnedString;
	}
}
