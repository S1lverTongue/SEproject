package gui;

import com.Contact;
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

public class ContactsView extends JPanel {
	private User loggedInUser;
	private JTextField contactSearch;
	private JScrollPane contactList;
	private JTextPane contactView;
	private JButton searchContacts;
	private JButton addContact;
	private JButton deleteContact;
	private JButton editContact;
	private JButton detailedContact;
	private JList jListOfContacts;
	private DefaultListModel contactModel;
	private ListSelectionModel selectionModel;
	private Dimension parentWindowSize;
	private ArrayList<Contact> userContacts;
	private int WIDTH;
	private int HEIGHT;
	
	public ContactsView(User loggedIn, Dimension d) {
		this.loggedInUser = loggedIn;
		this.parentWindowSize = d;
		this.userContacts = this.loggedInUser.getContacts();
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
		
		jListOfContacts = new JList();
		contactModel = new DefaultListModel();
		for (int i = 0; i < userContacts.size(); i++) {
			contactModel.add(i, userContacts.get(i).getFirstName() + " " + userContacts.get(i).getLastName());
		}
		jListOfContacts.setModel(contactModel);
		selectionModel = jListOfContacts.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (jListOfContacts.getSelectedIndex() != -1) 
					contactView.setText(loggedInUser.getContacts().get(jListOfContacts.getSelectedIndex()).toString());
				else 
					contactView.setText("");
			}
		});
		jListOfContacts.setVisible(true);
		
		contactList = new JScrollPane(jListOfContacts);
		contactList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contactView = new JTextPane();
		
		addContact = new JButton("Add");
		addContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contactListLength = loggedInUser.getContacts().size();
				AddContactFrame newContactFrame = new AddContactFrame(loggedInUser);
				newContactFrame.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent e) {}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						if (loggedInUser.getContacts().size() > contactListLength) {
							contactModel.add(contactListLength, loggedInUser.getContacts().get(contactListLength).getFirstName() + " " + loggedInUser.getContacts().get(contactListLength).getLastName());
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
		
		deleteContact = new JButton("Delete");
		deleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfContacts.getSelectedIndex() != -1) {
					loggedInUser.deleteContact(loggedInUser.getNotes().get(jListOfContacts.getSelectedIndex()).getID());
					contactModel.remove(jListOfContacts.getSelectedIndex());
				}
			}
		});
		editContact = new JButton("Edit");
		editContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfContacts.getSelectedIndex() != -1) {
					EditContactFrame editContactFrame = new EditContactFrame(loggedInUser, loggedInUser.getContacts().get(jListOfContacts.getSelectedIndex()));
				}
			}
		});
		detailedContact = new JButton("Detailed");
		detailedContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfContacts.getSelectedIndex() != -1) {
					DetailContactFrame detailedContactView = new DetailContactFrame(loggedInUser, loggedInUser.getContacts().get(jListOfContacts.getSelectedIndex()));
				}
			}
		});
		
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
