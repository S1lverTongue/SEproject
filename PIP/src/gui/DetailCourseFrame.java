package gui;

import com.User;
import com.Course;
import java.util.ArrayList;
public class DetailCourseFrame extends AddCourseFrame {
	
	public DetailCourseFrame(User loggedIn, Course toBeViewed) {
		super(loggedIn);
		super.setTitle("Course Details");
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}

}
