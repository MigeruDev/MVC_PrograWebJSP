package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Model.VO.PersonaVO;

public class PersonaDAO {
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "theworstone", "admin");
			
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public static int addPersona(PersonaVO persona){
		int estado = 0;
		try{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Persona"
					+ "(idPersona,nombrePersona,apellidoPersona,edad) values(?,?,?,?)");
		}catch(Exception e){
			System.out.println(e);
		}
		return estado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
