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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toedter.calendar.JDateChooser;

import ComboboxItem.ComboboxItem;
import Entity.ChuyenBayEntity;
import Entity.SanBayTrungGianEntity;
import JDBC.JDBC;
import net.proteanit.sql.DbUtils;

public class QuanLyChuyenBay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747369890957991308L;
	private JPanel contentPane;
	private JTextField txtMaTuyenBay;
	private JTable tbl_SanbayTrungGian;
	private JTable tbl_ChuyenBay;
	private JTextField textField_4;
	private JComboBox cbb_SanBayDi;
	private JComboBox cbb_SanBayDen;
	private JComboBox cbb_SanBayTrungGian;
	private JTable tbl_HangVe;
	private JSpinner spi_ThoiGianDung;
	private JSpinner spi_HangVeMoi;
	private JSpinner spi_SoLuongGheHangVe;
	private JDateChooser dc_NgayBay;
	private JSpinner spi_Gio;
	private JSpinner spi_Phut;
	private JSpinner spi_GioBay;
	private JSpinner spi_PhutBay;
	private JSpinner spi_SoLuongGhe1;
	private JSpinner spi_SoLuongGhe2;
	
    public void LoadDataCombobox() {
		try {
          Connection conn= (Connection) JDBC.getJDBCConnection();
          
          // prepare combobox
          String qry="Select * from tblsanbay";
          Statement st= conn.createStatement();
          ResultSet rs= st.executeQuery(qry);
          while(rs.next())
          {
        	  int idSanBay = rs.getInt("IdSanBay");
        	  String tenSanBay = rs.getString("TenSanBay");
        	  cbb_SanBayDi.addItem(new ComboboxItem(tenSanBay, idSanBay));
        	  cbb_SanBayDen.addItem(new ComboboxItem(tenSanBay, idSanBay));
        	  cbb_SanBayTrungGian.addItem(new ComboboxItem(tenSanBay, idSanBay));
          }     
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
    
    public void LoadDataChuyenBay() {
    	  // prepare table view
    	try {
            Connection conn= (Connection) JDBC.getJDBCConnection();
            String qry = "Select * from tblchuyenbay";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
	  
	        tbl_ChuyenBay.setModel(DbUtils.resultSetToTableModel(rs)); 
    	}
    	catch (Exception e)
		{
			e.printStackTrace();
		}	
    }
    
    public void ResetField() {
    	try {
    		 txtMaTuyenBay.setText("");
    		 dc_NgayBay.setDate(null);
			 spi_Gio.setValue(0);
			 spi_Phut.setValue(0);
			 spi_GioBay.setValue(0);
			 spi_PhutBay.setValue(0);
			 spi_SoLuongGhe1.setValue(0);
			 spi_SoLuongGhe2.setValue(0);
			 dc_NgayBay.setCalendar(null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
    }
    
    public void LoadData() {
    	GenerateTableColumn();
    	LoadDataCombobox();
    	LoadDataChuyenBay();
    }
    
    public int FindInDexInCombobox(JComboBox cbbtemp,int element) {
    	int size = cbbtemp.getItemCount();
    	for (int i = 0; i < size; i++) {
    		int maCanTim = ((ComboboxItem)cbb_SanBayDi.getItemAt(i)).HiddenValue();
    		if( maCanTim == element)
    		{
    			return i;
    		}
			
    	}
    	return 0;
    }
    
    public void GenerateTableColumn() {
    	// Khoi tao column cho table san bay trung gian
    	Object [] columnheader = {"Sân bay trung gian","Thời gian dừng"};
    	DefaultTableModel modelcolumn = new DefaultTableModel();
    	modelcolumn.setColumnIdentifiers(columnheader);
		tbl_SanbayTrungGian.setModel(modelcolumn);
		
		// Khoi tao column cho table hang ve
		Object [] columnheaderHangve = {"STT hạng vé","Số lượng ghế"};
		DefaultTableModel modelcolumnHangve = new DefaultTableModel();
		modelcolumnHangve.setColumnIdentifiers(columnheaderHangve);
		tbl_HangVe.setModel(modelcolumnHangve);
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyChuyenBay frame = new QuanLyChuyenBay();
					frame.LoadData();
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
	public QuanLyChuyenBay() {
		setTitle("Quản lý tuyến bay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 869, 39);
		contentPane.add(panel);
		
		JLabel lblQunLTuyn = new JLabel("THÔNG TIN CHUYẾN BAY");
		lblQunLTuyn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblQunLTuyn);
		
		JLabel lblMTuynBay = new JLabel("Mã tuyến bay");
		lblMTuynBay.setBounds(50, 60, 95, 20);
		contentPane.add(lblMTuynBay);
		
		JLabel lblTnSnBay = new JLabel("Tên sân bay đến");
		lblTnSnBay.setBounds(480, 90, 115, 20);
		contentPane.add(lblTnSnBay);
		
		JLabel lblTnSnBay_1 = new JLabel("Tên sân bay đi");
		lblTnSnBay_1.setBounds(50, 90, 95, 20);
		contentPane.add(lblTnSnBay_1);
		
		txtMaTuyenBay = new JTextField();
		txtMaTuyenBay.setBounds(190, 60, 215, 20);
		contentPane.add(txtMaTuyenBay);
		txtMaTuyenBay.setColumns(10);
			
		// Xu ly them chuyen bay
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtMaTuyenBay.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã chuyến bay");
					return;
				}
				if(dc_NgayBay.getDate() == null)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày của chuyến bay");
					return;
				}
				if(cbb_SanBayDen.getSelectedIndex() == cbb_SanBayDi.getSelectedIndex())
				{
					JOptionPane.showMessageDialog(null, "Sân bay đến không thể trùng sân bay đi");
					return;
				}
				else
				{
					SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(ChuyenBayEntity.class)
							.buildSessionFactory();
					Session session = factory.getCurrentSession();
					try {
						//set data
						ChuyenBayEntity cbe = new ChuyenBayEntity();
						cbe.setMaChuyenBay(txtMaTuyenBay.getText());
						int maSanBayDi = ((ComboboxItem)cbb_SanBayDi.getSelectedItem()).HiddenValue();
						int maSanBayDen = ((ComboboxItem)cbb_SanBayDen.getSelectedItem()).HiddenValue();
						cbe.setMaSanBayDi(maSanBayDi);
						cbe.setMaSanBayDen(maSanBayDen);
						cbe.setGioCatCanh((int)spi_Gio.getValue());
						cbe.setPhutCatCanh((int)spi_Phut.getValue());
						cbe.setNgayBay(dc_NgayBay.getDate().toString());
						cbe.setGioBay((int)spi_GioBay.getValue());
						cbe.setPhutBay((int)spi_PhutBay.getValue());
						cbe.setSoLuongGheHang1((int)spi_SoLuongGhe1.getValue());
						cbe.setSoLuongGheHang2((int)spi_SoLuongGhe2.getValue());
						cbe.setCoHangVeBoSung(0);
						
						session.beginTransaction();
						
						session.save(cbe);
						
						session.getTransaction().commit();
						
						
						// them chuyen bay trung gian
						if(tbl_SanbayTrungGian.getModel().getRowCount() > 0)
						{
							SessionFactory factory2 = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(SanBayTrungGianEntity.class)
									.buildSessionFactory();
							Session session2 = factory2.getCurrentSession();
							try {
								//set data
								session2.beginTransaction();
								
								for(int row = 0; row < tbl_SanbayTrungGian.getModel().getRowCount(); row++)
								{
									SanBayTrungGianEntity sbtg = new SanBayTrungGianEntity();
									
									sbtg.setMaChuyenBay(txtMaTuyenBay.getText());
									int maSanBayTG = ((ComboboxItem)tbl_SanbayTrungGian.getValueAt(row, 0)).HiddenValue();
									sbtg.setMaSanBay(maSanBayTG);
									sbtg.setThoiGianDung((int)tbl_SanbayTrungGian.getValueAt(row, 1));
									
									session2.save(sbtg);
									session2.flush();
								    session2.clear();
								}
								
								session2.getTransaction().commit();
								//JOptionPane.showMessageDialog(null, "Đã cập nhật san bay trung gian !");
								tbl_SanbayTrungGian.setModel(new DefaultTableModel());
								GenerateTableColumn();
							}
							finally {
								factory2.close();
							}
						}
						
						// reset data after insert
						JOptionPane.showMessageDialog(null, "Đã thêm chuyến bay thành công !");
						LoadDataChuyenBay();
						ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnAdd.setBounds(190, 650, 105, 40);
		contentPane.add(btnAdd);
		
		//Xu ly cap nhat chuyen bay
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (tbl_ChuyenBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần cập nhật!");
					return;
				}
				if(txtMaTuyenBay.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã chuyến bay");
					return;
				}
				if(dc_NgayBay.getDate() == null)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày của chuyến bay");
					return;
				}
				else
				{
				     SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(ChuyenBayEntity.class)
								.buildSessionFactory();
					 Session session = factory.getCurrentSession();
					try {
						//set data
						ChuyenBayEntity cbe = new ChuyenBayEntity();
						cbe.setMaChuyenBay(txtMaTuyenBay.getText());
						int maSanBayDi = ((ComboboxItem)cbb_SanBayDi.getSelectedItem()).HiddenValue();
						int maSanBayDen = ((ComboboxItem)cbb_SanBayDen.getSelectedItem()).HiddenValue();
						cbe.setMaSanBayDi(maSanBayDi);
						cbe.setMaSanBayDen(maSanBayDen);
						cbe.setGioCatCanh((int)spi_Gio.getValue());
						cbe.setPhutCatCanh((int)spi_Phut.getValue());
						cbe.setNgayBay(dc_NgayBay.getDate().toString());
						cbe.setGioBay((int)spi_GioBay.getValue());
						cbe.setPhutBay((int)spi_PhutBay.getValue());
						cbe.setSoLuongGheHang1((int)spi_SoLuongGhe1.getValue());
						cbe.setSoLuongGheHang2((int)spi_SoLuongGhe2.getValue());
						cbe.setCoHangVeBoSung(0);
						
						session.beginTransaction();
						
						session.saveOrUpdate(cbe);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã cập nhật chuyến bay thành công !");
						LoadDataChuyenBay();
						ResetField();
					}
					finally {
						factory.close();
					}
				}
			}
		});
		btnUpdate.setBounds(490, 650, 105, 40);
		contentPane.add(btnUpdate);
		
	
		// Xu ly xoa chuyen bay
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (tbl_ChuyenBay.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần xóa!");
					return;
				}
				else
				{
					 int index = tbl_ChuyenBay.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tbl_ChuyenBay.getModel(); 
				     String idChuyenBay = dtm.getValueAt(index, 0).toString();
					 SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(ChuyenBayEntity.class)
							.buildSessionFactory();
					 Session session = factory.getCurrentSession();
					try {
						ChuyenBayEntity emp = new ChuyenBayEntity();
						emp.setMaChuyenBay(idChuyenBay);
						
						session.beginTransaction();
						
						session.delete(emp);
						
						session.getTransaction().commit();
						
						JOptionPane.showMessageDialog(null, "Đã xóa chuyến bay thành công !");
						LoadDataChuyenBay();
				        ResetField();
					}
					finally {
						factory.close();
					}
				}
			
			}
		});
		btnDelete.setBounds(340, 650, 105, 40);
		contentPane.add(btnDelete);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 220, 635, 65);
		contentPane.add(scrollPane);
		
		tbl_SanbayTrungGian = new JTable();
		scrollPane.setViewportView(tbl_SanbayTrungGian);
		
		JLabel lblNgyGi = new JLabel("Ngày bay");
		lblNgyGi.setBounds(50, 120, 95, 20);
		contentPane.add(lblNgyGi);
		
		JLabel lblThiGianBay = new JLabel("Thời gian bay");
		lblThiGianBay.setBounds(480, 120, 115, 20);
		contentPane.add(lblThiGianBay);
		
		JLabel lblSLngGh = new JLabel("Số lượng ghế hạng 1");
		lblSLngGh.setBounds(50, 150, 130, 20);
		contentPane.add(lblSLngGh);
		
		JLabel lblSLngGh_1 = new JLabel("Số lượng ghế hạng 2");
		lblSLngGh_1.setBounds(480, 150, 130, 20);
		contentPane.add(lblSLngGh_1);
		
		JLabel lblSnBayTrung = new JLabel("Sân bay trung gian");
		lblSnBayTrung.setBounds(50, 180, 115, 20);
		contentPane.add(lblSnBayTrung);
		
		//Xu ly them san bay trung gian
		JButton btn_ThemSanBayTG = new JButton("Thêm sân bay trung gian");
		btn_ThemSanBayTG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cbb_SanBayTrungGian.getSelectedIndex() == cbb_SanBayDi.getSelectedIndex() || cbb_SanBayTrungGian.getSelectedIndex() == cbb_SanBayDen.getSelectedIndex())
				{
					JOptionPane.showMessageDialog(null, "Sân bay trung gian trùng với sân bay đến hoặc sân bay đi !");
					return;
				}
				else
				{
					Object [] row = new Object[2];
					row[0] = cbb_SanBayTrungGian.getSelectedItem();
					row[1] = spi_ThoiGianDung.getValue();
					
					DefaultTableModel model = (DefaultTableModel) tbl_SanbayTrungGian.getModel();
					model.addRow(row);
					tbl_SanbayTrungGian.setModel(model);
				}
			}
		});
		btn_ThemSanBayTG.setBounds(5, 220, 175, 25);
		contentPane.add(btn_ThemSanBayTG);
		
		// Xoa san bay trung gian 
		JButton btn_XoaSanBayTG = new JButton("Xóa sân bay trung gian");
		btn_XoaSanBayTG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tbl_SanbayTrungGian.getModel();
				int SelectedRow = tbl_SanbayTrungGian.getSelectedRow();
				model.removeRow(SelectedRow);
				tbl_SanbayTrungGian.setModel(model);
			}
		});
		btn_XoaSanBayTG.setBounds(5, 260, 175, 25);
		contentPane.add(btn_XoaSanBayTG);
		
		JLabel lblThiGianDng = new JLabel("Thời gian dừng");
		lblThiGianDng.setBounds(480, 180, 115, 20);
		contentPane.add(lblThiGianDng);
		
		cbb_SanBayTrungGian = new JComboBox();
		cbb_SanBayTrungGian.setBounds(190, 180, 215, 20);
		contentPane.add(cbb_SanBayTrungGian);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 500, 870, 130);
		contentPane.add(scrollPane_1);
		
		// Xu ly load du lieu theo dong chon
		tbl_ChuyenBay = new JTable();
		tbl_ChuyenBay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 int index = tbl_ChuyenBay.getSelectedRow();
				     DefaultTableModel dtm = (DefaultTableModel)tbl_ChuyenBay.getModel(); 
				     
				     txtMaTuyenBay.setText(dtm.getValueAt(index, 0).toString());
				     
				     int index1 = FindInDexInCombobox(cbb_SanBayDi, (int)dtm.getValueAt(index, 1));
				     int index2 = FindInDexInCombobox(cbb_SanBayDen, (int)dtm.getValueAt(index, 2));
				     cbb_SanBayDi.setSelectedIndex(index1);
				     cbb_SanBayDen.setSelectedIndex(index2);			
				     
					 spi_Gio.setValue(dtm.getValueAt(index, 3));
					 spi_Phut.setValue(dtm.getValueAt(index, 4));
					 spi_GioBay.setValue(dtm.getValueAt(index, 6));
					 spi_PhutBay.setValue(dtm.getValueAt(index, 7));
					 spi_SoLuongGhe1.setValue(dtm.getValueAt(index, 8));
					 spi_SoLuongGhe2.setValue(dtm.getValueAt(index, 9));
					 
					 Date dateload = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dtm.getValueAt(index, 5).toString());
					 dc_NgayBay.setDate(dateload);
						 
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(tbl_ChuyenBay);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(190, 470, 635, 20);
		contentPane.add(textField_4);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setBounds(120, 470, 60, 20);
		contentPane.add(lblTmKim);
		
		//Xu ly reset 
		JButton btnThitLpLi = new JButton("Thiết lập lại");
		btnThitLpLi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ResetField();
			}
		});
		btnThitLpLi.setBounds(640, 650, 105, 40);
		contentPane.add(btnThitLpLi);
		
	    cbb_SanBayDi = new JComboBox();
		cbb_SanBayDi.setBounds(190, 90, 215, 20);
		contentPane.add(cbb_SanBayDi);
		
		cbb_SanBayDen = new JComboBox();
		cbb_SanBayDen.setBounds(610, 90, 215, 20);
		contentPane.add(cbb_SanBayDen);
		
		dc_NgayBay = new JDateChooser();
		dc_NgayBay.setBounds(190, 120, 215, 20);
		contentPane.add(dc_NgayBay);
		
		spi_Gio = new JSpinner();
		spi_Gio.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spi_Gio.setBounds(610, 60, 50, 20);
		if ( spi_Gio.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spi_Gio.getEditor();
			   editor.getTextField().setEnabled( true );
			   editor.getTextField().setEditable( false );
		}
		contentPane.add(spi_Gio);
		
		JLabel lblGio = new JLabel("Giờ cất cánh");
		lblGio.setBounds(480, 60, 95, 20);
		contentPane.add(lblGio);
		
		JLabel lblGi = new JLabel("giờ");
		lblGi.setBounds(680, 60, 30, 20);
		contentPane.add(lblGi);
		
		spi_Phut = new JSpinner();
		spi_Phut.setModel(new SpinnerNumberModel(0, 0, 60, 5));
		spi_Phut.setBounds(720, 60, 50, 20);
		if ( spi_Phut.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spi_Phut.getEditor();
			   editor.getTextField().setEnabled( true );
			   editor.getTextField().setEditable( false );
		}
		contentPane.add(spi_Phut);
		
		JLabel lblPht = new JLabel("phút");
		lblPht.setBounds(795, 60, 30, 20);
		contentPane.add(lblPht);
		
		spi_ThoiGianDung = new JSpinner();
		spi_ThoiGianDung.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_ThoiGianDung.setBounds(610, 180, 160, 20);
		if ( spi_ThoiGianDung.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spi_ThoiGianDung.getEditor();
			   editor.getTextField().setEnabled( true );
			   editor.getTextField().setEditable( false );
		}
		contentPane.add(spi_ThoiGianDung);
		
		JLabel label = new JLabel("phút");
		label.setBounds(795, 180, 30, 20);
		contentPane.add(label);
		
	
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(190, 350, 635, 65);
		contentPane.add(scrollPane_2);
		
		tbl_HangVe = new JTable();
		scrollPane_2.setViewportView(tbl_HangVe);
		
		//Xu ly them 1 hang ve bo sung
		JButton btn_BoSungHangVe = new JButton("Bổ sung hạng vé");
		btn_BoSungHangVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object [] row = new Object[2];
				row[0] = spi_HangVeMoi.getValue();
				row[1] = spi_SoLuongGheHangVe.getValue();
				
				DefaultTableModel model = (DefaultTableModel) tbl_HangVe.getModel();
				model.addRow(row);
				tbl_HangVe.setModel(model);
			}
		});
		btn_BoSungHangVe.setBounds(5, 350, 175, 25);
		contentPane.add(btn_BoSungHangVe);
		
		JButton btn_BoHangVe = new JButton("Bỏ hạng vé");
		btn_BoHangVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) tbl_HangVe.getModel();
				int SelectedRow = tbl_HangVe.getSelectedRow();
				model.removeRow(SelectedRow);
				tbl_HangVe.setModel(model);
			}
		});
		btn_BoHangVe.setBounds(5, 390, 175, 25);
		contentPane.add(btn_BoHangVe);
		
		JLabel lblSttHngV = new JLabel("STT hạng vé mới");
		lblSttHngV.setBounds(50, 310, 130, 20);
		contentPane.add(lblSttHngV);
		
		spi_HangVeMoi = new JSpinner();
		spi_HangVeMoi.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_HangVeMoi.setBounds(190, 310, 215, 20);
		contentPane.add(spi_HangVeMoi);
		
		JLabel lblGiV = new JLabel("Số lượng ghế hạng vé");
		lblGiV.setBounds(480, 310, 130, 20);
		contentPane.add(lblGiV);
		
		spi_GioBay = new JSpinner();
		spi_GioBay.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_GioBay.setBounds(610, 120, 50, 20);
		contentPane.add(spi_GioBay);
		
		JLabel label_1 = new JLabel("giờ");
		label_1.setBounds(680, 123, 30, 20);
		contentPane.add(label_1);
		
		spi_PhutBay = new JSpinner();
		spi_PhutBay.setModel(new SpinnerNumberModel(0, 0, 60, 5));
		spi_PhutBay.setBounds(720, 120, 50, 20);
		contentPane.add(spi_PhutBay);
		
		JLabel label_2 = new JLabel("phút");
		label_2.setBounds(795, 123, 30, 20);
		contentPane.add(label_2);
		
		spi_SoLuongGheHangVe = new JSpinner();
		spi_SoLuongGheHangVe.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_SoLuongGheHangVe.setBounds(610, 310, 215, 20);
		contentPane.add(spi_SoLuongGheHangVe);
		
		spi_SoLuongGhe1 = new JSpinner();
		spi_SoLuongGhe1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_SoLuongGhe1.setBounds(190, 150, 215, 20);
		contentPane.add(spi_SoLuongGhe1);
		
		spi_SoLuongGhe2 = new JSpinner();
		spi_SoLuongGhe2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spi_SoLuongGhe2.setBounds(610, 150, 215, 20);
		contentPane.add(spi_SoLuongGhe2);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(5, 421, 869, 39);
		contentPane.add(panel_1);
		
		JLabel lblDanhSchChuyn = new JLabel("DANH SÁCH CHUYẾN BAY");
		lblDanhSchChuyn.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblDanhSchChuyn);
	}
}
