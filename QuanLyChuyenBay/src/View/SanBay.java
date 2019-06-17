package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTable;

import Entity.SanBayEntity;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SanBay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2578826657314100197L;
	private JPanel contentPane;
	private JTextField txtMaSB;
	private JTextField txtTenSB;
	private JTextField txtThongTin;
	private JTextField textsearch;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanBay frame = new SanBay();
					LoadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void LoadData() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select IdSanBay as 'ID', MaSanBay as 'Ma San Bay', TenSanBay as 'Ten San Bay', ThongTin as 'Thong Tin' from tblsanbay";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void ResetField() {
		try {
			 txtMaSB.setText("");
			 txtTenSB.setText("");
			 txtThongTin.setText("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Create the frame.
	 */
	public SanBay() {
		setTitle("Quản lý sân bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(77, 33, 295, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin sân bay");
		lblNewLabel.setBounds(26, 11, 224, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblTnSnBay = new JLabel("Tên điểm đến");
		lblTnSnBay.setBounds(41, 178, 77, 14);
		contentPane.add(lblTnSnBay);
		
		txtMaSB = new JTextField();
		txtMaSB.setBounds(128, 128, 159, 20);
		contentPane.add(txtMaSB);
		txtMaSB.setColumns(10);
		
		txtTenSB = new JTextField();
		txtTenSB.setColumns(10);
		txtTenSB.setBounds(128, 175, 159, 20);
		contentPane.add(txtTenSB);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtMaSB.getText().isEmpty() && txtTenSB.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				} else {
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(SanBayEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						SanBayEntity emp = new SanBayEntity();
						emp.setMaSanBay(txtMaSB.getText());
						emp.setTenSanBay(txtTenSB.getText());
						emp.setThongTin(txtThongTin.getText());
						
						session.beginTransaction();
						
						session.save(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã thêm sân bay thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnAdd.setBounds(318, 127, 111, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sân bay cần cập nhật!");
					return;
				}
				
				if (txtMaSB.getText().isEmpty() && txtTenSB.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				}
				
				int index = table.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
			    int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(SanBayEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					SanBayEntity emp = new SanBayEntity();
					emp.setIdSanBay(id);
					emp.setMaSanBay(txtMaSB.getText());
					emp.setTenSanBay(txtTenSB.getText());
					emp.setThongTin(txtThongTin.getText());
					
					session.beginTransaction();
					
					session.saveOrUpdate(emp);
					
					session.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, "Đã cập nhật sân bay thành công !");
					LoadData();
			        ResetField();
				} finally {
					factory.close();
				}
			}
		});
		btnUpdate.setBounds(318, 171, 111, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				} else {
					 int index = table.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
				     int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				     SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(SanBayEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						SanBayEntity emp = new SanBayEntity();
						emp.setIdSanBay(id);
						
						session.beginTransaction();
						
						session.delete(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa sân bay thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnDelete.setBounds(318, 216, 111, 23);
		contentPane.add(btnDelete);
		
		JLabel lblThngTin = new JLabel("Ghi chú");
		lblThngTin.setBounds(41, 219, 77, 14);
		contentPane.add(lblThngTin);
		
		txtThongTin = new JTextField();
		txtThongTin.setColumns(10);
		txtThongTin.setBounds(128, 216, 159, 20);
		contentPane.add(txtThongTin);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(454, 44, 434, 39);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách sân bay");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchSn);
		
		JLabel label = new JLabel("Tìm Kiếm");
		label.setBounds(454, 109, 85, 20);
		contentPane.add(label);
		
		textsearch = new JTextField();
		textsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel());
				table.setRowSorter(sorter);
				
				sorter.setRowFilter(RowFilter.regexFilter(textsearch.getText().trim()));
			}
		});
		textsearch.setColumns(10);
		textsearch.setBounds(548, 109, 340, 20);
		contentPane.add(textsearch);
		
		JButton button = new JButton("LÀM MỚI");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetField();
			}
		});
		button.setBounds(318, 262, 111, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(454, 148, 434, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("Tên sân bay");
		label_1.setBounds(41, 131, 77, 14);
		contentPane.add(label_1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					 int index = table.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
				     txtMaSB.setText(dtm.getValueAt(index, 1).toString());
					 txtTenSB.setText(dtm.getValueAt(index, 2).toString());
					 txtThongTin.setText(dtm.getValueAt(index, 3).toString());  					 
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
	}
}
