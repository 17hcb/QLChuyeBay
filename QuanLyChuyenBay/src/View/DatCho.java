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
import javax.swing.JSpinner;


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
	private JTextField txtGhiChu;
	private String MACHUYENBAY;
	private JSpinner spiSoLuong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String data) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatCho frame = new DatCho();
					frame.LoadData();
					frame.GetData(data);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	
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
	
	public void GetData(String data) {
		 cboMaChuyenBay.removeAllItems();
		 cboMaChuyenBay.addItem(data);
		 cboMaChuyenBay.setEditable(false);
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
        	  String maChuyenBay = rs.getString("MaChuyenBay");
        	  cboMaChuyenBay.addItem(maChuyenBay);
          }     
          MACHUYENBAY = "CB002";
          LoadDataComboboxHV(MACHUYENBAY);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
    
    public void LoadDataComboboxHV(String MaChuyenBay) {
		try {
		
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select HangVe from tblgiave where IdChuyenBay ='" + MaChuyenBay +"'";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);	
          while(rs.next())
          {
        	  int hangve = rs.getInt("HangVe");
        	  cboHangVe.addItem(hangve);

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
          String qry="select  vdc.IDDatCho as 'ID', vdc.MaChuyenBay as 'Ma Chuyen Bay', kh.TenKhachHang as 'Ten Khach Hang', kh.CMND as 'CMND', kh.SoDienThoai as 'So Dien Thoai', vdc.HangVe as 'Hang Ve', vdc.GiaVe as 'Gia Tien', vdc.GhiChu as 'Ghi Chu'\r\n" + 
          		"from tblvedatcho vdc\r\n" + 
          		"left join tblkhachhang kh on vdc.IDKhachHang = kh.IDKhachHang";
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
		LoadDataComboboxKH();
		LoadDataComboboxCB();
		LoadDataTable();
	}

	protected void ResetField() {
		// TODO Auto-generated method stub
		cboHangVe.removeAllItems();
		cboKhachHang.removeAllItems();
		cboMaChuyenBay.removeAllItems();
	}

	/**
	 * Create the frame.
	 */
	public DatCho() {
		setTitle("Thông tin đặt chỗ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 869, 35);
		contentPane.add(panel);
		
		JLabel lblThngTint = new JLabel("Thông tin đặt chỗ");
		lblThngTint.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTint);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(50, 60, 80, 20);
		contentPane.add(lblNewLabel);
		
		cboMaChuyenBay = new JComboBox();
		cboMaChuyenBay.setBounds(150, 60, 200, 20);
		contentPane.add(cboMaChuyenBay);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(150, 100, 200, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtGiaVe = new JTextField();
		txtGiaVe.setColumns(10);
		txtGiaVe.setBounds(600, 140, 200, 20);
		contentPane.add(txtGiaVe);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(50, 100, 80, 20);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(500, 100, 80, 20);
		contentPane.add(lblinThoi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(600, 100, 200, 20);
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
					String machuyenbay = cboMaChuyenBay.getSelectedItem().toString();
					dc.setMaChuyenBay(machuyenbay);
					dc.setIdKhachHang(((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue());
					dc.setHangVe(Integer.parseInt(cboHangVe.getSelectedItem().toString()));
					dc.setGiaVe(Integer.parseInt(txtGiaVe.getText().toString()));
					dc.setSoLuong((int)spiSoLuong.getValue());
					dc.setGhiChu(txtGhiChu.getText().toString());
					
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
		btnDatVe.setBounds(300, 400, 100, 50);
		contentPane.add(btnDatVe);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setBounds(500, 60, 85, 20);
		contentPane.add(lblKhchHng);
		
	    cboKhachHang = new JComboBox();
	    cboKhachHang.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {    			    		
	    		if(arg0.getStateChange() == ItemEvent.SELECTED) {
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
	    	}
	    });
		cboKhachHang.setBounds(600, 60, 200, 20);
		contentPane.add(cboKhachHang);
		
		JLabel lblHngV = new JLabel("Hạng vé");
		lblHngV.setBounds(50, 140, 80, 20);
		contentPane.add(lblHngV);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setBounds(500, 140, 80, 20);
		contentPane.add(lblGiTin);
		
		cboHangVe = new JComboBox();
		cboHangVe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					int HangVe = Integer.parseInt(cboHangVe.getSelectedItem().toString());
					try {
						Connection conn= (Connection) JDBC.getJDBCConnection();
			    		 String qry="Select GiaTien from tblgiave where IdChuyenBay = '" + MACHUYENBAY + "' And HangVe = '" + HangVe +"'";
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
			}
		});
		cboHangVe.setBounds(150, 140, 200, 20);
		contentPane.add(cboHangVe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 220, 865, 165);
		contentPane.add(scrollPane);
		
		tblDatCho = new JTable();
		scrollPane.setViewportView(tblDatCho);
		
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
		btnHuyVe.setBounds(600, 400, 100, 50);
		contentPane.add(btnHuyVe);
		
		spiSoLuong = new JSpinner();
		spiSoLuong.setBounds(150, 180, 200, 20);
		contentPane.add(spiSoLuong);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setBounds(600, 180, 200, 20);
		contentPane.add(txtGhiChu);
		txtGhiChu.setColumns(10);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setBounds(500, 180, 80, 20);
		contentPane.add(lblGhiCh);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(50, 180, 80, 20);
		contentPane.add(lblSLng);
	}
}
