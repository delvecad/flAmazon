import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelVecchioFlAmazonFilterPriceFrame extends JFrame {

	private JPanel contentPane;
	private final JTextField lowPriceTF = new JTextField();
	private final JTextField highPriceTF = new JTextField();
	private final JLabel lbl$1 = new JLabel("$");
	private final JLabel lbl$2 = new JLabel("$");
	private final JLabel lblFrom = new JLabel("FROM");
	private final JLabel lblTo = new JLabel("TO");
	private final JLabel lblNewLabel = new JLabel("Enter your price range:");
	private final JButton btnPriceApply = new JButton("Apply");
	private final JButton btnPriceCancel = new JButton("Cancel");
	
	private Query q = new Query();

	
	
	public DelVecchioFlAmazonFilterPriceFrame(Query query) {
		q = query;
		jbInit();
	}
	private void jbInit() {
		highPriceTF.setToolTipText("High Price");
		highPriceTF.setBounds(252, 65, 86, 20);
		highPriceTF.setColumns(10);
		lowPriceTF.setToolTipText("Low Price");
		lowPriceTF.setBounds(97, 65, 86, 20);
		lowPriceTF.setColumns(10);
		setTitle("Filter By Price");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(lowPriceTF);
		
		contentPane.add(highPriceTF);
		lbl$1.setBounds(81, 68, 19, 14);
		
		contentPane.add(lbl$1);
		lbl$2.setBounds(234, 68, 19, 14);
		
		contentPane.add(lbl$2);
		lblFrom.setBounds(31, 68, 46, 14);
		
		contentPane.add(lblFrom);
		lblTo.setBounds(193, 68, 31, 14);
		
		contentPane.add(lblTo);
		lblNewLabel.setBounds(31, 21, 137, 14);
		
		contentPane.add(lblNewLabel);
		btnPriceApply.setToolTipText("Apply Filter");
		btnPriceApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPriceApply_actionPerformed(arg0);
			}
		});
		btnPriceApply.setBounds(150, 122, 89, 23);
		
		contentPane.add(btnPriceApply);
		btnPriceCancel.setToolTipText("Cancel");
		btnPriceCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPriceCancel_actionPerformed(arg0);
			}
		});
		btnPriceCancel.setBounds(252, 122, 89, 23);
		
		contentPane.add(btnPriceCancel);
	}
	
	//Applies the price range to the table
	protected void do_btnPriceApply_actionPerformed(ActionEvent arg0) {
		q.getQuery();
		
		q.setPriceChunk(" AND Price >= " + Double.parseDouble(lowPriceTF.getText()));
		q.setPriceChunk(q.getPriceChunk() + " AND Price <= " + Double.parseDouble(highPriceTF.getText()));
		q.constructQuery();
		DelVecchioFlAmazonFrame.setFilterIndicator("Price");
		DelVecchioFlAmazonFrame.refresh(q.getQuery());
		
		System.out.println(q.getQuery());
		this.dispose();
	}
	protected void do_btnPriceCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
