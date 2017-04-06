package com;

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

    private ArrayList<Note> notes;
    private ArrayList<Course> courses;
    private ArrayList<Contact> contacts;
    private ArrayList<CalendarEvent> calendarEvents;

    private Secretary noteSec;
    private Secretary courseSec;
    private Secretary contactSec;
    private Secretary calendarEventsSec;

    public User() {

    }

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    // Any code to be executed when the user logs in
    public void onLogin() {
        loadData();
        noteSec.yesMrClintonNotes(notes);
        courseSec.yesMrClintonCourses(courses);
        contactSec.yesMrClintonContacts(contacts);
        calendarEventsSec.yesMrClintonCalendarEvents(calendarEvents);
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
        notes = PIPIO.loadNotes(username);
        courses = PIPIO.loadCourses(username);
        contacts = PIPIO.loadContacts(username);
        calendarEvents = PIPIO.loadEvents(username);
    }


    // Save ArrayLists using PIPIO
    public void saveData() {
        PIPIO.saveNotes(username, notes);
        PIPIO.saveCourses(username, courses);
        PIPIO.saveContacts(username, contacts);
        PIPIO.saveEvents(username, calendarEvents);
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

    }


    /*
        Use the following 8 methods every time
         a user creates or deletes a PIPEntity.
     */
    public void newNote(Note note) {
        notes.add(note);
        noteSec.add(note, note.getID(), note.getTag());
    }

    public void newCourse(Course course) {
        courses.add(course);
        courseSec.add(course, course.getID(), course.getTag());
    }

    public void newContact(Contact contact) {
        contacts.add(contact);
        contactSec.add(contact, contact.getID(), contact.getTag());
    }

    public void newCalendarEvent(CalendarEvent calendarEvent) {
        calendarEvents.add(calendarEvent);
        calendarEventsSec.add(calendarEvent, calendarEvent.getID(), calendarEvent.getTag());
    }

    public void deleteNote(int id) {
        for (Note note : notes)
            if (note.getID() == id) {
                notes.remove(note);
                break;
            }
        PIPIO.deleteObject(id, username, "Notes");
    }

    public void deleteCourse(int id) {
        for (Course course : courses)
            if (course.getID() == id) {
                courses.remove(course);
                break;
            }
        PIPIO.deleteObject(id, username, "Courses");
    }

    public void deleteContact(int id) {
        for (Contact contact : contacts)
            if (contact.getID() == id) {
                contacts.remove(contact);
                break;
            }
        PIPIO.deleteObject(id, username, "Contacts");
    }

    public void deleteCalendarEvent(int id) {
        for (CalendarEvent event : calendarEvents)
            if (event.getID() == id) {
                calendarEvents.remove(event);
                break;
            }
        PIPIO.deleteObject(id, username, "Events");
    }
}
