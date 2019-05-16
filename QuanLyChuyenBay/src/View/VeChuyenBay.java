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
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField;
	private JTextField textField_2;

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
		lblSnBayi.setBounds(21, 141, 90, 14);
		contentPane.add(lblSnBayi);
		
		JLabel lblNgyGi = new JLabel("Ngày giờ");
		lblNgyGi.setBounds(21, 172, 90, 14);
		contentPane.add(lblNgyGi);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setBounds(347, 116, 90, 14);
		contentPane.add(lblGiTin);
		
		JLabel lblSnBayn = new JLabel("Sân bay đến");
		lblSnBayn.setBounds(347, 141, 90, 14);
		contentPane.add(lblSnBayn);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(21, 85, 90, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(347, 85, 90, 14);
		contentPane.add(lblinThoi);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 113, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(168, 169, 137, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(447, 110, 137, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(168, 82, 137, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(447, 82, 137, 20);
		contentPane.add(textField_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(447, 138, 137, 20);
		contentPane.add(comboBox_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(168, 57, 137, 20);
		contentPane.add(textField_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(168, 138, 137, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setBounds(347, 60, 90, 14);
		contentPane.add(lblKhchHng);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(447, 57, 137, 20);
		contentPane.add(textField);
		
		JLabel lblHngV = new JLabel("Hạng vé");
		lblHngV.setBounds(21, 116, 90, 14);
		contentPane.add(lblHngV);
		
		JLabel lblSGh = new JLabel("Số ghế");
		lblSGh.setBounds(347, 172, 90, 14);
		contentPane.add(lblSGh);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(447, 169, 137, 20);
		contentPane.add(textField_2);
	}
}
