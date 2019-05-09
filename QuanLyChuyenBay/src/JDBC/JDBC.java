package JDBC;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC {

	public static Connection getJDBCConnection(){
		Properties prop = new Properties();
		String URL;
		String USER;
		String PASSWORD;
		Connection con;
		
		
		
		try {
			prop.load(new FileReader(new File("config.properties")));
			URL = prop.getProperty("url");
			USER = prop.getProperty("user");
			PASSWORD = prop.getProperty("password");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			
			return con;
			
		}catch (Exception e) {
			// TODO: handle exception
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
