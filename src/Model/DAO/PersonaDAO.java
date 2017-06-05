package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			PreparedStatement ps = con.prepareStatement("insert into persona"
					+ "(idPersona,nombrePersona,apellidoPersona,edad) values(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(persona.getId()));
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setInt(4, persona.getEdad());
			estado=ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		return estado;
	}
	
	
	public static int updatePersona(PersonaVO persona){
		int estado=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(
					"update persona set nombrePersona=?,apellidoPersona=?,edad=? where idPersona=?");
			ps.setString(1,persona.getNombre());
			ps.setString(2,persona.getApellido());
			ps.setInt(3,persona.getEdad());
			ps.setInt(4,Integer.parseInt(persona.getId()));
			estado=ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		return estado;
	}
	
	public static int deletePersona(PersonaVO persona){
		int estado=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from persona where idPersona=?");
			ps.setInt(1,Integer.parseInt(persona.getId()));
			estado=ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}

		return estado;
	}	
	
	public static List<PersonaVO> getAllRecords(){
		List<PersonaVO> list=new ArrayList<PersonaVO>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from persona");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				PersonaVO persona= new PersonaVO(String.valueOf(rs.getInt("idPersona")),
						rs.getString("nombrePersona"),rs.getString("apellidoPersona"));
				persona.setEdad(rs.getInt("edad"));
				list.add(persona);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public static PersonaVO getRecordById(String id){
		PersonaVO persona=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from persona where idPersona=?");
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				persona=new PersonaVO(String.valueOf(rs.getInt("idPersona")),
						rs.getString("nombrePersona"),rs.getString("apellidoPersona"));
				persona.setEdad(rs.getInt("edad"));				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return persona;
	}
	
}
