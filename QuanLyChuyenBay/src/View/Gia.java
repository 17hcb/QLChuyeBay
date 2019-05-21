package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gia extends JFrame {

	private JPanel contentPane;
	private JTextField txtGia;
	private static JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gia frame = new Gia();
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
          String qry="select sb.tensanbay as 'Ten San Bay', sb.tendiemden as 'Ten Diem Den', hv.tenhangve as 'Ten Hang Ve', gv.giatien as 'Gia Tien' from sanbay sb join giave gv on sb.id = gv.id_chuyenbay join hangve hv on hv.id = gv.hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void LoadDataHangVe() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select sb1.tensanbay as 'Ten San Bay Di', sb2.tensanbay as 'Ten San Bay Den', hv.tenhangve as 'Hang Ve', gv.giatien as 'Gia Tien'\r\n" + 
          		"from sanbay sb1 \r\n" + 
          		"			join chuyenbay cb on sb1.id = cb.idsanbaydi\r\n" + 
          		"			join sanbay sb2 on sb2.id = cb.idsanbayden\r\n" + 
          		"			join giave gv on gv.id_chuyenbay = cb.idchuyenbay\r\n" + 
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
	
	public static void LoadDataChuyenBay() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          String qry="select sb.tensanbay as 'Ten San Bay', sb.tendiemden as 'Ten Diem Den', hv.tenhangve as 'Ten Hang Ve', gv.giatien as 'Gia Tien' from sanbay sb join giave gv on sb.id = gv.id_chuyenbay join hangve hv on hv.id = gv.hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
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
		
		JLabel lblNewLabel = new JLabel("Chuyến bay");
		lblNewLabel.setBounds(30, 66, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMHngV = new JLabel("Hạng vé");
		lblMHngV.setBounds(30, 101, 90, 14);
		contentPane.add(lblMHngV);
		
		JLabel lblGi = new JLabel("Giá tiền");
		lblGi.setBounds(30, 133, 90, 14);
		contentPane.add(lblGi);
		
		txtGia = new JTextField();
		txtGia.setBounds(130, 130, 149, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JComboBox cbMaHV = new JComboBox();
		cbMaHV.setBounds(130, 98, 149, 20);
		contentPane.add(cbMaHV);
		
		JComboBox cbMaCB = new JComboBox();
		cbMaCB.setBounds(130, 63, 149, 20);
		contentPane.add(cbMaCB);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setBounds(318, 62, 106, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(318, 97, 106, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(318, 129, 106, 23);
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
		textField.setColumns(10);
		textField.setBounds(533, 70, 340, 20);
		contentPane.add(textField);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(439, 5, 434, 39);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách sân giá vé");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchSn);
	}
}
