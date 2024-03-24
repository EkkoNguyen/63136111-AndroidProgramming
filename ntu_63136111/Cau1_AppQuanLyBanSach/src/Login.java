import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTK;
	Connection con = null;
	PreparedStatement St = null, St1 = null;
	ResultSet Rs = null, Rs1 = null;
	private JPasswordField txtMK;
	
	public void login() {
		new Items().setVisible(true);
		this.setVisible(false);
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(10, 10, 522, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(220, 20, 88, 29);
		panel.add(lblNewLabel);
		
		JLabel lblTiKhon = new JLabel("Tài khoản:");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTiKhon.setBounds(70, 146, 136, 29);
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMtKhu.setBounds(70, 209, 114, 29);
		contentPane.add(lblMtKhu);
		
		txtTK = new JTextField();
		txtTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTK.setBounds(213, 144, 228, 43);
		contentPane.add(txtTK);
		txtTK.setColumns(10);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(txtTK.getText().isEmpty() || txtMK.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa nhập tài khoản hoặc mật khẩu");
				}else{
					try {
						con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true");
						St = con.prepareStatement("select * from TaiKhoan where TaiKhoan = '"+txtTK.getText().toString()+"' and MatKhau = '"+txtMK.getText().toString()+"'");
						Rs= St.executeQuery();
						if(Rs.next()) {
							login();
							JOptionPane.showMessageDialog(contentPane, "Login thành công");
						}else {
							JOptionPane.showMessageDialog(contentPane, "Tài khoản hoặc mật khẩu không đúng");
							txtMK.setText("");
							txtTK.setText("");
						}
					} catch (SQLException e1) {
						
					}				
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(184, 283, 167, 43);
		contentPane.add(btnLogin);
		
		txtMK = new JPasswordField();
		txtMK.setBounds(213, 209, 228, 39);
		contentPane.add(txtMK);
	}
}
