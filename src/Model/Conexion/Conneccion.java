/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Model.VO.*;
/**
 *
 * @author diegoM
 */
public class Conneccion {
     public static Connection getConnection(User login) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(login.getDbUrl(), login.getProperties());
            return connection;
        } catch (SQLException ex) {
            throw new IllegalArgumentException(login.getDbUrl());
        }
    }
}
