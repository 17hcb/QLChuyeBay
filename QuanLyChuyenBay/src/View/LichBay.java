package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class LichBay extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaCB;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LichBay frame = new LichBay();
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
	public LichBay() {
		setTitle("Lịch bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 495, 35);
		contentPane.add(panel);
		
		JLabel lblLchBay = new JLabel("Lịch bay");
		lblLchBay.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblLchBay);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(31, 61, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyGi = new JLabel("Ngày giờ");
		lblNgyGi.setBounds(31, 149, 89, 14);
		contentPane.add(lblNgyGi);
		
		JLabel lblThiGianBay = new JLabel("Thời gian bay");
		lblThiGianBay.setBounds(31, 174, 89, 14);
		contentPane.add(lblThiGianBay);
		
		JLabel lblSLngHng = new JLabel("Số lượng hàng ghế 1");
		lblSLngHng.setBounds(31, 198, 135, 14);
		contentPane.add(lblSLngHng);
		
		JLabel lblSLngHng_1 = new JLabel("Số lượng hàng ghế 2");
		lblSLngHng_1.setBounds(31, 221, 135, 14);
		contentPane.add(lblSLngHng_1);
		
		JButton btnNewButton = new JButton("Sân bay đi");
		btnNewButton.setBounds(31, 81, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSnBayn = new JButton("Sân bay đến");
		btnSnBayn.setBounds(31, 115, 105, 23);
		contentPane.add(btnSnBayn);
		
		JButton btnMMyBay = new JButton("Mã máy bay");
		btnMMyBay.setBounds(31, 246, 105, 23);
		contentPane.add(btnMMyBay);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(359, 61, 89, 36);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(359, 108, 89, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(359, 163, 89, 31);
		contentPane.add(btnDelete);
		
		txtMaCB = new JTextField();
		txtMaCB.setBounds(159, 61, 161, 20);
		contentPane.add(txtMaCB);
		txtMaCB.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 149, 161, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 174, 161, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 198, 161, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 221, 161, 20);
		contentPane.add(textField_4);
		
		JComboBox cbSBDi = new JComboBox();
		cbSBDi.setBounds(159, 85, 161, 20);
		contentPane.add(cbSBDi);
		
		JComboBox cbSBDen = new JComboBox();
		cbSBDen.setBounds(159, 119, 161, 20);
		contentPane.add(cbSBDen);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(159, 250, 161, 20);
		contentPane.add(comboBox_2);
		
		table = new JTable();
		table.setBounds(10, 281, 490, 114);
		contentPane.add(table);
	}
}
