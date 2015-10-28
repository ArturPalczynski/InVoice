package inVoiceView;

import inVoiceData.Customer;
import inVoiceData.HibernateConnection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {
	private JTextField textField_1;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblAddress;
	private JLabel lblNip;
	private JButton btnAddRow;
	private JButton btnRemoveRow;
	
	static HibernateConnection hibernateConnection = new HibernateConnection();

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 447);

		textField_1 = new JTextField();
		textField_1.setColumns(15);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("SureName");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnCustomers = new JButton("Customers");

		textField = new JTextField();
		textField.setColumns(15);

		textField_2 = new JTextField();
		textField_2.setColumns(15);

		textField_3 = new JTextField();
		textField_3.setColumns(15);

		lblAddress = new JLabel("Company");
		lblAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		lblNip = new JLabel("NIP");
		lblNip.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));

		btnAddRow = new JButton("Add row");

		btnRemoveRow = new JButton("Remove row");
		
		JButton btnSaveCustomerDetails = new JButton("Save Customer Details");
		btnSaveCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				String name = textField_1.getText();
				String sureName = textField.getText();
				String firmName = textField_2.getText();
				String nip = textField_3.getText();
				
				Customer tempCustomer = new Customer();
				
				tempCustomer.setName(name);
				tempCustomer.setSureName(sureName);
				tempCustomer.setFirmName(firmName);
				tempCustomer.setNip(nip);
				
				hibernateConnection.openHibernateConnection();
				
				hibernateConnection.saveEntityInDatabase(tempCustomer);
				
				hibernateConnection.closeHibernateConnection();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNip)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
									.addComponent(btnCustomers))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(btnSaveCustomerDetails)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddRow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveRow)
							.addGap(21))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel)
							.addGap(25)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCustomers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSaveCustomerDetails))
						.addComponent(lblNip, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddRow)
						.addComponent(btnRemoveRow))
					.addGap(22))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null }, }, new String[] { "Nr", "Goods",
				"Quantity", "Tax", "Total" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
}
