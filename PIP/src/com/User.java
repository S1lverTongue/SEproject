package com;

import util.IDGenerator;
import util.PIPIO;
import util.Secretary;
import java.util.*;

/**
 * User class is responsible for stuff <-- will finish description later. -matt
 *
 * **** I will fix all secretary calls once
 * ****** Secretary.java is updated.
 *
 * Methods:
 *   Setup/Breakdown Methods:
 *      - onLogin()
 *      - onLogout()
 *      - loadData()
 *      - saveData()
 *
 *   New PIPEntity Methods:
 *     > New
 *      - newNote(Note)
 *      - newCourse(Course)
 *      - newContact(Contact)
 *      - newCalendarEvent(CalendarEvent)
 *
 *     > Delete
 *      - deleteNote(Id)
 *      - deleteCourse(Id)
 *      - deleteContact(Id)
 *      - deleteCalendarEvent(Id)
 *
 *   Trivial Methods:
 *      - getID()
 *      - getUsername()
 *
 */
public class User {
    private int id;
    private String username;

    private PIPIO pipio;

    private ArrayList<Note> notes;
    private ArrayList<Course> courses;
    private ArrayList<Contact> contacts;
    private ArrayList<CalendarEvent> calendarEvents;

    private Secretary noteSec;
    private Secretary courseSec;
    private Secretary contactSec;
    private Secretary calendarEventsSec;

    public User(String _username) {
        username = _username;
        notes = new ArrayList<Note>();
        courses = new ArrayList<Course>();
        contacts = new ArrayList<Contact>();
        calendarEvents = new ArrayList<CalendarEvent>();
        initializeSecretaries();

        // generate and set a unique user id
        do {
            id = IDGenerator.getID();
        } while(PIPIO.loadUserIDs().contains(id));
    }

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    // Any code to be executed when the user logs in
    public void onLogin() {
        pipio = new PIPIO(username);
        loadData();
        initializeSecretaries();
    }


    // Any code to be executed when the user logs out
    public void onLogout() {
        saveData();

        // clear user environment then save user
        disposeUserEnvironment();
        PIPIO.saveUser(this);
    }


    // Load ArrayLists using PIPIO
    public void loadData() {
        notes = pipio.loadNotes();
        courses = pipio.loadCourses();
        contacts = pipio.loadContacts();
        calendarEvents = pipio.loadCalendarEvents();
    }


    // Save ArrayLists using PIPIO
    public void saveData() {
        pipio.saveNotes(notes);
        pipio.saveCourses(courses);
        pipio.saveContacts(contacts);
        pipio.saveCalendarEvents(calendarEvents);
    }

    public void initializeSecretaries() {
        noteSec.yesMrClintonNotes(notes);
        courseSec.yesMrClintonCourses(courses);
        contactSec.yesMrClintonContacts(contacts);
        calendarEventsSec.yesMrClintonCalendarEvents(calendarEvents);
    }

    // ** USE ONLY ON LOGOUT **
    //
    // Use this method to clear the ArrayLists and
    //  secretaries before saving the user. Any part
    //   of the User class that is separately saved to
    //    IO (or otherwise unnecessary to save to IO)
    //     can be added here.
    //
    private void disposeUserEnvironment() {
        // clear ArrayLists
        notes = null;
        courses = null;
        contacts = null;
        calendarEvents = null;

        // clear secretaries
        noteSec = null;
        courseSec = null;
        contactSec = null;
        calendarEventsSec = null;

        // release pipio
        pipio = null;

    }


    /*
        Use the following 8 methods every time
         a user creates or deletes a PIPEntity.
     */
    public void newNote(Note note) {
        notes.add(note);
        noteSec.add(note, note.getID(), note.getTag());
        pipio.saveNote(note);
    }

    public void newCourse(Course course) {
        courses.add(course);
        courseSec.add(course, course.getID(), course.getTag());
        pipio.saveCourse(course);
    }

    public void newContact(Contact contact) {
        contacts.add(contact);
        contactSec.add(contact, contact.getID(), contact.getTag());
        pipio.saveContact(contact);
    }

    public void newCalendarEvent(CalendarEvent calendarEvent) {
        calendarEvents.add(calendarEvent);
        calendarEventsSec.add(calendarEvent, calendarEvent.getID(), calendarEvent.getTag());
        pipio.saveCalendarEvent(calendarEvent);
    }

    public void deleteNote(int id) {
        for (Note note : notes)
            if (note.getID() == id) {
                noteSec.deleteFile(note.getTag(), id);
                notes.remove(note);
                break;
            }
        pipio.deleteNote(id);
    }

    public void deleteCourse(int id) {
        for (Course course : courses)
            if (course.getID() == id) {
                courseSec.deleteFile(course.getTag(), id);
                courses.remove(course);
                break;
            }
        pipio.deleteCourse(id);
    }

    public void deleteContact(int id) {
        for (Contact contact : contacts)
            if (contact.getID() == id) {
                contactSec.deleteFile(contact.getTag(), id);
                contacts.remove(contact);
                break;
            }
        pipio.deleteContact(id);
    }

    public void deleteCalendarEvent(int id) {
        for (CalendarEvent event : calendarEvents)
            if (event.getID() == id) {
                calendarEventsSec.deleteFile(event.getTag(), id);
                calendarEvents.remove(event);
                break;
            }
        pipio.deleteCalendarEvent(id);
    }
}
