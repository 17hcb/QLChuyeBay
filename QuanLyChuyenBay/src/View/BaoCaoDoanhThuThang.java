package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

public class BaoCaoDoanhThuThang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTable tbl_ChuyenBay;
	private JComboBox cbb_Thang;
   
    
    public void LoadDataChuyenBay() {
    	  // prepare table view
    	try {
            Connection conn= (Connection) JDBC.getJDBCConnection();
            String qry = "SELECT cb.MaChuyenBay as 'Ma Chuyen Bay',\r\n" + 
            		"COALESCE(SUM(dc.SoLuong),0) as 'So ve',\r\n" + 
            		"		\r\n" + 
            		"COALESCE(SUM(dc.SoLuong),0) /(SELECT COALESCE(SUM(dc.SoLuong),0) as 'Tong so ve'\r\n" + 
            		"FROM tblchuyenbay cb\r\n" + 
            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
            		")*100 as 'Ti le',\r\n" + 
            		"\r\n" + 
            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) as 'DoanhThu'\r\n" + 
            		"FROM tblchuyenbay cb\r\n" + 
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
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoDoanhThuThang frame = new BaoCaoDoanhThuThang();
					frame.LoadDataChuyenBay();
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
	public BaoCaoDoanhThuThang() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTháng = new JLabel("Tháng");
		lblTháng.setBounds(200, 70, 60, 20);
		contentPane.add(lblTháng);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(200, 10, 538, 40);
		contentPane.add(panel_1);
		
		JLabel lbltitle = new JLabel("Báo cáo doanh thu bán vé các chuyến bay");
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lbltitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 100, 870, 350);
		contentPane.add(scrollPane);
		
		tbl_ChuyenBay = new JTable();
		scrollPane.setViewportView(tbl_ChuyenBay);
		
		JButton btnTimKiem = new JButton("Tra cứu");
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int selected = cbb_Thang.getSelectedIndex() + 1;
		            Connection conn= (Connection) JDBC.getJDBCConnection();
		            String qry = "SELECT cb.MaChuyenBay as 'Ma Chuyen Bay',\r\n" + 
		            		"COALESCE(SUM(dc.SoLuong),0) as 'So ve',\r\n" + 
		            		"		\r\n" + 
		            		"COALESCE(SUM(dc.SoLuong),0) /(SELECT COALESCE(SUM(dc.SoLuong),0) as 'Tong so ve'\r\n" + 
		            		"FROM tblchuyenbay cb\r\n" + 
		            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
		            		"where \r\n" + 
		            		"MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = "+ selected  +")*100 as 'Ti le',\r\n" + 
		            		"\r\n" + 
		            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) as 'DoanhThu'\r\n" + 
		            		"FROM tblchuyenbay cb\r\n" + 
		            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
		            		"where \r\n" + 
		            		"MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = " + selected + "\r\n" + 
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
		});
		btnTimKiem.setBounds(615, 70, 95, 23);
		contentPane.add(btnTimKiem);
		
		cbb_Thang = new JComboBox();
		cbb_Thang.addItem("1");
		cbb_Thang.addItem("2");
		cbb_Thang.addItem("3");
		cbb_Thang.addItem("4");
		cbb_Thang.addItem("5");
		cbb_Thang.addItem("6");
		cbb_Thang.addItem("7");
		cbb_Thang.addItem("8");
		cbb_Thang.addItem("9");
		cbb_Thang.addItem("10");
		cbb_Thang.addItem("11");
		cbb_Thang.addItem("12");

		cbb_Thang.setBounds(270, 70, 300, 20);
		contentPane.add(cbb_Thang);
	}
}
