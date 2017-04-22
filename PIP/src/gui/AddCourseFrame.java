// Coded by Trent May
package gui;

import com.User;

import util.Filter;
import util.IDGenerator;

import com.Course;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class AddCourseFrame extends JFrame {
	private Course cor;
	private User loggedInUser;
	private int WIDTH;
	private int HEIGHT;
	private JLabel titleLabel;
	private JLabel skipsLabel;
	private JLabel tagLabel;
	private JTextField titleField;
	private JTextField skipsField;
	private JTextField tagField;
	private JButton addButton;
	private JButton linkButton;
	private JButton editButton;
	
	private String mode;
	
	private ArrayList<Course> collectionToAddTo;
	
	public AddCourseFrame(User loggedIn) {
		this.loggedInUser = loggedIn;
		setTitle("Add Course");
		setLayout(null);
		
		this.mode = "add";
		
		this.collectionToAddTo = this.loggedInUser.getCourses();
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
		add(tagLabel);
		add(tagField);
		add(addButton);
		add(linkButton);
		add(editButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		titleLabel = new JLabel("Title:");
		titleField = new JTextField();
		
		skipsLabel = new JLabel("Skips Allowed:");
		skipsField = new JTextField();
		
		tagLabel = new JLabel("Tag:");
		tagField = new JTextField();
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor = new Course();
				cor.setID(IDGenerator.getID());
				cor.setTitle(titleField.getText());
				if (Filter.isNumOnly(skipsField.getText())) {
					cor.setSkipTotal(Integer.parseInt(skipsField.getText()));
				}
				cor.setTag(tagField.getText());
				loggedInUser.newCourse(cor);
				dispose();
			}
		});
		linkButton = new JButton("Link");
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cor.setTitle(titleField.getText());
				if (Filter.isNumOnly(skipsField.getText())) {
					cor.setSkipTotal(Integer.parseInt(skipsField.getText()));
				}
				cor.setTag(tagField.getText());
				loggedInUser.newCourse(cor);
				dispose();
			}
		});
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
		tagField.setText(c.getTag());
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
		cor = c;
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
			tagField.setEditable(false);
		} else {
			titleField.setEditable(true);
			skipsField.setEditable(true);
			tagField.setEditable(true);
		}
	}
}
