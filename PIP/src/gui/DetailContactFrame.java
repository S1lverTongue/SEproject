package gui;

import com.Contact;
import java.util.ArrayList;
import java.util.Date;
public class DetailContactFrame extends AddContactFrame {
	
	public DetailContactFrame(ArrayList<Contact> contactCollection, Contact toView) {
		super(contactCollection);
		super.switchContext("detail");
		super.editSelected(toView);
	}
}
