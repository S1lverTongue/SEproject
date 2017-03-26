/*
 *  PIPIO is a static class that is responsible for reading and writing
 *      any of PIP's data objects to the filesystem (briefly explained
 *      in BasicFileSystem.txt). It also handles a user object, which
 *      will be needed when handling logins.
 *
 *  Loading and saving data objects:
 *      - Each 'load' method requires a username and returns a ArrayList<>
 *          of the data objects.
 *      - Each 'write' method requires a username and a ArrayList<> of the
 *          data objects desired to be written. There is no return value,
 *          but I may change the return to a boolean to signify a successful
 *          write.
 *
 *  Methods:
 *      Loading methods:
 *      - User loadUser(String username)    <-- These two are used by
 *      - ArrayList<String> loadUsernames()      <-- the login module.
 *      - ArrayList<Note> loadNotes(String username)
 *      - ArrayList<Event> loadEvents(String username)
 *      - ArrayList<Course> loadCourses(String username)
 *      - ArrayList<Contact> loadContacts(String username)
 *
 *      Saving methods:
 *      - void saveUser(User user)
 *      - void saveNotes(String username, ArrayList<Note> notes)
 *      - void saveEvents(String username, ArrayList<Event> events)
 *      - void saveCourses(String username, ArrayList<Course> courses)
 *      - void saveContacts(String username, ArrayList<Contacts> contacts)
 */

import java.util.*;
import java.io.*;

public class PIPIO {

    public static User loadUser(String username) {
        User result = null;
        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        try {
            FIS = new FileInputStream(username + "info.puid");
            OIS = new ObjectInputStream(FIS);
            result = (User) OIS.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (FIS != null) {
                try {
                    FIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (OIS != null) {
                try {
                    OIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static ArrayList<String> loadUsernames() {
        ArrayList<String> results = new ArrayList<String>();
        File directory = new File("");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    results.add(file.getName());
            }
        }

        return results;
    }

    public static ArrayList<Note> loadNotes(String username) {
        ArrayList<Note> results = new ArrayList<Note>(); // will contain note objects
        File directory = new File(username + "/Notes"); // the directory which holds objects
        File[] files = directory.listFiles(); // an array of files within the currentDirectory

        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        // this needs to be cleaned up.
        for (File file : files) {
            if (file.isFile()) {
                try {
                    FIS = new FileInputStream(file);
                    OIS = new ObjectInputStream(FIS);
                    results.add((Note) OIS.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (FIS != null) {
                        try {
                            FIS.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (OIS != null) {
                        try {
                            OIS.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return results;
    }

    public static ArrayList<Event> loadEvents(String username) {
        ArrayList<Event> results = new ArrayList<Event>(); // will contain event objects
        File directory = new File(username + "/Events"); // the directory which holds objects
        File[] files = directory.listFiles(); // an array of files within the currentDirectory

        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        // this needs to be cleaned up.
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FIS = new FileInputStream(file);
                        OIS = new ObjectInputStream(FIS);
                        results.add((Event) OIS.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        if (FIS != null) {
                            try {
                                FIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (OIS != null) {
                            try {
                                OIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static ArrayList<Contact> loadContacts(String username) {
        ArrayList<Contact> results = new ArrayList<Contact>(); // will contain contact objects
        File directory = new File(username + "/Contacts"); // the directory which holds objects
        File[] files = directory.listFiles(); // an array of files within the currentDirectory

        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        // this needs to be cleaned up.
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FIS = new FileInputStream(file);
                        OIS = new ObjectInputStream(FIS);
                        results.add((Contact) OIS.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        if (FIS != null) {
                            try {
                                FIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (OIS != null) {
                            try {
                                OIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static ArrayList<Course> loadCourses(String username) {
        ArrayList<Course> results = new ArrayList<Course>(); // will contain note objects
        File directory = new File(username + "/Courses"); // the directory which holds objects
        File[] files = directory.listFiles(); // an array of files within the currentDirectory

        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        // this needs to be cleaned up.
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FIS = new FileInputStream(file);
                        OIS = new ObjectInputStream(FIS);
                        results.add((Course) OIS.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        if (FIS != null) {
                            try {
                                FIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (OIS != null) {
                            try {
                                OIS.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void saveUser(User user) {
        //
        saveObject(user, user.getUsername(), "", "info.puid");
    }

    public static void saveNotes(String username, ArrayList<Note> notes) {
        for (Note note : notes)
            saveObject(note, username, "Notes/", Integer.toString(note.getID()) + ".pip");
    }

    public static void saveEvents(String username, ArrayList<Event> events) {
        for (Event event : events)
            saveObject(event, username, "Events/", Integer.toString(event.getID()) + ".pip");
    }

    public static void saveContacts(String username, ArrayList<Contact> contacts) {
        for (Contact contact : contacts)
            saveObject(contact, username, "Contacts/", Integer.toString(contact.getID()) + ".pip");
    }

    public static void saveCourses(String username, ArrayList<Course> courses) {
        for (Course course : courses)
            saveObject(course, username, "Courses/", Integer.toString(course.getID()) + ".pip");
    }

    private static void saveObject(Object obj, String username, String directory, String filename) {
        FileOutputStream FOS = null;
        ObjectOutputStream OOS = null;

        try {
            FOS = new FileOutputStream(username + "/" + directory + filename);
            OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (FOS != null) {
                try {
                    FOS.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (OOS != null) {
                try {
                    OOS.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
