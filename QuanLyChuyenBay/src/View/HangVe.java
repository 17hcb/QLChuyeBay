package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class HangVe extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHangVe;
	private JTextField txtTenHangVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangVe frame = new HangVe();
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
	public HangVe() {
		setTitle("Quản lý hạng vé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("HẠNG VÉ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hạng vé");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 65, 126, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMHngV = new JLabel("Mã hạng vé");
		lblMHngV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMHngV.setBounds(45, 102, 126, 27);
		contentPane.add(lblMHngV);
		
		JLabel lblTnHngV = new JLabel("Tên hạng vé");
		lblTnHngV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnHngV.setBounds(45, 140, 126, 26);
		contentPane.add(lblTnHngV);
		
		txtMaHangVe = new JTextField();
		txtMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaHangVe.setColumns(10);
		txtMaHangVe.setBounds(168, 102, 178, 26);
		contentPane.add(txtMaHangVe);
		
		txtTenHangVe = new JTextField();
		txtTenHangVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenHangVe.setColumns(10);
		txtTenHangVe.setBounds(168, 140, 178, 26);
		contentPane.add(txtTenHangVe);
		
		JComboBox cbHangVe = new JComboBox();
		cbHangVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbHangVe.setBounds(168, 65, 178, 26);
		contentPane.add(cbHangVe);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(29, 194, 114, 26);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(168, 194, 105, 26);
		contentPane.add(btnUpdate);
		
		JButton btmDelete = new JButton("Xóa");
		btmDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btmDelete.setBounds(304, 194, 105, 26);
		contentPane.add(btmDelete);
	}
}
