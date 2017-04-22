// Coded by Trent May
package gui;

import com.User;
import com.Contact;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


public class EditContactFrame extends AddContactFrame {
	
	public EditContactFrame(User loggedIn, Contact toBeEdited) {
		super(loggedIn);
		super.setTitle(toBeEdited.getLastName() + ", " + toBeEdited.getFirstName() + " Edit");
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
