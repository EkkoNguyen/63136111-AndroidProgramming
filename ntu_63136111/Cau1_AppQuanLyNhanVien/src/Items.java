import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Items extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTable ListSanPham;
	private JComboBox cbFilter;
	Connection con = null;
	PreparedStatement St = null, St1 = null;
	ResultSet Rs = null, Rs1 = null;
	private int key;
	
	private void ShowDanhSachSanPham() {
		try {
			ListSanPham.removeAll();
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
			ListSanPham.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e);
		}
		
	}
	
	private void FilterSanPham() {
		try {
			String[] arr = {"Mã sản phẩm", "Tên sản phẩm", "Thể loại", "Giá"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
			St = con.prepareStatement("select * from SanPham where TheLoai = N'"+cbFilter.getSelectedItem().toString()+"'");
			Rs= St.executeQuery();
			while(Rs.next()) {
				Vector vector = new Vector();
				vector.add(Rs.getString("MaSP"));
				vector.add(Rs.getString("TenSP"));
				vector.add(Rs.getString("TheLoai"));
				vector.add(Rs.getInt("Gia"));
				model.addRow(vector);
			}
			ListSanPham.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e);
		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items();
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
	public Items() {
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
		
		JLabel lblQunLSn_1_1_1 = new JLabel("Quản Lý Sản Phẩm");
		lblQunLSn_1_1_1.setBounds(355, 10, 175, 22);
		lblQunLSn_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1);
		
		JLabel lblQunLSn_1_1_1_1 = new JLabel("Tên:");
		lblQunLSn_1_1_1_1.setBounds(128, 74, 70, 22);
		lblQunLSn_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_1);
		
		txtTen = new JTextField();
		txtTen.setBounds(128, 114, 150, 25);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setBounds(645, 114, 150, 25);
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGia.setColumns(10);
		panel_1.add(txtGia);
		
		JLabel lblQunLSn_1_1_1_1_2 = new JLabel("Giá:");
		lblQunLSn_1_1_1_1_2.setBounds(645, 74, 70, 22);
		lblQunLSn_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_1_2);
		
		JComboBox cbTheLoai = new JComboBox();
		cbTheLoai.setBounds(389, 114, 120, 25);
		cbTheLoai.setModel(new DefaultComboBoxModel(new String[] {"Tình cảm", "Hành động"}));
		cbTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(cbTheLoai);
		
		JLabel lblQunLSn_1_1_1_2 = new JLabel("Thể loại:");
		lblQunLSn_1_1_1_2.setBounds(389, 74, 175, 22);
		lblQunLSn_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_2);
		
		JLabel lblQunLSn_1_1_1_3 = new JLabel("Danh sách sản phẩm");
		lblQunLSn_1_1_1_3.setBounds(355, 238, 250, 22);
		lblQunLSn_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_3);
		
		cbFilter = new JComboBox();
		cbFilter.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				FilterSanPham();
			}
		});
		cbFilter.setBounds(389, 276, 120, 25);
		cbFilter.setModel(new DefaultComboBoxModel(new String[] {"Tình cảm", "Hành động"}));
		cbFilter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(cbFilter);
		
		JLabel lblQunLSn_1_1_1_1_2_1 = new JLabel("Tìm kiếm:");
		lblQunLSn_1_1_1_1_2_1.setBounds(280, 276, 120, 22);
		lblQunLSn_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_1_2_1);
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTen.getText().isEmpty() || txtGia.getText().isEmpty() || cbTheLoai.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(contentPane, "Thiếu thông tin");			
				}else {
					try {
						con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
						PreparedStatement Pst = con.prepareStatement("insert into SanPham values(?,?,?)");
						
						Pst.setString(1, txtTen.getText());
						Pst.setString(2, cbTheLoai.getSelectedItem().toString());
						Pst.setInt(3, Integer.valueOf(txtGia.getText()));
						int row = Pst.executeUpdate()
;	
						JOptionPane.showMessageDialog(contentPane, "Sản phẩm đã được thêm");
						con.close();
						ShowDanhSachSanPham();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, e1);
					}
				}
			}
		});
		btnAdd.setBounds(327, 165, 85, 40);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTen.getText().isEmpty() || txtGia.getText().isEmpty() || cbTheLoai.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(contentPane, "Thiếu thông tin");
				}else {
					try {
						con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
						PreparedStatement Pst = con.prepareStatement("delete from SanPham where MaSP=?");
						Pst.setInt(1, key);   
						int row = Pst.executeUpdate()
;	
						JOptionPane.showMessageDialog(contentPane, "Xóa sản phẩm thành công");
						con.close();
						ShowDanhSachSanPham();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, e1);
					}
				}
			}
		});
		btnDelete.setBounds(458, 165, 85, 40);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnDelete);
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTen.getText().isEmpty() || txtGia.getText().isEmpty() || cbTheLoai.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(contentPane, "Thiếu thông tin");
				}else {
					try {
						con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
						PreparedStatement Pst = con.prepareStatement("update SanPham set TenSP=?,TheLoai=?,Gia=? where MaSP=?");
						Pst.setInt(4, key);
						Pst.setString(1, txtTen.getText());
						Pst.setString(2, cbTheLoai.getSelectedItem().toString());
						Pst.setInt(3, Integer.valueOf(txtGia.getText()));
						int row = Pst.executeUpdate()
;	
						JOptionPane.showMessageDialog(contentPane, "Sửa sản phẩm thành công");
						con.close();
						ShowDanhSachSanPham();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, e1);
					}
				}
			}
		});
		btnEdit.setBounds(578, 165, 85, 40);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnEdit);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 325, 750, 250);
		panel_1.add(scrollPane);
		ListSanPham = new JTable();
		ListSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) ListSanPham.getModel();
				int index = ListSanPham.getSelectedRow();
				key = Integer.valueOf(model.getValueAt(index, 0).toString());
				txtTen.setText(model.getValueAt(index, 1).toString());
				//CbTheLoai.setText(model.getValueAt(index, 2).toString());
				txtGia.setText(model.getValueAt(index, 3).toString());
			}
		});
		scrollPane.setViewportView(ListSanPham);
		ListSanPham.setRowHeight(29);
		ListSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Thể loại", "Giá"
			}
		));
		ListSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDanhSachSanPham();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.setBounds(563, 270, 85, 40);
		panel_1.add(btnReset);
		ShowDanhSachSanPham();
		JLabel lblNewLabel = new JLabel("Sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 75, 129, 40);
		panel.add(lblNewLabel);
		
		JLabel lblMuaHng = new JLabel("Mua hàng");
		lblMuaHng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMuaHng.setBounds(10, 137, 129, 40);
		panel.add(lblMuaHng);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogOut.setBounds(10, 535, 129, 40);
		panel.add(lblLogOut);
	}
}
