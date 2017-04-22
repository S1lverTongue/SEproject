// Coded by Trent May
package gui;

import com.User;

import util.IDGenerator;
import util.Filter;

import com.CalendarEvent;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;

public class AddCalendarEventFrame extends JFrame {
	private CalendarEvent newEvent;
	private User loggedInUser;
	private int WIDTH;
	private int HEIGHT;
	private JLabel eventTitleLabel;
	private JLabel dateLabel;
	private JLabel reminderLabel;
	private JLabel descriptionLabel;
	private JLabel tagLabel;
	private JTextField eventTitleField;
	private JTextField dateDayField;
	private JTextField dateMonthField;
	private JTextField dateYearField;
	private JTextField reminderField;
	private JTextField tagField;
	private JTextArea descriptionField;
	private JButton linkButton;
	private JButton addButton;
	private JButton editButton;
	
	private String mode;
	
	private ArrayList<CalendarEvent> eventCollectionToAddTo;
	
	public AddCalendarEventFrame(User loggedIn) {
		this.loggedInUser = loggedIn;
		setTitle("Add CalendarEvent");
		setLayout(null);
		
		this.mode = "add";
		
		this.eventCollectionToAddTo = this.loggedInUser.getCalendarEvents();
		WIDTH = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		HEIGHT = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		WIDTH = WIDTH / 2;
		
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		
		initComponents();
		add(eventTitleLabel);
		add(eventTitleField);
		add(dateLabel);
		add(dateDayField);
		add(dateMonthField);
		add(dateYearField);
		add(reminderLabel);
		add(reminderField);
		add(descriptionLabel);
		add(descriptionField);
		add(tagLabel);
		add(tagField);
		add(linkButton);
		add(addButton);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initComponents() {
		eventTitleLabel = new JLabel("Name:");
		eventTitleField =new JTextField();
		
		dateLabel = new JLabel("Date:");
		dateDayField = new JTextField();
		dateMonthField = new JTextField();
		dateYearField = new JTextField();
		
		reminderLabel = new JLabel("Remind You?:");
		reminderField = new JTextField();
		
		descriptionLabel = new JLabel("Description:");
		descriptionField = new JTextArea();
		descriptionField.setLineWrap(true);
		descriptionField.setWrapStyleWord(true);
		
		tagLabel = new JLabel("Tag:");
		tagField = new JTextField();
		
		linkButton = new JButton("Link");
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					newEvent = new CalendarEvent();
					newEvent.setID(IDGenerator.getID());
					newEvent.setTitle(eventTitleField.getText());
					newEvent.setDate(Filter.getDate(dateMonthField.getText(), dateDayField.getText(), dateYearField.getText()));
					newEvent.setModified(true);
					newEvent.setDescription(descriptionField.getText());
					if (Filter.isEmerg(reminderField.getText())) {
						newEvent.setRemindMe(true);
					} else {
						newEvent.setRemindMe(false);
					}
					newEvent.setTag(tagField.getText());
					loggedInUser.newCalendarEvent(newEvent);
					dispose();
				} else {
					Error_Se error = new Error_Se(new JFrame("Error"), false);
				}
			}
		});
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
					newEvent.setTitle(eventTitleField.getText());
					newEvent.setDate(Filter.getDate(dateMonthField.getText(), dateDayField.getText(), dateYearField.getText()));
					newEvent.setModified(true);
					newEvent.setDescription(descriptionField.getText());
					if (Filter.isEmerg(reminderField.getText())) {
						newEvent.setRemindMe(true);
					} else {
						newEvent.setRemindMe(false);
					}
					newEvent.setTag(tagField.getText());
					loggedInUser.newCalendarEvent(newEvent);
					dispose();
				}
			}
		});
		
		setSizes();
	}
	
	private void setSizes() {
		eventTitleLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		eventTitleField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 5, (WIDTH / 100) * 80, 20);
		
		dateLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 20, (WIDTH / 100) * 20, 20);
		dateDayField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 20, (WIDTH / 100) * 15, 20);
		dateMonthField.setBounds((WIDTH / 100) * 40, (HEIGHT / 100) * 20, (WIDTH / 100) * 15, 20);
		dateYearField.setBounds((WIDTH / 100) * 60, (HEIGHT / 100) * 20, (WIDTH / 100) * 15, 20);
	
		reminderLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 30, (WIDTH / 100) * 20, 20);
		reminderField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 30, (WIDTH / 100) * 20, 20);
		
		descriptionLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 40, (WIDTH / 100) * 20, 20);
		descriptionField.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 45, (WIDTH / 100) * 85, (HEIGHT / 100) * 40);
		
		tagLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 90, (WIDTH / 100) * 10, 20);
		tagField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 90, (WIDTH / 100) * 10, 20);
		linkButton.setBounds((WIDTH / 100) * 45, (HEIGHT / 100) * 90, (WIDTH / 100) * 25, 20);
		addButton.setBounds((WIDTH / 100) * 75, (HEIGHT / 100) * 90, (WIDTH / 100) * 25, 20);
		editButton.setBounds(addButton.getBounds());
	}
	
	private void populateFields(CalendarEvent cal) {
		newEvent = cal;
		eventTitleField.setText(cal.getTitle());
		dateDayField.setText("" + cal.getDate().getDay());
		dateMonthField.setText("" + cal.getDate().getMonth());
		dateYearField.setText("" + cal.getDate().getYear());
		if (cal.getRemindMe()) {
			reminderField.setText("Yes");
		} else {
			reminderField.setText("No");
		}
		descriptionField.setText(cal.getDescription());
	}
	
	public void switchContext(String toBeSwitched) {
		if (toBeSwitched.equals("edit")) {
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
	
	public void editSelected(CalendarEvent cal) {
		if (mode.equals("edit")) {
			populateFields(cal);
			makeNotEditable(true);
		} else if (mode.equals("detail")) {
			populateFields(cal);
			makeNotEditable(false);
		}
	}
	
	private void makeNotEditable(boolean editNeeded) {
		if (!editNeeded) {
			eventTitleField.setEditable(false);
			dateDayField.setEditable(false);
			dateMonthField.setEditable(false);
			dateYearField.setEditable(false);
			reminderField.setEditable(false);
			descriptionField.setEditable(false);
		} else {
			eventTitleField.setEditable(true);
			dateDayField.setEditable(true);
			dateMonthField.setEditable(true);
			dateYearField.setEditable(true);
			reminderField.setEditable(true);
			descriptionField.setEditable(true);
		}
	}
	
	private boolean checkFields() {
		if (!eventTitleField.getText().equals("") && Filter.isNumOnly(dateDayField.getText()) && Filter.isNumOnly(dateMonthField.getText()) && Filter.isNumOnly(dateYearField.getText())) {
			return true;
		} else {
			return false;
		}
	}
}
