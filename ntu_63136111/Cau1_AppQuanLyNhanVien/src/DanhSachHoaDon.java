import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DanhSachHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachHoaDon frame = new DanhSachHoaDon();
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
	public DanhSachHoaDon() {
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
		
		JLabel lblQunLSn_1_1_1 = new JLabel("Danh sách hóa đơn");
		lblQunLSn_1_1_1.setBounds(355, 10, 200, 22);
		lblQunLSn_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1);
		
		table = new JTable();
		table.setBounds(10, 54, 800, 500);
		panel_1.add(table);
		
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
		
		JLabel lblXemHan = new JLabel("Xem hóa đơn");
		lblXemHan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblXemHan.setBounds(10, 269, 129, 40);
		panel.add(lblXemHan);
	}

}
