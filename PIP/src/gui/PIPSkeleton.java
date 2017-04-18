package gui;
import com.User;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Dimension;

public class PIPSkeleton extends JFrame {
	private User loggedInUser;
	private PIPSkeleton curr;
	private JTabbedPane views;
	private NewMainView home;
	private NotesView notes;
	private CoursesView courses;
	private ContactsView contacts;
	private EventsView events;
	private SearchView search;
	private Dimension d;
	
	public PIPSkeleton(User loggedInUser) {
		this.loggedInUser = loggedInUser;
		curr = this;
		this.d = (Toolkit.getDefaultToolkit().getScreenSize());
		setSize(d);
		setMinimumSize(new Dimension(775, 750));
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		views = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(views);
		views.setSize(views.getParent().getSize());
		
		initComponents();
		
		views.addTab("Home", home);
		views.addTab("Notes", notes);
		views.addTab("Courses", courses);
		views.addTab("Contacts", contacts);
		views.addTab("Events", events);
		views.addTab("Search", search);
		views.setVisible(true);
		
		//System.out.println(views.getSize().toString());
		addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				d = curr.getSize();
				views.setSize(d);
				home.resize(d);
				notes.resize(d);
				courses.resize(d);
				contacts.resize(d);
				events.resize(d);
				search.resize(d);
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void initComponents() {
		home = new NewMainView(loggedInUser, views.getSize());
		notes = new NotesView(loggedInUser, views.getSize());
		courses = new CoursesView(views.getSize());
		contacts = new ContactsView(views.getSize());
		events = new EventsView(views.getSize());
		search = new SearchView(views.getSize());
	}
}
