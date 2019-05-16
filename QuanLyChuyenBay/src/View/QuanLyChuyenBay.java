package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class QuanLyChuyenBay extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTuyenBay;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTable table_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyChuyenBay frame = new QuanLyChuyenBay();
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
	public QuanLyChuyenBay() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 869, 39);
		contentPane.add(panel);
		
		JLabel lblQunLTuyn = new JLabel("QUẢN LÝ CHUYẾN BAY");
		lblQunLTuyn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblQunLTuyn);
		
		JLabel lblMTuynBay = new JLabel("Mã tuyến bay");
		lblMTuynBay.setBounds(59, 63, 93, 14);
		contentPane.add(lblMTuynBay);
		
		JLabel lblTnSnBay = new JLabel("Tên sân bay đến");
		lblTnSnBay.setBounds(488, 94, 105, 14);
		contentPane.add(lblTnSnBay);
		
		JLabel lblTnSnBay_1 = new JLabel("Tên sân bay đi");
		lblTnSnBay_1.setBounds(59, 94, 93, 14);
		contentPane.add(lblTnSnBay_1);
		
		txtMaTuyenBay = new JTextField();
		txtMaTuyenBay.setBounds(188, 60, 215, 20);
		contentPane.add(txtMaTuyenBay);
		txtMaTuyenBay.setColumns(10);
		
		JComboBox cbTenSBDen = new JComboBox();
		cbTenSBDen.setBounds(603, 91, 215, 20);
		contentPane.add(cbTenSBDen);
		
		JComboBox cbTenSBDi = new JComboBox();
		cbTenSBDi.setBounds(188, 91, 215, 20);
		contentPane.add(cbTenSBDi);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(188, 630, 105, 40);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(357, 630, 105, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(510, 630, 105, 40);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(188, 202, 630, 125);
		contentPane.add(table);
		
		JLabel lblNgyGi = new JLabel("Ngày-giờ");
		lblNgyGi.setBounds(59, 119, 93, 14);
		contentPane.add(lblNgyGi);
		
		JLabel lblThiGianBay = new JLabel("Thời gian bay");
		lblThiGianBay.setBounds(488, 119, 105, 14);
		contentPane.add(lblThiGianBay);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(603, 116, 215, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 116, 215, 20);
		contentPane.add(textField_1);
		
		JLabel lblSLngGh = new JLabel("Số lượng ghế hạng 1");
		lblSLngGh.setBounds(59, 144, 114, 14);
		contentPane.add(lblSLngGh);
		
		JLabel lblSLngGh_1 = new JLabel("Số lượng ghế hạng 2");
		lblSLngGh_1.setBounds(488, 144, 105, 14);
		contentPane.add(lblSLngGh_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 144, 215, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(603, 144, 215, 20);
		contentPane.add(textField_3);
		
		JLabel lblSnBayTrung = new JLabel("Sân bay trung gian");
		lblSnBayTrung.setBounds(59, 169, 114, 22);
		contentPane.add(lblSnBayTrung);
		
		JButton btnThmSnBay = new JButton("Thêm sân bay trung gian");
		btnThmSnBay.setBounds(5, 202, 173, 23);
		contentPane.add(btnThmSnBay);
		
		JButton btnXaSnBay = new JButton("Xóa sân bay trung gian");
		btnXaSnBay.setBounds(5, 236, 173, 23);
		contentPane.add(btnXaSnBay);
		
		JLabel lblThiGianDng = new JLabel("Thời gian dừng");
		lblThiGianDng.setBounds(488, 169, 86, 14);
		contentPane.add(lblThiGianDng);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(603, 170, 215, 20);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 171, 215, 20);
		contentPane.add(comboBox);
		
		table_1 = new JTable();
		table_1.setBounds(5, 378, 869, 228);
		contentPane.add(table_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(188, 347, 630, 20);
		contentPane.add(textField_4);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setBounds(113, 345, 60, 22);
		contentPane.add(lblTmKim);
		
		JButton btnThitLpLi = new JButton("Thiết lập lại");
		btnThitLpLi.setBounds(664, 630, 105, 40);
		contentPane.add(btnThitLpLi);
	}
}
