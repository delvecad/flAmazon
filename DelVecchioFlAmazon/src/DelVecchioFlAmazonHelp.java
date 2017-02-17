import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class DelVecchioFlAmazonHelp extends JFrame {

	private JPanel contentPane;
	private final JLabel lblSorting = new JLabel("Sorting:");
	private final JLabel lblFiltering = new JLabel("Filtering:");
	private final JLabel lblAddingItems = new JLabel("Adding Items:");
	private final JLabel sortingHelp = new JLabel("<HTML>\r\n\t To sort items by name, price, or category <br>\r\n\tselect Tools -> Select Sort -> [sort type]\r\n</HTML>");
	private final JLabel filteringHelp = new JLabel("<HTML>\r\n\t To filter items by price or category <br>\r\n\tselect Tools -> Select Filter -> [filter type] <br>\r\n\tBe sure to fill all fields.\r\n</HTML>");
	private final JLabel addingHelp = new JLabel("<HTML>\r\n\t To add an item to your cart, select <br>\r\n\tTools -> Add Item, and then fill in all fields <br>\r\n\twith the appropriate information.\r\n</HTML>");


	/**
	 * Create the frame.
	 */
	public DelVecchioFlAmazonHelp() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSorting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSorting.setBounds(10, 22, 84, 30);
		
		contentPane.add(lblSorting);
		lblFiltering.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFiltering.setBounds(10, 103, 84, 30);
		
		contentPane.add(lblFiltering);
		lblAddingItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddingItems.setBounds(10, 195, 112, 30);
		
		contentPane.add(lblAddingItems);
		sortingHelp.setBounds(104, 27, 199, 66);
		
		contentPane.add(sortingHelp);
		filteringHelp.setBounds(104, 113, 225, 60);
		
		contentPane.add(filteringHelp);
		addingHelp.setBounds(104, 200, 199, 66);
		
		contentPane.add(addingHelp);
	}
}
