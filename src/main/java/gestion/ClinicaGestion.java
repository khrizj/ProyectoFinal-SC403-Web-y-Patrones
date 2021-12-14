/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import modelo.Clinica;
import modelo.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maric
 */
public class ClinicaGestion {
    
    int id; 

    //CRUD
    private static final String SQL_SELECT = "SELECT * FROM clinica WHERE idClinica = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM clinica";
    private static final String SQL_INSERT = "INSERT INTO clinica(idClinica, nombreClinica, direccion, telefono1, email) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clinica"+
                                            "SET nombreClinica = ?, direccion = ?, telefono = ?, email = ?"+
                                            "WHERE idClinica = ?";
    private static final String SQL_DELETE = "DELETE FROM clinica WHERE idClinica = ?";

    //SQL_SELECT exec
    public static Clinica getClinica(String idClinica){
        Clinica clinica = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, idClinica);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                clinica = new Clinica(dataSet.getInt(1),
                                    dataSet.getString(2),
                                    dataSet.getString(3),
                                    dataSet.getInt(4),
                                    dataSet.getString(5));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ClinicaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return clinica;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Clinica> getClinicas(){
        ArrayList<Clinica> clinicaList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                clinicaList.add(new Clinica(dataSet.getInt(1),
                                dataSet.getString(2),
                                dataSet.getString(3),
                                dataSet.getInt(4),
                                dataSet.getString(5)));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ClinicaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return clinicaList;
    }

    //SQL_INSERT Exec
    public static boolean clinicaInsert(Clinica clinica){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setString(1, clinica.getNombreClinica());
            sqlQuery.setString(2, clinica.getDireccion());
            sqlQuery.setInt(3, clinica.getTelefono());
            sqlQuery.setString(4, clinica.getEmail());
            
            return sqlQuery.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(ClinicaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_UPDATE Exec
    public static boolean clinicaUpdate(Clinica clinica){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setString(1, clinica.getNombreClinica());
            sqlQuery.setString(2, clinica.getDireccion());
            sqlQuery.setInt(3, clinica.getTelefono());
            sqlQuery.setString(4, clinica.getEmail());
            sqlQuery.setInt(5, clinica.getIdClinica());
            
            return sqlQuery.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(ClinicaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_DELETE Exec
    public static boolean clinicaDelete(Clinica clinica){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setInt(1, clinica.getIdClinica());
            
            return sqlQuery.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(ClinicaGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
