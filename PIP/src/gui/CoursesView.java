package gui;

import com.Course;
import com.User;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CoursesView extends JPanel {
	private User loggedInUser;
	private JTextField coursesSearch;
	private JScrollPane courseList;
	private JTextPane courseView;
	private JButton searchCourses;
	private JButton addCourse;
	private JButton deleteCourse;
	private JButton editCourse;
	private JButton detailedCourse;
	private JButton viewAssignments;
	private JList jListOfCourses;
	private DefaultListModel courseModel;
	private ListSelectionModel selectionModel;
	private ArrayList<Course> userCourses;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public CoursesView(User loggedIn, Dimension d) {
		this.loggedInUser = loggedIn;
		this.parentWindowSize = d;
		this.userCourses = this.loggedInUser.getCourses();
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(coursesSearch);
		add(searchCourses);
		add(courseList);
		add(addCourse);
		add(deleteCourse);
		add(editCourse);
		add(viewAssignments);
		add(detailedCourse);
		add(courseView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		coursesSearch = new JTextField();
		coursesSearch.setText("Search");
		searchCourses = new JButton("Search");
		
		courseView = new JTextPane();
		
		jListOfCourses = new JList();
		courseModel = new DefaultListModel();
		for (int i = 0; i < userCourses.size(); i++) {
			courseModel.add(i, userCourses.get(i).getTitle());
		}
		jListOfCourses.setModel(courseModel);
		selectionModel = jListOfCourses.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (jListOfCourses.getSelectedIndex() != -1)
					courseView.setText(loggedInUser.getCourses().get(jListOfCourses.getSelectedIndex()).toString());
				else
					courseView.setText("");
			}
		});
		jListOfCourses.setVisible(true);
		courseList = new JScrollPane(jListOfCourses);
		courseList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		addCourse = new JButton("Add");
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int courseListLength = loggedInUser.getCourses().size();
				AddCourseFrame newCourseFrame = new AddCourseFrame(loggedInUser);
				newCourseFrame.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent arg0) {}

					@Override
					public void windowClosed(WindowEvent arg0) {
						if (loggedInUser.getCourses().size() > courseListLength) {
							courseModel.add(courseListLength, loggedInUser.getCourses().get(courseListLength).getTitle());
						}
					}

					@Override
					public void windowClosing(WindowEvent arg0) {}

					@Override
					public void windowDeactivated(WindowEvent arg0) {}

					@Override
					public void windowDeiconified(WindowEvent arg0) {}

					@Override
					public void windowIconified(WindowEvent arg0) {}

					@Override
					public void windowOpened(WindowEvent arg0) {}
					
				});
			}
		});
		deleteCourse = new JButton("Delete");
		deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfCourses.getSelectedIndex() != -1) {
					loggedInUser.deleteCourse(loggedInUser.getCourses().get(jListOfCourses.getSelectedIndex()).getID());
					courseModel.remove(jListOfCourses.getSelectedIndex());
				}
			}
		});
		editCourse = new JButton("Edit");
		editCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourseFrame editCourseFrame = new EditCourseFrame(loggedInUser, loggedInUser.getCourses().get(jListOfCourses.getSelectedIndex()));
				
			}
		});
		detailedCourse = new JButton("Detailed");
		detailedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfCourses.getSelectedIndex() != -1) {
					DetailCourseFrame detailCourseFrame = new DetailCourseFrame(loggedInUser, loggedInUser.getCourses().get(jListOfCourses.getSelectedIndex()));
				}
			}
		});
		viewAssignments = new JButton("Assign");
		viewAssignments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfCourses.getSelectedIndex() != -1) {
				JFrame assignmentFrame = new JFrame();
				assignmentFrame.setSize((int) Math.ceil(parentWindowSize.getWidth()), (int) Math.ceil(parentWindowSize.getHeight()));
				assignmentFrame.add(new AssignmentView(loggedInUser, loggedInUser.getCourses().get(jListOfCourses.getSelectedIndex()), parentWindowSize));	
				assignmentFrame.setVisible(true);
				assignmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
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
		viewAssignments.setBounds((WIDTH / 100) * 65, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedCourse.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
