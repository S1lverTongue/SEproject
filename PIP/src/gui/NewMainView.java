package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class NewMainView extends JPanel {
	private JScrollPane upcomingAssignments;
	private JTextPane componentView;
	private JScrollPane detailView;
	private JButton skip;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public NewMainView(Dimension d) {
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(upcomingAssignments);
		add(componentView);
		add(detailView);
		add(skip);
		setVisible(true);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		upcomingAssignments = new JScrollPane();
		
		componentView = new JTextPane();
		
		detailView = new JScrollPane();
		detailView.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		detailView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		skip = new JButton();
		skip.setText("SKIP CLASS");
		setSizes();
	}
	
	public void setSizes() {
		upcomingAssignments.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 40, (HEIGHT / 100) * 50);
		componentView.setBounds((WIDTH / 100) * 60, (HEIGHT / 100) * 5, (WIDTH / 100) * 40, (HEIGHT / 100) * 90);
		detailView.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 60, (WIDTH / 100) * 40, (HEIGHT / 100) * 20);
		skip.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 40, (HEIGHT / 100) * 10);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
