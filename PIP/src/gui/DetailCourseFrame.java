package gui;

import com.Course;
import java.util.ArrayList;
public class DetailCourseFrame extends AddCourseFrame {
	
	public DetailCourseFrame(ArrayList<Course> courseCollection, Course toBeViewed) {
		super(courseCollection);
		super.setTitle("Course Details");
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}

}
