package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotesView extends JPanel {
	private JTextField noteSearch;
	private JTextField noteView;
	public NotesView() {
		setLayout(null);
		
		noteSearch = new JTextField();
		noteSearch.setBounds(10, 11, 120, 20);
		add(noteSearch);
		noteSearch.setColumns(10);
		
		JScrollPane noteList = new JScrollPane();
		noteList.setBounds(10, 46, 200, 203);
		add(noteList);
		
		JButton addNote = new JButton("Add");
		addNote.setBounds(10, 266, 89, 23);
		add(addNote);
		
		JButton deleteNote = new JButton("Delete");
		deleteNote.setBounds(121, 266, 89, 23);
		add(deleteNote);
		
		noteView = new JTextField();
		noteView.setBounds(240, 46, 200, 203);
		add(noteView);
		noteView.setColumns(10);
		
		JButton editNote = new JButton("Edit");
		editNote.setBounds(250, 266, 89, 23);
		add(editNote);
		
		JButton detailedNote = new JButton("Detailed");
		detailedNote.setBounds(351, 266, 89, 23);
		add(detailedNote);
	}
}
