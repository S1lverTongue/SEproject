package gui;

import com.Contact;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


public class EditContactFrame extends AddContactFrame {
	
	public EditContactFrame(ArrayList<Contact> contactCollection, Contact toBeEdited) {
		super(contactCollection);
		super.switchContext("edit");
		super.editSelected(toBeEdited);
	}
}
