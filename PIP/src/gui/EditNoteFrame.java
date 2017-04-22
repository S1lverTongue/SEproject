// Coded by Trent May
package gui;

import com.User;
import com.Note;

import util.IDGenerator;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditNoteFrame extends JFrame {
	private User loggedInUser;
	private int WIDTH;
	private int HEIGHT;
	private JLabel titleLabel;
	private JLabel bodyLabel;
	private JLabel tagLabel;
	private JTextField titleField;
	private JTextField tagField;
	private JTextArea bodyField;
	private JButton editButton;
	private JButton linkButton;
	private Note toBeEdited;
	
	public EditNoteFrame(User loggedIn, Note toBeEdited) {
		this.loggedInUser = loggedIn;
		setTitle(toBeEdited.getTitle() + " Edit");
		setLayout(null);
		
		this.toBeEdited = toBeEdited;
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
		add(tagLabel);
		add(tagField);
		add(bodyField);
		add(editButton);
		add(linkButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void initComponents() {
		titleLabel = new JLabel("Title");
		bodyLabel = new JLabel("Body");
		
		titleField = new JTextField();
		titleField.setText(toBeEdited.getTitle());
		
		bodyField = new JTextArea();
		bodyField.setLineWrap(true);
		bodyField.setWrapStyleWord(true);
		bodyField.setText(toBeEdited.getBody());
		
		tagLabel = new JLabel("Tag:");
		tagField = new JTextField();
		tagField.setText(toBeEdited.getTag());
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBeEdited.setBody(bodyField.getText());
				toBeEdited.setModified(true);
				toBeEdited.setTitle(titleField.getText());
				toBeEdited.setVisible(true);
				toBeEdited.setTag(tagField.getText());
				loggedInUser.newNote(toBeEdited);
				dispose();
			}
		});
		linkButton = new JButton("Link");
		
		setSizes();
	}
	
	private void setSizes() {
		titleLabel.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 10, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		titleField.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 10, (WIDTH / 100) * 70, (HEIGHT / 100) * 10);
		bodyLabel.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 20, (WIDTH / 100) * 20, (HEIGHT / 100) * 10);
		bodyField.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 30, (WIDTH / 100) * 90, (HEIGHT / 100) * 55);
		tagLabel.setBounds((WIDTH / 100) * 10, (HEIGHT / 100) * 90, (WIDTH / 100) * 20, 15);
		tagField.setBounds((WIDTH / 100) * 20, (HEIGHT / 100) * 90, (WIDTH / 100) * 20, 15);
		linkButton.setBounds((WIDTH / 100) * 50, (HEIGHT / 100) * 90, (WIDTH / 100) * 20, 15);
		editButton.setBounds((WIDTH / 100) * 75, (HEIGHT / 100) * 90,  (WIDTH / 100) * 20, 15);
	}
	
	protected void setEditable(boolean editable) {
		editButton.setVisible(editable);
		linkButton.setVisible(editable);
		titleField.setEditable(editable);
		bodyField.setEditable(editable);
		tagField.setEditable(editable);
	}
}