package gui;

import com.User;
import com.CalendarEvent;
import java.util.ArrayList;
public class EditCalendarEventFrame extends AddCalendarEventFrame {
	
	public EditCalendarEventFrame(User loggedIn, CalendarEvent toBeEdited) {
		super(loggedIn);
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
