package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;


import Model.ErrorConexion.AddBodyException;
import Model.ErrorConexion.AddHeaderException;
import Model.ErrorConexion.CloseConnectionException;
import Model.ErrorConexion.QueryException;
import Model.VO.Query;
import Model.VO.Tupla;


public class DatabaseDAO {
	
	private Connection connection;
	
	public DatabaseDAO(Connection connection){
		this.connection = connection;
	}
	
	public void insert(Object o) throws QueryException, CloseConnectionException {
		Statement stmt = null;
		String query = null;
        try {
            query = Query.insertar(o);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            throw new QueryException(query, ex);
        } finally {
            closeConnection(stmt);
        }
    }

    public void addElement(String tableName, Map<String, String> fields) throws QueryException, CloseConnectionException {
        String query;
        query = Query.insertar(tableName, fields);
        update(query);
    }

    public void updateElement(String tableName, ArrayList<Tupla> previewFields, ArrayList<Tupla> newFields) throws QueryException, CloseConnectionException {
        String query;
        query = Query.actualizar(tableName, previewFields, newFields);
        System.out.println(query);
        update(query);
    }

    private void update(String query) throws QueryException, CloseConnectionException {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            throw new QueryException(query, ex);
        } finally {
            closeConnection(stmt);
        }
    }

    public ArrayList<ArrayList<String>> functionMax(String tableName, String colName) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        String query = Query.functionmaximo(tableName, colName);
        ArrayList<ArrayList<String>> result = consult(query);
        return result;
    }

    public ArrayList<ArrayList<String>> functionMin(String tableName, String colName) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        String query = Query.functionminimo(tableName, colName);
        ArrayList<ArrayList<String>> result = consult(query);
        return result;
    }

    public ArrayList<ArrayList<String>> functionCount(String tableName, String colName) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        String query = Query.functioncontar(tableName, colName);
        ArrayList<ArrayList<String>> result = consult(query);
        return result;
    }

    public ArrayList<ArrayList<String>> consult(String query) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        Statement stmt = null;
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        try {
            stmt = (Statement) connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            datos.add(getHeaderColName(result));
            addBody(datos, result);
            return datos;
        } catch (SQLException ex) {
            throw new QueryException(query, ex);
        } finally {
            closeConnection(stmt);
        }
    }

    public ArrayList<ArrayList<String>> getAll(String tableName) throws QueryException, AddHeaderException, AddBodyException, CloseConnectionException {
        String query = Query.selecionarTodoTabla(tableName);
        ArrayList<ArrayList<String>> datos;
        datos = consult(query);
        return datos;
    }

    private ArrayList<String> getHeaderColName(ResultSet result) throws AddHeaderException {
        try {
            ArrayList<String> columna = new ArrayList<>();
            int numCols = result.getMetaData().getColumnCount();
            for (int i = 0; i < numCols; i++) {
                columna.add(result.getMetaData().getColumnName(i + 1));
            }
            return columna;
        } catch (SQLException ex) {
            throw new AddHeaderException(ex);
        }
    }

    private void addBody(ArrayList<ArrayList<String>> datos, ResultSet result) throws AddBodyException {
        try {
            int numCols = result.getMetaData().getColumnCount();
            ArrayList<String> columna;
            while (result.next()) {
                columna = new ArrayList<>();
                for (int i = 0; i < numCols; i++) {
                    columna.add(result.getString(i + 1));
                }
                datos.add(columna);
            }
        } catch (SQLException ex) {
            throw new AddBodyException(ex);
        }
    }

    private ArrayList<ArrayList<String>> consultWithoutHeader(String query) throws AddBodyException, QueryException, CloseConnectionException {
        Statement stmt = null;
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            addBody(datos, result);
            return datos;
        } catch (SQLException ex) {
            throw new QueryException(query, ex);
        } finally {
            closeConnection(stmt);
        }
    }

    public void delete(String tableName, ArrayList<Tupla> fields) throws QueryException, CloseConnectionException {
        String query = Query.borrar(tableName, fields);
        query(query);
    }

    private void query(String query) throws QueryException, CloseConnectionException {
        Statement stmt = null;
        try {
            stmt = (Statement) connection.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            throw new QueryException(query, ex);
        } finally {
            closeConnection(stmt);
        }
    }

    public ArrayList<String> getAllTablesNames() throws AddBodyException, QueryException, CloseConnectionException {
        ArrayList<String> names = new ArrayList<>();
        String query = Query.seleccionarNombreTablas();
        ArrayList<ArrayList<String>> result = this.consultWithoutHeader(query);
        for (ArrayList<String> a : result) {
            names.add(a.get(0));
        }
        return names;
    }

    public ArrayList<String> getFields(String tableName) throws AddBodyException, QueryException, CloseConnectionException {
        ArrayList<String> fields = new ArrayList<>();
        String query = Query.seleccionarNombresColumnas(tableName);
        ArrayList<ArrayList<String>> result = this.consultWithoutHeader(query);
        for (ArrayList<String> a : result) {
            fields.add(a.get(0));
        }
        return fields;
    }

    public ArrayList<ArrayList<String>> search(String tableName, String subString) throws AddBodyException, 
    QueryException, CloseConnectionException, AddHeaderException {
        ArrayList<String> fields = getFields(tableName);
        String query = Query.buscar(tableName, fields, subString);
        ArrayList<ArrayList<String>> result = this.consult(query);
        return result;
    }

    public ArrayList<ArrayList<String>> obtenerElementosTabla(String tablaName) {

        String query = Query.ElementosDeUnaTabla(tablaName);
        Statement stmt = null;
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        try {
            stmt = (Statement) connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            int numCols = result.getMetaData().getColumnCount();
            ArrayList<String> columna;
            while (result.next()) {
                columna = new ArrayList<>();
                for (int i = 0; i < numCols; i++) {
                    columna.add(result.getString(i + 1));
                }
                datos.add(columna);
            }

        } catch (SQLException ex) {
        	
        }
        return datos;
    }
    
    private void closeConnection(Statement stmt) throws CloseConnectionException {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new CloseConnectionException();
        }
    }

}
