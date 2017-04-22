// Coded by Trent May
package gui;

import com.Course;
import com.User;
import java.util.ArrayList;

import com.Assignment;

public class EditAssignmentFrame extends AddAssignmentFrame {
	
	public EditAssignmentFrame(User loggedIn, Course cor, ArrayList<Assignment> assignmentCollection,  Assignment toBeEdited) {
		super(loggedIn, cor, assignmentCollection);
		super.setTitle(toBeEdited.getTitle() + " Edit");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}

}
