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
	private JTextField txtMaKH;
	private JTextField txtKH;
	private JTextField txtHangVe;
	private JTextField txtGiaTien;
	private JTextField txtNgayDat;
	private JTextField txtSBDen;
	private JTextField txtTinhTrangVe;
	private JTextField txtCMND;
	private JTextField txtDienThoai;
	private JTable table;

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
		
		JLabel lblSnBayi = new JLabel("Sân bay đi");
		lblSnBayi.setBounds(46, 88, 81, 14);
		contentPane.add(lblSnBayi);
		
		JLabel lblNgyGi = new JLabel("Ngày giờ");
		lblNgyGi.setBounds(46, 113, 81, 14);
		contentPane.add(lblNgyGi);
		
		Button btnKhachHang = new Button("Mã hành khách");
		btnKhachHang.setBounds(46, 141, 81, 22);
		contentPane.add(btnKhachHang);
		
		JLabel lblTnHnhKhch = new JLabel("Tên hành khách");
		lblTnHnhKhch.setBounds(46, 177, 81, 14);
		contentPane.add(lblTnHnhKhch);
		
		Button btnGiaTien = new Button("Giá tiên");
		btnGiaTien.setBounds(46, 238, 81, 22);
		contentPane.add(btnGiaTien);
		
		Button btnHangVe = new Button("Hang vé");
		btnHangVe.setBounds(46, 206, 81, 22);
		contentPane.add(btnHangVe);
		
		JLabel lblNgyt = new JLabel("Ngày đặt");
		lblNgyt.setBounds(46, 279, 81, 14);
		contentPane.add(lblNgyt);
		
		JComboBox cbMaCB = new JComboBox();
		cbMaCB.setBounds(148, 58, 147, 20);
		contentPane.add(cbMaCB);
		
		txtSBDi = new JTextField();
		txtSBDi.setBounds(148, 85, 147, 20);
		contentPane.add(txtSBDi);
		txtSBDi.setColumns(10);
		
		txtNgayGio = new JTextField();
		txtNgayGio.setColumns(10);
		txtNgayGio.setBounds(148, 110, 147, 20);
		contentPane.add(txtNgayGio);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(148, 141, 147, 20);
		contentPane.add(txtMaKH);
		
		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setBounds(148, 174, 147, 20);
		contentPane.add(txtKH);
		
		txtHangVe = new JTextField();
		txtHangVe.setColumns(10);
		txtHangVe.setBounds(148, 206, 147, 20);
		contentPane.add(txtHangVe);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(148, 238, 147, 20);
		contentPane.add(txtGiaTien);
		
		txtNgayDat = new JTextField();
		txtNgayDat.setColumns(10);
		txtNgayDat.setBounds(148, 276, 147, 20);
		contentPane.add(txtNgayDat);
		
		JLabel lblSnBayn = new JLabel("Sân bay đến");
		lblSnBayn.setBounds(348, 91, 81, 14);
		contentPane.add(lblSnBayn);
		
		JLabel lblTnhTrngV = new JLabel("Tình trạng vé");
		lblTnhTrngV.setBounds(348, 116, 81, 14);
		contentPane.add(lblTnhTrngV);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(348, 144, 81, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(348, 172, 81, 14);
		contentPane.add(lblinThoi);
		
		txtSBDen = new JTextField();
		txtSBDen.setColumns(10);
		txtSBDen.setBounds(426, 88, 147, 20);
		contentPane.add(txtSBDen);
		
		txtTinhTrangVe = new JTextField();
		txtTinhTrangVe.setColumns(10);
		txtTinhTrangVe.setBounds(426, 113, 147, 20);
		contentPane.add(txtTinhTrangVe);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(426, 141, 147, 20);
		contentPane.add(txtCMND);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(426, 169, 147, 20);
		contentPane.add(txtDienThoai);
		
		table = new JTable();
		table.setBounds(347, 206, 246, 173);
		contentPane.add(table);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(25, 344, 89, 35);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(124, 344, 89, 35);
		contentPane.add(btnDelete);
		
		JButton btnCreate = new JButton("Tạo mới");
		btnCreate.setBounds(223, 344, 89, 35);
		contentPane.add(btnCreate);
	}
}
