package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private static final String EVOLUCION_SQL_SELECT = "SELECT * FROM evolucion WHERE cedulaPaciente = ?";
    private static final String EVOLUCION_SQL_SELECT_ALL = "SELECT * FROM evolucion";
    private static final String EVOLUCION_SQL_INSERT = "INSERT INTO evolucion (motivoConsulta, presenciaDolor, descripcion, satisfechoConDentadura,"
            + "cedulaPaciente) VALUES (?, ? ,?, ? ,?)";
    private static final String EVOLUCION_SQL_UPDATE = "UPDATE evolucion SET motivoConsulta = ?, presenciaDolor = ?,"
            + "descripcion = ?, satisfechoConDentadura = ?, cedulaPaciente = ? WHERE cedulaPaciente = ?";
    private static final String EVOLUCION_SQL_DELETE = "DELETE FROM administrador WHERE cedulaPaciente = ? AND idEvolucion = ?";

    //Executions
    //SQL_SELECT exec
    public static Evolucion getEvolucionXPaciene(String cedulaPaciente) {

        Evolucion evolucion = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_SELECT);
            sqlQuery.setString(1, cedulaPaciente);
            ResultSet dataSet = sqlQuery.executeQuery();

            if (dataSet.next()) {
                evolucion = new Evolucion(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getBoolean(3),
                        dataSet.getString(4),
                        dataSet.getBoolean(5),
                        dataSet.getString(6));
            }
        } catch (SQLException e) {
            Logger.getLogger(EvolucionGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return evolucion;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Evolucion> getAllEvoulucion() {

        ArrayList<Evolucion> evolList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while (dataSet != null && dataSet.next()) {
                evolList.add(new Evolucion(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getBoolean(3),
                        dataSet.getString(4),
                        dataSet.getBoolean(5),
                        dataSet.getString(6)));
            }

        } catch (SQLException e) {
            Logger.getLogger(EvolucionGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return evolList;
    }

    //SQL_INSERT Exec
    public static boolean evolucionInsert(Evolucion evolucion) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_INSERT);
            sqlQuery.setString(1, evolucion.getMotivoConsulta());
            sqlQuery.setBoolean(2, evolucion.isPresenciaDolor());
            sqlQuery.setString(3, evolucion.getDescripcion());
            sqlQuery.setBoolean(4, evolucion.isSatisfechoConDentadura());
            sqlQuery.setString(5, evolucion.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(EvolucionGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_UPDATE Exec
    public static boolean evolucionUpdate(Evolucion evolucion) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_UPDATE);
            sqlQuery.setString(1, evolucion.getMotivoConsulta());
            sqlQuery.setBoolean(2, evolucion.isPresenciaDolor());
            sqlQuery.setString(3, evolucion.getDescripcion());
            sqlQuery.setBoolean(4, evolucion.isSatisfechoConDentadura());
            sqlQuery.setString(5, evolucion.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(EvolucionGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_DELETE Exec
    public static boolean evolucionDelete(Evolucion evolucion) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(EVOLUCION_SQL_DELETE);
            sqlQuery.setString(1, evolucion.getCedulaPaciente());
            sqlQuery.setInt(1, evolucion.getIdEvolucion());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(EvolucionGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

}
