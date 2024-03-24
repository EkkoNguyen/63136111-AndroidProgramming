import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://LAPTOP-PC1DS6GI\\MSSQLSERVER03:1433;encrypt=true;trustServerCertificate=true;databaseName=QLBanSach;integratedSecurity=true"; 
			connection = DriverManager.getConnection(connectionURL);
			System.out.println("Kết nối csdl thành công");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Kết nối csdl thất bại");
			System.err.println(e.getMessage()+"/n"+e.getClass()+"/n"+e.getCause());
		}
	}
	
}
