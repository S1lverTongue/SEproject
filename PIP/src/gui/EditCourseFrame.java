// Coded by Trent May
package gui;

import com.User;
import com.Course;
import java.util.ArrayList;

public class EditCourseFrame extends AddCourseFrame {

	public EditCourseFrame(User loggedIn, Course toBeEdited) {
		super(loggedIn);
		super.setTitle(toBeEdited.getTitle() + " Edit");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
