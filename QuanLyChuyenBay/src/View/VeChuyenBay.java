package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VeChuyenBay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeChuyenBay frame = new VeChuyenBay();
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
	public VeChuyenBay() {
		setTitle("Vé chuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 600, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Vé chuyến bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chuyến bay");
		lblNewLabel_1.setBounds(21, 60, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSnBayi = new JLabel("Sân bay đi");
		lblSnBayi.setBounds(21, 85, 90, 14);
		contentPane.add(lblSnBayi);
		
		JLabel lblNgyGi = new JLabel("Ngày giờ");
		lblNgyGi.setBounds(21, 110, 90, 14);
		contentPane.add(lblNgyGi);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setBounds(21, 166, 90, 14);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setBounds(21, 218, 90, 14);
		contentPane.add(lblGiTin);
		
		JLabel lblSnBayn = new JLabel("Sân bay đến");
		lblSnBayn.setBounds(347, 91, 90, 14);
		contentPane.add(lblSnBayn);
		
		JLabel lblTnhTrngV = new JLabel("Tình trạng vé");
		lblTnhTrngV.setBounds(347, 116, 90, 14);
		contentPane.add(lblTnhTrngV);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(347, 141, 90, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(347, 166, 90, 14);
		contentPane.add(lblinThoi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(168, 60, 137, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(168, 85, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 110, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 135, 137, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(168, 160, 137, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(447, 85, 137, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(168, 215, 137, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(447, 110, 137, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(447, 138, 137, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(447, 163, 137, 20);
		contentPane.add(textField_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 188, 137, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Mã khách hàng");
		btnNewButton.setBounds(21, 132, 131, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHngV = new JButton("Hạng vé");
		btnHngV.setBounds(21, 187, 131, 23);
		contentPane.add(btnHngV);
		
		JButton btnThmMi = new JButton("Thêm mới");
		btnThmMi.setBounds(63, 272, 115, 44);
		contentPane.add(btnThmMi);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setBounds(229, 272, 115, 44);
		contentPane.add(btnLu);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setBounds(404, 272, 103, 44);
		contentPane.add(btnThot);
	}
}
