package gui;

import com.CalendarEvent;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;

public class AddCalendarEventFrame extends JFrame {
	private int WIDTH;
	private int HEIGHT;
	private JLabel eventTitleLabel;
	private JLabel dateLabel;
	private JLabel reminderLabel;
	private JLabel descriptionLabel;
	private JTextField eventTitleField;
	private JTextField dateDayField;
	private JTextField dateMonthField;
	private JTextField dateYearField;
	private JTextField reminderField;
	private JTextArea descriptionField;
	private JButton linkButton;
	private JButton addButton;
	private JButton editButton;
	
	private String mode;
	
	private ArrayList<CalendarEvent> eventCollectionToAddTo;
	
	public AddCalendarEventFrame(ArrayList<CalendarEvent> eventCollection) {
		setTitle("Add CalendarEvent");
		setLayout(null);
		
		this.mode = "add";
		
		this.eventCollectionToAddTo = eventCollection;
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
		add(linkButton);
		add(addButton);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		linkButton = new JButton("Link");
		addButton = new JButton("Add");
		editButton = new JButton("Edit");
		
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
		
		linkButton.setBounds((WIDTH / 100) * 45, (HEIGHT / 100) * 90, (WIDTH / 100) * 25, 20);
		addButton.setBounds((WIDTH / 100) * 75, (HEIGHT / 100) * 90, (WIDTH / 100) * 25, 20);
		editButton.setBounds(addButton.getBounds());
	}
	
	private void populateFields(CalendarEvent cal) {
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
	
	public static void main(String[] args) {
		AddCalendarEventFrame x = new AddCalendarEventFrame(new ArrayList<CalendarEvent>());
	}
}
