package Model.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/mvc_prograweb";
			String user = "root";
			String password = " "; //mysql
			
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con la base de datos");
			e.printStackTrace();
		}
		return con;
	}
}
