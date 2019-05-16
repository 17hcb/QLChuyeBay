package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class DatCho extends JFrame {

	private JPanel contentPane;
	private JTextField txtSBDi;
	private JTextField txtNgayGio;
	private JTextField txtSBDen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatCho frame = new DatCho();
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
	public DatCho() {
		setTitle("Thông tin đặt chỗ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 593, 35);
		contentPane.add(panel);
		
		JLabel lblThngTint = new JLabel("Thông tin đặt chỗ");
		lblThngTint.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTint);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(46, 61, 81, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox cbMaCB = new JComboBox();
		cbMaCB.setBounds(148, 58, 147, 20);
		contentPane.add(cbMaCB);
		
		txtSBDi = new JTextField();
		txtSBDi.setBounds(148, 85, 147, 20);
		contentPane.add(txtSBDi);
		txtSBDi.setColumns(10);
		
		txtNgayGio = new JTextField();
		txtNgayGio.setColumns(10);
		txtNgayGio.setBounds(426, 116, 147, 20);
		contentPane.add(txtNgayGio);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(46, 88, 81, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(348, 88, 81, 14);
		contentPane.add(lblinThoi);
		
		txtSBDen = new JTextField();
		txtSBDen.setColumns(10);
		txtSBDen.setBounds(426, 88, 147, 20);
		contentPane.add(txtSBDen);
		
		JButton btnAdd = new JButton("Đặt vé");
		btnAdd.setBounds(278, 169, 102, 54);
		contentPane.add(btnAdd);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setBounds(348, 61, 81, 14);
		contentPane.add(lblKhchHng);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(426, 58, 147, 20);
		contentPane.add(comboBox);
		
		JLabel lblHngV = new JLabel("Hạng vé");
		lblHngV.setBounds(46, 113, 81, 14);
		contentPane.add(lblHngV);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setBounds(348, 119, 81, 14);
		contentPane.add(lblGiTin);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(148, 116, 147, 20);
		contentPane.add(comboBox_1);
	}
}
