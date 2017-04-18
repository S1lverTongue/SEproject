package gui;

import com.Course;
import java.util.ArrayList;

public class EditCourseFrame extends AddCourseFrame {

	public EditCourseFrame(ArrayList<Course> courseCollection, Course toBeEdited) {
		super(courseCollection);
		super.setTitle("Edit Course");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
