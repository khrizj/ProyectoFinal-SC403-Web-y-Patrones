package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Tratamiento;
import modelo.Conexion;

public class TratamientoGestion {
    //CRUD
    private static final String SQL_SELECT = "SELECT * FROM tratamiento WHERE cedulaPaciente = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM tratamiento";
    private static final String SQL_INSERT = "INSERT INTO tratamiento (nombreTratamiento,"
                                            +"costoTratamiento, descripcionTratamiento,"
                                            +"cedulaPaciente) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tratamiento"+
                                            "SET nombreTratamiento = ?, costoTratamiento = ?"+
                                            "descripctionTratamiento = ?"+
                                            "WHERE cedulaPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM tratamiento WHERE nombreTratamiento = ?";

    //SQL_SELECT exec
    public static Tratamiento getTratamiento(String cedulaPaciente){
        Tratamiento tratamiento = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaPaciente);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                tratamiento = new Tratamiento(dataSet.getString(1),
                                            dataSet.getFloat(2),
                                            dataSet.getString(3),
                                            dataSet.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(TratamientoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return tratamiento;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Tratamiento> getTratamientos(){
        ArrayList<Tratamiento> tratamientoList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                tratamientoList.add(new Tratamiento(dataSet.getString(1),
                                    dataSet.getFloat(2),
                                    dataSet.getString(3),
                                    dataSet.getString(4)));
            }
        } catch (SQLException e) {
            Logger.getLogger(TratamientoGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return tratamientoList;
    }



    //SQL_INSERT Exec
    public static boolean tratamientoInsert(Tratamiento tratamiento){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setString(1, tratamiento.getNombreTratamiento());
            sqlQuery.setFloat(2, tratamiento.getCostoTratamiento());
            sqlQuery.setString(3, tratamiento.getDescripcionTratamiento());
            sqlQuery.setString(4, tratamiento.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_UPDATE Exec
    public static boolean tratamientoUpdate(Tratamiento tratamiento){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setString(1, tratamiento.getNombreTratamiento());
            sqlQuery.setFloat(2, tratamiento.getCostoTratamiento());
            sqlQuery.setString(3, tratamiento.getDescripcionTratamiento());
            sqlQuery.setString(4, tratamiento.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean tratamientoDelete(Tratamiento tratamiento){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setString(1, tratamiento.getNombreTratamiento());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
}
