package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ComboboxItem.ComboboxItem;
import Entity.DatChoEntity;
import Entity.KhachHangEntity;
import Entity.MayBayEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DatCho extends JFrame {
	
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTextField txtCMND;
	private JTextField txtGiaVe;
	private JTextField txtSoDienThoai;
	private static JTable tblDatCho;
	private JComboBox cboKhachHang;
	private JComboBox cboHangVe;
	private JComboBox cboMaChuyenBay;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatCho frame = new DatCho();
					frame.LoadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    public void LoadDataComboboxKH() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from tblkhachhang";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int idKhachHang = rs.getInt("IDKhachHang");
        	  String tenKhachHang  = rs.getString("TenKhachHang");
        	  cboKhachHang.addItem(new ComboboxItem(tenKhachHang, idKhachHang));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

    
    public void LoadDataComboboxCB() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from tblchuyenbay";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int idMaChuyenBay = rs.getInt("MaChuyenBay");
        	  String tenMaChuyenBay  = rs.getString("MaChuyenBay");
        	  cboMaChuyenBay.addItem(new ComboboxItem(tenMaChuyenBay, idMaChuyenBay));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
    
    public void LoadDataComboboxHV() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          int MaChuyenBay = ((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue();
          // prepare combobox
          String qry="Select HangVe from tblgiave where MaChuyenBay =" + MaChuyenBay ;;
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);	
          while(rs.next())
          {
        	  int hangve = rs.getInt("HangVe");
        	  String strhangve  = rs.getString("HangVe");
        	  cboHangVe.addItem(new ComboboxItem(strhangve, hangve));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
    public static void LoadDataTable() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select d.IDDatCho as 'ID', d.MaChuyenBay as 'Ma Chuyen Bay', k.TenKhachHang as 'Ten Khach Hang'"
          			+ ", k.CMND as 'CMND', k.SoDienThoai as 'So Dien Thoai', g.HangVe as 'Hang Ve', g.GiaTien as 'Gia Tien' "
        		  	+ "from tbldatcho d "
        		  	+ "left join tblkhachhang k on d.IDKhachHang = k.IDKhachHang "
        		  	+ "left join tblgiave g on g.MaChuyenBay = d.MaChuyenBay and g.HangVe = d.HangVe ";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          tblDatCho.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
	protected void LoadData() {
		// TODO Auto-generated method stub
		//LoadDataCombobox(cboMaChuyenBay, "tblchuyenbay", "MaChuyenBay", "MaChuyenBay");
		LoadDataComboboxKH();
		LoadDataComboboxCB();
		//LoadDataComboboxHV();
		LoadDataTable();
	}

	protected void ResetField() {
		// TODO Auto-generated method stub
		cboHangVe.removeAllItems();
		cboKhachHang.removeAllItems();
		cboMaChuyenBay.removeAllItems();
		LoadDataComboboxHV();
	}

	/**
	 * Create the frame.
	 */
	public DatCho() {
		setTitle("Thông tin đặt chỗ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 593, 35);
		contentPane.add(panel);
		
		JLabel lblThngTint = new JLabel("Thông tin đặt chỗ");
		lblThngTint.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTint);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(46, 61, 81, 14);
		contentPane.add(lblNewLabel);
		
		cboMaChuyenBay = new JComboBox();
		cboMaChuyenBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cboHangVe.removeAllItems();
				LoadDataComboboxHV();
			}
		});
		cboMaChuyenBay.setBounds(148, 58, 147, 20);
		contentPane.add(cboMaChuyenBay);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(148, 85, 147, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtGiaVe = new JTextField();
		txtGiaVe.setColumns(10);
		txtGiaVe.setBounds(426, 116, 147, 20);
		contentPane.add(txtGiaVe);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(46, 88, 81, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(348, 88, 81, 14);
		contentPane.add(lblinThoi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(426, 88, 147, 20);
		contentPane.add(txtSoDienThoai);
		
		JButton btnDatVe = new JButton("Đặt vé");
		btnDatVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save();				
			}

			private void Save() {
				// TODO Auto-generated method stub		
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(KhachHangEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					DatChoEntity dc = new DatChoEntity();
					String machuyenbay = ((ComboboxItem)cboMaChuyenBay.getSelectedItem()).toString();
					dc.setMaChuyenBay(machuyenbay);
					dc.setIdKhachHang(((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue());
					dc.setHangVe(((ComboboxItem)cboHangVe.getSelectedItem()).HiddenValue());
					session.beginTransaction();
					session.save(dc);		
					session.getTransaction().commit();			
					JOptionPane.showMessageDialog(null, "Đặt chổ thành công !");
					LoadDataTable();
					ResetField();
				}
				finally {
					factory.close();
				}
			}
		});
		btnDatVe.setBounds(114, 154, 102, 54);
		contentPane.add(btnDatVe);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setBounds(348, 61, 81, 14);
		contentPane.add(lblKhchHng);
		
	    cboKhachHang = new JComboBox();
	    cboKhachHang.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {    		
	    		int idKhachHang = ((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue();
	    		
	    		try {
		    		Connection conn= (Connection) JDBC.getJDBCConnection();
		    		 String qry="Select * from tblkhachhang where IDKhachHang = " + idKhachHang ;
		             Statement st= conn.createStatement();
		             ResultSet rs= st.executeQuery(qry);
		             while(rs.next())
		             {
		           	  txtCMND.setText(rs.getString("CMND"));
		           	  txtSoDienThoai.setText(rs.getString("SoDienThoai"));
		             }     
	    		}
	    		catch (Exception e) {
					// TODO: handle exception
	    			e.printStackTrace();
				}
	    	}
	    });
		cboKhachHang.setBounds(426, 58, 147, 20);
		contentPane.add(cboKhachHang);
		
		JLabel lblHngV = new JLabel("Hạng vé");
		lblHngV.setBounds(46, 113, 81, 14);
		contentPane.add(lblHngV);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setBounds(348, 119, 81, 14);
		contentPane.add(lblGiTin);
		
		cboHangVe = new JComboBox();
		cboHangVe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int HangVe = ((ComboboxItem)cboHangVe.getSelectedItem()).HiddenValue();
				int MaChuyenBay = ((ComboboxItem)cboMaChuyenBay.getSelectedItem()).HiddenValue();
				try {
					Connection conn= (Connection) JDBC.getJDBCConnection();
		    		 String qry="Select GiaTien from tblgiave where MaChuyenBay = " + MaChuyenBay + " And HangVe = " + HangVe ;
		             Statement st= conn.createStatement();
		             ResultSet rs= st.executeQuery(qry);
		             while(rs.next())
		             {
		           	  txtGiaVe.setText(rs.getString("GiaTien"));		           
		             }     
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		cboHangVe.setBounds(148, 116, 147, 20);
		contentPane.add(cboHangVe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 583, 160);
		contentPane.add(scrollPane);
		
		tblDatCho = new JTable();
		scrollPane.setViewportView(tblDatCho);
		
		JButton btnThayDoiVe = new JButton("Thay đổi vé");
		btnThayDoiVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblDatCho.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn máy bay cần cập nhật!");
					return;
				}
				int index = tblDatCho.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tblDatCho.getModel(); 
			    int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(KhachHangEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					DatChoEntity dc = new DatChoEntity();
					
					String machuyenbay = ((ComboboxItem)cboMaChuyenBay.getSelectedItem()).toString();
					dc.setIdDatCho(id);
					dc.setMaChuyenBay(machuyenbay);
					dc.setIdKhachHang(((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue());
					dc.setHangVe(((ComboboxItem)cboHangVe.getSelectedItem()).HiddenValue());
					session.beginTransaction();
					
					session.saveOrUpdate(dc);
					
					session.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, "Cập nhật đặt chổ thành công !");
					LoadData();
			        ResetField();
				}
				finally {
					factory.close();
				}
			}
		});
		btnThayDoiVe.setBounds(264, 154, 102, 54);
		contentPane.add(btnThayDoiVe);
		
		JButton btnHuyVe = new JButton("Hủy vé");
		btnHuyVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblDatCho.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				}
				else
				{
					 int index = tblDatCho.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tblDatCho.getModel(); 
				     int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(KhachHangEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						DatChoEntity dc = new DatChoEntity();
						dc.setIdDatCho(id);
						
						session.beginTransaction();
						
						session.delete(dc);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa đặt chổ thành công !");
						LoadData();
						ResetField();
					}
					finally {
						factory.close();
					}
				}
			}


		});
		btnHuyVe.setBounds(412, 154, 102, 54);
		contentPane.add(btnHuyVe);
	}
}
