/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;


/**
 *
 *
 */
public class Query {
    public static String insertar(Object o) {
        
        Set<Entry<String, String>> object_values = sacarvalores(o).entrySet();
        StringJoiner fields = new StringJoiner(",");
        StringJoiner values = new StringJoiner(",");
        
        for (Entry<String, String> entry : object_values) {
            fields.add(entry.getKey());
            values.add(entry.getValue());
        }
        
        String query;
        query = "INSERT INTO " + getName(o) + " " +
                "(" + fields.toString() + ")" + " " +
                "VALUES(" + values.toString() + ")";
        return query;
    }

    private static String getName(Object o) {
        return o.getClass().getName();
    }

    private static Map<String, String> sacarvalores(Object o) {
        Map<String, String> values = new LinkedHashMap<>();
        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(o);
                if (value != null)
                    values.put(field.getName(), value.toString());
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            // Todo esta bien
        }
        return values;
    }

    public static String insertar(String tableName, Map<String, String> fieldsMap) {
        
        String fields="" ;
        String values="" ;
        for (Entry<String, String> entry : fieldsMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                fields=fields+entry.getKey()+",";
                values=values+"'" + entry.getValue() + "'"+",";
            }
        }
        fields= fields.substring(0,fields.length()-1);
        values = values.substring(0,values.length()-1);
        String query;
        query = "INSERT INTO " + tableName + " " +
                "(" + fields.toString() + ")" + " " +
                "VALUES(" + values.toString() + ")";
        return query;
    }

    public static  String selecionarTodoTabla(String tableName) {
        String query;
        query = "SELECT * FROM " + tableName;
        return query;
    }

    public static String borrar(String tableName, ArrayList<Tupla> fields) {
        String query;
        query = "DELETE FROM" + " " + tableName + " " +
                "WHERE" + " " + getCondition(fields); 
        return query;
    }

    public static String seleccionarNombresColumnas(String tableName) {
        String query;
        query = "SELECT" + " " + "COLUMNS" + " " +
                "FROM" + " " + "proyecto_torneo" + " " +
                "WHERE" + " " + "TABLE_NAME" + "=" + "'" + tableName + "'";
        return query;
    }

    public static String seleccionarNombreTablas() {
        String query;
        query = "SELECT" + " " + "TABLE_NAME" + " " +
                "FROM" + " " + "USER_TABLES";
        return query;
    }

    private static String getCondition(ArrayList<Tupla> fields) {
        String condition = "";
        for (Tupla field : fields)
            condition=condition+field.getName() + "=" + "'" + field.getValue() + "'"+" AND ";
        condition = condition.substring(0,condition.length()-4);
        return condition.toString();
    }

    public static String actualizar(String tableName, ArrayList<Tupla> previewfields, ArrayList<Tupla> newFields) {
        String query;
        query = "UPDATE" + " " + tableName + " " +
                "SET" + " " + getSet(newFields) + " " +
                "WHERE" + " " + getCondition(previewfields);
        return query;
    }

    private static String getSet(ArrayList<Tupla> fields) {
        String condition ="";
        for (Tupla field : fields)
            condition=condition+field.getName() + "=" + "'" + field.getValue() + "' ,";
        condition = condition.substring(0,condition.length()-1);
        return condition.toString();
    }
    
    public static String functionSuma(String table, String columna) {
        return funcion("SUM", table, columna);
    }
    
    public static String functionpromedio(String table, String columna) {
        return funcion("AVG", table, columna);
    }
    
    public static String functionmaximo(String table, String columna) {
        return funcion("MAX", table, columna);
    }
    
    public static String functionminimo(String table, String columna) {
        return funcion("MIN", table, columna);
    }
    
    public static String functioncontar(String table, String columna) {
        return funcion("COUNT", table, columna);
    }
    
    private static String funcion(String function, String table, String columna) {
        String query;
        query = "SELECT" + " " +
                function + "(" + columna + ")" +
                "FROM" + " " + table;
        return query;
    }
    
    public static String buscar(String table, ArrayList<String> columnas, String subString) {
        String query;
        StringJoiner search = new StringJoiner(" or ");
        for (String col : columnas)
            search.add("UPPER" + " " + "(" + col + ")" + " " +
                    "LIKE" + " " + "'" + "%" +
                    subString.toUpperCase() + "%" + "'"
            );
        query = "SELECT" + " " + "*" + " " +
                "FROM" + " " + table + " " +
                "WHERE" + " " + search.toString();
        return query;
    } 
    public static String ElementosDeUnaTabla(String table) {
        String query;
        
        query = "SELECT" + " " + "*" + " " +
                "FROM" + " " + table + " " ;
        return query;
    } 

    static String menorque(String table, String columna, String valor) {
        String query;
        query = getCondicion(table, columna, valor, "<");
        return query;                
    }

    public static String mayorque(String tabla, String columna, String valor) {
        String query;
        query = getCondicion(tabla, columna, valor, ">");
        return query;                
    }

    public static String igualdad(String tabla, String columna, String valor) {
        String query;
        query = getCondicion(tabla, columna, valor, "=");
        return query;                
    }

    public static String desiguales(String tabla, String columna, String valor) {
        String query;
        query = getCondicion(tabla, columna, valor, "<>");
        return query;
    }

    private static String getCondicion(String table, String columna, String valor, String operador) {
        String query;
        query = "SELECT" + " " + "*" + " " +
                "FROM" + " " + table + " " +
                "WHERE" + " " + columna + operador + "'" + valor + "'";
        return query;
    }
    
}
