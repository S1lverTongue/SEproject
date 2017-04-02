package com;

import util.*;
import java.util.*;
import java.time.*;

public class Assignment extends CalendarEvent {
	
	/*
	 * Interface block:
	 * 	see CalendarEvent.
	 * 
	 * 	Assignment does not
	 */
	
	public Assignment() {
		this.date = Date.from(Instant.now());
		this.reminderDate = Date.from(Instant.now());
	}
	
	// linking probably going to change later
	public void addLink(int id) {}
	public void removeLink(int id) {}
	public Linker getAssociatedPIPEntities() {return null;}
}
