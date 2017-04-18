package gui;

import com.User;
import com.Course;
import java.util.ArrayList;

public class EditCourseFrame extends AddCourseFrame {

	public EditCourseFrame(User loggedIn, Course toBeEdited) {
		super(loggedIn);
		super.setTitle("Edit Course");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
