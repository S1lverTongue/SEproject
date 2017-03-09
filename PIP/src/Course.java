import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;

public class Course {
	
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
	 * 	void setModified(boolean)
	 * 	boolean getModified()
	 * 	String toString()
	 * 	String toXML()
	 */
	
	// Probably going to have to work with the Date
	// objects again and go with Calendar objects and
	// instances instead.
	private int id;
	protected String title;
	protected ArrayList<CalendarEvent> eventIds;
	protected int skipTotal;
	protected int skipsUsed;
	protected Date startDate;
	protected Date endDate;
	protected Date meetingTime;
	private boolean isModified;
	
	// Default constructor for the Course
	public Course() {
		this.setTitle("");
		this.eventIds = new ArrayList<CalendarEvent>();
		this.setSkipTotal(0);
		this.skipsUsed = 0;
		this.setStartDate(Date.from(Instant.now()));
		this.setEndDate(Date.from(Instant.now()));
		this.setMeetingTime(Date.from(Instant.now()));
	}
	
	// More concise constructor for the Course object
	public Course(String title,
				  int skipTotal,
				  Date startDate,
				  Date endDate,
				  Date meetingTime) {
		this.setTitle(title);
		this.eventIds = new ArrayList<CalendarEvent>();
		this.setSkipTotal(skipTotal);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setMeetingTime(meetingTime);
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
	
	// adds an event to this Course object
	public void addEvent(CalendarEvent newEvent) {
		this.eventIds.add(newEvent);
	}
	
	// returns the list of CalendarEvents associated to this
	// course object
	public ArrayList<CalendarEvent> getAssociatedEventIds() {
		return this.eventIds;
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
		returnedString += "ID: " + this.getID() + "\n";
		returnedString += "Title: " + this.getTitle() + "\n";
		returnedString += "EventIds: " + this.getAssociatedEventIds().toString() + "\n";
		returnedString += "SkipTotal: " + this.getSkipTotal() + "\n";
		returnedString += "SkipsTotal: " + this.getSkipsUsed() + "\n";
		returnedString += "StartDate: " + this.getStartDate().toString() + "\n";
		returnedString += "EndDate: " + this.getEndDate().toString() + "\n";
		returnedString += "MeetingTime: " + this.getMeetingTime().toString() + "\n";
		returnedString += "Modified: " + this.getModified() + "\n";
		return returnedString;
	}
	
	// returns a String XML representation of this Course object
	public String toXML() {
		String xmlRepresentation = "<Course>\n";
		xmlRepresentation += "<id>" + this.getID() + "</id>\n";
		xmlRepresentation += "<title>" + this.getTitle() + "</title>\n";
		xmlRepresentation += "<eventIds>" + this.getAssociatedEventIds().toString() + "</eventIds>\n";
		xmlRepresentation += "<skipTotal>" + this.getSkipTotal() + "</skipTotal>\n";
		xmlRepresentation += "<skipsUsed>" + this.getSkipsUsed() + "</skipsUsed>\n";
		xmlRepresentation += "<startDate>" + this.getStartDate().toString() + "</startDate>\n";
		xmlRepresentation += "<endDate>" + this.getEndDate().toString() + "</endDate>\n";
		xmlRepresentation += "<meetingTime>" + this.getMeetingTime().toString() + "</meetingTime>\n";
		xmlRepresentation += "<isModified>" + this.getModified() + "</isModified>\n";
		xmlRepresentation += "</Course>\n";
		return xmlRepresentation;
	}
}
