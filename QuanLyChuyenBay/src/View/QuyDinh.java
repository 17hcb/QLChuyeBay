package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class QuyDinh extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaxBay;
	private JTextField txtMaxTrungGian;
	private JTextField txtMinDung;
	private JTextField txtMaxDung;
	private JTextField txtMinDatVe;
	private JTextField txtMinHuyVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuyDinh frame = new QuyDinh();
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
	public QuyDinh() {
		setTitle("Quy định");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblQunLQuy = new JLabel("Quản lý quy định");
		lblQunLQuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblQunLQuy);
		
		JLabel lblThiGianBay = new JLabel("Thời gian bay tối thiểu");
		lblThiGianBay.setBounds(27, 65, 165, 14);
		contentPane.add(lblThiGianBay);
		
		JLabel lblSTrungGian = new JLabel("Số trung gian bay tối đa");
		lblSTrungGian.setBounds(27, 91, 165, 14);
		contentPane.add(lblSTrungGian);
		
		JLabel lblThiGianDng = new JLabel("Thời gian dừng tối thiểu");
		lblThiGianDng.setBounds(27, 116, 165, 14);
		contentPane.add(lblThiGianDng);
		
		JLabel lblThiGianDng_1 = new JLabel("Thời gian dừng tối đa");
		lblThiGianDng_1.setBounds(27, 141, 165, 14);
		contentPane.add(lblThiGianDng_1);
		
		JLabel lblThiGianChm = new JLabel("Thời gian chậm nhất đặt vé");
		lblThiGianChm.setBounds(27, 166, 165, 14);
		contentPane.add(lblThiGianChm);
		
		JLabel lblThiGianChm_1 = new JLabel("Thời gian chậm nhất hủy vé");
		lblThiGianChm_1.setBounds(27, 191, 165, 14);
		contentPane.add(lblThiGianChm_1);
		
		txtMaxBay = new JTextField();
		txtMaxBay.setBounds(228, 62, 86, 20);
		contentPane.add(txtMaxBay);
		txtMaxBay.setColumns(10);
		
		txtMaxTrungGian = new JTextField();
		txtMaxTrungGian.setColumns(10);
		txtMaxTrungGian.setBounds(228, 88, 86, 20);
		contentPane.add(txtMaxTrungGian);
		
		txtMinDung = new JTextField();
		txtMinDung.setColumns(10);
		txtMinDung.setBounds(228, 113, 86, 20);
		contentPane.add(txtMinDung);
		
		txtMaxDung = new JTextField();
		txtMaxDung.setColumns(10);
		txtMaxDung.setBounds(228, 138, 86, 20);
		contentPane.add(txtMaxDung);
		
		txtMinDatVe = new JTextField();
		txtMinDatVe.setColumns(10);
		txtMinDatVe.setBounds(228, 163, 86, 20);
		contentPane.add(txtMinDatVe);
		
		txtMinHuyVe = new JTextField();
		txtMinHuyVe.setColumns(10);
		txtMinHuyVe.setBounds(228, 188, 86, 20);
		contentPane.add(txtMinHuyVe);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(53, 227, 100, 23);
		contentPane.add(btnUpdate);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(203, 227, 100, 23);
		contentPane.add(btnThoat);
	}

}
