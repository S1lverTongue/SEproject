package util;

public class Filter {
	
	private static String goodAscii = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
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
}
