package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class MayBay extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaMB;
	private JTextField txtTenMB;
	private JTextField txtThongTin;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MayBay frame = new MayBay();
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
	public MayBay() {
		setTitle("Quản lý máy bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 39);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ MÁY BAY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã máy bay");
		lblNewLabel_1.setBounds(28, 59, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnMyBay = new JLabel("Tên máy bay");
		lblTnMyBay.setBounds(28, 84, 71, 14);
		contentPane.add(lblTnMyBay);
		
		JLabel lblThngTin = new JLabel("Thông tin");
		lblThngTin.setBounds(28, 109, 71, 14);
		contentPane.add(lblThngTin);
		
		txtMaMB = new JTextField();
		txtMaMB.setBounds(115, 56, 194, 20);
		contentPane.add(txtMaMB);
		txtMaMB.setColumns(10);
		
		txtTenMB = new JTextField();
		txtTenMB.setColumns(10);
		txtTenMB.setBounds(115, 81, 194, 20);
		contentPane.add(txtTenMB);
		
		txtThongTin = new JTextField();
		txtThongTin.setColumns(10);
		txtThongTin.setBounds(115, 106, 194, 20);
		contentPane.add(txtThongTin);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(335, 50, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(335, 80, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(335, 105, 89, 23);
		contentPane.add(btnDelete);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 145, 419, 179);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		panel_1.add(table);
	}
}
