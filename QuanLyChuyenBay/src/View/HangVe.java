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

import Entity.HangVeEntity;
import Entity.SanBayEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HangVe extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenHangVe;
	private JTextField textField;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangVe frame = new HangVe();
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
          String qry="select id as 'ID', tenhangve as 'Ten Hang Ve' from hangve";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          
          table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void ResetField() {
		try {
			 txtTenHangVe.setText("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Create the frame.
	 */
	public HangVe() {
		setTitle("Quản lý hạng vé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 424, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("HẠNG VÉ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel lblTnHngV = new JLabel("Tên hạng vé");
		lblTnHngV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnHngV.setBounds(29, 65, 126, 26);
		contentPane.add(lblTnHngV);
		
		txtTenHangVe = new JTextField();
		txtTenHangVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenHangVe.setColumns(10);
		txtTenHangVe.setBounds(165, 65, 178, 26);
		contentPane.add(txtTenHangVe);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtTenHangVe.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				} else {
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(HangVeEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						HangVeEntity emp = new HangVeEntity();
						emp.setTenHangVe(txtTenHangVe.getText());
						
						session.beginTransaction();
						
						session.save(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã thêm hạng vé thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(29, 194, 114, 26);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hạng vé cần cập nhật!");
					return;
				}
				
				if (txtTenHangVe.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
					return;
				}
				
				int index = table.getSelectedRow();
			    DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
			    int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(HangVeEntity.class)
						.buildSessionFactory();
				Session session = factory.getCurrentSession();
				try {
					HangVeEntity emp = new HangVeEntity();
					emp.setId(id);
					emp.setTenHangVe(txtTenHangVe.getText());
					
					session.beginTransaction();
					
					session.saveOrUpdate(emp);
					
					session.getTransaction().commit();
					
					JOptionPane.showMessageDialog(null, "Đã cập nhật hạng vé thành công !");
					LoadData();
			        ResetField();
				} finally {
					factory.close();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(168, 194, 105, 26);
		contentPane.add(btnUpdate);
		
		JButton btmDelete = new JButton("Xóa");
		btmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				} else {
					 int index = table.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
				     int id = Integer.parseInt(dtm.getValueAt(index, 0).toString());
				     SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(HangVeEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						HangVeEntity emp = new HangVeEntity();
						emp.setId(id);
						
						session.beginTransaction();
						
						session.delete(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa hạng vé thành công !");
						LoadData();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btmDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btmDelete.setBounds(304, 194, 105, 26);
		contentPane.add(btmDelete);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(433, 5, 434, 39);
		contentPane.add(panel_1);
		
		
		JLabel lblDanhSchHng = new JLabel("Danh sách hạng vé");
		lblDanhSchHng.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchHng);
		
		JLabel label_1 = new JLabel("Tìm Kiếm");
		label_1.setBounds(433, 70, 85, 20);
		contentPane.add(label_1);
		
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
		textField.setBounds(527, 70, 340, 20);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(433, 101, 434, 263);
		
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 int index = table.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)table.getModel(); 
				     txtTenHangVe.setText(dtm.getValueAt(index, 1).toString()); 					 
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		table.setBounds(433, 109, 434, 263);
		
		scrollPane.setViewportView(table);
		
	}
}
