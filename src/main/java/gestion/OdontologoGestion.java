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
import modelo.Odontologo;

/**
 *
 * @author maric
 */
public class OdontologoGestion {

    private static final String SQL_SELECT = "SELECT * FROM odontologo WHERE cedulaOdontologo = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM odontologo";
    private static final String SQL_INSERT = "INSERT INTO odontologo (cedulaOdontologo, nombre,"
            + "apellido1, apellido2, username, pass,"
            + "direccion, telefono1,email)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_ODONTOLOGO = "UPDATE odontologo SET nombre=?"
            + "apellido1=?,apellido2=?,username=?,pass=?, "
            + "direccion=?,telefono1=?,email=? WHERE cedulaOdontologo=?";
    private static final String SQL_DELETE = "DELETE FROM odontologo WHERE cedulaOdontologo = ?";

    public static Odontologo getOdontologo(String cedulaOdontologo) {

        Odontologo odontologo = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaOdontologo);
            ResultSet dataSet = sqlQuery.executeQuery();

            if (dataSet.next()) {
                odontologo = new Odontologo(dataSet.getInt(1),
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
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return odontologo;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Odontologo> getOdontologo() {

        ArrayList<Odontologo> OdontologoList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while (dataSet != null && dataSet.next()) {
                OdontologoList.add(new Odontologo(dataSet.getInt(1),
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
            Logger.getLogger(OdontologoGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return OdontologoList;
    }

    //SQL_INSERT Exec
    public static boolean odontologoInsert(Odontologo odontologo) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);

            sqlQuery.setString(1, odontologo.getNombre());
            sqlQuery.setString(2, odontologo.getApellido1());
            sqlQuery.setString(3, odontologo.getApellido2());
            sqlQuery.setString(4, odontologo.getUsername());
            sqlQuery.setString(5, odontologo.getPassw());
            sqlQuery.setString(6, odontologo.getDireccion());
            sqlQuery.setInt(7, odontologo.getTelefono1());
            sqlQuery.setString(8, odontologo.getEmail());
            sqlQuery.setInt(9, odontologo.getCedulaOdontologo());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(OdontologoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_UPDATE Exec
    public static boolean odontologoUpdate(Odontologo odontologo) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATE_ODONTOLOGO);

            sentencia.setString(1, odontologo.getNombre());
            sentencia.setString(2, odontologo.getApellido1());
            sentencia.setString(3, odontologo.getApellido2());
            sentencia.setString(4, odontologo.getUsername());
            sentencia.setString(5, odontologo.getPassw());
            sentencia.setString(6, odontologo.getDireccion());
            sentencia.setInt(7, odontologo.getTelefono1());
            sentencia.setString(8, odontologo.getEmail());
            sentencia.setInt(9, odontologo.getCedulaOdontologo());
            
            return sentencia.executeUpdate()>0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_DELETE Exec
    public static boolean odontologoDelete(Odontologo odontologo) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setInt(1, odontologo.getCedulaOdontologo());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
