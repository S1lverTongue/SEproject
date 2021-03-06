// Coded by Trent May
package gui;

import com.PIPEntity;
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
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SearchView extends JPanel {
	private User loggedInUser;
	private JTextField entitySearch;
	private JScrollPane entityList;
	private JTextPane entityView;
	private JButton searchEntity;
	private JButton addEntity;
	private JButton deleteEntity;
	private JButton editEntity;
	private JButton detailedEntity;
	private JList jListOfPIPEntities;
	private DefaultListModel PIPEntityModel;
	private ListSelectionModel selectionModel;
	private Dimension parentWindowSize;
	private ArrayList<PIPEntity> results;
	private int WIDTH;
	private int HEIGHT;
	
	public SearchView(User loggedIn, Dimension d) {
		this.loggedInUser = loggedIn;
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
		results = new ArrayList<PIPEntity>();
		entitySearch = new JTextField();
		entitySearch.setText("Search");
		searchEntity = new JButton("Search");
		
		jListOfPIPEntities = new JList();
		PIPEntityModel = new DefaultListModel();
		for (int i = 0; i < results.size(); i++) {
			PIPEntityModel.add(i, results.get(i).getTitle());
		}
		jListOfPIPEntities.setModel(PIPEntityModel);
		selectionModel = jListOfPIPEntities.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (jListOfPIPEntities.getSelectedIndex() != -1) {
					entityView.setText(results.get(jListOfPIPEntities.getSelectedIndex()).toString());
				} else {
					entityView.setText("");
				}
			}
		});
		searchEntity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results = loggedInUser.searchByTitle((entitySearch.getText()));
				PIPEntityModel.removeAllElements();
				for (int i = 0; i < results.size(); i++) {
					PIPEntityModel.add(i, results.get(i).getTitle());
				}
			}
		});
		
		jListOfPIPEntities.setVisible(true);
		entityList = new JScrollPane(jListOfPIPEntities);
		entityList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		entityView = new JTextPane();
		entityView.setEditable(false);
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
