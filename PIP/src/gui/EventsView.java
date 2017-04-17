package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class EventsView extends JPanel {
	private JTextField eventSearch;
	private JScrollPane eventList;
	private JTextPane eventView;
	private JButton searchEvents;
	private JButton addEvent;
	private JButton deleteEvent;
	private JButton editEvent;
	private JButton detailedEvent;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public EventsView(Dimension d) {
		this.parentWindowSize = d;
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
		eventList = new JScrollPane();
		eventList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		eventView = new JTextPane();
		addEvent = new JButton("Add");
		deleteEvent = new JButton("Delete");
		editEvent = new JButton("Edit");
		detailedEvent = new JButton("Detailed");
		
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
