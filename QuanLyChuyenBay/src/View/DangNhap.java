package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JDBC.JDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDN;
	private JPasswordField txtPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 44, 118, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhu.setBounds(28, 82, 118, 20);
		contentPane.add(lblMtKhu);
		
		txtTenDN = new JTextField();
		txtTenDN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenDN.setBounds(158, 44, 204, 20);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);
		
		txtPW = new JPasswordField();
		txtPW.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPW.setBounds(158, 82, 204, 20);
		contentPane.add(txtPW);
		
		JButton btnDN = new JButton("Đăng nhập");
		btnDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTenDN.getText().isEmpty() || txtPW.getPassword().length == 0)
				{
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu trống !");
					return;
				} 
				else {
					String myuser = txtTenDN.getText().toString();
					String mypass = new String(txtPW.getPassword());
					try {
						  Connection conn= (Connection) JDBC.getJDBCConnection();
						  String qry="select * from tbltaikhoan";
						  Statement st= conn.createStatement();
						  ResultSet rs= st.executeQuery(qry);
						  while(rs.next()) {
							if(myuser.equals(rs.getString("username")) && mypass.equals(rs.getString("password")))
							{
								Main frmMain = new Main(rs.getInt("type"));
								setVisible(false);
								dispose();
								return;
							}
						  }  
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}	
					
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác !");
					return;
				}
			}
		});
		btnDN.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDN.setBounds(47, 138, 136, 41);
		contentPane.add(btnDN);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThoat.setBounds(253, 138, 136, 41);
		contentPane.add(btnThoat);
	}
}
