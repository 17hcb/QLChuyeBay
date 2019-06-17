package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

import net.bytebuddy.implementation.bytecode.Addition;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main {

	private JFrame frmMnHnhChnh;
	private JMenu menuHeThong;
	private JMenu menuQuanLy;
	private JMenu menuChucNang;
	private JMenu menuBaoCao;
	
	JTabbedPane tabbedPane;
	int ntabs = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main(0);
					
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
	public Main(int type) {
		initialize();
		if(type == 2)
		{
			menuQuanLy.setVisible(false);
			menuBaoCao.setVisible(false);
		}
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new CustomTabbedPaneUI());
		
		GroupLayout groupLayout = new GroupLayout(frmMnHnhChnh.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(250))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		frmMnHnhChnh.getContentPane().setLayout(groupLayout);
		frmMnHnhChnh.setVisible(true);
		
	    menuHeThong = new JMenu("Hệ thống");
		menuHeThong.setIcon(new ImageIcon(Main.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		menuBar.add(menuHeThong);
		
		JMenuItem itemQuyDinh = new JMenuItem("Quy định");
		itemQuyDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuyDinh qd = new QuyDinh();
				tabbedPane.addTab("Quy định    ", qd.getContentPane());
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
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuHeThong.add(itemExit);
		
		menuQuanLy = new JMenu("Quản Lý");
		menuQuanLy.setIcon(new ImageIcon(Main.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		menuBar.add(menuQuanLy);
		
		JMenuItem itemQLSanBay = new JMenuItem("Sân bay");
		itemQLSanBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SanBay dn = new SanBay();
				tabbedPane.addTab("Sân bay    ", dn.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLSanBay);
		
		
		JMenuItem itemQuanLyChuyenBay = new JMenuItem("Chuyến bay");
		itemQuanLyChuyenBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyChuyenBay qlcb = new QuanLyChuyenBay();
				tabbedPane.addTab("Quản lý chuyến bay    ", qlcb.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQuanLyChuyenBay);
		
//		JMenuItem itemQLTuyenBay = new JMenuItem("Quản lý tuyến bay");
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
//		menuQuanLy.add(itemQLTuyenBay);
//		
//		JMenuItem itemQLMayBay = new JMenuItem("Quản lý máy bay");
//		itemQLMayBay.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		menuQuanLy.add(itemQLMayBay);
//		
//		JMenuItem itemQLLichBay = new JMenuItem("Quản lý lịch bay");
//		itemQLLichBay.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		menuQuanLy.add(itemQLLichBay);
		
//		JMenuItem itemQLHangVe = new JMenuItem("Quản lý hạng vé");
//		itemQLHangVe.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		menuQuanLy.add(itemQLHangVe);
		
		JMenuItem itemQLGiaVe = new JMenuItem("Cập nhật giá vé");
		itemQLGiaVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gia g = new Gia();
				tabbedPane.addTab("Giá Vé    ", g.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuQuanLy.add(itemQLGiaVe);
		
		menuChucNang = new JMenu("Chức năng");
		menuChucNang.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(menuChucNang);
		
		JMenuItem itemDanhSachChuyenBay = new JMenuItem("Danh sách chuyến bay");
		itemDanhSachChuyenBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DanhSachChuyenBay ds = new DanhSachChuyenBay();
				tabbedPane.addTab("Danh Sách Chuyến Bay    ", ds.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuChucNang.add(itemDanhSachChuyenBay);
		
		JMenuItem itemKhachHang = new JMenuItem("Khách Hàng");
		itemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh = new KhachHang();
				tabbedPane.addTab("Khách hàng    ", kh.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuChucNang.add(itemKhachHang);
		
		menuBaoCao = new JMenu("Báo cáo");
		menuBaoCao.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(menuBaoCao);
		
		JMenuItem itemDTBVThang = new JMenuItem("Doanh thu bán vé tháng");
		itemDTBVThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaoCaoDoanhThuThang dtt = new BaoCaoDoanhThuThang();
				tabbedPane.addTab("Doanh Thu Tháng    ", dtt.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuBaoCao.add(itemDTBVThang);
		
		JMenuItem itemDTBVNam = new JMenuItem("Doanh thu bán vé năm");
		itemDTBVNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BaoCaoDoanhThuNam bcn = new BaoCaoDoanhThuNam();
				tabbedPane.addTab("Doanh Thu Năm    ", bcn.getContentPane());
				if (tabbedPane.getComponentCount() > 1)
				{
					tabbedPane.remove(0);
				}
			}
		});
		menuBaoCao.add(itemDTBVNam);
	}

}

class CustomTabbedPaneUI extends MetalTabbedPaneUI
{
   Rectangle xRect;
  
   protected void installListeners() {
      super.installListeners();
      tabPane.addMouseListener(new MyMouseHandler());
   }
  
   protected void paintTab(Graphics g, int tabPlacement,
                           Rectangle[] rects, int tabIndex,
                           Rectangle iconRect, Rectangle textRect) {
      super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
  
      Font f = g.getFont();
      g.setFont(new Font("Courier", Font.BOLD, 10));
      g.setColor(Color.RED);
      FontMetrics fm = g.getFontMetrics(g.getFont());
      int charWidth = fm.charWidth('x');
      int maxAscent = fm.getMaxAscent();
      g.drawString("x", textRect.x + textRect.width - 3, textRect.y + textRect.height - 3);
      g.drawRect(textRect.x + textRect.width - 5, textRect.y + textRect.height - maxAscent, charWidth + 2, maxAscent - 1);
      xRect = new Rectangle(textRect.x + textRect.width-5, textRect.y + textRect.height - maxAscent, charWidth+2, maxAscent-1);
      g.setFont(f);
    }
  
    public class MyMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println(e);
            if (xRect.contains(e.getPoint())) {
               JTabbedPane tabPane = (JTabbedPane)e.getSource();
               int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
               tabPane.remove(tabIndex);
            }
        }
    }
}
