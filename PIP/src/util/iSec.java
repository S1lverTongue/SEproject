package util;
//interface for the secretary object
public interface iSec {
	void add(Object o, String n, String t);
	String[] getTags();
	String[] getDrawer(String tag);
	void deleteFile(String tag, String name);
	void deleteDrawer(String tag);
	Object getFile(String tag, String name);
	boolean search(String tag, String name);
	
}
