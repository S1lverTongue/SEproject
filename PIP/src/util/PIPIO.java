package util;

import com.*;
import java.io.*;
import java.util.*;

public class PIPIO {
    private String slash; // filepath slash type
    private String username; // PIP user's username
    private String userDirectory; // PIP user's directory
    // userDirectory is path to system user's
    //  home directory, plus "PIPSqueak/[username]/"
    //   EX: /Users/sanders/PIPSqueak/fatmattspipjunk/

    public PIPIO(String _username) {
        slash = getSlashType();
        username = _username;
        userDirectory = getUserDirectory(username);
    }

    //
    //
    // STATIC METHODS:
    //  - These are the user-related methods.
    //  - They are static because a PIPIO instance
    //     does not exist without a logged in user.
    //  - These should be used by the login window.
    //
    public static ArrayList<String> loadUsernames() {
        if (!(new File(getPIPDirectory()).exists())) {
            // This block only executes if this is PIP's
            //  first time running on this machine.
            createPIPFolder();
        }

        ArrayList<String> results = new ArrayList<String>();
        String pipDir = getPIPDirectory();

        File directory = new File(pipDir);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    results.add(file.getName());
            }
        }

        return results;
    }

    public static User loadUser(String username) {
        // path to user.puid file:
        String puidPath = getUserDirectory(username) + "user.puid";

        User result = null;
        FileInputStream FIS = null;
        ObjectInputStream OIS = null;

        try {
            FIS = new FileInputStream(puidPath);
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

    public static void createUser(User user) {
        // set the 'slash' for proper path naming
        String slash = getSlashType();
        String userDir = getUserDirectory(user.getUsername());

        // create directories
        try {
            new File(userDir).mkdir(); // user folder
            new File(userDir +  "Notes" + slash).mkdir();
            new File(userDir +  "Events" + slash).mkdir();
            new File(userDir +  "Courses" + slash).mkdir();
            new File(userDir +  "Contacts" + slash).mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveUser(user);
    }

    public static void saveUser(User user) {
        String userDir = getUserDirectory(user.getUsername());

        FileOutputStream FOS = null;
        ObjectOutputStream OOS = null;

        try {
            FOS = new FileOutputStream(userDir + "user.puid");
            OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(user);
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

    private static void createPIPFolder() {
        String pipDir = getPIPDirectory();
        try {
            new File(pipDir).mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getPIPDirectory() {
        String slash = getSlashType();
        return System.getProperty("user.home") + slash + "PIPSqueak" + slash;
    }

    private static String getUserDirectory(String username) {
        String slash = getSlashType();
        return getPIPDirectory() + username + slash;
    }

    private static String getSlashType() {
        if (System.getProperty("os.name").startsWith("Windows"))
            return "\\";
        else
            return "/";
    }

    //
    //
    // helper methods for PIPIO
    //
    private String getDirectoryToEntity(PIPEntity obj) {
        // set base directory for this file
        String typeDir = userDirectory;
        // set the filename based on obj id
        String filename = Integer.toString(obj.getID()) + ".pip";

        // add the appropriate folder to the directory
        if (obj instanceof Note) {
            typeDir += "Notes" + slash;
        } else if (obj instanceof Course) {
            typeDir += "Courses" + slash;
        } else if (obj instanceof Contact) {
            typeDir += "Contacts" + slash;
        } else if (obj instanceof CalendarEvent) {
            typeDir += "Events" + slash;
        } else {
            System.out.println("Object not saved: Type cannot be determined.");
        }

        return typeDir;
    }

    private void saveObject(PIPEntity obj) {
        // get path to object
        String filename = getDirectoryToEntity(obj);

        // start writing the file
        FileOutputStream FOS = null;
        ObjectOutputStream OOS = null;

        try {
            FOS = new FileOutputStream(filename);
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

    private void deleteObject(PIPEntity obj) {
        // get path to object
        String filename = getDirectoryToEntity(obj);

        try {
            File file = new File(filename);
            file.delete();
        } catch (Exception e) {
            System.out.println("UH OH IN PIPIO!: Deleting failed");
        }
    }

    private void deleteObject(int id, String type) {
        String objPath = userDirectory + type + slash + id + ".pip";

        try {
            File file = new File(objPath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //
    //
    // methods for saving a single PIPEntity after modification
    //
    public void saveNote(PIPEntity obj) {
        saveObject(obj);
    }

    public void saveCourse(PIPEntity obj) {
        saveObject(obj);
    }

    public void saveContact(PIPEntity obj) {
        saveObject(obj);
    }

    public void saveCalendarEvent(PIPEntity obj) {
        saveObject(obj);
    }

    //
    //
    // methods for saving an ArrayList of PIPEntities
    //
    public void saveNotes(ArrayList<Note> notes) {
        for (Note note : notes)
            saveObject(note);
    }

    public void saveCourses(ArrayList<Course> courses) {
        for (Course course : courses)
            saveObject(course);
    }

    public void saveContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts)
            saveObject(contact);
    }

    public void saveCalendarEvents(ArrayList<CalendarEvent> events) {
        for (CalendarEvent event : events)
            saveObject(event);
    }

    //
    //
    // methods for deleting a single PIPEntity from filesystem
    //
    public void deleteNote(int id) {
        deleteObject(id, "Notes");
    }

    public void deleteCourse(int id) {
        deleteObject(id, "Courses");
    }

    public void deleteContact(int id) {
        deleteObject(id, "Contacts");
    }

    public void deleteCalendarEvent(int id) {
        deleteObject(id, "Events");
    }

    //
    //
    // methods for loading PIPEntities. Returns ArrayLists
    //
    public ArrayList<Note> loadNotes() {
        ArrayList<Note> results = new ArrayList<Note>(); // will contain note objects
        File directory = new File(userDirectory + "Notes"); // the directory which holds objects
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

    public ArrayList<Course> loadCourses() {
        ArrayList<Course> results = new ArrayList<Course>(); // will contain course objects
        File directory = new File(userDirectory + "Courses"); // the directory which holds objects
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

    public ArrayList<Contact> loadContacts() {
        ArrayList<Contact> results = new ArrayList<Contact>(); // will contain contact objects
        File directory = new File(userDirectory + "Contacts"); // the directory which holds objects
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

    public ArrayList<CalendarEvent> loadCalendarEvents() {
        ArrayList<CalendarEvent> results = new ArrayList<CalendarEvent>(); // will contain CalendarEvent objects
        File directory = new File(userDirectory + "Events"); // the directory which holds objects
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
                        results.add((CalendarEvent) OIS.readObject());
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

}
