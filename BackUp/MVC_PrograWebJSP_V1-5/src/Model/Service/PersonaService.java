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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

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
		login.setPassword("andre");
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
	
	/**
	 * 
	 * @param baseDatos
	 * @param claveBaseDatos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
    public static void initQuerySrv(String baseDatos, String claveBaseDatos) throws ClassNotFoundException, SQLException {
        instance = new PersonaService(baseDatos, claveBaseDatos);
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
    
    public ArrayList<ArrayList<String>> obtenerElemento(String tablaNam) {
        return database.obtenerElementosTabla(tablaNam);
    }
    /**
     * 
     * @param args
     * @throws QueryException
     * @throws CloseConnectionException
     * 
     */
    /*
    public static void main(String[] args) throws QueryException, CloseConnectionException {
		try {
			PersonaService persona_service;
			PersonaService.initQuerySrv("mydb", "1234");
			persona_service = PersonaService.getInstance();
			
			Map<String, String> personaNueva = new HashMap<>();
			personaNueva.put("idPersona", "03");
			personaNueva.put("nombrePersona", "CARLOS");
			personaNueva.put("apellidoPersona", "SANTAMARIA");
			personaNueva.put("edad", "25");
			
			//persona_service.addElement("persona", personaNueva);
			
	        ArrayList<ArrayList<String>> datos=persona_service.obtenerElemento("persona");
	        Iterator<ArrayList<String>> iterador = datos.iterator();
	        while(iterador.hasNext()){
	        	ArrayList<String> next = iterador.next();
	        	Iterator<String> iterator = next.iterator();
	        	Object[]objeto = new Object[4];
	        	int i = 0;
	        	while (iterator.hasNext()){
	        		objeto[i] = iterator.next();
	        		i++;
	        	}
	        	
	        	System.out.println(objeto[0]);
	        	System.out.println(objeto[1]);
	        	System.out.println(objeto[2]);
	        	System.out.println(objeto[3]);
	
	        }
			
			JOptionPane.showMessageDialog(null, "�sta verga sali� bien !!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    */
}

