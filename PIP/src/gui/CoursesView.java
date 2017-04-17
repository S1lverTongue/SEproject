package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class CoursesView extends JPanel {
	private JTextField coursesSearch;
	private JScrollPane courseList;
	private JTextPane courseView;
	private JButton searchCourses;
	private JButton addCourse;
	private JButton deleteCourse;
	private JButton editCourse;
	private JButton detailedCourse;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public CoursesView(Dimension d) {
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(coursesSearch);
		add(searchCourses);
		add(courseList);
		add(addCourse);
		add(deleteCourse);
		add(editCourse);
		add(detailedCourse);
		add(courseView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		coursesSearch = new JTextField();
		coursesSearch.setText("Search");
		searchCourses = new JButton("Search");
		courseList = new JScrollPane();
		courseList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		courseView = new JTextPane();
		addCourse = new JButton("Add");
		deleteCourse = new JButton("Delete");
		editCourse = new JButton("Edit");
		detailedCourse = new JButton("Detailed");
		
		setSizes();
	}
	
	public void setSizes() {
		coursesSearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchCourses.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
		courseList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		courseView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addCourse.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteCourse.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editCourse.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedCourse.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
