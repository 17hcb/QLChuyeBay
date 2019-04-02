package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

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
		
		JMenu menuHeThong = new JMenu("Hệ thống");
		menuHeThong.setIcon(new ImageIcon(Main.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		menuBar.add(menuHeThong);
		
		JMenuItem itemQLNV = new JMenuItem("Quản lý nhân viên");
		menuHeThong.add(itemQLNV);
		
		JMenuItem itemDoiMK = new JMenuItem("Đổi mật khẩu");
		menuHeThong.add(itemDoiMK);
		
		JMenuItem itemLogout = new JMenuItem("Đăng xuất");
		menuHeThong.add(itemLogout);
		
		JMenuItem itemExit = new JMenuItem("Thoát");
		menuHeThong.add(itemExit);
		
		JMenu menuQuanLy = new JMenu("Quản Lý");
		menuQuanLy.setIcon(new ImageIcon(Main.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		menuBar.add(menuQuanLy);
		
		JMenuItem itemQLSanBay = new JMenuItem("Quản lý sân bay");
		menuQuanLy.add(itemQLSanBay);
		
		JMenuItem itemQLTuyenBay = new JMenuItem("Quản lý tuyến bay");
		menuQuanLy.add(itemQLTuyenBay);
		
		JMenuItem itemQLMayBay = new JMenuItem("Quản lý máy bay");
		menuQuanLy.add(itemQLMayBay);
		
		JMenuItem itemQLLichBay = new JMenuItem("Quản lý lịch bay");
		menuQuanLy.add(itemQLLichBay);
		
		JMenuItem itemQLHangVe = new JMenuItem("Quản lý hạng vé");
		menuQuanLy.add(itemQLHangVe);
		
		JMenuItem itemQLGiaVe = new JMenuItem("Quản lý giá vé");
		menuQuanLy.add(itemQLGiaVe);
		
		JMenuItem itemQLKhachHang = new JMenuItem("Quản lý khách hàng");
		menuQuanLy.add(itemQLKhachHang);
		
		JMenuItem itemQLDatCho = new JMenuItem("Quản lý đặt chỗ");
		menuQuanLy.add(itemQLDatCho);
		
		JMenu menuBaoCao = new JMenu("Báo cáo");
		menuBaoCao.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(menuBaoCao);
		
		JMenuItem itemDTBVThang = new JMenuItem("Doanh thu bán vé tháng");
		menuBaoCao.add(itemDTBVThang);
//		frmMnHnhChnh.setUndecorated(true);
		frmMnHnhChnh.setVisible(true);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
