package gui;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.SystemColor;

public class GeneralFrame extends JFrame {
	public GeneralFrame() {
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 752, 0);
		getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(24, 56, 229, 414);
		getContentPane().add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(293, 56, 411, 414);
		getContentPane().add(list_2);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(24, 485, 109, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(144, 485, 109, 52);
		getContentPane().add(btnDelete);
		
		JButton btnDetailView = new JButton("Detail View");
		btnDetailView.setBounds(293, 485, 109, 52);
		getContentPane().add(btnDetailView);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(429, 485, 109, 52);
		getContentPane().add(btnEdit);
		
		JFormattedTextField frmtdtxtfldTypeOfPanel = new JFormattedTextField();
		frmtdtxtfldTypeOfPanel.setBackground(SystemColor.control);
		frmtdtxtfldTypeOfPanel.setText("TYPE OF PANEL");
		frmtdtxtfldTypeOfPanel.setBounds(24, 11, 229, 38);
		getContentPane().add(frmtdtxtfldTypeOfPanel);
		
		JFormattedTextField frmtdtxtfldDetailedView = new JFormattedTextField();
		frmtdtxtfldDetailedView.setText("Detailed View");
		frmtdtxtfldDetailedView.setBackground(SystemColor.menu);
		frmtdtxtfldDetailedView.setBounds(293, 11, 229, 38);
		getContentPane().add(frmtdtxtfldDetailedView);
	}

	public static void main(String[] args) {
		GeneralFrame g = new GeneralFrame();
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
