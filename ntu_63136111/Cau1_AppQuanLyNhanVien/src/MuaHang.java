import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class MuaHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuaHang frame = new MuaHang();
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
	public MuaHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1000, 626);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(149, 0, 1065, 600);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQunLSn_1_1_1 = new JLabel("Quản Lý Mua Hàng");
		lblQunLSn_1_1_1.setBounds(355, 10, 200, 22);
		lblQunLSn_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1);
		
		JLabel lblQunLSn_1_1_1_1 = new JLabel("Tên:");
		lblQunLSn_1_1_1_1.setBounds(20, 74, 70, 22);
		lblQunLSn_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(20, 106, 150, 25);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(20, 180, 150, 25);
		panel_1.add(textField_2);
		
		JLabel lblQunLSn_1_1_1_1_2 = new JLabel("Giá:");
		lblQunLSn_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_2.setBounds(20, 150, 70, 22);
		panel_1.add(lblQunLSn_1_1_1_1_2);
		
		JTable itemList = new JTable();
		itemList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		itemList.setRowHeight(29);
		itemList.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "T\u00EAn", "Th\u1EC3 lo\u1EA1i", "Gi\u00E1"
			}
		));
		itemList.setBounds(40, 293, 300, 282);
		panel_1.add(itemList);
		
		JButton btnNewButton = new JButton("Thêm vào giỏ hàng");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(100, 242, 200, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblQunLSn_1_1_1_1_2_1 = new JLabel("Số lượng:");
		lblQunLSn_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_2_1.setBounds(198, 150, 90, 22);
		panel_1.add(lblQunLSn_1_1_1_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(198, 180, 150, 25);
		panel_1.add(textField_1);
		
		table = new JTable();
		table.setRowHeight(29);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBounds(487, 115, 300, 400);
		panel_1.add(table);
		
		JButton btnInHan = new JButton("In hóa đơn");
		btnInHan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInHan.setBounds(545, 533, 200, 30);
		panel_1.add(btnInHan);
		
		JLabel lblQunLSn_1_1_1_1_1 = new JLabel("Hóa đơn");
		lblQunLSn_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_1.setBounds(595, 74, 90, 22);
		panel_1.add(lblQunLSn_1_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 131, 129, 40);
		panel.add(lblNewLabel);
		
		JLabel lblMuaHng = new JLabel("Mua hàng");
		lblMuaHng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMuaHng.setBounds(10, 200, 129, 40);
		panel.add(lblMuaHng);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogOut.setBounds(10, 535, 129, 40);
		panel.add(lblLogOut);
	}
}
