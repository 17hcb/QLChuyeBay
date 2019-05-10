package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import JDBC.JDBC;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtCMND;
	private JTextField txtTenKH;
	private JTextField txtDT;
	private static JTable tblKhachHang;

	/**
	 * Launch the application.
	 */
	
	public static ArrayList<Method.KhachHang> viewDataKH(){
		
		ArrayList<Method.KhachHang> kh = null;
		kh = new ArrayList<Method.KhachHang>();
		
		try {
            Connection conn= (Connection) JDBC.getJDBCConnection();
            String qry="select * from tblKhachHang";
            Statement st=(Statement) conn.createStatement();
            ResultSet rs=(ResultSet) st.executeQuery(qry);
            

            
            Method.KhachHang khachhang;
            
            while (rs.next()) {
            	khachhang = new Method.KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));               
            	kh.add(khachhang);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return kh; 				
	}
	
	
	public static void LoadData() {
		// TODO Auto-generated method stub
		ArrayList<Method.KhachHang> kq = viewDataKH();
		DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
		model.setRowCount(0);
		Object[] row=new Object[4];
        for (int i = 0; i < kq.size(); i++) {
            row[0]=kq.get(i).getIdKhachHang();
            row[1]=kq.get(i).getTenKhachHang();
            row[2]=kq.get(i).getCMND();
            row[3]=kq.get(i).getSoDienThoai();
            model.addRow(row);
        }
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
					/*Load Data*/
					LoadData();
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
	public KhachHang() {
		setTitle("Khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblKhchHng = new JLabel("KHÁCH HÀNG");
		lblKhchHng.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblKhchHng);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(42, 60, 69, 14);
		contentPane.add(lblCmnd);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setBounds(42, 85, 94, 14);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setBounds(42, 110, 94, 14);
		contentPane.add(lblinThoi);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(146, 60, 146, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(146, 85, 146, 20);
		contentPane.add(txtTenKH);
		
		txtDT = new JTextField();
		txtDT.setColumns(10);
		txtDT.setBounds(146, 110, 146, 20);
		contentPane.add(txtDT);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(new ActionListener() {
			/*Insert Data*/
			public void actionPerformed(ActionEvent arg0) {
				if(txtTenKH.getText()!=null || txtCMND!=null
		                || txtDT!=null){
		               try {

		            } catch (Exception e) {
		                
		            }
		        }else{
		              
		        }
			}
		});
		btnAdd.setBounds(323, 56, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setBounds(323, 81, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(323, 106, 89, 23);
		contentPane.add(btnDelete);
		
		tblKhachHang = new JTable();
		tblKhachHang.setBounds(5, 144, 419, 106);
		contentPane.add(tblKhachHang);
	}
}
