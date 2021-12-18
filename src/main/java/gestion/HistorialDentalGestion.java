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
    private static final String SQL_INSERT = "INSERT INTO historiaDental (ultimaVisitaDentista, numeroCepilladosDia, usoHilo, usoEnjuague,tipoPastaDental, numeroComidasDia, dietaMuyCariogenica, dietaPocoCariogenica,dietaNadaCariogenica, masAgua, igualAgua, menosAgua, cedulaPaciente) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE historialDental"+ 
                                            "SET ultimaVisitaDentista = ?, numeroCepilladosDia = ?, usoHilo = ?,"+
                                            "usoEnjuague = ?, tipoPastaDental = ?, numeroComidasDia = ?, dietaMuyCariogenica = ?,"+
                                            "dietaPocoCariogenica = ?, dietaNadaCariogenica = ?, masAgua = ?,"+
                                            "igualAgua = ?, menosAgua = ?, cedulaPaciente = ?"+
                                            "WHERE cedulaPaciente = ?;";
    private static final String SQL_DELETE = "DELETE FROM historiaDental WHERE cedulaPaciente = ?";


    //SQL_INSERT Exec
    public static boolean historialDentalInsert(HistoriaDental historial){
        try{
            PreparedStatement sqlQuery = Conexion.getConexion().prepareCall(SQL_INSERT);
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
