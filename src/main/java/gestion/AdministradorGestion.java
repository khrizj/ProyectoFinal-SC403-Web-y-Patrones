package gestion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Administrador;
import modelo.Conexion;

public class AdministradorGestion {
    //CRUD elements
    private static final String SQL_SELECT = "SELECT * FROM administrador WHERE cedulaAdmin = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM administrador";
    private static final String SQL_INSERT = "INSERT INTO administrador (cedulaAdmin, nombre, apellido1, apellido2,"+
                                             "username, pass, direccion, telefono1, email) VALUES (?, ? ,?, ? ,?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE administrador SET nombre = ?, apellido1 = ?,"+
                                             "apellido2 = ?, username = ?, pass = ?, direccion = ?, telefono1 = ?,"+
                                             "email =  ? WHERE cedulaAdmin = ?";
    private static final String SQL_DELETE = "DELETE FROM administrador WHERE cedulaAdmin = ?";

    //Executions
    //SQL_SELECT exec
    public static Administrador getAdmin(String cedulaAdmin){
    
        Administrador admin = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaAdmin);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                admin = new Administrador(dataSet.getString(1),
                                          dataSet.getString(2),
                                          dataSet.getString(3),
                                          dataSet.getString(4),
                                          dataSet.getString(5),
                                          dataSet.getString(6),
                                          dataSet.getString(7),
                                          dataSet.getString(8),
                                          dataSet.getString(9),
                                          dataSet.getInt(10));
            }
        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return admin;
    }
    
    //SQL_SELECT_ALL exec
    public static ArrayList<Administrador> getAdmins(){

        ArrayList<Administrador> adminList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while(dataSet != null && dataSet.next()){
                adminList.add(new Administrador(dataSet.getString(1),
                                                dataSet.getString(2),
                                                dataSet.getString(3),
                                                dataSet.getString(4),
                                                dataSet.getString(5),
                                                dataSet.getString(6),
                                                dataSet.getString(7),
                                                dataSet.getString(8),
                                                dataSet.getString(9),
                                                dataSet.getInt(10)));
            }

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return adminList;
    }

    //SQL_INSERT Exec
    public static boolean adminInsert(Administrador admin){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setString(1, admin.getCedulaAdmin());
            sqlQuery.setString(2, admin.getNombre());
            sqlQuery.setString(3, admin.getApellido1());
            sqlQuery.setString(4, admin.getApellido2());
            sqlQuery.setString(5, admin.getUsername());
            sqlQuery.setString(6, admin.getPass());
            sqlQuery.setString(7, admin.getDireccion());
            sqlQuery.setString(8, admin.getTelefono1());
            sqlQuery.setString(9, admin.getEmail());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean adminUpdate(Administrador admin){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setString(1, admin.getNombre());
            sqlQuery.setString(2, admin.getApellido1());
            sqlQuery.setString(3, admin.getApellido2());
            sqlQuery.setString(4, admin.getUsername());
            sqlQuery.setString(5, admin.getPass());
            sqlQuery.setString(6, admin.getDireccion());
            sqlQuery.setString(7, admin.getTelefono1());
            sqlQuery.setString(8, admin.getEmail());
            sqlQuery.setString(9, admin.getCedulaAdmin());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean adminDelete(Administrador admin){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setString(1, admin.getCedulaAdmin());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
}
