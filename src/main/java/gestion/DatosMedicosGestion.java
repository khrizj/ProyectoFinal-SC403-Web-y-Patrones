package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.DatosMedicos;
import modelo.Conexion;

public class DatosMedicosGestion {
    //CRUD elements
    private static final String SQL_SELECT = "SELECT * FROM datosMedicos WHERE cedulaPaciente = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM datosMedicos";
    private static final String SQL_INSERT = "INSERT INTO datosMedicos (antecedentesPatologicosPersonales,"
                                            +"antecendentesPatologicosFamiliares, antecedentesQuirugicos,"
                                            +"alergia, alergiaDetalle, medicamentosConsumidos, cedulaPaciente)"
                                            +"VALUES (?, ?, ?, ?, ?, ?, ?,)";
    private static final String SQL_UPDATE = "UPDATE Paciente SET antecedentesPatologicosPersonales = ?,"
                                            +"antecendentesPatologicosFamiliares = ?, antecedentesQuirugicos  = ?,"
                                            +"alergia  = ?, alergiaDetalle = ?, medicamentosConsumidos = ?" 
                                            +"WHERE cedulaPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE cedulaPaciente = ?";

        //Executions
     //SQL_SELECT exec
     public static DatosMedicos getDato(String cedulaPaciente){
     
        DatosMedicos data = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaPaciente);
            ResultSet dataSet = sqlQuery.executeQuery();

            if(dataSet.next()){
                data = new DatosMedicos(dataSet.getInt(1),
                                        dataSet.getString(2),
                                        dataSet.getString(3),
                                        dataSet.getString(4),
                                        dataSet.getBoolean(5),
                                        dataSet.getString(6),
                                        dataSet.getString(7),
                                        dataSet.getString(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    //SQL_SELECT_ALL exec
    public static ArrayList<DatosMedicos> getDatos(){

        ArrayList<DatosMedicos> dataList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while(dataSet != null && dataSet.next()){
                dataList.add(new DatosMedicos(dataSet.getInt(1),
                                            dataSet.getString(2),
                                            dataSet.getString(3),
                                            dataSet.getString(4),
                                            dataSet.getBoolean(5),
                                            dataSet.getString(6),
                                            dataSet.getString(7),
                                            dataSet.getString(8)));
            }

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return dataList;
    }

    //SQL_INSERT Exec
    public static boolean datosInsert(DatosMedicos datos){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setString(1, datos.getAntecedentesPatologicosPersonales());
            sqlQuery.setString(2, datos.getAntecedentesPatologicosFamiliares());
            sqlQuery.setString(3, datos.getAntecedentesQuirurgicos());
            sqlQuery.setBoolean(4, datos.isAlergia());
            sqlQuery.setString(5, datos.getAlergiaDetalle());
            sqlQuery.setString(6, datos.getMedicamentosConsumidos());
            
            sqlQuery.setString(7, datos.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    //SQL_UPDATE Exec
    public static boolean datosUpdate(DatosMedicos datos){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setString(1, datos.getAntecedentesPatologicosPersonales());
            sqlQuery.setString(2, datos.getAntecedentesPatologicosFamiliares());
            sqlQuery.setString(3, datos.getAntecedentesQuirurgicos());
            sqlQuery.setBoolean(4, datos.isAlergia());
            sqlQuery.setString(5, datos.getAlergiaDetalle());
            sqlQuery.setString(6, datos.getMedicamentosConsumidos());
            
            sqlQuery.setString(7, datos.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }

    //SQL_DELETE Exec
    public static boolean datosDelete(DatosMedicos datos){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setString(1, datos.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
}
