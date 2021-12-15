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
    private static final String CITA_SQL_SELECT = "SELECT * FROM cita WHERE idCita = ?";
    private static final String CITA_SQL_SELECT_ALL = "SELECT * FROM cita";
    private static final String CITA_SQL_INSERT = "INSERT INTO cita (motivoCita, fechaCita, cedulaPaciente) VALUES (?, ? ,?)";
    private static final String CITA_SQL_UPDATE = "UPDATE cita SET nombre = ?, motivoCita = ?,"+
                                             "fechaCita = ?, cedulaPaciente = ?";
    private static final String CITA_SQL_DELETE = "DELETE FROM cita WHERE idCita = ?";

    //Executions
    //SQL_SELECT exec
    public static Cita getCita(String cedulaAdmin){
    
        Cita cita = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(CITA_SQL_SELECT);
            sqlQuery.setString(1, cedulaAdmin);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                cita = new Cita(dataSet.getString(1),
                                          dataSet.getDate(2),
                                          dataSet.getString(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return cita;
    }
    
    //SQL_SELECT_ALL exec
    public static ArrayList<Cita> getCitas(){

        ArrayList<Cita> citaList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(CITA_SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while(dataSet != null && dataSet.next()){
                citaList.add(new Cita(dataSet.getString(1),
                                                dataSet.getDate(2),
                                                dataSet.getString(3)));
            }

        } catch (SQLException e) {
            Logger.getLogger(AdministradorGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return citaList;
    }

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
            sqlQuery.setString(1, cita.getMotivoCita());
            sqlQuery.setObject(2, cita.getFechaCita());
            sqlQuery.setString(3, cita.getCedulaPaciente());

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
