package com;

import util.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.time.Instant;

public class Course extends PIPEntity implements Serializable {
	
	/*
	 * Interface:
	 * 	void setID(int)
	 * 	int getID()
	 * 	void setTitle(String)
	 * 	String getTitle()
	 * 	void addEvent(CalendarEvent)
	 * 	ArrayList<CalendarEvent> getAssociatedEventIds()
	 * 	void setSkipTotal(int)
	 * 	int getSkipTotal()
	 * 	int getSkipsUsed()
	 * 	void setStartDate(Date)
	 * 	Date getStartDate()
	 * 	void setEndDate(Date)
	 * 	Date getEndDate()
	 * 	void setMeetingTime(Date)
	 * 	Date getMeetingTime()
	 *  void addAssignment()
	 *  void removeAssignment()
	 *  ArrayList<Assignment> getAssignments()
	 *  void addLink()
	 *  void removeLink()
	 *  Linker getAssociatedPIPEntities()
	 *  void addTag()
	 *  void removeTag()
	 *  ArrayList<String> getAssociatedTags()
	 * 	void setModified(boolean)
	 * 	boolean getModified()
	 * 	String toString()
	 * 	String toXML()
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3032767791345106378L;
	// Probably going to have to work with the Date
	// objects again and go with Calendar objects and
	// instances instead.
	private int id;
	protected String title;
	//protected ArrayList<CalendarEvent> eventIds;
	protected int skipTotal;
	protected int skipsUsed;
	protected Date startDate;
	protected Date endDate;
	protected Date meetingTime;
	protected ArrayList<Assignment> assignments;
	protected String tag;
	protected Linker associatedPIPEntities;
	private boolean isModified;
	
	// Constructor. Possibly changing the dates later
	public Course() {
		this.associatedPIPEntities = new Linker();
		this.startDate = Date.from(Instant.now());
		this.endDate = Date.from(Instant.now());
		this.meetingTime = Date.from(Instant.now());
	}
	
	// sets the ID of this Course object
	public void setID(int id) {
		this.id = id;
	}
	
	// retrieves the ID of this Course object
	public int getID() {
		return this.id;
	}
	
	// sets the title of this Course object
	public void setTitle(String title) {
		this.title = title;
	}
	
	// retrieves the title of this Course object
	public String getTitle() {
		return this.title;
	}
	
	// sets how many skip days that this Course allows a
	// participant
	public void setSkipTotal(int totalSkips) {
		this.skipTotal = totalSkips;
	}
	
	// returns how many skip days that are available
	// in this Course object
	public int getSkipTotal() {
		return this.skipTotal;
	}
	
	// returns how many skip days have been used in this Course
	// object
	public int getSkipsUsed() {
		return this.skipsUsed;
	}
	
	// sets the starting date for this Course object
	public void setStartDate(Date date) {
		this.startDate = date;
	}
	
	// retrieves the starting date for this Course object
	public Date getStartDate() {
		return this.startDate;
	}
	
	// sets the ending date for this Course object
	public void setEndDate(Date date) {
		this.endDate = date;
	}
	
	// retrieves the ending date for this Course object
	public Date getEndDate() {
		return this.endDate;
	}
	
	// sets the time that this Course object meets
	public void setMeetingTime(Date date) {
		this.meetingTime = date;
	}
	
	// retrieves the meeting time that this Course object
	// meets
	public Date getMeetingTime() {
		return this.meetingTime;
	}
	
	// adds an assignment to the list
	public void addAssignment(Assignment newAssignment) {
		this.assignments.add(newAssignment);
	}
	
	// removes a specified assignment from the course
	public void removeAssignment(Assignment oldAssignment) {
		Assignment comparator = oldAssignment;
		if (this.assignments.contains(comparator)) {
			this.assignments.remove(comparator);
		}
	}
	
	// gets the list of assignments for this course
	public ArrayList<Assignment> getAssignments() {
		return this.assignments;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return this.tag;
	}
	
	// adds a link to the linker associated with this course
	public void addLink(String objectToBeLinkedTo, int idToBeLinkedTo) {
		this.getAssociatedPIPEntities().addLink(objectToBeLinkedTo, idToBeLinkedTo);
	}
	
	// removes a link from linker associated with this course 
	public void removeLink(String objectToBeUnlinked, int idToBeUnlinked) {
		this.getAssociatedPIPEntities().removeLink(objectToBeUnlinked, idToBeUnlinked);
	}
	
	// gets the linker associated with course
	public Linker getAssociatedPIPEntities() {
		return this.associatedPIPEntities;
	}
	
	// sets the isModified attribute for this Course object
	public void setModified(boolean modified) {
		this.isModified = modified;
	}
	
	// retrieves the isModified attribute for this Course object 
	public boolean getModified() {
		return this.isModified;
	}
	
	// returns a String representation of this Course object
	public String toString() {
		String returnedString = "";
		returnedString += "Title: " + this.getTitle() + "\n";
		returnedString += "Allowable Skips: " + this.getSkipTotal() + "\n";
		returnedString += "Skips Used: " + this.getSkipsUsed() + "\n";
		returnedString += "Start Date: " + this.getStartDate().toString() + "\n";
		returnedString += "EndD ate: " + this.getEndDate().toString() + "\n";
		returnedString += "Meeting Time: " + this.getMeetingTime().toString() + "\n";
		return returnedString;
	}
}
