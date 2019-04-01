package View;

import java.awt.EventQueue;
import javax.swing.JFrame;

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
//		frmMnHnhChnh.setUndecorated(true);
		frmMnHnhChnh.setVisible(true);
		
	}

}
