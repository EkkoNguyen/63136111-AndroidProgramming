import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MuaHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen, txtGia, txtSoLuong;
	private JTable itemList;
	private JTable hoaDon;
	private int key;
	int tongTien = 0;
	Connection con = null;
	PreparedStatement St = null, St1 = null;
	ResultSet Rs = null, Rs1 = null;
	private JTextField txtTongTien;
	private JTextField txtTenKhachHang;
	
	private void clear() {
		txtTen.setText("");
		txtGia.setText("");
		txtSoLuong.setText("");
	}
	
	private void ShowDanhSachSanPham() {
		try {
			itemList.removeAll();
			String[] arr = {"Mã sản phẩm", "Tên sản phẩm", "Thể loại", "Giá"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
			St = con.prepareStatement("select * from SanPham");
			Rs= St.executeQuery();
			while(Rs.next()) {
				Vector vector = new Vector();
				vector.add(Rs.getString("MaSP"));
				vector.add(Rs.getString("TenSP"));
				vector.add(Rs.getString("TheLoai"));
				vector.add(Rs.getInt("Gia"));
				model.addRow(vector);
			}
			itemList.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e);
		}
		
	}
	
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
	
	public void logOut() {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
	public void insertHoaDon() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
			PreparedStatement Pst = con.prepareStatement("insert into HoaDon values(?,?,?)");
			
			Pst.setString(1, txtTenKhachHang.getText());
			Pst.setString(2, java.time.LocalDate.now().toString());
			Pst.setInt(3, tongTien);
			int row = Pst.executeUpdate();	
			con.close();
			ShowDanhSachSanPham();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(contentPane, e1);
		}
	}
	
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
		panel_1.setBounds(149, 0, 1065, 600);
		panel_1.setBackground(new Color(0, 128, 192));
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
		
		txtTen = new JTextField();
		txtTen.setBounds(20, 106, 150, 25);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGia.setColumns(10);
		txtGia.setBounds(20, 180, 150, 25);
		panel_1.add(txtGia);
		
		JLabel lblQunLSn_1_1_1_1_2 = new JLabel("Giá:");
		lblQunLSn_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_2.setBounds(20, 150, 70, 22);
		panel_1.add(lblQunLSn_1_1_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(15, 293, 375, 282);
		panel_1.add(scrollPane);
		
		itemList = new JTable();
		itemList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				DefaultTableModel model = (DefaultTableModel) itemList.getModel();
				int index = itemList.getSelectedRow();
				key = Integer.valueOf(model.getValueAt(index, 0).toString());
				txtTen.setText(model.getValueAt(index, 1).toString());
				//CbTheLoai.setText(model.getValueAt(index, 2).toString());
				txtGia.setText(model.getValueAt(index, 3).toString());
			}
		});
		scrollPane.setViewportView(itemList);
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
				"Mã sản phẩm", "Tên sản phẩm", "Thể loại", "Giá"
			}
		));
		JButton btnAdd = new JButton("Thêm vào giỏ hàng");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTen.getText().isEmpty() || txtGia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn sản phẩm rồi mới thêm");
				}else {
					int thanhtien = Integer.valueOf(txtGia.getText()) * Integer.valueOf(txtSoLuong.getText());
					tongTien = tongTien + thanhtien;
					txtTongTien.setText(""+tongTien);
					DefaultTableModel model = (DefaultTableModel) hoaDon.getModel();
					String nextRowId = Integer.toString(model.getRowCount());
					model.addRow(new Object [] {
							Integer.valueOf(nextRowId) + 1,
							txtTen.getText(),
							txtGia.getText(),
							txtSoLuong.getText(),
							thanhtien
					});
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(100, 242, 200, 30);
		panel_1.add(btnAdd);
		
		JLabel lblQunLSn_1_1_1_1_2_1 = new JLabel("Số lượng:");
		lblQunLSn_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_2_1.setBounds(198, 150, 90, 22);
		panel_1.add(lblQunLSn_1_1_1_1_2_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(198, 180, 150, 25);
		panel_1.add(txtSoLuong);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(400, 115, 420, 350);
		panel_1.add(scrollPane_1);
		
		hoaDon = new JTable();
		scrollPane_1.setViewportView(hoaDon);
		hoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"
			}
		));
		hoaDon.setRowHeight(29);
		hoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnInHD = new JButton("In hóa đơn");
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertHoaDon();
					hoaDon.print();
				}catch (Exception e1) {
					
				}
			}
		});
		btnInHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInHD.setBounds(520, 533, 200, 30);
		panel_1.add(btnInHD);
		
		JLabel lblQunLSn_1_1_1_1_1 = new JLabel("Hóa đơn");
		lblQunLSn_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_1.setBounds(580, 74, 90, 22);
		panel_1.add(lblQunLSn_1_1_1_1_1);
		txtTen.setEditable(false);
		txtGia.setEditable(false);
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(488, 485, 100, 30);
		panel_1.add(lblNewLabel_1);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(593, 490, 150, 25);
		panel_1.add(txtTongTien);
		
		JLabel lblQunLSn_1_1_1_1_3 = new JLabel("Tên khách hàng:");
		lblQunLSn_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLSn_1_1_1_1_3.setBounds(198, 74, 200, 22);
		panel_1.add(lblQunLSn_1_1_1_1_3);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setText("User1");
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(198, 106, 150, 25);
		panel_1.add(txtTenKhachHang);
		txtTenKhachHang.setEditable(false);
		ShowDanhSachSanPham();
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		lblLogOut.setBounds(10, 535, 129, 40);
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblLogOut);
		
		JLabel lblNewLabel_2 = new JLabel("Sản phẩm");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 44, 129, 40);
		panel.add(lblNewLabel_2);
		
		JLabel lblMuaHng_1 = new JLabel("Mua hàng");
		lblMuaHng_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMuaHng_1.setBounds(10, 106, 129, 40);
		panel.add(lblMuaHng_1);
		
		JLabel lblXemHan = new JLabel("Xem hóa đơn");
		lblXemHan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblXemHan.setBounds(10, 175, 129, 40);
		panel.add(lblXemHan);
	}
}
