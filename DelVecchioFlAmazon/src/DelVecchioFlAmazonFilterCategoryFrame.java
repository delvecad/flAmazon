import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DelVecchioFlAmazonFilterCategoryFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblFilterCategoryInstructions = new JLabel("Select the categories to include");
	private final JCheckBox chckbxElectronics = new JCheckBox("Electronics");
	private final JCheckBox chckbxComputers = new JCheckBox("Computers");
	private final JCheckBox chckbxClothing = new JCheckBox("Clothing");
	private final JCheckBox chckbxMusic = new JCheckBox("Music");
	private final JCheckBox chckbxBooks = new JCheckBox("Books");
	private final JCheckBox chckbxMovies = new JCheckBox("Movies");
	private final JButton btnCategoryApply = new JButton("Apply");
	private final JButton btnCategoryCancel = new JButton("Cancel");
	
	private Query q = new Query();
	private final JCheckBox chckbxHomeGarden = new JCheckBox("Home & Garden");
	private final JCheckBox chckbxSports = new JCheckBox("Sports");
	private final JCheckBox chckbxAutomotive = new JCheckBox("Automotive");
	private final JCheckBox chckbxOther = new JCheckBox("Other");

	
	/**
	 * Create the frame.
	 */
	public DelVecchioFlAmazonFilterCategoryFrame(Query query) {
		q = query;
		jbInit();
	}
	private void jbInit() {
		setTitle("Filter By Category");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFilterCategoryInstructions.setBounds(10, 11, 196, 14);
		
		contentPane.add(lblFilterCategoryInstructions);
		chckbxElectronics.setBounds(20, 32, 97, 23);
		
		contentPane.add(chckbxElectronics);
		chckbxComputers.setBounds(20, 58, 97, 23);
		
		contentPane.add(chckbxComputers);
		chckbxClothing.setBounds(20, 84, 97, 23);
		
		contentPane.add(chckbxClothing);
		chckbxMusic.setBounds(20, 110, 97, 23);
		
		contentPane.add(chckbxMusic);
		chckbxBooks.setBounds(20, 136, 97, 23);
		
		contentPane.add(chckbxBooks);
		chckbxMovies.setBounds(20, 162, 97, 23);
		
		contentPane.add(chckbxMovies);
		btnCategoryApply.setToolTipText("Apply Filter");
		btnCategoryApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCategoryApply_actionPerformed(arg0);
			}
		});
		
		//Grays out "apply" button while no categories are checked
		/* while(! chckbxItemID.isSelected() || 
				! chckbxItemName.isSelected() || 
				! chckbxCategory.isSelected() || 
				! chckbxQuantity.isSelected() ||
				! chckbxPrice.isSelected() ||
				! chckbxShipping.isSelected()){
			btnCategoryApply.setEnabled(false);
		}//while */
		
		btnCategoryApply.setBounds(135, 295, 89, 23);
		
		contentPane.add(btnCategoryApply);
		btnCategoryCancel.setToolTipText("Cancel");
		btnCategoryCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCategoryCancel_actionPerformed(arg0);
			}
		});
		btnCategoryCancel.setBounds(234, 295, 89, 23);
		
		contentPane.add(btnCategoryCancel);
		chckbxHomeGarden.setBounds(20, 188, 125, 23);
		
		contentPane.add(chckbxHomeGarden);
		chckbxSports.setBounds(20, 214, 97, 23);
		
		contentPane.add(chckbxSports);
		chckbxAutomotive.setBounds(20, 240, 97, 23);
		
		contentPane.add(chckbxAutomotive);
		chckbxOther.setBounds(20, 266, 97, 23);
		
		contentPane.add(chckbxOther);
	}
	protected void do_btnCategoryApply_actionPerformed(ActionEvent arg0) {
		q.getQuery();
		
		//uses all check boxes to create query
		q.setCategoryChunk(q.getCategoryChunk() + " AND ((1=2)");
		if(chckbxElectronics.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'ItemID')");
		if(chckbxComputers.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'ItemName')");
		if(chckbxClothing.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Clothing')");
		if(chckbxMusic.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Music')");
		if(chckbxBooks.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Books')");
		if(chckbxMovies.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Movies')");
		if(chckbxHomeGarden.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'HomeGarden')");
		if(chckbxSports.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Sports')");
		if(chckbxAutomotive.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Automotive')");
		if(chckbxOther.isSelected())
			q.setCategoryChunk(q.getCategoryChunk() + " OR (Category = 'Other')");
		q.setCategoryChunk(q.getCategoryChunk() + ")");
		
		q.constructQuery();
		System.out.println(q.getQuery());
		DelVecchioFlAmazonFrame.refresh(q.getQuery());
		DelVecchioFlAmazonFrame.setFilterIndicator("Category");
		this.dispose();
		
	}
	protected void do_btnCategoryCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
