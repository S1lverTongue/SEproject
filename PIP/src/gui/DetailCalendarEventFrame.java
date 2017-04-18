package gui;

import com.User;
import com.CalendarEvent;
import java.util.ArrayList;
public class DetailCalendarEventFrame extends AddCalendarEventFrame{
	
	public DetailCalendarEventFrame(User loggedIn, CalendarEvent toBeViewed) {
		super(loggedIn);
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}

}
