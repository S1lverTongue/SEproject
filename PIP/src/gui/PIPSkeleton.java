package gui;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Dimension;

public class PIPSkeleton extends JFrame {
	private PIPSkeleton curr;
	private JTabbedPane views;
	private NewMainView home;
	private Dimension d;
	public PIPSkeleton() {
		curr = this;
		this.d = (Toolkit.getDefaultToolkit().getScreenSize());
		setSize(d);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		views = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(views);
		views.setSize(views.getParent().getSize());
		
		initComponents();
		
		views.addTab("Home", home);
		//views.addTab("Notes", null);
		//views.addTab("Courses", null);
		//views.addTab("Contacts", null);
		//views.addTab("Events", null);
		//views.addTab("Search", null);
		views.setVisible(true);
		
		//System.out.println(views.getSize().toString());
		addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				d = curr.getSize();
				System.out.println("Width: " + d.getWidth() + " :: Height: " + d.getHeight());
				views.setSize(d);
				home.resize(d);
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public JTabbedPane getViews() {
		return this.views;
	}
	
	public void initComponents() {
		home = new NewMainView(views.getSize());
	}
	
	public static void main(String[] args) {
		PIPSkeleton x = new PIPSkeleton();
	}
}
