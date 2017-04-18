package gui;

import com.Note;
import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddNoteFrame extends JFrame {
	private int WIDTH;
	private int HEIGHT;
	private JLabel titleLabel;
	private JLabel bodyLabel;
	private JTextField titleField;
	private JTextArea bodyField;
	private JButton addButton;
	private JButton linkButton;
	private ArrayList<Note> collectionToAddTo;
	
	public AddNoteFrame(ArrayList<Note> noteCollection) {
		setTitle("Add Note");
		setLayout(null);
		
		this.collectionToAddTo = noteCollection;
		WIDTH = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		HEIGHT = (int) Math.ceil(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		WIDTH = WIDTH / 4;
		HEIGHT = HEIGHT / 2;
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		
		initComponents();
		add(titleLabel);
		add(bodyLabel);
		add(titleField);
		add(bodyField);
		add(addButton);
		add(linkButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		titleLabel = new JLabel("Title");
		bodyLabel = new JLabel("Body");
		titleField = new JTextField();
		bodyField = new JTextArea();
		bodyField.setLineWrap(true);
		bodyField.setWrapStyleWord(true);
		
		addButton = new JButton("Add");
		linkButton = new JButton("Link");
		
		setSizes();
	}
	
	private void setSizes() {
		titleLabel.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 10, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		titleField.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 10, (WIDTH / 100) * 70, (HEIGHT / 100) * 10);
		bodyLabel.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 20, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		bodyField.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 30, (WIDTH / 100) * 90, (HEIGHT / 100) * 55);
		linkButton.setBounds((WIDTH / 100) * 50, (HEIGHT / 100) * 90, (WIDTH / 100) * 20, 15);
		addButton.setBounds((WIDTH / 100) * 75, (HEIGHT / 100) * 90,  (WIDTH / 100) * 20, 15);
	}
	
	public static void main(String[] args) {
		AddNoteFrame x = new AddNoteFrame(new ArrayList<Note>());
	}
}
