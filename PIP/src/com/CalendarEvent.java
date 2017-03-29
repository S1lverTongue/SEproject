package com;

import java.util.Date;

public class CalendarEvent {
	
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
	private boolean isModified;
	
	// Default Constructor, dates set to null
	// be refactored lately
	public CalendarEvent() {}
	
	// More verbose constructor for the CalendarEvent object
	public CalendarEvent(String title, 
						 Date date, 
						 boolean remindMe, 
						 Date reminderDate, 
						 String description) {
		this.setTitle(title);
		this.setDate(date);
		this.setRemindMe(remindMe);
		this.setReminderDate(reminderDate);
		this.setDescription(description);
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
		returnedString += "ID: " + this.getID() + "\n";
		returnedString += "Date: " + this.getDate().toString() + "\n";
		returnedString += "Remind Me: " + this.getRemindMe() + "\n";
		returnedString += "Reminder Date: " + this.getReminderDate().toString() + "\n";
		returnedString += "Description: " + this.getDescription() + "\n";
		returnedString += "IsModified: " + this.getModified() + "\n";
		return returnedString;
	}
	
	// Returns a String representation of this CalendarEvent
	// in XML format
	public String toXML() {
		String xmlRepresentation = "<CalendarEvent>\n";
		xmlRepresentation += "<id>" + this.getID() + "</id>\n";
		xmlRepresentation += "<title>" + this.getTitle() + "</title>\n";
		xmlRepresentation += "<date>" + this.getDate().toString() + "</date>\n";
		xmlRepresentation += "<remindMe>" + this.getRemindMe() + "</remindMe>\n";
		xmlRepresentation += "<reminderDate>" + this.getReminderDate().toString() + "</reminderDate>\n";
		xmlRepresentation += "<description>" + this.getDescription() + "</description>\n";
		xmlRepresentation += "<isModified>" + this.getModified() + "</isModified>\n";
		xmlRepresentation += "</CalendarEvent>\n";
		return xmlRepresentation;
	}
}
