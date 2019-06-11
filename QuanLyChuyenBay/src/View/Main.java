package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main {

	private JFrame frmMnHnhChnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMnHnhChnh.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frmMnHnhChnh = new JFrame();
		frmMnHnhChnh.setTitle("Màn hình chính");
		frmMnHnhChnh.setBounds(100, 100, 537, 368);
		frmMnHnhChnh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMnHnhChnh.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		frmMnHnhChnh.setJMenuBar(menuBar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmMnHnhChnh.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmMnHnhChnh.getContentPane().setLayout(groupLayout);
		frmMnHnhChnh.setVisible(true);
		
		JMenu menuHeThong = new JMenu("Hệ thống");
		menuHeThong.setIcon(new ImageIcon(Main.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		menuBar.add(menuHeThong);
		
		JMenuItem itemQLNV = new JMenuItem("Quản lý nhân viên");
		itemQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv = new NhanVien();
				tabbedPane.addTab("Nhân viên", nv.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuHeThong.add(itemQLNV);
		
		JMenuItem itemDoiMK = new JMenuItem("Đổi mật khẩu");
		itemDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuHeThong.add(itemDoiMK);
		
		JMenuItem itemQuyDinh = new JMenuItem("Quy định");
		itemQuyDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuyDinh qd = new QuyDinh();
				tabbedPane.addTab("Quy định", qd.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuHeThong.add(itemQuyDinh);
		
		JMenuItem itemLogout = new JMenuItem("Đăng xuất");
		menuHeThong.add(itemLogout);
		
		JMenuItem itemExit = new JMenuItem("Thoát");
		itemExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		menuHeThong.add(itemExit);
		
		JMenu menuQuanLy = new JMenu("Quản Lý");
		menuQuanLy.setIcon(new ImageIcon(Main.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		menuBar.add(menuQuanLy);
		
		JMenuItem itemQLSanBay = new JMenuItem("Quản lý sân bay");
		itemQLSanBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SanBay dn = new SanBay();
				tabbedPane.addTab("Sân bay", dn.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLSanBay);
		
		JMenuItem itemQLTuyenBay = new JMenuItem("Quản lý tuyến bay");
//		itemQLTuyenBay.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TuyenBay tb = new TuyenBay();
//				tabbedPane.addTab("Tuyến bay", tb.getContentPane());
//				if (tabbedPane.getComponentCount() > 1)
//				{
//					tabbedPane.remove(0);
//				}
//			}
//		});
		menuQuanLy.add(itemQLTuyenBay);
		
		JMenuItem itemQLMayBay = new JMenuItem("Quản lý máy bay");
		itemQLMayBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MayBay mb = new MayBay();
				tabbedPane.addTab("Máy bay", mb.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLMayBay);
		
		JMenuItem itemQLLichBay = new JMenuItem("Quản lý lịch bay");
		itemQLLichBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichBay lb = new LichBay();
				tabbedPane.addTab("Lịch bay", lb.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLLichBay);
		
		JMenuItem itemQLHangVe = new JMenuItem("Quản lý hạng vé");
		itemQLHangVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HangVe hv = new HangVe();
				tabbedPane.addTab("Hạng Vé", hv.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLHangVe);
		
		JMenuItem itemQLGiaVe = new JMenuItem("Quản lý giá vé");
		itemQLGiaVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gia g = new Gia();
				tabbedPane.addTab("Giá Vé", g.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLGiaVe);
		
		JMenuItem itemQLKhachHang = new JMenuItem("Quản lý khách hàng");
		itemQLKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh = new KhachHang();
				tabbedPane.addTab("Khách hàng", kh.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLKhachHang);
		
		JMenuItem itemQLDatCho = new JMenuItem("Quản lý đặt chỗ");
		itemQLDatCho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatCho dc = new DatCho();
				tabbedPane.addTab("Đặt chỗ", dc.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLDatCho);
		
		JMenuItem itemVeChuyenBay = new JMenuItem("Vé chuyến bay");
		itemVeChuyenBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeChuyenBay vcb = new VeChuyenBay();
				tabbedPane.addTab("Vé chuyến bay", vcb.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemVeChuyenBay);
		
		JMenu menuBaoCao = new JMenu("Báo cáo");
		menuBaoCao.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(menuBaoCao);
		
		JMenuItem itemDTBVThang = new JMenuItem("Doanh thu bán vé tháng");
//		itemDTBVThang.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DoanhThuThang dtt = new DoanhThuThang();
//				tabbedPane.addTab("Doanh Thu Tháng", dtt.getContentPane());
//				if (tabbedPane.getComponentCount() > 1)
//				{
//					tabbedPane.remove(0);
//				}
//				
//			}
//		});
		menuBaoCao.add(itemDTBVThang);
	}

}
