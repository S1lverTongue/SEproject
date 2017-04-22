// Coded by Trent May
package gui;

import com.User;
import com.CalendarEvent;
import java.util.ArrayList;
public class EditCalendarEventFrame extends AddCalendarEventFrame {
	
	public EditCalendarEventFrame(User loggedIn, CalendarEvent toBeEdited) {
		super(loggedIn);
		super.setTitle(toBeEdited.getTitle() + " Edit");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
