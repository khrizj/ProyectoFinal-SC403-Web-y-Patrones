package gestion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evolucion;
import modelo.Conexion;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class EvolucionGestion {

    //CRUD elements
    private static final String EVOLUCION_SQL_INSERT = "INSERT INTO evolucion (motivoConsulta,presenciaDolor,descripcion,satisfechoConDentadura,cedulaPaciente) VALUES (?, ? ,?, ? ,?)";
    private static final String EVOLUCION_SQL_UPDATE = "UPDATE evolucion SET motivoConsulta = ?, presenciaDolor = ?,"
            + "descripcion = ?, satisfechoConDentadura = ?, cedulaPaciente = ? WHERE cedulaPaciente = ?";
    private static final String EVOLUCION_SQL_DELETE = "DELETE FROM evolucion WHERE cedulaPaciente = ?";

    //Executions
      //SQL_INSERT Exec
    public static boolean evolucionInsert(Evolucion evolucion){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareCall(EVOLUCION_SQL_INSERT);
            sqlQuery.setString(1, evolucion.getMotivoConsulta());
            sqlQuery.setBoolean(2, evolucion.isPresenciaDolor());
            sqlQuery.setString(3, evolucion.getDescripcion());
            sqlQuery.setBoolean(4, evolucion.isSatisfechoConDentadura());
            sqlQuery.setString(5, evolucion.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean evolucionUpdate(Evolucion evolucion){
        
        
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_UPDATE);
  
            sqlQuery.setString(1, evolucion.getMotivoConsulta());
            sqlQuery.setBoolean(2, evolucion.isPresenciaDolor());
            sqlQuery.setString(3, evolucion.getDescripcion());
            sqlQuery.setBoolean(4, evolucion.isSatisfechoConDentadura());
            sqlQuery.setString(5, evolucion.getCedulaPaciente());
            

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean evolucionDelete(Evolucion evolucion){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_DELETE);
            sqlQuery.setString(1, evolucion.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

}
