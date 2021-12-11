/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Login;

/**
 *
 * @author maric
 */
public class LoginGestion {
    
    
    private static final String SQL_VALIDA="SELECT * FROM odontologo nombre, from username where username=? and pass=MD5(?)";
    
    public static Login Valida (String username, String passw){
        
        Login login = null;
        
        try{
            
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setString(1, username);
            sentencia.setString(2, passw);
            ResultSet rs= sentencia.executeQuery();
            
            if (rs.next()){//Si tiene la posibilidad de hacer next es porque tiene datos
                
                login= new Login (username,rs.getString(1),rs.getString(2));
            }
            
        }catch (SQLException ex){
            
            Logger.getLogger(LoginGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return login;
    }
    
}
