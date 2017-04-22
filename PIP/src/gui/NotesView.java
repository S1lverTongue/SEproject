// Coded by Trent May
package gui;

import com.User;
import com.Note;
import java.util.ArrayList;
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

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NotesView extends JPanel {
	private User loggedInUser;
	private JScrollPane noteList;
	private JTextPane noteView;
	private JButton addNote;
	private JButton deleteNote;
	private JButton editNote;
	private JButton detailedNote;
	private JList jListOfNotes;
	private DefaultListModel noteModel;
	private ListSelectionModel selectionModel;
	private Dimension parentWindowSize;
	private ArrayList<Note> userNotes;
	private int WIDTH;
	private int HEIGHT;
	
	public NotesView(User loggedIn, Dimension d) {
		this.parentWindowSize = d;
		this.loggedInUser = loggedIn;
		this.userNotes = this.loggedInUser.getNotes();
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(noteList);
		add(addNote);
		add(deleteNote);
		add(editNote);
		add(detailedNote);
		add(noteView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		noteView = new JTextPane();
		noteView.setEditable(false);
		
		jListOfNotes = new JList();
		noteModel = new DefaultListModel();
		for (int i = 0; i < userNotes.size(); i++) {
			noteModel.add(i, userNotes.get(i).getTitle());
		}
		jListOfNotes.setModel(noteModel);
		selectionModel = jListOfNotes.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (jListOfNotes.getSelectedIndex() != -1)
					noteView.setText(loggedInUser.getNotes().get(jListOfNotes.getSelectedIndex()).toString());
				else
					noteView.setText("");
			}
			
		});
		jListOfNotes.setVisible(true);
		noteList = new JScrollPane(jListOfNotes);
		noteList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		addNote = new JButton("Add");
		addNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int noteListLength = loggedInUser.getNotes().size();
				AddNoteFrame newNoteFrame = new AddNoteFrame(loggedInUser);
				newNoteFrame.addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent arg0) {}

					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						if (loggedInUser.getNotes().size() > noteListLength) {
							noteModel.add(noteListLength, loggedInUser.getNotes().get(noteListLength).getTitle());
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
		
		deleteNote = new JButton("Delete");
		deleteNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfNotes.getSelectedIndex() != -1) {
					loggedInUser.deleteNote(loggedInUser.getNotes().get(jListOfNotes.getSelectedIndex()).getID());
					noteModel.remove(jListOfNotes.getSelectedIndex());
				}
			}
		});
		editNote = new JButton("Edit");
		editNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfNotes.getSelectedIndex() != -1) {
					EditNoteFrame editFrame = new EditNoteFrame(loggedInUser, loggedInUser.getNotes().get(jListOfNotes.getSelectedIndex()));
					editFrame.addWindowListener(new WindowListener() {

						@Override
						public void windowActivated(WindowEvent arg0) {}

						@Override
						public void windowClosed(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
							
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
						public void windowOpened(WindowEvent arg0){}
						
					});
				}
			}
		});
		detailedNote = new JButton("Detailed");
		detailedNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListOfNotes.getSelectedIndex() != -1) {
					DetailedNoteFrame detailedNoteView = new DetailedNoteFrame(loggedInUser, loggedInUser.getNotes().get(jListOfNotes.getSelectedIndex()));
				}
			}
		});
		
		setSizes();
	}
	
	public void setSizes() {
		noteList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		noteView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addNote.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteNote.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editNote.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedNote.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
	
}
