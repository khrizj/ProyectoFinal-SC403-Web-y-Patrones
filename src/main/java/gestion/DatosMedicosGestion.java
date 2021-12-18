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

    private static final String SQL_INSERT = "INSERT INTO datosMedicos (antecedentesPatologicosPersonales,antecedentesPatologicosFamiliares, antecedentesQuirurgicos,alergia, alergiaDetalle, medicamentosConsumidos, cedulaPaciente) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE datosMedicos SET antecedentesPatologicosPersonales = ?,"
                                            +"antecendentesPatologicosFamiliares = ?, antecedentesQuirugicos  = ?,"
                                            +"alergia  = ?, alergiaDetalle = ?, medicamentosConsumidos = ?" 
                                            +"WHERE cedulaPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM datosMedicos WHERE cedulaPaciente = ?";

    //SQL_INSERT Exec
    public static boolean datosInsert(DatosMedicos datos){
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareCall(SQL_INSERT);
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
