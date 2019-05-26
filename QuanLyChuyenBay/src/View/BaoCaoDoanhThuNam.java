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

public class BaoCaoDoanhThuNam extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTable tbl_ChuyenBay;
	private JTextField txtNam;
   
    
    public void LoadDataChuyenBay() {
    	  // prepare table view
    	try {
            Connection conn= (Connection) JDBC.getJDBCConnection();
            String qry = "SELECT MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) as 'Thang',\r\n" + 
            		"Count(cb.MaChuyenBay) as 'So Ma Chuyen Bay',\r\n" + 
            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) as 'DoanhThu',\r\n" + 
            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) / (\r\n" + 
            		"	SELECT COALESCE(SUM(dc.SoLuong * dc.GiaVe),0)\r\n" + 
            		"    FROM tblchuyenbay cb\r\n" + 
            		"	LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
            		"    WHERE \r\n" + 
            		"	YEAR(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = 2019\r\n" + 
            		") * 100 as 'Ti le'\r\n" + 
            		"FROM tblchuyenbay cb\r\n" + 
            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
            		"WHERE \r\n" + 
            		"YEAR(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = 2019\r\n" + 
            		"GROUP BY MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d'))\r\n" + 
            		"";
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
					BaoCaoDoanhThuNam frame = new BaoCaoDoanhThuNam();
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
	public BaoCaoDoanhThuNam() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(200, 70, 60, 20);
		contentPane.add(lblNam);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(5, 10, 870, 40);
		contentPane.add(panel_1);
		
		JLabel lbltitle = new JLabel("Báo cáo doanh thu năm");
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
					String selected = txtNam.getText();
		            Connection conn= (Connection) JDBC.getJDBCConnection();
		            String qry = "SELECT MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) as 'Thang',\r\n" + 
		            		"Count(cb.MaChuyenBay) as 'So Ma Chuyen Bay',\r\n" + 
		            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) as 'DoanhThu',\r\n" + 
		            		"COALESCE(SUM(dc.SoLuong * dc.GiaVe),0) / (\r\n" + 
		            		"	SELECT COALESCE(SUM(dc.SoLuong * dc.GiaVe),0)\r\n" + 
		            		"    FROM tblchuyenbay cb\r\n" + 
		            		"	LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
		            		"    WHERE \r\n" + 
		            		"	YEAR(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = " + selected + "\r\n" + 
		            		") * 100 as 'Ti le'\r\n" + 
		            		"FROM tblchuyenbay cb\r\n" + 
		            		"LEFT JOIN tblvedatcho dc ON dc.MaChuyenBay = cb.MaChuyenBay\r\n" + 
		            		"WHERE \r\n" + 
		            		"YEAR(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d')) = " + selected + "\r\n" + 
		            		"GROUP BY MONTH(STR_TO_DATE(cb.NgayBay,'%Y-%m-%d'))\r\n" + 
		            		"";
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
		
		txtNam = new JTextField();
		txtNam.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(Character.isLetter(c))
				{
					txtNam.setEditable(false);
				}
				else
				{
					txtNam.setEditable(true);
				}
			}
		});
		txtNam.setBounds(270, 70, 300, 20);
		contentPane.add(txtNam);
		txtNam.setColumns(10);
	}
}
