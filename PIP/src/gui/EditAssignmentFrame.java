package gui;

import java.util.ArrayList;

import com.Assignment;

public class EditAssignmentFrame extends AddAssignmentFrame {
	
	public EditAssignmentFrame(ArrayList<Assignment> assignmentCollection, Assignment toBeEdited) {
		super(assignmentCollection);
		super.setTitle("Edit Assignment");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}

}
