import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

//PROBLEM GETTING DATA FROM FILTER WINDOW TO CLASS TO HERE! FIX!!!!
public class DelVecchioFlAmazonFrame extends JFrame {

	private JPanel contentPane;
	private final static JTable CartTable = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item");
	private final JMenu mnSetSort = new JMenu("Set Sort...");
	private final JMenuItem mntmByItemName = new JMenuItem("By Item Name");
	private final JMenuItem mntmByPrice = new JMenuItem("By Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JMenu mnSetFilter = new JMenu("Set Filter...");
	private final JMenuItem mntmByPrice_1 = new JMenuItem("By Price");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category");
	private final JLabel lblShoppingCart = new JLabel("Your Shopping Cart");
	private final JLabel SortMethodIndicator = new JLabel("Item ID");
	private final JLabel lblSortedBy = new JLabel("Sorted By:");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmHelpMenu = new JMenuItem("Help Menu");
	
	private Query theQuery = new Query();
	private final JLabel lblFilteredBy = new JLabel("Filtered By:");
	private final static JLabel FilterMethodIndicator = new JLabel("None");
	private final JMenuItem mntmSortDefault = new JMenuItem("Default");
	private final JMenuItem mntmFilterDefault = new JMenuItem("Default");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelVecchioFlAmazonFrame frame = new DelVecchioFlAmazonFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DelVecchioFlAmazonFrame() {
		jbInit();
	}
	private void jbInit() {
		System.out.println(theQuery.getBaseQuery());
		setTitle("DelVecchio FlAmazon Shopping Cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 425);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddItem_actionPerformed(arg0);
			}
		});
		mntmAddItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		mntmByItemName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByItemName_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByItemName);
		mntmByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByPrice);
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByCategory_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmByCategory);
		mntmSortDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmSortDefault_actionPerformed(arg0);
			}
		});
		
		mnSetSort.add(mntmSortDefault);
		
		mnTools.add(mnSetFilter);
		mntmByPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByPrice_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByPrice_1);
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmByCategory_1_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmByCategory_1);
		mntmFilterDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmFilterDefault_actionPerformed(arg0);
			}
		});
		
		mnSetFilter.add(mntmFilterDefault);
		
		menuBar.add(mnHelp);
		mntmHelpMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmHelpMenu_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmHelpMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setToolTipText("Your Shopping Cart");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 60, 527, 245);
		
		contentPane.add(scrollPane);
		CartTable.setFont(new Font("Courier New", Font.PLAIN, 11));
		CartTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Item ID", "Item Name", "Category", "Qty", "Price", "Shipping"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Long.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		CartTable.getColumnModel().getColumn(0).setResizable(false);
		CartTable.getColumnModel().getColumn(0).setPreferredWidth(46);
		CartTable.getColumnModel().getColumn(1).setResizable(false);
		CartTable.getColumnModel().getColumn(1).setPreferredWidth(131);
		CartTable.getColumnModel().getColumn(2).setResizable(false);
		CartTable.getColumnModel().getColumn(3).setResizable(false);
		CartTable.getColumnModel().getColumn(3).setPreferredWidth(28);
		CartTable.getColumnModel().getColumn(4).setResizable(false);
		CartTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		CartTable.getColumnModel().getColumn(5).setResizable(false);
		CartTable.getColumnModel().getColumn(5).setPreferredWidth(65);
		
		//grab the column model
		TableColumnModel m = CartTable.getColumnModel();
		//set the third column in the table to display currency
		m.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		m.getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
				
		scrollPane.setViewportView(CartTable);
		
		//Load the driver
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		lblShoppingCart.setFont(new Font("Sylfaen", Font.PLAIN, 27));
		lblShoppingCart.setBounds(10, 11, 336, 38);
		
		contentPane.add(lblShoppingCart);
		SortMethodIndicator.setToolTipText("Sort Method");
		SortMethodIndicator.setBounds(459, 320, 78, 14);
		
		contentPane.add(SortMethodIndicator);
		lblSortedBy.setBounds(392, 320, 71, 14);
		
		contentPane.add(lblSortedBy);
		
		displayCart();
		lblFilteredBy.setBounds(392, 340, 71, 14);
		
		contentPane.add(lblFilteredBy);
		FilterMethodIndicator.setToolTipText("Filter Method");
		FilterMethodIndicator.setBounds(459, 340, 78, 14);
		
		contentPane.add(FilterMethodIndicator);
	}
	
	//Sorts cart by item name
	protected void do_mntmByItemName_actionPerformed(ActionEvent arg0) {
		SortMethodIndicator.setText("Item Name");
		setSort("ItemName");
	}
	
	//Sorts items by price
	protected void do_mntmByPrice_actionPerformed(ActionEvent arg0) {
		SortMethodIndicator.setText("Price");
		setSort("Price");
	}
	
	//Sorts items by category
	protected void do_mntmByCategory_actionPerformed(ActionEvent arg0) {
		SortMethodIndicator.setText("Category");
		setSort("Category");
	}
	

	//Sets filter indicator
	protected static void setFilterIndicator(String filterMethod){
		FilterMethodIndicator.setText(filterMethod);
	}
	
	//Sets sort method back to the default, Item ID
	protected void do_mntmSortDefault_actionPerformed(ActionEvent arg0) {
		SortMethodIndicator.setText("Item ID");
		setSort("ItemID");
	}
	
	//Sets filter back to default
	protected void do_mntmFilterDefault_actionPerformed(ActionEvent arg0) {
		FilterMethodIndicator.setText("None");
		displayCart();
	}
	
	//Opens Add Item window
	protected void do_mntmAddItem_actionPerformed(ActionEvent arg0) {
		DelVecchioFlAmazonAddItemFrame AddItemFrame = new DelVecchioFlAmazonAddItemFrame();
		AddItemFrame.setVisible(true);
	}
	
	//Opens Filter by Category window
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent arg0) {
		DelVecchioFlAmazonFilterCategoryFrame FilterByCategoryFrame = new DelVecchioFlAmazonFilterCategoryFrame(theQuery);
		FilterByCategoryFrame.setVisible(true);
	}
	
	//Opens FIlter by Price window
	protected void do_mntmByPrice_1_actionPerformed(ActionEvent arg0) {
		DelVecchioFlAmazonFilterPriceFrame FilterByPriceFrame = new DelVecchioFlAmazonFilterPriceFrame(theQuery);
		FilterByPriceFrame.setVisible(true);
	}
	
	//Opens Help window
	protected void do_mntmHelpMenu_actionPerformed(ActionEvent arg0) {
		DelVecchioFlAmazonHelp HelpFrame = new DelVecchioFlAmazonHelp();
		HelpFrame.setVisible(true);
	}
	
	//Closes program
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	
	//refreshes the table to display updated results
	protected static void refresh(String query){
		Statement stmt = null;
		ResultSet rs = null;
		
		//Establish the connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./DelVecchioFlAmazon.accdb");
			
			//Create the statement
			stmt = conn.createStatement();
			
			//Execute the statement
			rs = stmt.executeQuery(query);
			
			//Process the results
			//This part is different when using jTables!!!!!!!!
			
			//remove any previously added rows
			while(CartTable.getRowCount() > 0)
				((DefaultTableModel) CartTable.getModel()).removeRow(0); //casts the table to the default table model and removes the first row while there are rows
			
			int numColumns = rs.getMetaData().getColumnCount(); //tells me the number of columns in the resultSet
			
			while(rs.next()){
				Object[] row = new Object[numColumns];
				for (int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i+1);  //we add 1 to i because java arrays are 0-based, and resultSet records are 1-based
				((DefaultTableModel) CartTable.getModel()).insertRow(rs.getRow() -1, row); //inserts row into jtable
			}//while
			
			rs.close();
			conn.close();
			}//try
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
	}	
	
	
	//Inserts statement into table
	protected static void refreshInsert(String statement){
		Statement stmt = null;
		ResultSet rs = null;
		
		//Establish the connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./DelVecchioFlAmazon.accdb");
			
			//Create the statement
			stmt = conn.createStatement();
			stmt.executeUpdate(statement);
			
			//Execute the statement
			rs = stmt.executeQuery("SELECT ItemName, ItemID, Category, Quantity, Price, Shipping FROM ShoppingCart");
			
			//Process the results
			//This part is different when using jTables!!!!!!!!
			
			//remove any previously added rows
			while(CartTable.getRowCount() > 0)
				((DefaultTableModel) CartTable.getModel()).removeRow(0); //casts the table to the default table model and removes the first row while there are rows
			
			int numColumns = rs.getMetaData().getColumnCount(); //tells me the number of columns in the resultSet
			
			while(rs.next()){
				Object[] row = new Object[numColumns];
				for (int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i+1);  //we add 1 to i because java arrays are 0-based, and resultSet records are 1-based
				((DefaultTableModel) CartTable.getModel()).insertRow(rs.getRow() -1, row); //inserts row into jtable
			}//while
			
			rs.close();
			conn.close();
			}//try
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
	}	
	
	
	
	//sets the sorting method
	protected void setSort(String type){
		Statement stmt = null;
		ResultSet rs = null;
		
		//Establish the connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./DelVecchioFlAmazon.accdb");
			
			//Create the statement
			stmt = conn.createStatement();
			//String query = "SELECT ItemID, ItemName, Category, Quantity, Price, Shipping FROM ShoppingCart ORDER BY ItemName";
			theQuery.setOrderbyChunk(" ORDER BY " + type);
			theQuery.constructQuery();
			System.out.println(theQuery.getQuery());
			
			//Execute the statement
			rs = stmt.executeQuery(theQuery.getQuery());
			System.out.println(theQuery.getQuery());
			
			//Process the results
			//This part is different when using jTables!!!!!!!!
			
			//remove any previously added rows
			while(CartTable.getRowCount() > 0)
				((DefaultTableModel) CartTable.getModel()).removeRow(0); //casts the table to the default table model and removes the first row while there are rows
			
			int numColumns = rs.getMetaData().getColumnCount(); //tells me the number of columns in the resultSet
			
			while(rs.next()){
				Object[] row = new Object[numColumns];
				for (int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i+1);  //we add 1 to i because java arrays are 0-based, and resultSet records are 1-based
				((DefaultTableModel) CartTable.getModel()).insertRow(rs.getRow() -1, row); //inserts row into jtable
			}//while
			
			rs.close();
			conn.close();
			}//try
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
	}
	
	//Displays the entire shopping cart 
	public void displayCart(){
		Statement stmt = null;
		ResultSet rs = null;
		
		//Establish the connection
		try {
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://./DelVecchioFlAmazon.accdb");
			
			//Create the statement
			stmt = conn.createStatement();

			
			//Execute the statement
			rs = stmt.executeQuery(theQuery.getBaseQuery());
			
			//Process the results
			//This part is different when using jTables!!!!!!!!
			
			//remove any previously added rows
			while(CartTable.getRowCount() > 0)
				((DefaultTableModel) CartTable.getModel()).removeRow(0); //casts the table to the default table model and removes the first row while there are rows
			
			int numColumns = rs.getMetaData().getColumnCount(); //tells me the number of columns in the resultSet
			
			while(rs.next()){
				Object[] row = new Object[numColumns];
				for (int i = 0; i < numColumns; i++)
					row[i] = rs.getObject(i+1);  //we add 1 to i because java arrays are 0-based, and resultSet records are 1-based
				((DefaultTableModel) CartTable.getModel()).insertRow(rs.getRow() -1, row); //inserts row into jtable
			}//while
			
			rs.close();
			conn.close();
			}//try
			catch (SQLException ex)
			{
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				ex.printStackTrace();
			} //catch
	}
	
}


