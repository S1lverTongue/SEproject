package app;

import javax.swing.JFrame;
import gui.*;

public class PIPStart {
	
	private static JFrame mainWindow;
	
	public static void main(String[] args) {
		try {
			mainWindow = new LoginFrame();
		} catch (Exception e) {
			System.out.println("Error Occurred");
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void changeWindow(JFrame newWindow) {
		mainWindow = newWindow;
	}

}
