package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.HabitosParafuncionales;
import modelo.Conexion;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class HabitosParafuncionalesGestion {
    
     //CRUD elements
    private static final String HABITOSP_SQL_INSERT = "INSERT INTO habitosParafuncionales (comeUnnas, bruxismo, ronca, dormirBocaAbierta,"+
                                             "chuparDedo, deglusionAtipica, morderObjetos, cedulaPaciente) VALUES (?, ? ,?, ? ,?, ?, ?, ?)";
    private static final String HABITOSP_SQL_UPDATE = "UPDATE habitosParafuncionales SET comeUnnas = ?, bruxismo = ?,"+
                                             "ronca = ?, dormirBocaAbierta = ?, chuparDedo = ?, deglusionAtipica = ?, morderObjetos = ?,"+
                                             "cedulaPaciente =  ? WHERE cedulaPaciente = ?";
    private static final String HABITOSP_SQL_DELETE = "DELETE FROM habitosParafuncionales WHERE cedulaPaciente = ?";

    //Executions
    //SQL_SELECT exec
    public static HabitosParafuncionales getHabitoP(String cedulaPaciente){
    
        HabitosParafuncionales habitoP = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareCall(HABITOSP_SQL_INSERT);
            sqlQuery.setString(1, cedulaPaciente);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                habitoP = new HabitosParafuncionales(dataSet.getBoolean(1),
                                          dataSet.getBoolean(2),
                                          dataSet.getBoolean(3),
                                          dataSet.getBoolean(4),
                                          dataSet.getBoolean(5),
                                          dataSet.getBoolean(6),
                                          dataSet.getBoolean(7),
                                          dataSet.getString(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(HabitosParafuncionalesGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return habitoP;
    }
    
    //SQL_SELECT_ALL exec
    public static ArrayList<HabitosParafuncionales> getHabitos(){

        ArrayList<HabitosParafuncionales> habitosPList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(HABITOSP_SQL_UPDATE);
            ResultSet dataSet = sqlQuery.executeQuery();

            while(dataSet != null && dataSet.next()){
                habitosPList.add(new HabitosParafuncionales(dataSet.getBoolean(1),
                                          dataSet.getBoolean(2),
                                          dataSet.getBoolean(3),
                                          dataSet.getBoolean(4),
                                          dataSet.getBoolean(5),
                                          dataSet.getBoolean(6),
                                          dataSet.getBoolean(7),
                                          dataSet.getString(8)));
            }

        } catch (SQLException e) {
            Logger.getLogger(HabitosParafuncionalesGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return habitosPList;
    }

    //SQL_INSERT Exec
    public static boolean habitosParafInsert(HabitosParafuncionales habitosP){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(HABITOSP_SQL_INSERT);
            sqlQuery.setBoolean(1, habitosP.isComeUnnas());
            sqlQuery.setBoolean(2, habitosP.isBruxismo());
            sqlQuery.setBoolean(3, habitosP.isRonca());
            sqlQuery.setBoolean(4, habitosP.isDormirBocaAbierta());
            sqlQuery.setBoolean(5, habitosP.isChuparDedo());
            sqlQuery.setBoolean(6, habitosP.isDeglusionAtipica());
            sqlQuery.setBoolean(7, habitosP.isMorderObjetos());
            sqlQuery.setString(8, habitosP.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(HabitosParafuncionalesGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean habitosParafUpdate(HabitosParafuncionales habitosP){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(HABITOSP_SQL_UPDATE);
            sqlQuery.setBoolean(1, habitosP.isComeUnnas());
            sqlQuery.setBoolean(2, habitosP.isBruxismo());
            sqlQuery.setBoolean(3, habitosP.isRonca());
            sqlQuery.setBoolean(4, habitosP.isDormirBocaAbierta());
            sqlQuery.setBoolean(5, habitosP.isChuparDedo());
            sqlQuery.setBoolean(6, habitosP.isDeglusionAtipica());
            sqlQuery.setBoolean(7, habitosP.isMorderObjetos());
            sqlQuery.setString(8, habitosP.getCedulaPaciente());
            
            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(HabitosParafuncionalesGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean habitosParafDelete(HabitosParafuncionales habitosP){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(HABITOSP_SQL_DELETE);
            sqlQuery.setString(1, habitosP.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(HabitosParafuncionalesGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
}
