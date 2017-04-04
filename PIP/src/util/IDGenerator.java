package util;

import java.util.Random;
import java.util.UUID;

/*
 * Static class for ID generation for PIP entities.
 * 
 * Class uses Java's random number generator and the UUID Class.
 */

public class IDGenerator {
	
	/*
	 * getID() uses a Random object and a UUID object composed
	 * of two random longs.
	 * 
	 * It then returns a hash code of that UUID
	 */
	public static int getID() {
		Random randGen = new Random();
		UUID id = new UUID(randGen.nextLong(), randGen.nextLong());
		int returner = id.hashCode();
		while (returner < 0) {
			id = new UUID(randGen.nextLong(), randGen.nextLong());
			returner = id.hashCode();
		}
		return returner;
	}
}
