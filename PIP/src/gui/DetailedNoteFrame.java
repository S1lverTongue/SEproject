package gui;

import com.Note;

public class DetailedNoteFrame extends EditNoteFrame {
	
	public DetailedNoteFrame(Note toBeViewed) {
		super(toBeViewed);
		this.setEditable(false);
	}
	
	public static void main(String[] args) {
		Note test = new Note();
		test.setTitle("Help");
		test.setBody("I'm stuck in a Chinese Fortune Cookie Factory! Send for the national guard, the army, johnny quest, anybody!!");
		DetailedNoteFrame x = new DetailedNoteFrame(test);
	}

}
