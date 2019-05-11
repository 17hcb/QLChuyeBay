package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.KhachHangEntity;

public class CreateData {
	public static void main(String[] args) throws Exception {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(KhachHangEntity.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			KhachHangEntity emp = new KhachHangEntity();
			emp.setIdKhachHang(4);
			emp.setCmnd("093352214");
			emp.setTenKhachHang("NguyenQuocCuong");
			emp.setSoDienThoai("0909696238291");
			
			session.beginTransaction();
			
			session.save(emp);
			
			session.getTransaction().commit();
			
			System.out.println("Successfully inserted");
			
		}
		finally {
			factory.close();
		}
	}
}
