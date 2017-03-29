package util;

import java.util.*;

public class Secretary implements iSec {
	String tag = "";
	String name =  "";
	TreeMap<String, TreeMap> cabinet = new TreeMap<String, TreeMap>();
	
	/*
	 *add takes the object and gets the tag if there is already a tag 
	 * for that type of object adds it to that row otherwise it creates
	 * new row and puts it into it.
	 */
	@Override
	public void add(Object o, String n, String t) {
		tag = t;
		name = n;
		if (cabinet.containsKey(tag)) {
			TreeMap<String, Object> tempMap = cabinet.get(tag);
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
		TreeMap<String, Object> tempMap = cabinet.get(tag);
		Set<String> s = tempMap.keySet();
		String[] arr = s.toArray(new String[s.size()]);
		return arr;
	}

	/*
	 * deletes the object from the row
	 */
	@Override
	public void deleteFile(String tag, String name) {
		TreeMap<String, Object> tempMap = cabinet.get(tag);
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
	public Object getFile(String tag, String name) {
		TreeMap<String, Object> tempMap = cabinet.get(tag);	
		return tempMap.get(name);
	}

	@Override
	public boolean search(String tag, String name) {
		boolean found = false;
		TreeMap<String, Object> tempMap = new TreeMap<String, Object>();
		if (tag != "misc") {
			tempMap = cabinet.get(tag);
			found = tempMap.containsKey(name);
		} else {
			tempMap = cabinet.get("misc");
			found = tempMap.containsKey(name);
		}
		return found;
	}

}
