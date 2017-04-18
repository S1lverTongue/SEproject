package gui;

import util.Filter;
import util.IDGenerator;
import com.User;
import com.Contact;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AddContactFrame extends JFrame {
	private Contact con;
	private User loggedInUser;
	private int WIDTH;
	private int HEIGHT;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel addressLabel;
	private JLabel birthdayLabel;
	private JLabel companyLabel;
	private JLabel associationLabel;
	private JLabel emergencyLabel;
	private JLabel phoneLabel;
	private JLabel descriptionLabel;
	private JLabel tagLabel;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	private JTextField birthdayDayField;
	private JTextField birthdayMonthField;
	private JTextField birthdayYearField;
	private JTextField companyField;
	private JTextField associationField;
	private JTextField emergencyField;
	private JTextField phoneField;
	private JTextField tagField;
	private JTextArea descriptionField;
	private JButton addButton;
	private JButton editButton;
	private JButton linkButton;
	
	private String mode;
	
	private ArrayList<Contact> contactCollectionToAddTo;
	private Contact editingContact;
	
	public AddContactFrame(User loggedIn) {
		this.loggedInUser = loggedIn;
		setTitle("Add Contact");
		setLayout(null);
		
		this.mode = "add";
		
		this.contactCollectionToAddTo = this.loggedInUser.getContacts();
		WIDTH = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		HEIGHT = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		WIDTH = WIDTH / 2;
		
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		
		initComponents();
		add(firstNameLabel);
		add(firstNameField);
		add(lastNameLabel);
		add(lastNameField);
		add(addressLabel);
		add(addressField);
		add(birthdayLabel);
		add(birthdayDayField);
		add(birthdayMonthField);
		add(birthdayYearField);
		add(companyLabel);
		add(companyField);
		add(associationLabel);
		add(associationField);
		add(emergencyLabel);
		add(emergencyField);
		add(phoneLabel);
		add(phoneField);
		add(descriptionLabel);
		add(descriptionField);
		add(tagLabel);
		add(tagField);
		add(addButton);
		add(editButton);
		add(linkButton);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initComponents() {
		firstNameLabel = new JLabel("First:");
		firstNameField = new JTextField();
		
		lastNameLabel = new JLabel("Last:");
		lastNameField = new JTextField();
		
		addressLabel = new JLabel("Address:");
		addressField = new JTextField();
		
		birthdayLabel = new JLabel("Birthday:");
		birthdayDayField = new JTextField();
		birthdayMonthField = new JTextField();
		birthdayYearField = new JTextField();
		
		companyLabel = new JLabel("Company:");
		companyField = new JTextField();
		
		associationLabel = new JLabel("Association:");
		associationField =new JTextField();
		
		emergencyLabel = new JLabel("Emergency:");
		emergencyField = new JTextField();
		
		phoneLabel = new JLabel("Phone");
		phoneField = new JTextField();
		
		descriptionLabel = new JLabel("Description:");
		descriptionField =new JTextArea();
		
		tagLabel = new JLabel("Tag:");
		tagField = new JTextField();
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					con = new Contact();
					con.setID(IDGenerator.getID());
					con.setFirstName(firstNameField.getText());
					con.setLastName(lastNameField.getText());
					con.setAddress(addressField.getText());
					con.setAssociation(associationField.getText());
					con.setCompany(companyField.getText());
					con.setBirthday(Filter.getDate(birthdayMonthField.getText(), birthdayDayField.getText(), birthdayYearField.getText()));
					con.setModified(true);
					if (Filter.isEmerg(emergencyField.getText()))
						con.setEmergency(true);
					else 
						con.setEmergency(false);
					if (Filter.isNumOnly(phoneField.getText())) {
						con.setPhoneNumber(phoneField.getText());
					} else {
						con.setPhoneNumber("");
					}
					con.setDescription(descriptionField.getText());
					con.setTitle();
					con.setTag("");
					loggedInUser.newContact(con);
					dispose();
				}
			}
		});
		linkButton = new JButton("Link");
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					con.setFirstName(firstNameField.getText());
					con.setLastName(lastNameField.getText());
					con.setAddress(addressField.getText());
					con.setAssociation(associationField.getText());
					con.setCompany(companyField.getText());
					con.setBirthday(Filter.getDate(birthdayMonthField.getText(), birthdayDayField.getText(), birthdayYearField.getText()));
					con.setModified(true);
					if (Filter.isEmerg(emergencyField.getText()))
						con.setEmergency(true);
					else 
						con.setEmergency(false);
					if (Filter.isNumOnly(phoneField.getText())) {
						con.setPhoneNumber(phoneField.getText());
					} else {
						con.setPhoneNumber("");
					}
					con.setDescription(descriptionField.getText());
					con.setTitle();
					con.setTag("");
					loggedInUser.newContact(con);
					dispose();
				}
			}
		});
		
		setSizes();
	}
	
	private void setSizes() {
		firstNameLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 10, (HEIGHT / 100) * 10);
		firstNameField.setBounds((WIDTH / 100) * 15, (HEIGHT / 100) * 13, (WIDTH / 100) * 40, (HEIGHT / 100) * 5);
		
		lastNameLabel.setBounds((WIDTH / 100) * 57, (HEIGHT / 100) * 10, (WIDTH / 100) * 10, (HEIGHT / 100) * 10);
		lastNameField.setBounds((WIDTH / 100) * 65, (HEIGHT / 100) * 13, (WIDTH / 100) * 40, (HEIGHT / 100) * 5);
		
		addressLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 17, (WIDTH / 100) * 10, (HEIGHT / 100) * 10);
		addressField.setBounds((WIDTH / 100) * 15, (HEIGHT / 100) * 20, (WIDTH / 100) * 90, (HEIGHT / 100) * 5);
		
		birthdayLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 24, (WIDTH / 100) * 10, (HEIGHT / 100) * 10);
		birthdayDayField.setBounds((WIDTH / 100) * 15, (HEIGHT / 100) * 27, (WIDTH / 100) * 10, (HEIGHT / 100) * 5);
		birthdayMonthField.setBounds((WIDTH / 100) * 25, (HEIGHT / 100) * 27, (WIDTH / 100) * 10, (HEIGHT / 100) * 5);
		birthdayYearField.setBounds((WIDTH / 100) * 35, (HEIGHT / 100) * 27, (WIDTH / 100) * 10, (HEIGHT / 100) * 5);
		
		companyLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 30, (WIDTH / 100) * 10, (HEIGHT / 100) * 10);
		companyField.setBounds((WIDTH / 100) * 15, (HEIGHT / 100) * 33, (WIDTH / 100) * 20, (HEIGHT / 100) * 5); 
		
		associationLabel.setBounds((WIDTH / 100) * 40, (HEIGHT / 100) * 30, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		associationField.setBounds((WIDTH / 100) * 60, (HEIGHT / 100) * 33, (WIDTH / 100) * 20, (HEIGHT / 100) * 5);
		
		emergencyLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 40, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		emergencyField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 43, (WIDTH / 100) * 20, (HEIGHT / 100) * 5);
		
		phoneLabel.setBounds((WIDTH / 100) * 45, (HEIGHT / 100) * 40, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		phoneField.setBounds((WIDTH / 100) * 65, (HEIGHT / 100) * 43, (WIDTH / 100) * 20, (HEIGHT / 100 * 5));
		
		descriptionLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 50, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		descriptionField.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 60, (WIDTH / 100) * 90, (HEIGHT / 100) * 20);
		
		tagLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 90, (WIDTH / 100) * 10, 20);
		tagField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 90, (WIDTH / 100) * 20, 20);
		addButton.setBounds((WIDTH / 100) * 85, (HEIGHT / 100) * 90, (WIDTH / 100) * 10, 20);
		linkButton.setBounds((WIDTH / 100) * 65, (HEIGHT / 100) * 90, (WIDTH / 100) * 10, 20);
		editButton.setBounds(addButton.getBounds());
	}
	
	private void populateFields(Contact con) {
		this.con = con;
		firstNameField.setText(con.getFirstName());
		lastNameField.setText(con.getLastName());
		addressField.setText(con.getAddress());
		birthdayDayField.setText("" + con.getBirthday().getDay());
		birthdayMonthField.setText("" + con.getBirthday().getMonth());
		birthdayYearField.setText("" + con.getBirthday().getYear());
		companyField.setText(con.getCompany());
		associationField.setText(con.getAssociation());
		if (con.getEmergency()) {
			emergencyField.setText("Yes");
		} else {
			emergencyField.setText("No");
		}
		descriptionField.setText(con.getDescription());
		phoneField.setText(con.getPhoneNumber());
		tagField.setText(con.getTag());
	}
	
	public void switchContext(String toBeSwitched) {
		if (toBeSwitched.equals("edit")){
			this.mode = "edit";
			addButton.setVisible(false);
			editButton.setVisible(true);
		} else if (toBeSwitched.equals("detail")) {
			this.mode = "detail";
			addButton.setVisible(false);
			editButton.setVisible(false);
			linkButton.setVisible(false);
		}
	}
	
	public void editSelected(Contact con) {
		if (mode.equals("edit")) {
			this.editingContact = con;
			populateFields(con);
			makeNotEditable(true);
		} else if (mode.equals("detail")) {
			populateFields(con);
			makeNotEditable(false);
		}
	}
	
	private void makeNotEditable(boolean editNeeded) {
		if (!editNeeded) {
			firstNameField.setEditable(false);
			lastNameField.setEditable(false);
			addressField.setEditable(false);
			birthdayMonthField.setEditable(false);
			birthdayDayField.setEditable(false);
			birthdayYearField.setEditable(false);
			companyField.setEditable(false);
			associationField.setEditable(false);
			emergencyField.setEditable(false);
			descriptionField.setEditable(false);
			phoneField.setEditable(false);
			tagField.setEditable(false);
		} else {
			firstNameField.setEditable(true);
			lastNameField.setEditable(true);
			addressField.setEditable(true);
			birthdayMonthField.setEditable(true);
			birthdayDayField.setEditable(true);
			birthdayYearField.setEditable(true);
			companyField.setEditable(true);
			associationField.setEditable(true);
			emergencyField.setEditable(true);
			descriptionField.setEditable(true);
			phoneField.setEditable(true);
			tagField.setEditable(true);
		}
	}
	
	private boolean checkFields() {
		return (!firstNameField.getText().equals("") &&
				Filter.isNumOnly(birthdayDayField.getText()) &&
				Filter.isNumOnly(birthdayMonthField.getText()) &&
				Filter.isNumOnly(birthdayYearField.getText()));
	}
}
