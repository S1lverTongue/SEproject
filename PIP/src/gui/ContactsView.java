package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class ContactsView extends JPanel {
	private JTextField contactSearch;
	private JScrollPane contactList;
	private JTextPane contactView;
	private JButton searchContacts;
	private JButton addContact;
	private JButton deleteContact;
	private JButton editContact;
	private JButton detailedContact;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public ContactsView(Dimension d) {
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(contactSearch);
		add(searchContacts);
		add(contactList);
		add(addContact);
		add(deleteContact);
		add(editContact);
		add(detailedContact);
		add(contactView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		contactSearch = new JTextField();
		contactSearch.setText("Search");
		searchContacts = new JButton("Search");
		contactList = new JScrollPane();
		contactList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contactView = new JTextPane();
		addContact = new JButton("Add");
		deleteContact = new JButton("Delete");
		editContact = new JButton("Edit");
		detailedContact = new JButton("Detailed");
		
		setSizes();
	}
	
	public void setSizes() {
		contactSearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchContacts.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
		contactList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		contactView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addContact.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteContact.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editContact.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedContact.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
