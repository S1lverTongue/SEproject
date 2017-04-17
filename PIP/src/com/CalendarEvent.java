package com;

import util.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class CalendarEvent extends PIPEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7605917612747223537L;
	/*
	 * Interface block up top for ease of access
	 * 
	 * 
	 * Interface:
	 *  int getID()
	 *  void setID()
	 *  void setTitle()
	 *  String getTitle()
	 *  void setDate(Date)
	 *  Date getDate()
	 *  void setRemindMe(boolean)
	 *  boolean getRemindMe()
	 *  void setReminderDate(Date)
	 *  Date getReminderDate()
	 *  void setDescription(String)
	 *  String getDescription()
	 *  void addTag()
	 *  void removeTag()
	 *  ArrayList<String> getAssociatedTags()
	 *  void addLink()
	 *  void removeLink()
	 *  Linker getAssociatedPIPEntities()
	 *  void setModified(boolean)
	 *  boolean getModified()
	 *  String toString()
	 *  String toXML()
	 */
	
	// gotta go in and review about setting the
	// dates and stuff for in the future, may have
	// to switch from the Date to a Calendar object
	// instead.
	private int id;
	protected String title;
	protected Date date;
	protected boolean remindMe;
	protected Date reminderDate;
	protected String description;
	protected ArrayList<String> associatedTags;
	private boolean isModified;
	protected Linker associatedPIPEntities;
	
	// Constructor probably going to change the dates
	// later
	public CalendarEvent() {
		this.associatedPIPEntities = new Linker();
		this.associatedTags = new ArrayList<String>();
		this.date = Date.from(Instant.now());
		this.reminderDate = Date.from(Instant.now());
	}
	
	// Sets the distinct id
	public void setID(int id) {
		this.id = id;
	}
	
	// Gets the distinct id, how the Id will be made is
	// made at a later date
	public int getID() {
		return this.id;
	}
	
	// Sets the title of the event
	public void setTitle(String title) {
		this.title = title;
	}
	
	// retrieves the title of the CalendarEvent
	public String getTitle() {
		return this.title;
	}
	
	// sets the date of the CalendarEvent
	public void setDate(Date date) {
		this.date = date;
	}
	
	// retrieves the date for this CalendarEvent object
	public Date getDate() {
		return this.date;
	}
	
	// sets whether or not a verbal/visible reminder is
	// needed for this calendar event
	public void setRemindMe(boolean toBeReminded) {
		this.remindMe = toBeReminded;
	}
	
	// retrieves whether or not this CalendarEvent is
	// one that needs to be reminded
	public boolean getRemindMe() {
		return this.remindMe;
	}
	
	// sets the Date by which this CalendarEvent must be
	// reminded,
	//
	// Refactor this doc later
	public void setReminderDate(Date date) {
		this.reminderDate = date;
	}
	
	// Retrieves the date that this CalendarEvent
	// needs to be reminded about by
	public Date getReminderDate() {
		return this.reminderDate;
	}
	
	// Sets the description of this CalendarEvent
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Retrieves the description of this CalendarEvent
	public String getDescription() {
		return this.description;
	}
	
	// adds a link to this object's associated linker
	public void addLink(String objectToBeLinked, int idToBeLinked) {
		this.getAssociatedPIPEntities().addLink(objectToBeLinked, idToBeLinked);
	}
	
	// removes a link from this object's associated linker
	public void removeLink(String objectToBeUnlinked, int idToBeUnlinked) {
		this.getAssociatedPIPEntities().removeLink(objectToBeUnlinked, idToBeUnlinked);
	}
	
	// gets the linker associated with this object
	public Linker getAssociatedPIPEntities() {
		return this.associatedPIPEntities;
	}
	
	// adds a tag to this contact
	public void addTag(String tag) {
		this.associatedTags.add(tag);
	}
		
	// linear search to remove tag
	public void removeTag(String tag) {
		if (this.associatedTags.contains(tag)) {
			this.associatedTags.remove(tag);
		}
	}
		
	// returns an ArrayList of the associated tags
	public ArrayList<String> getAssociatedTags() {
		return this.associatedTags;
	}	
	
	// Sets whether this CalendarEvent has been modified
	public void setModified(boolean modified) {
		this.isModified = modified;
	}
	
	// Retrieves the isModified attribute of this CalendarEvent
	public boolean getModified() {
		return this.isModified;
	}
	
	// Returns the String representation of this CalendarEvent
	public String toString() {
		String returnedString = "";
		returnedString += "Title: " + this.getTitle() + "\n";
		returnedString += "Date: " + this.getDate().toString() + "\n";
		returnedString += "Remind Me: " + this.getRemindMe() + "\n";
		returnedString += "Reminder Date: " + this.getReminderDate().toString() + "\n";
		returnedString += "Description: " + this.getDescription() + "\n";
		returnedString += "IsModified: " + this.getModified() + "\n";
		return returnedString;
	}
}
