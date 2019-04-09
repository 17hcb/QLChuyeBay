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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class Gia extends JFrame {

	private JPanel contentPane;
	private JTextField txtGia;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gia frame = new Gia();
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
	public Gia() {
		setTitle("Thông tin giá");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblThngTinGi = new JLabel("Thông tin giá");
		lblThngTinGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTinGi);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(30, 66, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMHngV = new JLabel("Mã hạng vé");
		lblMHngV.setBounds(30, 93, 90, 14);
		contentPane.add(lblMHngV);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setBounds(30, 118, 90, 14);
		contentPane.add(lblGi);
		
		txtGia = new JTextField();
		txtGia.setBounds(130, 115, 149, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JComboBox cbMaHV = new JComboBox();
		cbMaHV.setBounds(130, 90, 149, 20);
		contentPane.add(cbMaHV);
		
		JComboBox cbMaCB = new JComboBox();
		cbMaCB.setBounds(130, 63, 149, 20);
		contentPane.add(cbMaCB);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(318, 62, 106, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(318, 89, 106, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(318, 114, 106, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(5, 150, 419, 133);
		contentPane.add(table);
	}

}
