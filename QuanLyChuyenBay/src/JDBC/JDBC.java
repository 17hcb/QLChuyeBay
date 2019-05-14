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

		try {
			prop.load(new FileReader(new File("config.properties")));
			URL = prop.getProperty("url");
			USER = prop.getProperty("user");
			PASSWORD = prop.getProperty("password");
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			return con;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
