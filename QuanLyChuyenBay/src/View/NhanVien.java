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
		setBounds(100, 100, 537, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 506, 32);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setBounds(24, 53, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setBounds(270, 53, 92, 14);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(24, 78, 70, 14);
		contentPane.add(lblinThoi);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(270, 78, 70, 14);
		contentPane.add(lblaCh);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(122, 47, 131, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(122, 72, 131, 20);
		contentPane.add(txtDienThoai);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(364, 47, 131, 20);
		contentPane.add(txtTenNV);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(364, 72, 131, 20);
		contentPane.add(txtDiaChi);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(60, 114, 105, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(205, 114, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(350, 114, 89, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(5, 156, 506, 163);
		contentPane.add(table);
	}

}
