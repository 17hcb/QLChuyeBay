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

import ComboboxItem.ComboboxItem;
import Entity.GiaVeEntity;
import Entity.SanBayEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gia extends JFrame implements Serializable {

	private JPanel contentPane;
	private JTextField txtGia;
	private static JTable table;
	private JTextField textField;
	private static JComboBox cbMaHV;
	private static JComboBox cbMaCB;
	private static JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gia frame = new Gia();
					LoadDataHangVe();
					LoadDataComboboxHV();
					
					LoadDataChuyenBay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void LoadDataHangVe() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select sb1.tensanbay as 'Ten San Bay Di', sb2.tensanbay as 'Ten San Bay Den', hv.tenhangve as 'Hang Ve', gv.giatien as 'Gia Tien'\r\n" + 
          		"from sanbay sb1 \r\n" + 
          		"			join chuyenbay cb on sb1.id = cb.idsanbaydi\r\n" + 
          		"			join sanbay sb2 on sb2.id = cb.idsanbayden\r\n" + 
          		"			join giave gv on gv.idchuyenbay = cb.idchuyenbay\r\n" + 
          		"			join hangve hv on hv.id = gv.hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataComboboxHV() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int id = rs.getInt("id");
        	  String tenHV  = rs.getString("tenhangve");
        	  cbMaHV.addItem(new ComboboxItem(tenHV, id));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataChuyenBay() {
		try {
			  Connection conn= (Connection) JDBC.getJDBCConnection();
			  String qry="select * from sanbay";
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				  int id = rs.getInt("id");
				  String tenHV  = rs.getString("tensanbay");
				  cbMaCB.addItem(new ComboboxItem(tenHV, id));
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataChuyenBayDi() {
		try {
			  Connection conn= (Connection) JDBC.getJDBCConnection();
			  String qry="select cb.idsanbaydi, sb.tensanbay from sanbay sb join chuyenbay cb on sb.id = cb.idsanbaydi";
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				  int id = rs.getInt("idsanbaydi");
				  String tenHV  = rs.getString("tensanbay");
				  cbMaCB.addItem(new ComboboxItem(tenHV, id));
			
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataChuyenBayDen() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select sb.tensanbay as 'Ten San Bay', sb.tendiemden as 'Ten Diem Den', hv.tenhangve as 'Ten Hang Ve', gv.giatien as 'Gia Tien' from sanbay sb join giave gv on sb.id = gv.idchuyenbay join hangve hv on hv.id = gv.hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataChuyenBayDenWithItem(int item) {
		try {
			  Connection conn= (Connection) JDBC.getJDBCConnection();
			  String qry="Select * from chuyenbay cb join sanbay sb on cb.idsanbayden = sb.id where idsanbaydi = " + item;
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				  int id = rs.getInt("idsanbayden");
				  String tenHV  = rs.getString("tensanbay");
				  comboBox.addItem(new ComboboxItem(tenHV, id));
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Gia() {
		setTitle("Thông tin giá");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblThngTinGi = new JLabel("Thông tin giá vé");
		lblThngTinGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTinGi);
		
		JLabel lblNewLabel = new JLabel("Sân bay đi");
		lblNewLabel.setBounds(30, 66, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMHngV = new JLabel("Hạng vé");
		lblMHngV.setBounds(30, 128, 90, 14);
		contentPane.add(lblMHngV);
		
		JLabel lblGi = new JLabel("Giá tiền");
		lblGi.setBounds(30, 166, 90, 14);
		contentPane.add(lblGi);
		
		txtGia = new JTextField();
		txtGia.setBounds(130, 163, 211, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		cbMaHV = new JComboBox();
		cbMaHV.setBounds(130, 125, 259, 20);
		contentPane.add(cbMaHV);
		
		cbMaCB = new JComboBox();
		cbMaCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					comboBox.removeAllItems();
					int idSBDi = ((ComboboxItem)cbMaCB.getSelectedItem()).HiddenValue();
					LoadDataChuyenBayDenWithItem(idSBDi);
				}
			}
		});
		cbMaCB.setBounds(130, 63, 259, 20);
		contentPane.add(cbMaCB);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idSBDi = ((ComboboxItem)cbMaCB.getSelectedItem()).HiddenValue();
				int idSBDen = ((ComboboxItem)comboBox.getSelectedItem()).HiddenValue();
				int hangve =  ((ComboboxItem)cbMaHV.getSelectedItem()).HiddenValue();
				try {
			          Connection conn= (Connection) JDBC.getJDBCConnection();
			          String qry="select count(*) as total \r\n" + 
			          		"from chuyenbay cb join giave gv on cb.idchuyenbay = gv.idchuyenbay join hangve hv on gv.hangve = hv.id\r\n" + 
			          		"where cb.idsanbaydi = " + idSBDi + " and cb.idsanbayden = " + idSBDen +" and hv.id = " + hangve;
			          Statement st= conn.createStatement();
			          ResultSet rs= st.executeQuery(qry);
			          rs.next();
			          if(rs.getInt("total") > 0) {
			        	  JOptionPane.showMessageDialog(null, "Giá vé đã tồn tại. Vui lòng chỉnh sửa!");
			        	  return;
			          } if(txtGia.getText().isEmpty()) {
			        	  JOptionPane.showMessageDialog(null, "Vui lòng nhập giá tiền!");
							return;
			          } else {
			        	  
			        	  String qry1="select cb.idchuyenbay as result \r\n" + 
					          		"from chuyenbay cb where cb.idsanbaydi = " + idSBDi + " and cb.idsanbayden = " + idSBDen;
				          ResultSet rs1= st.executeQuery(qry1);
			        	  SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(GiaVeEntity.class)
									.buildSessionFactory();
							Session session = factory.getCurrentSession();
							
							try {
								while(rs1.next())
								{
									GiaVeEntity dc = new GiaVeEntity();
									int idchuyenbay1 = rs1.getInt("result");
									dc.setIdChuyenBay(idchuyenbay1);
									dc.setHangVe(hangve);
									dc.setGiaTien(Integer.parseInt(txtGia.getText()));
									session.beginTransaction();
									session.save(dc);		
									session.getTransaction().commit();			
									JOptionPane.showMessageDialog(null, "Thêm giá vé thành công !");
									LoadDataHangVe();
									break;
								}
								
							}
							finally {
								factory.close();
							}
			          }
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}	
			}
		});
		btnAdd.setBounds(30, 208, 106, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(165, 208, 106, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idSBDi = ((ComboboxItem)cbMaCB.getSelectedItem()).HiddenValue();
				int idSBDen = ((ComboboxItem)comboBox.getSelectedItem()).HiddenValue();
				int hangve =  ((ComboboxItem)cbMaHV.getSelectedItem()).HiddenValue();
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(GiaVeEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				
				String qry1="select cb.idchuyenbay as result \r\n" + 
		          		"from chuyenbay cb where cb.idsanbaydi = " + idSBDi + " and cb.idsanbayden = " + idSBDen;
				
				try {
					Connection conn= (Connection) JDBC.getJDBCConnection();
					Statement st1;
					try {
						st1 = conn.createStatement();
						ResultSet rs1= st1.executeQuery(qry1);
						while(rs1.next())
						{
							GiaVeEntity dc = new GiaVeEntity();
							int idchuyenbay1 = rs1.getInt("result");
							dc.setIdChuyenBay(idchuyenbay1);
							dc.setHangVe(hangve);
							session.beginTransaction();
							session.delete(dc);		
							session.getTransaction().commit();			
							JOptionPane.showMessageDialog(null, "Đã xóa giá vé thành công !");
							LoadDataHangVe();
							break;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				finally {
					LoadDataHangVe();
					factory.close();
				}
			}
		});
		btnDelete.setBounds(307, 208, 106, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					 int index = table.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
//				     txtMaSB.setText(dtm.getValueAt(index, 1).toString());
//					 txtTenSB.setText(dtm.getValueAt(index, 2).toString());
					 txtGia.setText(dtm.getValueAt(index, 3).toString());  					 
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollPane_1.setBounds(434, 113, 439, 170);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JLabel label = new JLabel("Tìm Kiếm");
		label.setBounds(439, 70, 85, 20);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel());
				table.setRowSorter(sorter);
				
				sorter.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
			}
		});
		textField.setColumns(10);
		textField.setBounds(533, 70, 340, 20);
		contentPane.add(textField);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(439, 5, 434, 39);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách giá vé");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchSn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(130, 94, 259, 20);
		contentPane.add(comboBox);
		
		JLabel lblChuynBayn = new JLabel("Sân bay đến");
		lblChuynBayn.setBounds(30, 94, 90, 14);
		contentPane.add(lblChuynBayn);
		
		JLabel lblVn = new JLabel("VNĐ");
		lblVn.setBounds(351, 166, 37, 14);
		contentPane.add(lblVn);
	}
}
