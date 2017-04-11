package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class TESTGUI extends JFrame {
	public TESTGUI() {
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(349, 111, 1, 1);
		getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(24, 80, 210, 462);
		getContentPane().add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(282, 80, 419, 462);
		getContentPane().add(list_2);
		
		JButton btnNewButton = new JButton("Load Tags");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel dlm = new DefaultListModel();
				String[] arr = {"Fred", "Fredd", "Freddie"};	
				for (int i = 0; i < arr.length; i++) {
					dlm.addElement(arr[i]);
				}
				
				
				//dlm.addElement("BUTT");
	
				list_1.setModel(dlm);
			}
		});
		btnNewButton.setBounds(85, 39, 149, 30);
		getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Associated Files");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel dlmT = new DefaultListModel();
		
				dlmT.addElement(list_1.getSelectedValue());
				list_2.setModel(dlmT);
				}
		});
		btnNewButton_1.setBounds(413, 39, 133, 30);
		getContentPane().add(btnNewButton_1);
		
		JFormattedTextField frmtdtxtfldTags = new JFormattedTextField();
		frmtdtxtfldTags.setText("Tags:");
		frmtdtxtfldTags.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldTags.setEditable(false);
		frmtdtxtfldTags.setBounds(24, 39, 51, 30);
		getContentPane().add(frmtdtxtfldTags);
		
		JFormattedTextField frmtdtxtfldAssociatedFiles = new JFormattedTextField();
		frmtdtxtfldAssociatedFiles.setText("Associated Files:");
		frmtdtxtfldAssociatedFiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldAssociatedFiles.setEditable(false);
		frmtdtxtfldAssociatedFiles.setBounds(282, 39, 108, 30);
		getContentPane().add(frmtdtxtfldAssociatedFiles);
		
		JButton btnNewButton_2 = new JButton("Load File");
		btnNewButton_2.setBounds(568, 39, 133, 30);
		getContentPane().add(btnNewButton_2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TESTGUI t = new TESTGUI();
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
