package util;

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
}
