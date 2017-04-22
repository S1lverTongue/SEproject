// Coded by Trent May
package gui;

import com.User;
import com.Note;

public class DetailedNoteFrame extends EditNoteFrame {
	
	public DetailedNoteFrame(User loggedIn, Note toBeViewed) {
		super(loggedIn, toBeViewed);
		super.setTitle(toBeViewed.getTitle() + " Detail");
		this.setEditable(false);
	}

}
