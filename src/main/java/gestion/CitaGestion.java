package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cita;
import modelo.Conexion;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class CitaGestion {
        //CRUD elements
    private static final String CITA_SQL_INSERT = "INSERT INTO cita (motivoCita, fechaCita, cedulaPaciente) VALUES (?, ? ,?)";
    private static final String CITA_SQL_UPDATE = "UPDATE cita SET motivoCita =?, fechaCita =?  WHERE cedulapaciente = ?";
    private static final String CITA_SQL_DELETE = "DELETE FROM cita WHERE cedulaPaciente = ?";

    //SQL_INSERT Exec
    public static boolean citaInsert(Cita cita){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(CITA_SQL_INSERT);
            sqlQuery.setString(1, cita.getMotivoCita());
            sqlQuery.setObject(2, cita.getFechaCita());
            sqlQuery.setString(3, cita.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean citaUpdate(Cita cita){
        
        
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(CITA_SQL_UPDATE);
            
            sqlQuery.setObject(1,cita.getCedulaPaciente());
            sqlQuery.setString(2, cita.getMotivoCita());
            sqlQuery.setObject(3, cita.getFechaCita());
            

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean citaDelete(Cita cita){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(CITA_SQL_DELETE);
            sqlQuery.setString(1, cita.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
}
