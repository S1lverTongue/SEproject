package gui;

import com.CalendarEvent;
import java.util.ArrayList;
public class EditCalendarEventFrame extends AddCalendarEventFrame {
	
	public EditCalendarEventFrame(ArrayList<CalendarEvent> eventCollection, CalendarEvent toBeEdited) {
		super(eventCollection);
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
