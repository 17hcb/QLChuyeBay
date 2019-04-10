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

public class TuyenBay extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTuyenBay;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TuyenBay frame = new TuyenBay();
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
	public TuyenBay() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 543, 39);
		contentPane.add(panel);
		
		JLabel lblQunLTuyn = new JLabel("QUẢN LÝ TUYẾN BAY");
		lblQunLTuyn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblQunLTuyn);
		
		JLabel lblMTuynBay = new JLabel("Mã tuyến bay");
		lblMTuynBay.setBounds(48, 69, 93, 14);
		contentPane.add(lblMTuynBay);
		
		JLabel lblTnSnBay = new JLabel("Tên sân bay đến");
		lblTnSnBay.setBounds(48, 95, 93, 14);
		contentPane.add(lblTnSnBay);
		
		JLabel lblTnSnBay_1 = new JLabel("Tên sân bay đi");
		lblTnSnBay_1.setBounds(48, 120, 93, 14);
		contentPane.add(lblTnSnBay_1);
		
		txtMaTuyenBay = new JTextField();
		txtMaTuyenBay.setBounds(151, 66, 215, 20);
		contentPane.add(txtMaTuyenBay);
		txtMaTuyenBay.setColumns(10);
		
		JComboBox cbTenSBDen = new JComboBox();
		cbTenSBDen.setBounds(151, 92, 215, 20);
		contentPane.add(cbTenSBDen);
		
		JComboBox cbTenSBDi = new JComboBox();
		cbTenSBDi.setBounds(151, 117, 215, 20);
		contentPane.add(cbTenSBDi);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(415, 65, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(415, 91, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(415, 116, 89, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(10, 162, 533, 229);
		contentPane.add(table);
	}
}
