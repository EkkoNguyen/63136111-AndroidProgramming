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
import java.awt.event.ActionEvent;

public class Items extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTable itemList;
	
	Connection con = null;
	Statement St = null;
	ResultSet Rs = null;

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
		cbTheLoai.setBounds(389, 114, 100, 25);
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
		
		JComboBox cbThe = new JComboBox();
		cbThe.setBounds(389, 276, 100, 25);
		cbThe.setModel(new DefaultComboBoxModel(new String[] {"Tình cảm", "Hành động"}));
		cbThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(cbThe);
		
		JLabel lblQunLSn_1_1_1_1_2_1 = new JLabel("Tìm kiếm:");
		lblQunLSn_1_1_1_1_2_1.setBounds(280, 276, 120, 22);
		lblQunLSn_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblQunLSn_1_1_1_1_2_1);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setBounds(327, 165, 85, 40);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(458, 165, 85, 40);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnDelete);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setBounds(578, 165, 85, 40);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnEdit);
		
		JTable SanPhamList = new JTable();
		SanPhamList.setBounds(40, 325, 750, 250);
		SanPhamList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SanPhamList.setRowHeight(29);
		SanPhamList.setModel(new DefaultTableModel(
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
		panel_1.add(SanPhamList);
		
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
