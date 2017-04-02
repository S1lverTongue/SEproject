package testDrivers;

import java.util.*;
import com.*;

public class TestDriver {
	
	public static void main(String[] args) {
		ArrayList<CalendarEvent> cal = new ArrayList<CalendarEvent>();
		ArrayList<Contact> con = new ArrayList<Contact>();
		
		CalendarEvent cal1 = new CalendarEvent(); cal1.setID(0);
		
		CalendarEvent cal2 = new CalendarEvent(); cal2.setID(1);
		
		CalendarEvent cal3 = new CalendarEvent(); cal3.setID(3);
		
		cal1.addLink("calendarEvent", 1);
		cal2.addLink("calendarEvent", 0);
		cal3.addLink("contact", 12);
		
		cal.add(cal1); cal.add(cal2); cal.add(cal3);
		
		Contact con1 = new Contact(); con1.setID(12);
		
		Contact con2 = new Contact(); con2.setID(2);
		
		Contact con3 = new Contact(); con3.setID(56);
		
		con1.addLink("contact", 2);
		con1.addLink("contact", 34);
		con1.addLink("calendarEvent", 3);
		con2.addLink("contact", 56);
		
		con.add(con1); con.add(con2); con.add(con3);
		
		System.out.println("====Calendar Events====");
		for (CalendarEvent event : cal) {
			System.out.println("New Calendar Event");
			System.out.println("Contacts: " + event.getAssociatedPIPEntities().getContacts().toString());
			System.out.println("Notes: " + event.getAssociatedPIPEntities().getNotes().toString());
			System.out.println("CalendarEvents " + event.getAssociatedPIPEntities().getCalendarEvents().toString());
			System.out.println("Courses: " + event.getAssociatedPIPEntities().getCourses().toString());
			System.out.println();
		}
		System.out.println("====End Calendar Events====");
		
		System.out.println();
		System.out.println("====Contacts====");
		for (Contact c : con) {
			System.out.println("New Contact");
			System.out.println("Contacts: " + c.getAssociatedPIPEntities().getContacts().toString());
			System.out.println("Notes: " + c.getAssociatedPIPEntities().getNotes().toString());
			System.out.println("CalendarEvents " + c.getAssociatedPIPEntities().getCalendarEvents().toString());
			System.out.println("Courses: " + c.getAssociatedPIPEntities().getCourses().toString());
			System.out.println();
		}
		System.out.println("====End Contacts====");
		System.out.println();
		System.out.println("Working with removing links");
		for (CalendarEvent e : cal) {
			e.removeLink("note", 1);
			e.removeLink("contact", 2);
			e.removeLink("calendarEvent", 3);
		}
		
		for (Contact c : con) {
			c.removeLink("contact", 2);
			c.removeLink("contact", 9);
			c.removeLink("note",  23);
			c.removeLink("calendarEvent", 3);
		}
		System.out.println("Some Links removed");
		System.out.println();
		
		System.out.println("====Calendar Events Again====");
		for (CalendarEvent event : cal) {
			System.out.println("New Calendar Event");
			System.out.println("Contacts: " + event.getAssociatedPIPEntities().getContacts().toString());
			System.out.println("Notes: " + event.getAssociatedPIPEntities().getNotes().toString());
			System.out.println("CalendarEvents " + event.getAssociatedPIPEntities().getCalendarEvents().toString());
			System.out.println("Courses: " + event.getAssociatedPIPEntities().getCourses().toString());
			System.out.println();
		}
		System.out.println("====End Calendar Events====");
		
		System.out.println();
		System.out.println("====Contacts Again====");
		for (Contact c : con) {
			System.out.println("New Contact");
			System.out.println("Contacts: " + c.getAssociatedPIPEntities().getContacts().toString());
			System.out.println("Notes: " + c.getAssociatedPIPEntities().getNotes().toString());
			System.out.println("CalendarEvents " + c.getAssociatedPIPEntities().getCalendarEvents().toString());
			System.out.println("Courses: " + c.getAssociatedPIPEntities().getCourses().toString());
			System.out.println();
		}
		System.out.println("====End Contacts====");
		System.out.println();
		
	}

}
