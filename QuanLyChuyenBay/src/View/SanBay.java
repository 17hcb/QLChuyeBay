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

public class SanBay extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSB;
	private JTextField txtTenSB;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanBay frame = new SanBay();
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
	public SanBay() {
		setTitle("Quản lý sân bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 39);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Quản lý sân bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sân bay");
		lblNewLabel_1.setBounds(41, 70, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnSnBay = new JLabel("Tên sân bay");
		lblTnSnBay.setBounds(41, 95, 77, 14);
		contentPane.add(lblTnSnBay);
		
		txtMaSB = new JTextField();
		txtMaSB.setBounds(128, 67, 159, 20);
		contentPane.add(txtMaSB);
		txtMaSB.setColumns(10);
		
		txtTenSB = new JTextField();
		txtTenSB.setColumns(10);
		txtTenSB.setBounds(128, 92, 159, 20);
		contentPane.add(txtTenSB);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(318, 66, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(318, 91, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(318, 117, 89, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(5, 157, 419, 104);
		contentPane.add(table);
	}

}
