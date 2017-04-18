package gui;

import com.CalendarEvent;
import java.util.ArrayList;
public class DetailCalendarEventFrame extends AddCalendarEventFrame{
	
	public DetailCalendarEventFrame(ArrayList<CalendarEvent> eventCollection, CalendarEvent toBeViewed) {
		super(eventCollection);
		super.switchContext("detail");
		super.editSelected(toBeViewed);
	}

}
