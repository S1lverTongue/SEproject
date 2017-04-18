package gui;

import java.util.ArrayList;

import com.Assignment;

public class DetailAssignmentFrame extends AddAssignmentFrame {
	
	public DetailAssignmentFrame(ArrayList<Assignment> assignmentCollection, Assignment toBeViewed) {
		super(assignmentCollection);
		super.setTitle("View Assignment");
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}
}
