package Model.Service;

import Model.Conexion.Conneccion;
import Model.DAO.DatabaseDAO;
import Model.ErrorConexion.AddBodyException;
import Model.ErrorConexion.AddHeaderException;
import Model.ErrorConexion.CloseConnectionException;
import Model.ErrorConexion.QueryException;
import Model.VO.PersonaVO;
import Model.VO.Tupla;
import Model.VO.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

public class PersonaService {

	private static PersonaService instance = null;
	private DatabaseDAO database;
	
	private PersonaService(){
		
	}
	
	public static PersonaService getInstance(){
		if(instance == null){
			return instance = new PersonaService();
		}
		return instance;
	}
	
	private PersonaService (String base_datos, String clave_base_datos){
		User login = new User("jdbc:mysql://localhost:3306/mydb");
		login.setUser("root");
		login.setPassword("1234");
		Connection connection = Conneccion.getConnection(login);
        database = new DatabaseDAO(connection);
	}
	
	public void validarDatosPersona(PersonaVO persona) {
		String cedula = persona.getId();
		String nombre = persona.getNombre();
		String apellido = persona.getApellido();
		Integer edad = persona.getEdad();
        if (cedula == null || cedula.length() != 10) {
            throw new IllegalArgumentException("Cedula Incorrecta");
        } else if (nombre == null || nombre.length() < 1) {
            throw new IllegalArgumentException("Ingrese un nombre");
        } else if (apellido == null || apellido.length() < 1) {
            throw new IllegalArgumentException("Ingrese un apellido");
        } else if (edad == null) {
            throw new IllegalArgumentException("La edad es incorrecta");
        }
    }
	
	
	public void addElement(String tableName, Map<String, String> fields) throws QueryException, CloseConnectionException {
        database.addElement(tableName, fields);
    }
	
	public ArrayList<ArrayList<String>> getAll(String tableName) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        return database.getAll(tableName);
    }

    public void deleteRow(String tableName, ArrayList<Tupla> fields) throws QueryException, CloseConnectionException {
        database.delete(tableName, fields);
    }

    public void update(String tableName, ArrayList<Tupla> previewRow, ArrayList<Tupla> newRow) throws QueryException, CloseConnectionException {
        database.updateElement(tableName, previewRow, newRow);
    }

}
