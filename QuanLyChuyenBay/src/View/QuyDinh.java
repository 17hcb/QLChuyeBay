package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.GiaVeEntity;
import Entity.QuyDinhEntity;
import JDBC.JDBC;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuyDinh extends JFrame {

	private JPanel contentPane;
	private JTextField txtTgBay;
	private JTextField txtTrungGian;
	private JTextField txtDungToiThieu;
	private JTextField txtDungToiDa;
	private JTextField txtDatVe;
	private JTextField txtHuyDatVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuyDinh frame = new QuyDinh();
					frame.LoadDataQuyDinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void LoadDataQuyDinh() {
		try {
			  Connection conn= (Connection) JDBC.getJDBCConnection();
			  String qry="select * from tblquydinh";
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				txtTgBay.setText(rs.getString("TgBayToiThieu"));
				txtTrungGian.setText(rs.getString("SanBayTrungGianToiDa"));
				txtDungToiThieu.setText(rs.getString("ThoiGianDungToiThieu"));
				txtDungToiDa.setText(rs.getString("ThoiGianDungToiDa"));
				txtDatVe.setText(rs.getString("ThoiGianChamNhatDatVe"));
				txtHuyDatVe.setText(rs.getString("ThoiGianChamNhatHuyDatVe"));
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	public void CapNhatQuyDinh() {
		if (txtTgBay.getText().isEmpty() || txtTrungGian.getText().isEmpty() || txtDungToiThieu.getText().isEmpty() ||txtDungToiDa.getText().isEmpty() || txtDatVe.getText().isEmpty() ||txtHuyDatVe.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
			return;
		}
		else
		{
		     SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(QuyDinhEntity.class)
						.buildSessionFactory();
			 Session session = factory.getCurrentSession();
			try {
				//set data
				QuyDinhEntity rule = new QuyDinhEntity();
				
				rule.setMasterkey(1);
				rule.setTgBayToiThieu(Integer.parseInt(txtTgBay.getText().toString()));
				rule.setSanBayTrungGianToiDa(Integer.parseInt(txtTrungGian.getText().toString()));
				rule.setThoiGianDungToiThieu(Integer.parseInt(txtDungToiThieu.getText().toString()));
				rule.setThoiGianDungToiDa(Integer.parseInt(txtDungToiDa.getText().toString()));
				rule.setThoiGianChamNhatDatVe(Integer.parseInt(txtDatVe.getText().toString()));
				rule.setThoiGianChamNhatHuyDatVe(Integer.parseInt(txtHuyDatVe.getText().toString()));
				
				session.beginTransaction();
				
				session.update(rule);
				
				session.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "Cập nhật quy định thành công !");

			}
			finally {
				factory.close();
			}
		}
	}
	/**
	 * Create the frame.
	 */
	public QuyDinh() {
		setTitle("Quy định");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(138, 5, 201, 35);
		contentPane.add(panel);
		
		JLabel lblQunLQuy = new JLabel("Quản lý quy định");
		lblQunLQuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblQunLQuy);
		
		JLabel lblThiGianBay = new JLabel("Thời gian bay tối thiểu");
		lblThiGianBay.setBounds(30, 60, 165, 20);
		contentPane.add(lblThiGianBay);
		
		JLabel lblSTrungGian = new JLabel("Số trung gian bay tối đa");
		lblSTrungGian.setBounds(30, 90, 165, 20);
		contentPane.add(lblSTrungGian);
		
		JLabel lblThiGianDng = new JLabel("Thời gian dừng tối thiểu");
		lblThiGianDng.setBounds(30, 120, 165, 20);
		contentPane.add(lblThiGianDng);
		
		JLabel lblThiGianDng_1 = new JLabel("Thời gian dừng tối đa");
		lblThiGianDng_1.setBounds(30, 150, 165, 20);
		contentPane.add(lblThiGianDng_1);
		
		JLabel lblThiGianChm = new JLabel("Thời gian chậm nhất đặt vé");
		lblThiGianChm.setBounds(30, 180, 165, 20);
		contentPane.add(lblThiGianChm);
		
		txtTgBay = new JTextField();
		txtTgBay.setBounds(220, 60, 100, 20);
		contentPane.add(txtTgBay);
		txtTgBay.setColumns(10);
		
		txtTrungGian = new JTextField();
		txtTrungGian.setColumns(10);
		txtTrungGian.setBounds(220, 90, 100, 20);
		contentPane.add(txtTrungGian);
		
		txtDungToiThieu = new JTextField();
		txtDungToiThieu.setColumns(10);
		txtDungToiThieu.setBounds(220, 120, 100, 20);
		contentPane.add(txtDungToiThieu);
		
		txtDungToiDa = new JTextField();
		txtDungToiDa.setColumns(10);
		txtDungToiDa.setBounds(220, 150, 100, 20);
		contentPane.add(txtDungToiDa);
		
		txtDatVe = new JTextField();
		txtDatVe.setColumns(10);
		txtDatVe.setBounds(220, 180, 100, 20);
		contentPane.add(txtDatVe);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CapNhatQuyDinh();
			}
		});
		btnUpdate.setBounds(65, 255, 100, 30);
		contentPane.add(btnUpdate);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(220, 255, 100, 30);
		contentPane.add(btnThoat);
		
		JLabel lblThiGianChm_1 = new JLabel("Thời gian chậm nhất hủy đặt vé");
		lblThiGianChm_1.setBounds(30, 210, 180, 20);
		contentPane.add(lblThiGianChm_1);
		
		txtHuyDatVe = new JTextField();
		txtHuyDatVe.setColumns(10);
		txtHuyDatVe.setBounds(220, 210, 100, 20);
		contentPane.add(txtHuyDatVe);
		
		JLabel lblPht = new JLabel("phút");
		lblPht.setBounds(350, 60, 80, 20);
		contentPane.add(lblPht);
		
		JLabel lblChuyn = new JLabel("chuyến");
		lblChuyn.setBounds(350, 90, 80, 20);
		contentPane.add(lblChuyn);
		
		JLabel label_1 = new JLabel("phút");
		label_1.setBounds(350, 120, 80, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("phút");
		label_2.setBounds(350, 150, 80, 20);
		contentPane.add(label_2);
		
		JLabel lblNgy = new JLabel("ngày");
		lblNgy.setBounds(350, 183, 80, 20);
		contentPane.add(lblNgy);
		
		JLabel lblNgy_1 = new JLabel("ngày");
		lblNgy_1.setBounds(350, 213, 80, 20);
		contentPane.add(lblNgy_1);
	}
}
