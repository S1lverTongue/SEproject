package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filter {
	
	private static String goodAscii = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
	
	// Looks for any characters not specified in
	// the goodAscii variable above
	public static boolean userFilter(String data) {
		boolean good = true;
		int i = 0;
		while (i < data.length() - 1) {
			if (goodAscii.contains(data.substring(i, i + 1)) == false) {
				good = false;
			}
			if (!good) {
				break;
			}
			i++;
		}
		return good;
	}
	
	// Grabs a description or any string really and shortens
	// it and adds an ellipsis on to it
	public static String shortenDescription(String description) {
		String returner = "";
		if (description.length() >= 15) { // long string
			returner = description.substring(0, 14).trim() + "...";
		} else {
			returner = description.trim();
		}
		return returner;
	}
	
	/*
	 * Takes in a string and compares it to yes 
	 * and changes the return value of emergency
	 * to match it.
	 */
	public static boolean isEmerg (String checkString) {
		boolean emergency = false;
		if (checkString.equalsIgnoreCase("yes"))
			emergency = true;
		return emergency;
	}
	
	/*
	 * makes sure that all given strings contain only numbers and
	 * no letters or symbols
	 */
	public static boolean isNumOnly(String checkString) {
		boolean isNum = false;
		if (checkString.matches("[0-9]+"));
			isNum = true;
		return isNum;
	}
	
	public static Date getDate(String month, String day, String year) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = new Date();
		try {
			startDate = df.parse(month + "/" + day + "/" + year);
		} catch (ParseException e) {}
		return startDate;
	}
}
