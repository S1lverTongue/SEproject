package app;

import java.nio.file.Files;
import java.util.*;
import java.io.*;

public class PIPStart {
	
	public static void main(String[] args) {
		File directory = new File(".");
		File[] files = directory.listFiles();
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		
		File newDirectory = new File("./src/users/");
		files = directory.listFiles(fileFilter);
		System.out.println(directory.toString());
		System.out.println(Arrays.toString(files));
		System.out.println(directory.getAbsolutePath());
		System.out.println(newDirectory.toString());
		System.out.println(newDirectory.isDirectory());
		System.out.println(newDirectory.getAbsolutePath());
	}

}
