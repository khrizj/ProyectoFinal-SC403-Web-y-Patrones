/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Empleado;


/**
 *
 * @author maric
 */
public class EmpleadoGestion {
    
    //CRUD
 
    private static final String SQL_INSERT = "INSERT INTO empleado(cedulaEmpleado, nombre, apellido1, apellido2,"+
                                            "username, pass, direccion, telefono1, email)"+
                                            "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado"+
                                            "SET cedulaEmpleado = ?, nombre = ?, apellido1 = ?, apellido2 = ?,"+
                                            "username = ?, pass = ?, direccion = ?, telefono = ?, email = ?"+
                                            "WHERE idClinica = ?";
    private static final String SQL_DELETE = "DELETE FROM clinica WHERE idClinica = ?";
    
    //SQL_INSERT Exec
    public static boolean empleadoInsert(Empleado empleado){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setInt(1, empleado.getCedulaEmpleado());
            sqlQuery.setString(2, empleado.getNombre());
            sqlQuery.setString(3, empleado.getApellido1());
            sqlQuery.setString(4, empleado.getUsername());
            sqlQuery.setString(5, empleado.getPassw());
            sqlQuery.setString(6, empleado.getDireccion());
            sqlQuery.setInt(7, empleado.getTelefono1());
            sqlQuery.setString(8, empleado.getEmail());

            return sqlQuery.executeUpdate() > 0;
        }catch(SQLException e){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean empleadoUpdate(Empleado empleado){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setString(1, empleado.getNombre());
            sqlQuery.setString(2, empleado.getApellido1());
            sqlQuery.setString(3, empleado.getUsername());
            sqlQuery.setString(4, empleado.getPassw());
            sqlQuery.setString(5, empleado.getDireccion());
            sqlQuery.setInt(6, empleado.getTelefono1());
            sqlQuery.setString(7, empleado.getEmail());
            sqlQuery.setInt(8, empleado.getCedulaEmpleado());

            return sqlQuery.executeUpdate() > 0;
        }catch(SQLException e){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_DELETE Exec
    public static boolean empleadoDelete(Empleado empleado){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setInt(1, empleado.getCedulaEmpleado());
            
            return sqlQuery.executeUpdate() > 0; 
        }catch(SQLException e){
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
    
}
