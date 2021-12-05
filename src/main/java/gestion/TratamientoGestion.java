package gestion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Tratamiento;
import modelo.Conexion;

public class TratamientoGestion {
    //INSERT AND DELETE statements
    private static final String SQL_INSERT = "INSERT INTO tratamiento (nombreTratamiento,"
                                            +"costoTratamiento, descripcionTratamiento,"
                                            +"cedulaPaciente) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM tratamiento WHERE nombreTratamiento = ?";

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
