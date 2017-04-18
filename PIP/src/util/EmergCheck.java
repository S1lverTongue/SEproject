package util;
/*
 * Takes in a string and compares it to yes 
 * and changes the return value of emergency
 * to match it.
 */
public class EmergCheck {
	public boolean isEmerg (String checkString) {
			boolean emergency = false;
			if (checkString.equalsIgnoreCase("yes"))
				emergency = true;
			return emergency;
	}
}
