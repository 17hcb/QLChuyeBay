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
import Entity.ChuyenBayEntity;
import Entity.GiaVeEntity;
import Entity.SanBayEntity;
import Entity.SanBayTrungGianEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private JTextField txt_GiaTien;
	private static JTable table;
	private JTextField textField;
	private static JComboBox cbb_HangVe;
	private static JComboBox cbb_MaChuyenBay;
	private JTextField txtSBDi;
	private JTextField txtSBDen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gia frame = new Gia();
					LoadDataHangVe();
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
          String qry="select cb.MaChuyenBay as 'Ma Chuyen Bay', sb1.tensanbay as 'Ten San Bay Di', sb2.tensanbay as 'Ten San Bay Den', gv.HangVe as 'Hang Ve', gv.GiaTien as 'Gia Tien'\r\n" + 
          		"from tblchuyenbay cb\r\n" + 
          		"join tblsanbay sb1 on sb1.IdSanBay = cb.MaSanBayDi\r\n" + 
          		"join tblsanbay sb2 on sb2.IdSanBay = cb.MaSanBayDen\r\n" + 
          		"join tblgiave gv on gv.Idchuyenbay = cb.MaChuyenBay";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataComboboxHV(String MaChuyenBay) {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          cbb_HangVe.removeAllItems();
          // prepare combobox
          String qry="Select HangVe from tblgiave where IdChuyenBay ='" + MaChuyenBay +"'";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);	
          while(rs.next())
          {
        	  int hangve = rs.getInt("HangVe");
        	  cbb_HangVe.addItem(hangve);

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
			  String qry="select * from tblchuyenbay";
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				  String maCB  = rs.getString("MaChuyenBay");
				  cbb_MaChuyenBay.addItem(maCB);
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public Integer getIdGiaVe(String idChuyenBay,String hangVe) {
		int idGiaVe = 0;
		try {
			  Connection conn= (Connection) JDBC.getJDBCConnection();
			  String qry="select IdGiaVe\r\n" + 
		          		"from tblgiave gv \r\n" + 
		          		"where gv.IdChuyenBay = '" + idChuyenBay +"'\r\n"+
		          		"and gv.HangVe = '" +  hangVe +"'";
			  Statement st= conn.createStatement();
			  ResultSet rs= st.executeQuery(qry);
			  while(rs.next()) {
				  idGiaVe  = rs.getInt("IdGiaVe");
			  }  
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}	
		return idGiaVe;
	}
	
	public void UpdateGiaVe() {

		
		if (txt_GiaTien.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập giá tiền");
			return;
		}
		else
		{
		     SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(GiaVeEntity.class)
						.buildSessionFactory();
			 Session session = factory.getCurrentSession();
			try {
				//set data
				GiaVeEntity giave = new GiaVeEntity();
				
				
				int idgiave = getIdGiaVe(cbb_MaChuyenBay.getSelectedItem().toString(),cbb_HangVe.getSelectedItem().toString());
				
				giave.setIdGiaVe(idgiave);
				giave.setIdChuyenBay(cbb_MaChuyenBay.getSelectedItem().toString());
				giave.setHangVe(Integer.parseInt(cbb_HangVe.getSelectedItem().toString()));
				giave.setGiaTien(Integer.parseInt(txt_GiaTien.getText().toString()));
				
				
				session.beginTransaction();
				
				session.update(giave);
				
				session.getTransaction().commit();
				
				JOptionPane.showMessageDialog(null, "Cập nhật giá vé thành công !");
				
				LoadDataHangVe();
			}
			finally {
				factory.close();
			}
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
		panel.setBounds(5, 5, 425, 35);
		contentPane.add(panel);
		
		JLabel lblThngTinGi = new JLabel("Thông tin giá vé");
		lblThngTinGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTinGi);
		
		JLabel lblNewLabel = new JLabel("Sân bay đi");
		lblNewLabel.setBounds(30, 95, 90, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblMHngV = new JLabel("Hạng vé");
		lblMHngV.setBounds(30, 170, 90, 15);
		contentPane.add(lblMHngV);
		
		JLabel lblGi = new JLabel("Giá tiền");
		lblGi.setBounds(30, 210, 90, 15);
		contentPane.add(lblGi);
		
		txt_GiaTien = new JTextField();
		txt_GiaTien.setBounds(130, 210, 210, 20);
		contentPane.add(txt_GiaTien);
		txt_GiaTien.setColumns(10);
		
		cbb_HangVe = new JComboBox();
		cbb_HangVe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
			          Connection conn= (Connection) JDBC.getJDBCConnection();
			          // prepare 
			          String qry="select GiaTIen\r\n" + 
			          		"from tblchuyenbay cb \r\n" + 
			          		"join tblgiave gv on cb.MaChuyenBay = gv.IdChuyenBay\r\n" + 
			          		"where cb.MaChuyenBay = '" + cbb_MaChuyenBay.getSelectedItem().toString() +"'\r\n"+
			          		"and gv.HangVe = '" +  cbb_HangVe.getSelectedItem().toString() +"'";
			          Statement st= conn.createStatement();
			          ResultSet rs= st.executeQuery(qry);	
			          while(rs.next())
			          {
			        	  String giave  = rs.getString("GiaTIen");
			        	  txt_GiaTien.setText(giave);
			          }     
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}	
			}
		});
		cbb_HangVe.setBounds(130, 170, 260, 20);
		contentPane.add(cbb_HangVe);
		
		cbb_MaChuyenBay = new JComboBox();
		cbb_MaChuyenBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cbb_MaChuyenBay.getSelectedItem().toString() != null)
				{
				LoadDataComboboxHV(cbb_MaChuyenBay.getSelectedItem().toString());
				try {
			          Connection conn= (Connection) JDBC.getJDBCConnection();
			          // prepare 
			          String qry="select tbl1.TenSanBay as 'SanBayDi',tbl2.TenSanBay as 'SanBayDen' \r\n" + 
			          		"from tblchuyenbay cb \r\n" + 
			          		"join tblsanbay tbl1 ON cb.MaSanBayDi = tbl1.IdSanBay\r\n" + 
			          		"join tblsanbay tbl2 ON cb.MaSanBayDen = tbl2.IdSanBay\r\n" + 
			          		"where cb.MaChuyenBay = '" +  cbb_MaChuyenBay.getSelectedItem().toString() +"'";
			          Statement st= conn.createStatement();
			          ResultSet rs= st.executeQuery(qry);	
			          while(rs.next())
			          {
			        	  String sbDi  = rs.getString("SanBayDi");
			        	  String sbDen = rs.getString("SanBayDen");
			        	  txtSBDi.setText(sbDi);
			        	  txtSBDen.setText(sbDen);
			        	  txtSBDi.setEditable(false);
			        	  txtSBDen.setEditable(false);
			          }     
					}
						catch (Exception e)
						{
							e.printStackTrace();
						}	
					}
				}
		});
		cbb_MaChuyenBay.setBounds(130, 65, 260, 20);
		contentPane.add(cbb_MaChuyenBay);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UpdateGiaVe();
			}
		});
		btnUpdate.setBounds(170, 240, 106, 40);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(439, 113, 436, 170);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JLabel label = new JLabel("Tìm Kiếm");
		label.setBounds(440, 70, 85, 20);
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
		textField.setBounds(505, 70, 370, 20);
		contentPane.add(textField);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(439, 5, 434, 39);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách giá vé");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchSn);
		
		JLabel lblChuynBayn = new JLabel("Sân bay đến");
		lblChuynBayn.setBounds(30, 130, 90, 15);
		contentPane.add(lblChuynBayn);
		
		JLabel lblVn = new JLabel("VNĐ");
		lblVn.setBounds(355, 215, 35, 15);
		contentPane.add(lblVn);
		
		txtSBDi = new JTextField();
		txtSBDi.setColumns(10);
		txtSBDi.setBounds(130, 95, 260, 20);
		contentPane.add(txtSBDi);
		
		txtSBDen = new JTextField();
		txtSBDen.setColumns(10);
		txtSBDen.setBounds(130, 130, 260, 20);
		contentPane.add(txtSBDen);
		
		JLabel lblMChuynBay = new JLabel("Mã chuyến bay");
		lblMChuynBay.setBounds(30, 65, 90, 15);
		contentPane.add(lblMChuynBay);
	}
}
