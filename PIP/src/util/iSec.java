import java.util.ArrayList;

//interface for the secretary object
public interface iSec {
	void add(Object o, int n, String t);
	String[] getTags();
	String[] getDrawer(String tag);
	void deleteFile(String tag, int name);
	void deleteDrawer(String tag);
	Object getFile(String tag, int name);
	boolean search(String tag, int name);
	public void yesMrClinton(ArrayList<Note> a);
	public void yesMrClinton(ArrayList<Contact> a);
	public void yesMrClinton(ArrayList<CalendarEvent> a);
	public void yesMrClinton(ArrayList<Course> a);
	public void save(Object o, String n, int t);
	
}
