package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	public static Connection getJDBCConnection(){
		final String url = "jdbc:mysql://localhost:3306/quanlychuyenbay?user=root&password=123456";
		
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url);
			
			return conn;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		Connection connection = getJDBCConnection();
		
		if(connection != null)
		{
			System.out.println("THANH CONG");
		}
		else
		{
			System.out.println("THAT BAI");
		}
	}
}
