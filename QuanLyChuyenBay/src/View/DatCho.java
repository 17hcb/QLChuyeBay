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
import javax.swing.SpinnerNumberModel;


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
					frame.GetData(data);
					frame.LoadData();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DatCho frame = new DatCho();
//					frame.LoadData();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void GetData(String data) {
		 cboMaChuyenBay.removeAllItems();
		 cboMaChuyenBay.addItem(data);
		 cboMaChuyenBay.setSelectedItem(data);
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
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
    
    public void LoadDataComboboxHV(String MaChuyenBay) {
		try {
		
          Connection conn= (Connection) JDBC.getJDBCConnection();
          cboHangVe.removeAllItems();
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
    
    public void LoadDataTable() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="SELECT \r\n" + 
            		"		cb.SoLuongGheHang1 - (select SUM(soluong) FROM tblvedatcho dc WHERE dc.HangVe = 1 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 1', \r\n" + 
              		"		cb.SoLuongGheHang2 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 2 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 2', \r\n" + 
              		"		HBS.SoLuongGheHang3 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 3 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 3',\r\n" + 
              		"        HBS.SoLuongGheHang4 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 4 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 4',\r\n" + 
              		"        HBS.SoLuongGheHang5 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 5 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 5',\r\n" + 
              		"        HBS.SoLuongGheHang6 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 6 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 6', \r\n" + 
              		"        HBS.SoLuongGheHang7 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 7 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 7',\r\n" + 
              		"        HBS.SoLuongGheHang8 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 8 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 8',\r\n" + 
              		"        HBS.SoLuongGheHang9 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 9 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 9',\r\n" + 
              		"        HBS.SoLuongGheHang10 - (select COALESCE(SUM(soluong),0) FROM tblvedatcho dc WHERE dc.HangVe = 10 and dc.MaChuyenBay = cb.MaChuyenBay) as 'Ghe hang 10'\r\n" + 
              		"FROM tblchuyenbay cb\r\n" + 
              		"LEFT JOIN (\r\n" + 
              		"	SELECT hvbs.MaChuyenBay,\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 3 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang3',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 4 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang4',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 5 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang5',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 6 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang6',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 7 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang7',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 8 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang8',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 9 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang9',\r\n" + 
              		"         MAX(CASE WHEN hvbs.STTHangVe = 10 THEN hvbs.SoLuongGhe ELSE 0 END) as 'SoLuongGheHang10'\r\n" + 
              		"	FROM tblhangvebosung hvbs\r\n" + 
              		") HBS on HBS.MaChuyenBay = cb.MaChuyenBay\r\n" + 
              		"WHERE cb.MaChuyenBay = '" + cboMaChuyenBay.getSelectedItem().toString() + "'" +
              		"GROUP BY cb.MaChuyenBay";
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(255, 5, 355, 35);
		contentPane.add(panel);
		
		JLabel lblThngTint = new JLabel("Thông tin đặt chỗ");
		lblThngTint.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThngTint);
		
		JLabel lblNewLabel = new JLabel("Mã chuyến bay");
		lblNewLabel.setBounds(50, 60, 90, 20);
		contentPane.add(lblNewLabel);
		
		cboMaChuyenBay = new JComboBox();
		cboMaChuyenBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cboMaChuyenBay.getSelectedItem() != null)
				{
					MACHUYENBAY = cboMaChuyenBay.getSelectedItem().toString();
			        LoadDataComboboxHV(MACHUYENBAY);
				}
			}
		});
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
						.addAnnotatedClass(DatChoEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					DatChoEntity dc = new DatChoEntity();
					DefaultTableModel dtm = (DefaultTableModel)tblDatCho.getModel(); 
					int available = Integer.parseInt(dtm.getValueAt(0, cboHangVe.getSelectedIndex()).toString());
					if((available - (int)spiSoLuong.getValue()) > 0)
					{
						String machuyenbay = cboMaChuyenBay.getSelectedItem().toString();
						dc.setMaChuyenBay(machuyenbay);
						dc.setIdKhachHang(((ComboboxItem)cboKhachHang.getSelectedItem()).HiddenValue());
						dc.setHangVe(Integer.parseInt(cboHangVe.getSelectedItem().toString()));
						dc.setGiaVe(Integer.parseInt(txtGiaVe.getText().toString()));
						dc.setSoLuong((int)spiSoLuong.getValue());
						if(txtGhiChu.getText().toString().isEmpty())
						{
							dc.setGhiChu("");
						}
						else
						{
							dc.setGhiChu(txtGhiChu.getText().toString());
						}
						dc.setTinhTrang(1);

						session.beginTransaction();
						session.save(dc);		
						session.getTransaction().commit();			
						JOptionPane.showMessageDialog(null, "Đặt chổ thành công !");
						
						LoadDataTable();
						ResetField();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Đã hết vé hạng vé này !");
						return;
					}
				}
				finally {
					factory.close();
				}
			}
		});
		btnDatVe.setBounds(400, 400, 100, 50);
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
		
		spiSoLuong = new JSpinner();
		spiSoLuong.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
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
