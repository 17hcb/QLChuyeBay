package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.KhachHangEntity;
import Entity.MayBayEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MayBay extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaMB;
	private static JTextField txtTenMB;
	private static JTextField txtThongTin;
	private static JTable tblMayBay;
	private static JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	
	public static void LoadData() {
		// TODO Auto-generated method stub
		try {
	          Connection conn= (Connection) JDBC.getJDBCConnection();
	          String qry="select IDMayBay as 'IDMayBay' ,MaMayBay as 'Mã máy bay', TenMayBay as 'Tên máy bay', ThongTin as 'Thông tin' from tblmaybay";
	          Statement st= conn.createStatement();
	          ResultSet rs= st.executeQuery(qry);
	          
	          tblMayBay.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	
	private static void ResetField() {
		// TODO Auto-generated method stub
		try {
			 txtMaMB.setText("");
			 txtTenMB.setText("");
			 txtThongTin.setText("");
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
					MayBay frame = new MayBay();
					//LoadData
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
	public MayBay() {
		setTitle("Quản lý máy bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(137, 2, 328, 48);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ MÁY BAY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã máy bay");
		lblNewLabel_1.setBounds(54, 59, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnMyBay = new JLabel("Tên máy bay");
		lblTnMyBay.setBounds(54, 84, 71, 14);
		contentPane.add(lblTnMyBay);
		
		JLabel lblThngTin = new JLabel("Thông tin");
		lblThngTin.setBounds(54, 107, 71, 20);
		contentPane.add(lblThngTin);
		
		txtMaMB = new JTextField();
		txtMaMB.setBounds(154, 56, 361, 20);
		contentPane.add(txtMaMB);
		txtMaMB.setColumns(10);
		
		txtTenMB = new JTextField();
		txtTenMB.setColumns(10);
		txtTenMB.setBounds(154, 81, 361, 20);
		contentPane.add(txtTenMB);
		
		txtThongTin = new JTextField();
		txtThongTin.setColumns(10);
		txtThongTin.setBounds(154, 106, 361, 23);
		contentPane.add(txtThongTin);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Save();			
			}

			private void Save() {
				// TODO Auto-generated method stub
				if (txtMaMB.getText().isEmpty() && txtTenMB.getText().isEmpty()&& txtThongTin.getText().isEmpty())
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
						MayBayEntity mb = new MayBayEntity();
						mb.setMaMayBay(txtMaMB.getText());
						mb.setTenMayBay(txtTenMB.getText());
						mb.setThongTin(txtThongTin.getText());
						
						session.beginTransaction();
						
						session.save(mb);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã thêm máy bay thành công !");
						LoadData();
						ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnAdd.setBounds(184, 140, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblMayBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn máy bay cần cập nhật!");
					return;
				}
				if (txtMaMB.getText().isEmpty() && txtTenMB.getText().isEmpty()&& txtThongTin.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				}
				int index = tblMayBay.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tblMayBay.getModel(); 
			    int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(KhachHangEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					MayBayEntity mb = new MayBayEntity();
					mb.setIdMayBay(id);
					mb.setMaMayBay(txtMaMB.getText());
					mb.setTenMayBay(txtTenMB.getText());
					mb.setThongTin(txtThongTin.getText());
					
					session.beginTransaction();
					
					session.saveOrUpdate(mb);
					
					session.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, "Đã cập nhật máy bay thành công !");
					LoadData();
			        ResetField();
				}
				finally {
					factory.close();
				}
			}
		});
		btnUpdate.setBounds(305, 140, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblMayBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				}
				else
				{
					 int index = tblMayBay.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tblMayBay.getModel(); 
				     int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(KhachHangEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						MayBayEntity mb = new MayBayEntity();
						mb.setIdMayBay(id);
						
						session.beginTransaction();
						
						session.delete(mb);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa máy bay thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnDelete.setBounds(426, 140, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResetField();
			}


		});
		btnLamMoi.setBounds(54, 138, 89, 23);
		contentPane.add(btnLamMoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 564, 184);
		contentPane.add(scrollPane);
		
		tblMayBay = new JTable();
		scrollPane.setViewportView(tblMayBay);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setBounds(54, 182, 71, 20);
		contentPane.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel)tblMayBay.getModel());
				tblMayBay.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText().trim()));
			}
		});
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(154, 181, 361, 23);
		contentPane.add(txtTimKiem);
	}
}
