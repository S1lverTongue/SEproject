package gui;

import com.Course;
import com.User;
import java.util.ArrayList;

import com.Assignment;

public class DetailAssignmentFrame extends AddAssignmentFrame {
	
	public DetailAssignmentFrame(User loggedInUser, Course cor, ArrayList<Assignment> collection, Assignment toBeViewed) {
		super(loggedInUser, cor, collection);
		super.setTitle("View Assignment");
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}
}
