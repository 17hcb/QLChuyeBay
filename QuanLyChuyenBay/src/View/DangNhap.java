package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
				if(true) {
					Main frmMain = new Main();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Đăng nhập không thành công");
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
