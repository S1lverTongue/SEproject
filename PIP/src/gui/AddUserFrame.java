package gui;

import util.*;
import com.User;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.PIPStart;

import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUserFrame extends JFrame {
	private JTextField userField;
	private JLabel lblUsername;
	private JButton createNewUser;
	private LoginFrame parent;
	
	public AddUserFrame(LoginFrame parent) {
		this.parent = parent; //parent;
		setTitle("User Creation");
		setSize(this.parent.getWidth(),this.parent.getHeight() / 2);
		getContentPane().setLayout(null);
		
		userField = new JTextField();
		userField.setBounds(this.parent.getWidth() / 5, 10, this.parent.getWidth() - (this.parent.getWidth() / 4), 20);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 11, 71, 14);
		getContentPane().add(lblUsername);
		
		createNewUser  = new JButton("Create User");
		createNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (userField.getText().length() > 0) {
					if (Filter.userFilter(userField.getText())) { // good username
						User newUser = new User(userField.getText());
						PIPIO.createUser(newUser);
						System.out.println(userField.getText());
						dispose();
						PIPStart.changeWindow(new LoginFrame());
					}
				}
			}
		});
		createNewUser.setBounds(10, 41, this.parent.getWidth() - 30, 23);
		getContentPane().add(createNewUser);
		
		setVisible(true);
		setResizable(false);
		setLocation(this.parent.getX(), this.parent.getY());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
