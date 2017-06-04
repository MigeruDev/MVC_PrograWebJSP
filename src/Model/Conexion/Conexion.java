/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion { 
    private static Conexion instancia=null;
    public static Connection conexion;
    private Conexion()
    {
        
    }
    public static Conexion getInstancia(String baseDatos, String claveBaseDatos) throws ClassNotFoundException, SQLException 
    {   
        
            try{
            Class.forName("com.mysql.jdbc.Driver");
            String BaseDeDatos = "jdbc:mysql://localhost:3306/mydb";
            conexion = DriverManager.getConnection(BaseDeDatos,baseDatos,claveBaseDatos);
            
            if(conexion != null){
                System.out.println("Conexion Exitosa !");
            }else{
                System.out.println("Conexion Fallida :( ");
            }
            }catch (SQLException ex){
                System.out.println("Coneccion Fallida");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return instancia;
      
    }
  
    
}
