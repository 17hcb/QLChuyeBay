package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.KhachHangEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class KhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -106450264968318044L;
	
	private JPanel contentPane;
	private JTextField txtCMND;
	private JTextField txtTenKH;
	private JTextField txtDT;
	private static JTable tblKhachHang;

	/**
	 * Launch the application.
	 */
	
	public static void LoadData() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select IDKhachHang as 'ID', CMND as 'CMND', TenKhachHang as 'Ten khach hang', SoDienThoai as 'So dien thoai' from tblKhachHang";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          tblKhachHang.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void ResetField() {
		try {
			 txtCMND.setText("");
			 txtTenKH.setText("");
			 txtDT.setText("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
					LoadData();
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
	public KhachHang() {
		setTitle("KHÁCH HÀNG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 889, 35);
		contentPane.add(panel);
		
		JLabel lblKhchHng = new JLabel("KHÁCH HÀNG");
		lblKhchHng.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblKhchHng);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(25, 88, 107, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblTnKhchHng = new JLabel("TÊN KHÁCH HÀNG");
		lblTnKhchHng.setBounds(25, 140, 124, 14);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblinThoi = new JLabel("SỐ ĐIỆN THOẠI");
		lblinThoi.setBounds(25, 193, 124, 14);
		contentPane.add(lblinThoi);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(155, 85, 146, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(155, 137, 146, 20);
		contentPane.add(txtTenKH);
		
		txtDT = new JTextField();
		txtDT.setColumns(10);
		txtDT.setBounds(155, 190, 146, 20);
		contentPane.add(txtDT);
		
		JButton btnAdd = new JButton("THÊM");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtCMND.getText().isEmpty() && txtTenKH.getText().isEmpty()&& txtDT.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				}
				else
				{
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(KhachHangEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						KhachHangEntity emp = new KhachHangEntity();
						emp.setCmnd(txtCMND.getText());
						emp.setTenKhachHang(txtTenKH.getText());
						emp.setSoDienThoai(txtDT.getText());
						
						session.beginTransaction();
						
						session.save(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnAdd.setBounds(337, 84, 100, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("CẬP NHẬT");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tblKhachHang.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần cập nhật!");
					return;
				}
				if (txtCMND.getText().isEmpty() && txtTenKH.getText().isEmpty()&& txtDT.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				}
				int index = tblKhachHang.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tblKhachHang.getModel(); 
			    int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(KhachHangEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					KhachHangEntity emp = new KhachHangEntity();
					emp.setIdKhachHang(id);
					emp.setCmnd(txtCMND.getText());
					emp.setTenKhachHang(txtTenKH.getText());
					emp.setSoDienThoai(txtDT.getText());
					
					session.beginTransaction();
					
					session.saveOrUpdate(emp);
					
					session.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, "Đã cập nhật khách hàng thành công !");
					LoadData();
			        ResetField();
				}
				finally {
					factory.close();
				}
			}
		});
		btnUpdate.setBounds(337, 189, 100, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("XÓA");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tblKhachHang.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				}
				else
				{
					 int index = tblKhachHang.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tblKhachHang.getModel(); 
				     int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(KhachHangEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						KhachHangEntity emp = new KhachHangEntity();
						emp.setIdKhachHang(id);
						
						session.beginTransaction();
						
						session.delete(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa khách hàng thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnDelete.setBounds(337, 136, 100, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 int index = tblKhachHang.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tblKhachHang.getModel(); 
				     txtCMND.setText(dtm.getValueAt(index, 1).toString());
					 txtTenKH.setText(dtm.getValueAt(index, 2).toString());
					 txtDT.setText(dtm.getValueAt(index, 3).toString());  
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollPane.setBounds(458, 85, 436, 243);
		contentPane.add(scrollPane);
		
		tblKhachHang = new JTable();
		tblKhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblKhachHang);
		
		JButton btnLam = new JButton("LÀM MỚI");
		btnLam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetField();
			}
		});
		btnLam.setBounds(337, 236, 100, 23);
		contentPane.add(btnLam);
	}
}
