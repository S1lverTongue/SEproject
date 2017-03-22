package com;

//interface for the note objects used for
//the notes section of the personal information
//planner
public interface note {
	//returns the id number of the note object
	int id();
	//returns the title of the note object
	String title();
	//returns the body string of the note object
	String body();
	//returns the date the note object was created
	String date_created();
	//returns the last date the note object was modified
	String date_modded();
	//whether or not the note object is visible or not
	boolean visible();
	//returns an array of string of all people associated with the note
	String[] people();
	//returns an array of string of all events associated with the people
	String[] events();
	//returns an array of string that contains all of the categories the
	//is associated with
	String[] categories();
	
}
