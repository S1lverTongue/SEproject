// Coded by Trent May
package gui;

import com.User;
import com.Contact;
import java.util.ArrayList;
import java.util.Date;
public class DetailContactFrame extends AddContactFrame {
	
	public DetailContactFrame(User loggedIn, Contact toView) {
		super(loggedIn);
		super.setTitle(toView.getLastName() + ", " + toView.getFirstName() + " Detail");
		super.switchContext("detail");
		super.editSelected(toView);
	}
}
