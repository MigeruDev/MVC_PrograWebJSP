/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ErrorConexion;

import java.sql.SQLException;


public class AddHeaderException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3816558870002896869L;

	public AddHeaderException(SQLException ex) {
        super(ex);
    }
    
}
