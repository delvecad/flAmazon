import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelVecchioFlAmazonAddItemFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblItemID = new JLabel("Item ID");
	private final JLabel lblItemName = new JLabel("Item Name");
	private final JLabel lblCategory = new JLabel("Category");
	private final JLabel lblQuantity = new JLabel("Quantity");
	private final JLabel lblPrice = new JLabel("Price");
	private final JLabel lblShipping = new JLabel("Shipping");
	private final JFormattedTextField itemIDFTF = new JFormattedTextField();
	private final JFormattedTextField quantityFTF = new JFormattedTextField();
	private final JFormattedTextField priceFTF = new JFormattedTextField();
	private final JFormattedTextField shippingFTF = new JFormattedTextField();
	private final JComboBox categoryComboBox = new JComboBox();
	private final JTextField itemNameTF = new JTextField();
	private final JButton btnAddItem = new JButton("Add");
	private final JButton btnCancel = new JButton("Cancel");
	
	private Query q = new Query();
	private Statement s = new Statement();


	/**
	 * Create the frame.
	 */
	public DelVecchioFlAmazonAddItemFrame() {
		jbInit();
	}
	private void jbInit() {
		itemNameTF.setToolTipText("Enter a Name");
		itemNameTF.setBounds(77, 33, 110, 20);
		itemNameTF.setColumns(10);
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblItemID.setBounds(10, 11, 57, 14);
		
		contentPane.add(lblItemID);
		lblItemName.setBounds(10, 36, 75, 14);
		
		contentPane.add(lblItemName);
		lblCategory.setBounds(10, 61, 75, 14);
		
		contentPane.add(lblCategory);
		lblQuantity.setBounds(10, 86, 66, 14);
		
		contentPane.add(lblQuantity);
		lblPrice.setBounds(10, 111, 57, 14);
		
		contentPane.add(lblPrice);
		lblShipping.setBounds(10, 133, 75, 14);
		
		contentPane.add(lblShipping);
		itemIDFTF.setToolTipText("Enter an Integer");
		itemIDFTF.setBounds(77, 8, 110, 20);
		
		contentPane.add(itemIDFTF);
		quantityFTF.setToolTipText("Enter an Integer");
		quantityFTF.setBounds(77, 83, 110, 20);
		
		contentPane.add(quantityFTF);
		priceFTF.setToolTipText("Enter a Number");
		priceFTF.setBounds(77, 108, 110, 20);
		
		contentPane.add(priceFTF);
		shippingFTF.setToolTipText("Enter a Number");
		shippingFTF.setBounds(77, 130, 110, 20);
		
		contentPane.add(shippingFTF);
		categoryComboBox.setToolTipText("Select a Category");
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Electronics", "Computers", "Clothing", "Music", "Books", "Movies", "HomeGarden", "Sports", "Automotive", "Other"}));
		categoryComboBox.setBounds(77, 58, 110, 20);
		
		contentPane.add(categoryComboBox);
		
		contentPane.add(itemNameTF);
		btnAddItem.setToolTipText("Add to Cart");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAddItem_actionPerformed(arg0);
			}
		});
		btnAddItem.setBounds(10, 158, 89, 23);
		
		contentPane.add(btnAddItem);
		btnCancel.setToolTipText("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(111, 158, 89, 23);
		
		contentPane.add(btnCancel);
	}
	protected void do_btnAddItem_actionPerformed(ActionEvent arg0) {
		s.setItemID(Integer.parseInt(itemIDFTF.getText()));
		s.setItemName(itemNameTF.getText());
		s.setCategory(categoryComboBox.getSelectedItem().toString());
		s.setQuantity(Integer.parseInt(quantityFTF.getText()));
		s.setPrice(Double.parseDouble(priceFTF.getText()));
		s.setShipping(Double.parseDouble(shippingFTF.getText()));
		s.constructStatement();
		q.constructQuery();
		
		System.out.println(s.getMyStatement());
		System.out.println(q.getQuery());
		DelVecchioFlAmazonFrame.refreshInsert(s.getMyStatement());
		
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
