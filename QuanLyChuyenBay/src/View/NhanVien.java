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
import javax.swing.JTable;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtDienThoai;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
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
	public NhanVien() {
		setTitle("Quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(195, 10, 253, 32);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setBounds(25, 69, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setBounds(320, 69, 92, 14);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(25, 100, 70, 14);
		contentPane.add(lblinThoi);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(320, 100, 70, 14);
		contentPane.add(lblaCh);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(123, 63, 171, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(123, 94, 171, 20);
		contentPane.add(txtDienThoai);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(444, 63, 169, 20);
		contentPane.add(txtTenNV);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(444, 94, 169, 20);
		contentPane.add(txtDiaChi);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(122, 140, 105, 32);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(267, 140, 89, 32);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(412, 140, 89, 32);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(10, 203, 619, 230);
		contentPane.add(table);
	}

}
