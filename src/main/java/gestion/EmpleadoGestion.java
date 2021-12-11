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
    
    private static final String SQL_SELECT = "SELECT * FROM empleado WHERE cedulaEmpleado = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM empleado";
    
    public static Empleado getEmpleado(String cedulaEmpleado) {

        Empleado empleado = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaEmpleado);
            ResultSet dataSet = sqlQuery.executeQuery();

            if (dataSet.next()) {
                empleado = new Empleado(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getInt(8),
                        dataSet.getString(9));
            }
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return empleado;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Empleado> getEmpleado() {

        ArrayList<Empleado> EmpleadoList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while (dataSet != null && dataSet.next()) {
                EmpleadoList.add(new Empleado(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getInt(8),
                        dataSet.getString(9)));
            }

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return EmpleadoList;
    }
    
    
}
