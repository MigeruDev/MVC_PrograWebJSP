/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ErrorConexion;

import java.sql.SQLException;


public class AddBodyException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3634113868335669711L;

	public AddBodyException(SQLException ex) {
        super(ex);
    }
    
}
