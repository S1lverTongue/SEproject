package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class SearchView extends JPanel {
	private JTextField entitySearch;
	private JScrollPane entityList;
	private JTextPane entityView;
	private JButton searchEntity;
	private JButton addEntity;
	private JButton deleteEntity;
	private JButton editEntity;
	private JButton detailedEntity;
	private Dimension parentWindowSize;
	private int WIDTH;
	private int HEIGHT;
	
	public SearchView(Dimension d) {
		this.parentWindowSize = d;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		initComponents();
		add(entitySearch);
		add(searchEntity);
		add(entityList);
		add(addEntity);
		add(deleteEntity);
		add(editEntity);
		add(detailedEntity);
		add(entityView);
	}
	
	public void initComponents() {
		WIDTH = (int) Math.ceil(parentWindowSize.getWidth());
		HEIGHT = (int) Math.ceil(parentWindowSize.getHeight());
		
		entitySearch = new JTextField();
		entitySearch.setText("Search");
		searchEntity = new JButton("Search");
		entityList = new JScrollPane();
		entityList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		entityView = new JTextPane();
		addEntity = new JButton("Add");
		deleteEntity = new JButton("Delete");
		editEntity = new JButton("Edit");
		detailedEntity = new JButton("Detailed");
		
		setSizes();
	}
	
	public void setSizes() {
		entitySearch.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 5, (WIDTH / 100) * 20, 20);
		searchEntity.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 5, (WIDTH / 100) * 15, 20);
		entityList.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		entityView.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 10, (WIDTH / 100) * 40, (HEIGHT / 100) * 70);
		addEntity.setBounds((WIDTH / 100) * 5, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		deleteEntity.setBounds((WIDTH / 100) * 30, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		editEntity.setBounds((WIDTH / 100) * 55, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
		detailedEntity.setBounds((WIDTH / 100) * 80, (HEIGHT / 100) * 85, (WIDTH / 100) * 15, 25);
	}
	
	public void resize(Dimension d) {
		WIDTH = (int) Math.ceil(d.getWidth());
		HEIGHT = (int) Math.ceil(d.getHeight());
		setSizes();
	}
}
