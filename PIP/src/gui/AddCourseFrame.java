package gui;

import com.Course;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class AddCourseFrame extends JFrame {
	private int WIDTH;
	private int HEIGHT;
	private JLabel titleLabel;
	private JLabel skipsLabel;
	private JTextField titleField;
	private JTextField skipsField;
	private JButton addButton;
	private JButton linkButton;
	private JButton editButton;
	
	private String mode;
	
	private ArrayList<Course> collectionToAddTo;
	
	public AddCourseFrame(ArrayList<Course> courseCollection) {
		setTitle("Add Course");
		setLayout(null);
		
		this.mode = "add";
		
		this.collectionToAddTo = courseCollection;
		WIDTH = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		HEIGHT = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		WIDTH = WIDTH / 4;
		HEIGHT = HEIGHT / 2;
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		
		initComponents();
		add(titleLabel);
		add(titleField);
		add(skipsLabel);
		add(skipsField);
		add(addButton);
		add(linkButton);
		add(editButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		titleLabel = new JLabel("Title:");
		titleField = new JTextField();
		
		skipsLabel = new JLabel("Skips Allowed:");
		skipsField = new JTextField();
		
		addButton = new JButton("Add");
		linkButton = new JButton("Link");
		editButton = new JButton("Edit");
		setSizes();
	}
	
	public void setSizes() {
		titleLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 25, 20);
		titleField.setBounds((WIDTH / 100) * 35, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		
		skipsLabel.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 15, (WIDTH / 100) * 30, 20);
		skipsField.setBounds((WIDTH / 100) * 35, (HEIGHT / 100) * 15, (WIDTH / 100) * 20, 20);
		
		addButton.setBounds((WIDTH / 100) * 85, (HEIGHT / 100) * 85, (WIDTH / 100) * 20,  20);
		linkButton.setBounds((WIDTH / 100) * 60, (HEIGHT / 100) * 85, (WIDTH / 100) * 20, 20);
		editButton.setBounds(addButton.getBounds());
	}
	
	private void populateFields(Course c) {
		titleField.setText(c.getTitle());
		skipsField.setText("" + c.getSkipTotal());
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
	
	public void editSelected(Course c) {
		if (mode.equals("edit")) {
			populateFields(c);
			makeNotEditable(true);
		} else if (mode.equals("detail")) {
			populateFields(c);
			makeNotEditable(false);
		}
	}
	
	private void makeNotEditable(boolean editNeeded) {
		if (!editNeeded) {
			titleField.setEditable(false);
			skipsField.setEditable(false);
		} else {
			titleField.setEditable(true);
			skipsField.setEditable(true);
		}
	}
	
	public static void main(String[] args) {
		AddCourseFrame x = new AddCourseFrame(new ArrayList<Course>());
	}
}
