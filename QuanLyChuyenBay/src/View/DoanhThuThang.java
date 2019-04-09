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
import java.awt.Button;

public class DoanhThuThang extends JFrame {

	private JPanel contentPane;
	private JTextField txtThang;
	private JTextField txtNam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThuThang frame = new DoanhThuThang();
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
	public DoanhThuThang() {
		setTitle("Doanh thu tháng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblThngKDoanh = new JLabel("Thống kê doanh thu tháng");
		lblThngKDoanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngKDoanh);
		
		JLabel lblNewLabel = new JLabel("Tháng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 66, 72, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNm.setBounds(209, 66, 45, 19);
		contentPane.add(lblNm);
		
		txtThang = new JTextField();
		txtThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtThang.setBounds(115, 66, 72, 20);
		contentPane.add(txtThang);
		txtThang.setColumns(10);
		
		txtNam = new JTextField();
		txtNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNam.setColumns(10);
		txtNam.setBounds(264, 67, 72, 20);
		contentPane.add(txtNam);
		
		Button btnBaoCao = new Button("Báo cáo");
		btnBaoCao.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBaoCao.setBounds(97, 120, 90, 35);
		contentPane.add(btnBaoCao);
		
		Button btnThoat = new Button("Thoát");
		btnThoat.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnThoat.setBounds(235, 120, 90, 35);
		contentPane.add(btnThoat);
	}

}
