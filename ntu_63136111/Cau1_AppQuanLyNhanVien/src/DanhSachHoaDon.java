import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DanhSachHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable danhSachHoaDon;
	Connection con = null;
	PreparedStatement St = null, St1 = null;
	ResultSet Rs = null, Rs1 = null;
	
	private void ShowHoaDon() {
		try {
			String[] arr = {"Mã hóa đơn", "Tên khách hàng", "Ngày mua", "Tổng tiền"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
			St = con.prepareStatement("select * from HoaDon");
			Rs= St.executeQuery();
			while(Rs.next()) {
				Vector vector = new Vector();
				vector.add(Rs.getString("MaHD"));
				vector.add(Rs.getString("TenKhachHang"));
				vector.add(Rs.getString("NgayMua"));
				vector.add(Rs.getInt("Gia"));
				model.addRow(vector);
			}
			danhSachHoaDon.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e);
		}
		
	}
	
	public void logOut() {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
	public void muaHang() {
		new MuaHang().setVisible(true);
		this.setVisible(false);
	}
	
	public void sanPham() {
		new Items().setVisible(true);
		this.setVisible(false);
	}
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 800, 500);
		panel_1.add(scrollPane);
		
		danhSachHoaDon = new JTable();
		scrollPane.setViewportView(danhSachHoaDon);
		danhSachHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hóa đơn", "Tên khách hàng", "Ngày mua", "Tổng tiền"
			}
		));
		ShowHoaDon();
		JLabel lblNewLabel = new JLabel("Sản phẩm");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sanPham();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 131, 129, 40);
		panel.add(lblNewLabel);
		
		JLabel lblMuaHng = new JLabel("Mua hàng");
		lblMuaHng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				muaHang();
			}
		});
		lblMuaHng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMuaHng.setBounds(10, 200, 129, 40);
		panel.add(lblMuaHng);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogOut.setBounds(10, 535, 129, 40);
		panel.add(lblLogOut);
	}

}
