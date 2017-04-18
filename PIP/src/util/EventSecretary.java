package util;

import com.*;
import java.util.*;

public class EventSecretary {
	private String tag = "";
	private int name =  0;
	private TreeMap<String, TreeMap> cabinet = new TreeMap<String, TreeMap>();
	private TreeMap<String, ArrayList> index = new TreeMap<String, ArrayList>();
	private TreeMap<Integer, String> IDLookup = new TreeMap<Integer, String>();
	
	/*
	 *add takes the CalendarEvent and gets the tag if there is already a tag 
	 * for that type of CalendarEvent adds it to that row otherwise it creates
	 * new row and puts it into it.
	 */
	public void add(CalendarEvent o, int n, String t) {
		String title = o.getTitle();
		tag = t;
		name = n;
		addToIndex(title, t, n);
		IDLookup.put(n, tag);
		if (cabinet.containsKey(tag)) {
			TreeMap<Integer , CalendarEvent> tempMap = cabinet.get(tag);
			tempMap.put(name, o);
			cabinet.put(tag,  tempMap);
		} else {
			TreeMap<Integer, CalendarEvent> row = new TreeMap<Integer, CalendarEvent>();
			row.put(name, o);
			cabinet.put(tag,  row);
		}//close if
	}//close add
	
	
	/*
	 * gets all the tags that exist and
	 * returns them in the form of an
	 * array of strings
	 */
	public String[] getTags() {
		Set<String> s = cabinet.keySet();
		String[] arr = s.toArray(new String[s.size()]);
		return arr;
	}

	/*
	 * gets all the names of the CalendarEvents in
	 * each of the tag drawers and returns 
	 * them in the form of an array string
	 */
	public String[] getDrawer(String tag) {
		TreeMap<Integer, CalendarEvent> tempMap = cabinet.get(tag);
		Set<Integer> s = tempMap.keySet();
		String[] arr = s.toArray(new String[s.size()]);
		return arr;
	}

	/*
	 * deletes the CalendarEvent from the row
	 */

	public void deleteFile(String tag, int name, String title) {
		TreeMap<Integer, CalendarEvent> tempMap = cabinet.get(tag);
		tempMap.remove(name);
		cabinet.put(tag, tempMap);
		index.remove(title);
	}
	
	/*
	 * deletes everything related with the tag
	 */
	public void deleteDrawer(String tag) {
		TreeMap<Integer, CalendarEvent> temp = new TreeMap<Integer, CalendarEvent>();
		Set<Integer> s = temp.keySet();
		Integer[] arr = s.toArray(new Integer[s.size()]);
		for (Integer remover : arr) {
			CalendarEvent tempEvent = temp.get(remover);
			index.remove(tempEvent.getTitle());
		}
		cabinet.remove(tag);
	}
	
	/*
	 * gets the CalendarEvent and returns it
	 */
	public CalendarEvent getFile(String tag, int name) {
		TreeMap<Integer, CalendarEvent> tempMap = cabinet.get(tag);	
		return tempMap.get(name);
	}

	public boolean search(String tag, int name) {
		boolean found = false;
		TreeMap<Integer, CalendarEvent> tempMap = new TreeMap<Integer, CalendarEvent>();
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
	 * yesMrClinton brings in an array list and loads all of the
	 * events into the appropriate spots in the cabinet
	 */
	public void yesMrClinton(ArrayList<CalendarEvent> a) {
		for (CalendarEvent blueDress : a) {
			String book = blueDress.getTag();
			int cut = blueDress.getID();
			add(blueDress, cut, book);
		}
	}	

	/*
	 * SearchFor searches for an item and returns it used for each of the menus
	 * it creates a new PIPEntity and then if the title exist loads it into the 
	 */
	public CalendarEvent searchFor (String title) {
		CalendarEvent temp = new CalendarEvent();
		ArrayList arrL = new ArrayList();
		if (index.containsKey(title)) {
			arrL = index.get(title);
			String objName = (String) arrL.get(0);
			int objID = (int) arrL.get(1);
			temp = getFile(objName, objID);
		} else {
			temp.setTitle("FILE NOT FOUND");
		}
		return temp;
	}
	
	/*
	 * SearchByID finds the ID and gets the tag from a map and then returns
	 * the object back to the caller 
	 */
	public CalendarEvent searchByID(int ID) {
		String tag = IDLookup.get(ID);
		CalendarEvent temp = getFile(tag, ID);
		return temp;
	}

	/*
	 * adds to the index the name of the object as a key and
	 * an arraylist of 2 that contains the tag and ID that is needed to 
	 * get the file and return it
	 */
	private void addToIndex(String title, String tag, int id) {
		ArrayList temp = new ArrayList();
		temp.add(tag);
		temp.add(id);
		index.put(title, temp);
	}

}
