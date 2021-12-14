package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.HistoriaDental;
import modelo.Conexion;

public class HistorialDentalGestion {
    //CRUD elements
    private static final String SQL_SELECT = "SELECT * FROM historiadental WHERE cedulaPaciente = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM historiadental";
    private static final String SQL_INSERT = "INSERT INTO historiadental (ultimaVisitaDentista, numeroCepilladosDia, usoHilo, usoEnjuague,"+
                                            "tipoPastaDental, numeroComidasDia, dietaMuyCariogenica, dietaPocoCariogenica,"+
                                            "dietaNadaCarigoenica, masAgua, igualAgua, menosAgua, cedulaPaciente)"+
                                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE historialDental"+ 
                                            "SET ultimaVisitaDentista = ?, numeroCepilladosDia = ?, usoHilo = ?,"+
                                            "usoEnjuague = ?, tipoPastaDental = ?, numeroComidasDia = ?, dietaMuyCariogenica = ?,"+
                                            "dietaPocoCariogenica = ?, dietaNadaCariogenica = ?, masAgua = ?,"+
                                            "igualAgua = ?, menosAgua = ?, cedulaPaciente = ?"+
                                            "WHERE cedulaPaciente = ?;";
    private static final String SQL_DELETE = "DELETE FROM historiadental WHERE cedulaPaciente = ? AND idHistoriaDental = ?";

    //SQL_SELECT Exec
    public static HistoriaDental getHistorial(String cedulaPaciente){
        HistoriaDental hist = null;

        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaPaciente);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                hist = new HistoriaDental(dataSet.getString(1), 
                                        dataSet.getInt(2), 
                                        dataSet.getBoolean(3), 
                                        dataSet.getBoolean(4), 
                                        dataSet.getString(5), 
                                        dataSet.getInt(6), 
                                        dataSet.getBoolean(7), 
                                        dataSet.getBoolean(8), 
                                        dataSet.getBoolean(9), 
                                        dataSet.getBoolean(10), 
                                        dataSet.getBoolean(11), 
                                        dataSet.getBoolean(12), 
                                        dataSet.getString(13));
            }
        } catch (SQLException e) {
            Logger.getLogger(HistorialDentalGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return hist;
    }

    
    //SQL_SELECT_ALL Exec
    public static ArrayList<HistoriaDental> getAllHistorial(){
        ArrayList<HistoriaDental> histList = null;

        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet != null && dataSet.next()){
                histList.add(new HistoriaDental(dataSet.getString(1), 
                            dataSet.getInt(2), 
                            dataSet.getBoolean(3), 
                            dataSet.getBoolean(4), 
                            dataSet.getString(5), 
                            dataSet.getInt(6), 
                            dataSet.getBoolean(7), 
                            dataSet.getBoolean(8), 
                            dataSet.getBoolean(9), 
                            dataSet.getBoolean(10), 
                            dataSet.getBoolean(11), 
                            dataSet.getBoolean(12), 
                            dataSet.getString(13))); 
            }
        } catch (SQLException e) {
            Logger.getLogger(HistorialDentalGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return histList;
    }

    //SQL_INSERT Exec
    public static boolean historialDentalInsert(HistoriaDental historial){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setString(1, historial.getUltimaVisitaDentista());
            sqlQuery.setInt(2, historial.getNumeroCepilladosDia());
            sqlQuery.setBoolean(3, historial.isUsoHilo());
            sqlQuery.setBoolean(4, historial.isUsoEnjuague());  
            sqlQuery.setString(5, historial.getTipoPastaDental());
            sqlQuery.setInt(6, historial.getNumeroComidasDia());
            sqlQuery.setBoolean(7, historial.isDietaMuyCariogenica());
            sqlQuery.setBoolean(8, historial.isDietaPocoCariogenica());
            sqlQuery.setBoolean(9, historial.isDietaNadaCariogenica());
            sqlQuery.setBoolean(10, historial.isMasAgua());
            sqlQuery.setBoolean(11, historial.isIgualAgua());
            sqlQuery.setBoolean(12, historial.isMenosAgua());
            sqlQuery.setString(13, historial.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;
        } catch (SQLException e){
            Logger.getLogger(HistorialDentalGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

        //SQL_UPDATE Exec
        public static boolean historialDentalUpdate(HistoriaDental historial){
            try{
                PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
                sqlQuery.setString(1, historial.getUltimaVisitaDentista());
                sqlQuery.setInt(2, historial.getNumeroCepilladosDia());
                sqlQuery.setBoolean(3, historial.isUsoHilo());
                sqlQuery.setBoolean(4, historial.isUsoEnjuague());  
                sqlQuery.setString(5, historial.getTipoPastaDental());
                sqlQuery.setInt(6, historial.getNumeroComidasDia());
                sqlQuery.setBoolean(7, historial.isDietaMuyCariogenica());
                sqlQuery.setBoolean(8, historial.isDietaPocoCariogenica());
                sqlQuery.setBoolean(9, historial.isDietaNadaCariogenica());
                sqlQuery.setBoolean(10, historial.isMasAgua());
                sqlQuery.setBoolean(11, historial.isIgualAgua());
                sqlQuery.setBoolean(12, historial.isMenosAgua());
                sqlQuery.setString(13, historial.getCedulaPaciente());
    
                return sqlQuery.executeUpdate() > 0;
            } catch (SQLException e){
                Logger.getLogger(HistorialDentalGestion.class.getName()).log(Level.SEVERE, null, e);
            }
    
            return false;
        }

        //SQL_DELETE Exec
        public static boolean historialDentalDelete(HistoriaDental historial){
            try{
                PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
                sqlQuery.setString(1, historial.getCedulaPaciente());
                sqlQuery.setInt(2, historial.getIdHistoriaDental());

                return sqlQuery.executeUpdate() > 0;
            }catch (SQLException e){
                Logger.getLogger(HistorialDentalGestion.class.getName()).log(Level.SEVERE, null, e);
            }
    
            return false;
        }
}
