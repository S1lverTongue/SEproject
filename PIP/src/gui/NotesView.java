package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class NotesView extends JPanel {
	private JTextField noteSearch;
	private JScrollPane noteList;
	private JTextPane noteView;
	private JButton searchNotes;
	private JButton addNote;
	private JButton deleteNote;
	private JButton editNote;
	private JButton detailedNote;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public NotesView(Dimension d) {
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(noteSearch);
		add(searchNotes);
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
		
		noteSearch = new JTextField();
		noteSearch.setText("Search");
		searchNotes = new JButton("Search");
		noteList = new JScrollPane();
		noteList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		noteView = new JTextPane();
		addNote = new JButton("Add");
		deleteNote = new JButton("Delete");
		editNote = new JButton("Edit");
		detailedNote = new JButton("Detailed");
		
		setSizes();
	}
	
	public void setSizes() {
		noteSearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchNotes.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
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
