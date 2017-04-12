package gui;

import util.*;
import app.*;
import com.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;

public class LoginFrame extends JFrame {
	private JButton loginUserButton;
	private JButton createNewUserButton;
	private JScrollPane userListContainer;
	private JList userList;
	private LoginFrame current;
	
	public LoginFrame() {
		current = this;
		setTitle("PIP");
		setSize(473, 198); // work later
		setLocation(120, 120);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setSize(panel.getParent().getWidth(), panel.getParent().getHeight());
		
		loginUserButton = new JButton("Login User");
		createNewUserButton = new JButton("Create User");
		
		userList = new JList();
		DefaultListModel dlm = new DefaultListModel();
		for (int i = 0; i < PIPIO.loadUsernames().size(); i++) {
			dlm.add(i, PIPIO.loadUsernames().get(i));
		}
		userList.setModel(dlm);
		userList.setVisible(true);
		
		userListContainer = new JScrollPane(userList);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(loginUserButton, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(createNewUserButton, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addComponent(userListContainer, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(userListContainer, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(createNewUserButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(loginUserButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		
		panel.setLayout(gl_panel);
		
		loginUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (userList.getSelectedIndex() != -1 ) {
					String username = PIPIO.loadUsernames().get(userList.getSelectedIndex());
					//User currentUser = PIPIO.loadUser(username);
					//PIPStart.changeWindow(new SE_skeleton());
					dispose();
				}
			}
		});
		
		createNewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// open new window
				PIPStart.changeWindow(new AddUserFrame(current));
				dispose();
			}
		});
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}