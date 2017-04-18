package gui;

import com.Assignment;
import com.User;
import com.Course;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AssignmentView extends JPanel {
	private Course cor;
	private User loggedInUser;
	private JTextField assignmentSearch;
	private JScrollPane contactList;
	private JTextPane assignmentView;
	private JButton searchAssignments;
	private JButton addAssignment;
	private JButton deleteAssignment;
	private JButton editAssignment;
	private JButton detailedAssignment;
	private JList jListOfAssignments;
	private DefaultListModel assignmentModel;
	private ListSelectionModel selectionModel;
	private ArrayList<Assignment> courseAssignments;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public AssignmentView(User loggedIn, Course cor, Dimension d) {
		this.cor =cor;
		this.loggedInUser = loggedIn;
		this.courseAssignments = cor.getAssignments();
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(searchAssignments);
		add(assignmentSearch);
		add(contactList);
		add(addAssignment);
		add(deleteAssignment);
		add(editAssignment);
		add(detailedAssignment);
		add(assignmentView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		assignmentSearch = new JTextField();
		assignmentSearch.setText("Search");
		searchAssignments = new JButton("Search");
		
		jListOfAssignments = new JList();
		assignmentModel = new DefaultListModel();
		for (int i = 0; i < courseAssignments.size(); i++) {
			assignmentModel.add(i, courseAssignments.get(i).getTitle());
		}
		jListOfAssignments.setModel(assignmentModel);
		selectionModel = jListOfAssignments.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (jListOfAssignments.getSelectedIndex() != -1) 
					assignmentView.setText(courseAssignments.get(jListOfAssignments.getSelectedIndex()).toString());
				else 
					assignmentView.setText("");
			}
		});
		jListOfAssignments.setVisible(true);
		
		contactList = new JScrollPane(jListOfAssignments);
		contactList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		assignmentView = new JTextPane();
		
		addAssignment = new JButton("Add");
		addAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int assignmentListLength = courseAssignments.size();
				AddAssignmentFrame newAssignmentFrame = new AddAssignmentFrame(loggedInUser, cor, courseAssignments);
				newAssignmentFrame.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent e) {}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						if (courseAssignments.size() > assignmentListLength) {
							assignmentModel.add(assignmentListLength, courseAssignments.get(assignmentListLength).getTitle());
						}
					}

					@Override
					public void windowClosing(WindowEvent e) {}

					@Override
					public void windowDeactivated(WindowEvent e) {}

					@Override
					public void windowDeiconified(WindowEvent e) {}

					@Override
					public void windowIconified(WindowEvent e) {}

					@Override
					public void windowOpened(WindowEvent e) {}
					
				});
			}
		});
		
		deleteAssignment = new JButton("Delete");
		deleteAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfAssignments.getSelectedIndex() != -1) {
					cor.removeAssignment(courseAssignments.get(jListOfAssignments.getSelectedIndex()));
					assignmentModel.remove(jListOfAssignments.getSelectedIndex());
				}
			}
		});
		editAssignment = new JButton("Edit");
		editAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfAssignments.getSelectedIndex() != -1) {
					EditAssignmentFrame editContactFrame = new EditAssignmentFrame(loggedInUser, cor, courseAssignments, courseAssignments.get(jListOfAssignments.getSelectedIndex()));
				}
			}
		});
		detailedAssignment = new JButton("Detailed");
		detailedAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfAssignments.getSelectedIndex() != -1) {
					DetailAssignmentFrame detailedContactView = new DetailAssignmentFrame(loggedInUser, cor, courseAssignments, courseAssignments.get(jListOfAssignments.getSelectedIndex()));
				}
			}
		});
		
		setSizes();
	}
	
	public void setSizes() {
		assignmentSearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchAssignments.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
		contactList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		assignmentView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addAssignment.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteAssignment.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editAssignment.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedAssignment.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}