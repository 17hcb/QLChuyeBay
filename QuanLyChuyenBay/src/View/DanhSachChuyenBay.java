package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.toedter.calendar.JDateChooser;

import ComboboxItem.ComboboxItem;
import Entity.ChuyenBayEntity;
import Entity.SanBayTrungGianEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DanhSachChuyenBay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable tbl_ChuyenBay;
	private int qd_NgayDatVe = 0;
	private int qd_NgayHuyVe = 0;
   
    
    public void LoadDataChuyenBay() {
    	  // prepare table view
    	try {
            Connection conn= (Connection) JDBC.getJDBCConnection();
            String qry = "SELECT cb.MaChuyenBay as 'Ma Chuyen Bay', sb1.TenSanBay as 'Ten san bay di', sb2.TenSanBay as 'Ten san bay den', cb.NgayBay as 'Ngay bay', "
            		+ "CONCAT(CONVERT(cb.GioCatCanh, CHAR(50)),\":\",CONVERT(cb.PhutCatCanh, CHAR(50))) as 'Gio Khoi Hanh', "
            		+ "CONCAT(CONVERT(cb.GioBay, CHAR(50)),\":\",CONVERT(cb.PhutBay, CHAR(50)))  as 'Gio Bay',"
            		+ "cb.SoLuongGheHang1 + cb.SoLuongGheHang2 as 'So Luong Ghe' ,COALESCE(SUM(dc.SoLuong),0) as 'So ghe da dat'\r\n" + 
            		"FROM tblchuyenbay cb \r\n" + 
            		"LEFT JOIN tblsanbay sb1 ON sb1.IdSanBay = cb.MaSanBayDi\r\n" + 
            		"LEFT JOIN tblsanbay sb2 ON sb2.IdSanBay = cb.MaSanBayDen\r\n" + 
            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
            		"group by cb.MaChuyenBay";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
	  
	        tbl_ChuyenBay.setModel(DbUtils.resultSetToTableModel(rs)); 
    	}
    	catch (Exception e)
		{
			e.printStackTrace();
		}	
    }
    
    public void LoadDataQuyDinh() {
    	  // prepare table view
    	try {
    		  Connection conn= (Connection) JDBC.getJDBCConnection();
  		  String qry="select * from tblquydinh";
  		  Statement st= conn.createStatement();
  		  ResultSet rs= st.executeQuery(qry);
  		  while(rs.next()) {
  			qd_NgayDatVe = Integer.parseInt(rs.getString("ThoiGianChamNhatDatVe"));
  			qd_NgayHuyVe = Integer.parseInt(rs.getString("ThoiGianChamNhatHuyDatVe"));
  		  }  
    	}
    	catch (Exception e)
  		{
  			e.printStackTrace();
  		}	
    }
    
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachChuyenBay frame = new DanhSachChuyenBay();
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
	public DanhSachChuyenBay() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		// Xu ly them chuyen bay
		JButton btnDatVe = new JButton("Đặt vé");
		btnDatVe.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tbl_ChuyenBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyến bay để đặt vé");
					return;
				}
				
				int index = tbl_ChuyenBay.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tbl_ChuyenBay.getModel(); 
			    int SoLuongGhe = Integer.parseInt(dtm.getValueAt(index, 6).toString());
			    int SoLuongGheDaDat =Integer.parseInt(dtm.getValueAt(index, 7).toString());
			    int SoGheConTrong = SoLuongGhe - SoLuongGheDaDat;
			    
			    // kiem tra ngay
			    try {
			    	//lay ngay so sanh
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	Date today = new Date();
				    String Ngaybay =  dtm.getValueAt(index, 3).toString();
					Date compareday = sdf.parse(Ngaybay);
					
					// them ngay vao ngay so sanh
					Calendar c = Calendar.getInstance();
					c.setTime(compareday);
					c.add(Calendar.DATE,-1 * qd_NgayDatVe); // them ngay
					compareday = c.getTime();
					
					// reset gio cua ngay hom nay
					Calendar c2 = Calendar.getInstance();
					c2.setTime(today);
					c2.set(Calendar.HOUR_OF_DAY,0);
					c2.set(Calendar.MINUTE,0);
					c2.set(Calendar.SECOND,0);
					c2.set(Calendar.MILLISECOND,0);
					today = c2.getTime();
					
					 if (compareday.compareTo(today) < 0) {
					    JOptionPane.showMessageDialog(null, "Đã hết hạn đặt vé");
						return;
				     } 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    
			    if(SoGheConTrong > 0)
			    {
			    	JOptionPane.showMessageDialog(null, "Mời đặt chỗ - Số ghế còn trống " + SoGheConTrong);
			    	//DatCho newframe = new DatCho();
			    	DatCho.main(null, dtm.getValueAt(index, 0).toString());
			    	//newframe.setVisible(true);
					return;
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Đã hết ghế");
					return;
			    }
			}
		});
		btnDatVe.setBounds(375, 390, 120, 60);
		contentPane.add(btnDatVe);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel)tbl_ChuyenBay.getModel());
				tbl_ChuyenBay.setRowSorter(sorter);
				
				sorter.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText().trim()));
			}
		});
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(130, 70, 635, 20);
		contentPane.add(txtTimKiem);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setBounds(65, 70, 60, 20);
		contentPane.add(lblTmKim);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(252, 10, 413, 40);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchChuyn = new JLabel("DANH SÁCH CHUYẾN BAY");
		lblDanhSchChuyn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchChuyn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 100, 870, 280);
		contentPane.add(scrollPane);
		
		tbl_ChuyenBay = new JTable();
		scrollPane.setViewportView(tbl_ChuyenBay);
		
		JButton btnHytV = new JButton("Hủy đặt vé");
		btnHytV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tbl_ChuyenBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyến bay để hủy đặt vé");
					return;
				}
				
				int index = tbl_ChuyenBay.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tbl_ChuyenBay.getModel(); 

			 // kiem tra ngay
			    try {
			    	//lay ngay so sanh
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	Date today = new Date();
				    String Ngaybay =  dtm.getValueAt(index, 3).toString();
					Date compareday = sdf.parse(Ngaybay);
					
					// them ngay vao ngay so sanh
					Calendar c = Calendar.getInstance();
					c.setTime(compareday);
					c.add(Calendar.DATE,-1 * qd_NgayHuyVe); // them ngay
					compareday = c.getTime();
					
					// reset gio cua ngay hom nay
					Calendar c2 = Calendar.getInstance();
					c2.setTime(today);
					c2.set(Calendar.HOUR_OF_DAY,0);
					c2.set(Calendar.MINUTE,0);
					c2.set(Calendar.SECOND,0);
					c2.set(Calendar.MILLISECOND,0);
					today = c2.getTime();
					
					 if (compareday.compareTo(today) < 0) {
					    JOptionPane.showMessageDialog(null, "Đã hết hạn hủy đặt vé");
						return;
				     } 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    
			    //HuyDatCho newframe = new HuyDatCho();
			    HuyDatCho.main(null, dtm.getValueAt(index, 0).toString());
			    //newframe.setVisible(true);
				return;
			}
		});
		btnHytV.setBounds(520, 390, 120, 60);
		contentPane.add(btnHytV);
		
		JButton btnBnV = new JButton("Bán vé");
		btnBnV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tbl_ChuyenBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyến bay để bán vé");
					return;
				}
				
				int index = tbl_ChuyenBay.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)tbl_ChuyenBay.getModel(); 
			    int SoLuongGhe = Integer.parseInt(dtm.getValueAt(index, 6).toString());
			    int SoLuongGheDaDat =Integer.parseInt(dtm.getValueAt(index, 7).toString());
			    int SoGheConTrong = SoLuongGhe - SoLuongGheDaDat;
			    
			 // kiem tra ngay
			    try {
			    	//lay ngay so sanh
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	Date today = new Date();
				    String Ngaybay =  dtm.getValueAt(index, 3).toString();
					Date compareday = sdf.parse(Ngaybay);
					
					// reset gio cua ngay hom nay
					Calendar c2 = Calendar.getInstance();
					c2.setTime(today);
					c2.set(Calendar.HOUR_OF_DAY,0);
					c2.set(Calendar.MINUTE,0);
					c2.set(Calendar.SECOND,0);
					c2.set(Calendar.MILLISECOND,0);
					today = c2.getTime();
					
					 if (compareday.compareTo(today) < 0) {
					    JOptionPane.showMessageDialog(null, "Đã hết hạn bán vé");
						return;
				     } 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    
			    if(SoGheConTrong > 0)
			    {
			    	JOptionPane.showMessageDialog(null, "Mời chọn chỗ - Số ghế còn trống " + SoGheConTrong);
			    	//BanVe newframe = new BanVe();
			    	BanVe.main(null, dtm.getValueAt(index, 0).toString());
			    	//newframe.setVisible(true);
					return;
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Đã hết ghế");
					return;
			    }
			}
		});
		btnBnV.setBounds(230, 390, 120, 60);
		contentPane.add(btnBnV);
		
		// cac ham xu ly
		LoadDataQuyDinh();
		LoadDataChuyenBay();
	}
}
