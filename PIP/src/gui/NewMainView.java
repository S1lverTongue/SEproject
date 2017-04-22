// Coded by Trent May
package gui;

import com.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ToolTipManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;

public class NewMainView extends JPanel {
	private JScrollPane upcomingAssignments;
	private JTextPane componentView;
	private JScrollPane detailView;
	private JButton skip;
	private Dimension parentWindowSize;
	private ListSelectionModel assignmentModel;
	private User loggedInUser;
	private int WIDTH;
	private int HEIGHT;
	
	public NewMainView(User loggedIn, Dimension d) {
		this.parentWindowSize = d;
		this.loggedInUser = loggedIn;
		this.loggedInUser.onLogin();
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		initComponents();
		add(upcomingAssignments);
		add(componentView);
		add(detailView);
		add(skip);
		setVisible(true);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		JList assignmentList = new JList();
		ArrayList<Assignment> allAssignments = new ArrayList<Assignment>();
		DefaultListModel dlm = new DefaultListModel();
		for (int i = 0; i < loggedInUser.getCourses().size(); i++) {
			Course curr = loggedInUser.getCourses().get(i);
			if (curr.getAssignments() != null) {
				for (int assignmentIndex = 0; assignmentIndex < curr.getAssignments().size(); assignmentIndex++) {
					dlm.addElement(curr.getAssignments().get(assignmentIndex).getTitle());
					allAssignments.add(curr.getAssignments().get(assignmentIndex));
				}
			}
			
		}
		assignmentList.setModel(dlm);
		assignmentModel = assignmentList.getSelectionModel();
		assignmentModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (assignmentList.getSelectedIndex() != -1)
					componentView.setText(allAssignments.get(assignmentList.getSelectedIndex()).toString());
				else
					componentView.setText("");
			}
			
		});
		assignmentList.setVisible(true);
		upcomingAssignments = new JScrollPane(assignmentList);
		
		componentView = new JTextPane();
		componentView.setEditable(false);
		
		detailView = new JScrollPane();
		detailView.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		detailView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		skip = new JButton();
		skip.setText("SKIP CLASS");
		setSizes();
	}
	
	public void setSizes() {
		upcomingAssignments.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 40, (HEIGHT / 100) * 50);
		componentView.setBounds((WIDTH / 100) * 60, (HEIGHT / 100) * 5, (WIDTH / 100) * 40, (HEIGHT / 100) * 90);
		detailView.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 60, (WIDTH / 100) * 40, (HEIGHT / 100) * 20);
		skip.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 40, (HEIGHT / 100) * 10);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
