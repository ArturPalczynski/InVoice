package inVoiceView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MainFrameView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblName;
	private JLabel lblSureName;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblFrim;
	private JLabel lblNip;
	private JTable table;
	private JButton btnAddRow;
	private JButton btnRemoveRow;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameView frame = new MainFrameView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainFrameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel leftPanelForCustomerData = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, leftPanelForCustomerData, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, leftPanelForCustomerData, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, leftPanelForCustomerData, 130, SpringLayout.NORTH, contentPane);
		contentPane.add(leftPanelForCustomerData);
		leftPanelForCustomerData.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		lblName = new JLabel("Name");
		leftPanelForCustomerData.add(lblName, "2, 2, right, default");
		
		textField_1 = new JTextField();
		leftPanelForCustomerData.add(textField_1, "4, 2, left, top");
		textField_1.setColumns(10);
		
		lblSureName = new JLabel("Sure Name");
		leftPanelForCustomerData.add(lblSureName, "2, 4, right, default");
		
		textField = new JTextField();
		leftPanelForCustomerData.add(textField, "4, 4, left, top");
		textField.setColumns(10);
		
		lblFrim = new JLabel("Frim");
		leftPanelForCustomerData.add(lblFrim, "2, 6, right, default");
		
		textField_2 = new JTextField();
		leftPanelForCustomerData.add(textField_2, "4, 6, fill, default");
		textField_2.setColumns(10);
		
		lblNip = new JLabel("NIP");
		leftPanelForCustomerData.add(lblNip, "2, 8, right, default");
		
		textField_3 = new JTextField();
		leftPanelForCustomerData.add(textField_3, "4, 8, fill, default");
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 20, SpringLayout.WEST, leftPanelForCustomerData);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 278, SpringLayout.SOUTH, leftPanelForCustomerData);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCustomers = new JButton("Customers");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCustomers, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCustomers, -28, SpringLayout.EAST, contentPane);
		contentPane.add(btnCustomers);
		
		JButton btnAddCustomer = new JButton("Add customer");
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 21, SpringLayout.SOUTH, btnAddCustomer);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddCustomer, 6, SpringLayout.SOUTH, leftPanelForCustomerData);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddCustomer, 0, SpringLayout.EAST, leftPanelForCustomerData);
		contentPane.add(btnAddCustomer);
		
		JButton btnShowInvoice = new JButton("Show Invoice");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnShowInvoice, 0, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnShowInvoice, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnShowInvoice);
		
		JButton btnSave = new JButton("Save");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, btnShowInvoice);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSave, 6, SpringLayout.EAST, btnShowInvoice);
		contentPane.add(btnSave);
		
		btnAddRow = new JButton("Add row");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddRow, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddRow, -99, SpringLayout.EAST, contentPane);
		contentPane.add(btnAddRow);
		
		btnRemoveRow = new JButton("Remove row");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemoveRow, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRemoveRow, 6, SpringLayout.EAST, btnAddRow);
		contentPane.add(btnRemoveRow);
	}
}
