package com;

import util.IDGenerator;
import util.PIPIO;
import util.*;

import java.io.Serializable;
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
public class User implements Serializable {
    private String username;

    private PIPIO pipio;

    private ArrayList<Note> notes;
    private ArrayList<Course> courses;
    private ArrayList<Contact> contacts;
    private ArrayList<CalendarEvent> calendarEvents;

    private NoteSecretary noteSec;
    private CourseSecretary courseSec;
    private ContactSecretary contactSec;
    private EventSecretary calendarEventsSec;

    public User(String _username) {
        username = _username;
        //notes = new ArrayList<Note>();
        //courses = new ArrayList<Course>();
        //contacts = new ArrayList<Contact>();
        //calendarEvents = new ArrayList<CalendarEvent>();
        //initializeSecretaries();
        //pipio = new PIPIO(username);
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
        // saveData();
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
        noteSec = new NoteSecretary();
        courseSec = new CourseSecretary();
        contactSec = new ContactSecretary();
        calendarEventsSec = new EventSecretary();

        noteSec.yesMrClintonNotes(notes);
        courseSec.yesMrClintonCourses(courses);
        contactSec.yesMrClinton(contacts);
        calendarEventsSec.yesMrClinton(calendarEvents);
    }

    // ** USE ONLY ON LOGOUT **
    //
    // Use this method to clear the ArrayLists and
    //  secretaries before saving the user. Any part
    //   of the User class that is separately saved to
    //    IO (or otherwise unnecessary to save to IO)
    //     can be added here.
    //
    public void disposeUserEnvironment() {
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


    /////////////
    //////////////////
    // Everything below this point is for PIPEntity handling.
    ////////////////////////
    //////////////////////////////


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
                noteSec.deleteFile(note.getTag(), id, note.getTitle());
                notes.remove(note);
                break;
            }
        pipio.deleteNote(id);
    }

    public void deleteCourse(int id) {
        for (Course course : courses)
            if (course.getID() == id) {
                courseSec.deleteFile(course.getTag(), id, course.getTitle());
                courses.remove(course);
                break;
            }
        pipio.deleteCourse(id);
    }

    public void deleteContact(int id) {
        for (Contact contact : contacts)
            if (contact.getID() == id) {
                contactSec.deleteFile(contact.getTag(), id, contact.getTitle());
                contacts.remove(contact);
                break;
            }
        pipio.deleteContact(id);
    }

    public void deleteCalendarEvent(int id) {
        for (CalendarEvent event : calendarEvents)
            if (event.getID() == id) {
                calendarEventsSec.deleteFile(event.getTag(), id, event.getTitle());
                calendarEvents.remove(event);
                break;
            }
        pipio.deleteCalendarEvent(id);
    }

    //
    //
    // Secretary lookups
    //
    public String[] getNoteTags() {
        return noteSec.getTags();
    }

    public String[] getCourseTags() {
        return courseSec.getTags();
    }

    public String[] getContactTags() {
        return contactSec.getTags();
    }

    public String[] getCalendarEventTags() {
        return calendarEventsSec.getTags();
    }

    public PIPEntity getEntityById(int id) {
        PIPEntity result1 = null;
        PIPEntity result2 = null;
        PIPEntity result3 = null;
        PIPEntity result4 = null;

        try {
            result1 = noteSec.searchByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            result2 = courseSec.searchByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            result3 = contactSec.searchByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            result4 = calendarEventsSec.searchByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result1 != null) {
            return result1;
        } else if (result2 != null) {
            return result2;
        } else if (result3 != null) {
            return result3;
        } else if (result4 != null) {
            return  result4;
        } else {
            return null;
        }
    }

    public boolean idIsAvailable(int id) {
        PIPEntity temp = null;
        temp = getEntityById(id);

        if (temp == null)
            return true;
        else
            return false;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }

    public ArrayList<PIPEntity> searchByTitle(String title) {
        ArrayList<PIPEntity> result = new ArrayList<PIPEntity>();

        for (Note note : notes) {
            if (title.equals(note.getTitle())) {
                result.add(note);
            }
        }

        for (Course course : courses) {
            if (title.equals(course.getTitle())) {
                result.add(course);
            }
        }

        for (Contact contact : contacts) {
            if (title.equals(contact.getTitle())) {
                result.add(contact);
            }
        }

        for (CalendarEvent event : calendarEvents) {
            if (title.equals(event.getTitle())) {
                result.add(event);
            }
        }

        return result;
    }
    
}
