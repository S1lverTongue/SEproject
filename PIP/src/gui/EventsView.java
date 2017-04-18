package gui;

import com.CalendarEvent;
import com.User;
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

public class EventsView extends JPanel {
	private User loggedInUser;
	private JTextField eventSearch;
	private JScrollPane eventList;
	private JTextPane eventView;
	private JButton searchEvents;
	private JButton addEvent;
	private JButton deleteEvent;
	private JButton editEvent;
	private JButton detailedEvent;
	private JList jListOfEvents;
	private DefaultListModel eventModel;
	private ListSelectionModel selectionModel;
	private Dimension parentWindowSize;
	private ArrayList<CalendarEvent> userEvents;
	private int WIDTH;
	private int HEIGHT;
	
	public EventsView(User loggedIn, Dimension d) {
		this.loggedInUser = loggedIn;
		this.parentWindowSize = d;
		this.userEvents = this.loggedInUser.getCalendarEvents();
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(eventSearch);
		add(searchEvents);
		add(eventList);
		add(addEvent);
		add(deleteEvent);
		add(editEvent);
		add(detailedEvent);
		add(eventView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		eventSearch = new JTextField();
		eventSearch.setText("Search");
		searchEvents = new JButton("Search");
		
		eventView = new JTextPane();
		
		jListOfEvents = new JList();
		eventModel = new DefaultListModel();
		for (int i = 0; i < userEvents.size(); i++) {
			eventModel.add(i, userEvents.get(i).getTitle());
		}
		jListOfEvents.setModel(eventModel);
		selectionModel = jListOfEvents.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (jListOfEvents.getSelectedIndex() != -1)
					eventView.setText(loggedInUser.getCalendarEvents().get(jListOfEvents.getSelectedIndex()).toString());
				else
					eventView.setText("");
			}
		});
		jListOfEvents.setVisible(true);
		eventList = new JScrollPane(jListOfEvents);
		eventList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		addEvent = new JButton("Add");
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eventListLength = loggedInUser.getCalendarEvents().size();
				AddCalendarEventFrame newCalEventFrame = new AddCalendarEventFrame(loggedInUser);
				newCalEventFrame.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						if (loggedInUser.getCalendarEvents().size() > eventListLength) {
							eventModel.add(eventListLength, loggedInUser.getCalendarEvents().get(eventListLength).getTitle());
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
		deleteEvent = new JButton("Delete");
		deleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfEvents.getSelectedIndex() != -1) {
					loggedInUser.deleteCalendarEvent(loggedInUser.getCalendarEvents().get(jListOfEvents.getSelectedIndex()).getID());
					eventModel.remove(jListOfEvents.getSelectedIndex());
				}
			}
		});
		editEvent = new JButton("Edit");
		editEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfEvents.getSelectedIndex() != -1) {
					EditCalendarEventFrame editCalEventFrame = new EditCalendarEventFrame(loggedInUser, loggedInUser.getCalendarEvents().get(jListOfEvents.getSelectedIndex()));
				}
			}
		});
		detailedEvent = new JButton("Detailed");
		detailedEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfEvents.getSelectedIndex() != -1) {
					DetailCalendarEventFrame detailCalFrame = new DetailCalendarEventFrame(loggedInUser, loggedInUser.getCalendarEvents().get(jListOfEvents.getSelectedIndex()));
				}
			}
		});
		
		setSizes();
	}
	
	public void setSizes() {
		eventSearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchEvents.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
		eventList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		eventView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addEvent.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteEvent.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editEvent.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedEvent.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
