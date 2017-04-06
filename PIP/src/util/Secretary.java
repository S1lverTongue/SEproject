import java.util.*;

public class Secretary implements iSec {
	String tag = "";
	int name =  "";
	TreeMap<String, TreeMap> cabinet = new TreeMap<String, TreeMap>();
	
	/*
	 *add takes the object and gets the tag if there is already a tag 
	 * for that type of object adds it to that row otherwise it creates
	 * new row and puts it into it.
	 */
	@Override
	public void add(Object o, int n, String t) {
		tag = t;
		name = n;
		if (cabinet.containsKey(tag)) {
			TreeMap<Integer , Object> tempMap = cabinet.get(tag);
			tempMap.put(name, o);
			cabinet.put(tag,  tempMap);
		} else {
			TreeMap<String, Object> row = new TreeMap<String, Object>();
			row.put(name, o);
			cabinet.put(tag,  row);
		}//close if
	}//close add
	
	
	/*
	 * gets all the tags that exist and
	 * returns them in the form of an
	 * array of strings
	 */
	@Override
	public String[] getTags() {
		Set<String> s = cabinet.keySet();
		String[] arr = s.toArray(new String[s.size()]);
		return arr;
	}

	/*
	 * gets all the names of the objects in
	 * each of the tag drawers and returns 
	 * them in the form of an array string
	 */
	@Override
	public String[] getDrawer(String tag) {
		TreeMap<Integer, Object> tempMap = cabinet.get(tag);
		Set<Integer> s = tempMap.keySet();
		String[] arr = s.toArray(new String[s.size()]);
		return arr;
	}

	/*
	 * deletes the object from the row
	 */
	@Override
	public void deleteFile(String tag, int name) {
		TreeMap<Integer, Object> tempMap = cabinet.get(tag);
		tempMap.remove(name);
		cabinet.put(tag, tempMap);
	}
	
	/*
	 * deletes everything related with the tag
	 */
	@Override
	public void deleteDrawer(String tag) {
		cabinet.remove(tag);
	}
	
	/*
	 * gets the object and returns it
	 */
	@Override
	public Object getFile(String tag, int name) {
		TreeMap<Integer, Object> tempMap = cabinet.get(tag);	
		return tempMap.get(name);
	}

	@Override
	public boolean search(String tag, int name) {
		boolean found = false;
		TreeMap<Integer, Object> tempMap = new TreeMap<Integer, Object>();
		if (tag != "misc") {
			tempMap = cabinet.get(tag);
			found = tempMap.containsKey(name);
		} else {
			tempMap = cabinet.get("misc");
			found = tempMap.containsKey(name);
		}
		return found;
	}
	
	/*
	 * yesMrClinton takes in the four different types based off of overloading
	 * and runs through the ArrayList and adds each item in it to the secretary 
	 * object. It uses the built in add on each one to accomplish this.
	 */
	public void yesMrClinton(ArrayList<Note> a) {
		for (int i = 0; i < a.size(); i++) {
		note blueDress = a.get(i);
		String book = blueDress.getTag();
		int cut = blueDress.getId();
		add(blueDress, cut, book);	
		}
	}			

	public void yesMrClinton(ArrayList<Contact> a) {
		for (int i = 0; i < a.size(); i++) {
		Contact blueDress = a.get(i);
		String book = blueDress.getTag();
		int cut = blueDress.getId();
		add(blueDress, cut, book);	
		}
	}	
	
	public void yesMrClinton(ArrayList<CalendarEvent> a) {
		for (int i = 0; i < a.size(); i++) {
		CalendarEvent blueDress = a.get(i);
		String book = blueDress.getTag();
		int cut = blueDress.getId();
		add(blueDress, cut, book);	
		}
	}	

	public void yesMrClinton(ArrayList<Course> a) {
		for (int i = 0; i < a.size(); i++) {
		Course blueDress = a.get(i);
		String book = blueDress.getTag();
		int cut = blueDress.getId();
		add(blueDress, cut, book);	
		}
	}	

	/*
	 * This save feature keeps from having to do more then one operation
	 * in the main part of the program and instead takes care of it internally
	 * in the secretary class so only one call has to be made. It takes the object
	 * and if it doesn't exist and adds it. If it does exist it removes the old one 
	 * first then adds the updated one.
	 */
	public void save(Object o, int n, String t) {
		if (search(t, n) == false) {
			add(o, n, t);
		} else {
			deleteFile(t, n);
			add(o, n, t);
		}
	}

}
