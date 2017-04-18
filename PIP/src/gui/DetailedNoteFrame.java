package gui;

import com.User;
import com.Note;

public class DetailedNoteFrame extends EditNoteFrame {
	
	public DetailedNoteFrame(User loggedIn, Note toBeViewed) {
		super(loggedIn, toBeViewed);
		this.setEditable(false);
	}

}
