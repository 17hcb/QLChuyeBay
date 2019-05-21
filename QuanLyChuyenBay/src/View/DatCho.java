package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComboboxItem.ComboboxItem;
import JDBC.JDBC;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class DatCho extends JFrame {
	
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTextField txtSBDi;
	private JTextField txtNgayGio;
	private JTextField txtSBDen;
	private JTable tblDatCho;
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
	
	
    /*public void LoadDataCombobox(JComboBox tenCombobox , String tenTable, int idValues, String nameValues) {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from" + tenTable;
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int id = rs.getInt(idValues);
        	  String name = rs.getString(nameValues);       	  
        	  tenCombobox.addItem(new ComboboxItem(name, id));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}*/
	
    public void LoadDataCombobox() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from tblkhachhang";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int idMaChuyenBay = rs.getInt("IDKhachHang");
        	  String tenMaChuyenBay  = rs.getString("TenKhachHang");
        	  cboKhachHang.addItem(new ComboboxItem(tenMaChuyenBay, idMaChuyenBay));

          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	protected void LoadData() {
		// TODO Auto-generated method stub
		//LoadDataCombobox(cboMaChuyenBay, "tblchuyenbay", "MaChuyenBay", "MaChuyenBay");
		LoadDataCombobox();
		
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
		cboMaChuyenBay.setBounds(148, 58, 147, 20);
		contentPane.add(cboMaChuyenBay);
		
		txtSBDi = new JTextField();
		txtSBDi.setBounds(148, 85, 147, 20);
		contentPane.add(txtSBDi);
		txtSBDi.setColumns(10);
		
		txtNgayGio = new JTextField();
		txtNgayGio.setColumns(10);
		txtNgayGio.setBounds(426, 116, 147, 20);
		contentPane.add(txtNgayGio);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(46, 88, 81, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(348, 88, 81, 14);
		contentPane.add(lblinThoi);
		
		txtSBDen = new JTextField();
		txtSBDen.setColumns(10);
		txtSBDen.setBounds(426, 88, 147, 20);
		contentPane.add(txtSBDen);
		
		JButton btnAdd = new JButton("Đặt vé");
		btnAdd.setBounds(253, 154, 102, 54);
		contentPane.add(btnAdd);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setBounds(348, 61, 81, 14);
		contentPane.add(lblKhchHng);
		
	    cboKhachHang = new JComboBox();
	    cboKhachHang.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	    		String v = "";
	    		v = cboKhachHang.getSelectedItem().toString();
	    		
	    		
	    		
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
		cboHangVe.setBounds(148, 116, 147, 20);
		contentPane.add(cboHangVe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 583, 160);
		contentPane.add(scrollPane);
		
		tblDatCho = new JTable();
		scrollPane.setViewportView(tblDatCho);
	}
}
