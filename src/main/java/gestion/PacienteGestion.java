package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Paciente;
import modelo.Conexion;

public class PacienteGestion {
     //CRUD elements
    
    private static final String SQL_SELECT = "SELECT * FROM paciente WHERE cedulaPaciente = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM paciente";
    private static final String SQL_INSERT = "INSERT INTO paciente (nacional, cedulaPaciente,"
            + "nombre, apellido1, apellido2, username, pass,"
            + "fechaNacimiento, edad, sexo, direccion, telefono1,"
            + "email, nombreEncargado, apellidoEncargado1,"
            + "apellidoEncargado2, activo, cedulaOdontologo)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Paciente SET nacional = ?,"
            + "nombre = ?,  apellido1 = ?,  apellido2 = ?,  username = ?,  pass = ?, "
            + "fechaNacimiento = ?,  edad = ?,  sexo = ?,  direccion = ?,  telefono1 = ?, "
            + "email = ?,  nombreEncargado = ?,  apellidoEncargado1 = ?, "
            + "apellidoEncargado2 = ?,  activo = ?,  cedulaOdontologo = ?"
            + "WHERE cedulaPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE cedulaPaciente = ?";

    private static final String PACIENTE_SQL_VALIDA = "SELECT nombre,apellido1,apellido2,cedulaPaciente FROM paciente WHERE username=? and pass = ?";

    //Executions
    //SQL_SELECT exec
    public static final Paciente pacienteValida(String username, String pass) {

        Paciente paciente = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(PACIENTE_SQL_VALIDA);
            sqlQuery.setString(6, username);
            sqlQuery.setString(7, pass);
            ResultSet rs = sqlQuery.executeQuery();

            if (rs.next()) {
                paciente = new Paciente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    public static Paciente getPaciente(String cedulaAdmin) {

        Paciente admin = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaAdmin);
            ResultSet dataSet = sqlQuery.executeQuery();

            if (dataSet.next()) {
                admin = new Paciente(dataSet.getBoolean(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getDate(8),
                        dataSet.getInt(9),
                        dataSet.getBoolean(10),
                        dataSet.getString(11),
                        dataSet.getString(12),
                        dataSet.getString(13),
                        dataSet.getString(14),
                        dataSet.getString(15),
                        dataSet.getString(16),
                        dataSet.getBoolean(17),
                        dataSet.getString(18));
            }
        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return admin;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Paciente> getPacientes() {

        ArrayList<Paciente> adminList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while (dataSet != null && dataSet.next()) {
                adminList.add(new Paciente(dataSet.getBoolean(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getDate(8),
                        dataSet.getInt(9),
                        dataSet.getBoolean(10),
                        dataSet.getString(11),
                        dataSet.getString(12),
                        dataSet.getString(13),
                        dataSet.getString(14),
                        dataSet.getString(15),
                        dataSet.getString(16),
                        dataSet.getBoolean(17),
                        dataSet.getString(18)));
            }

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return adminList;
    }

    //SQL_INSERT Exec
    public static boolean pacienteInsert(Paciente paciente) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_INSERT);
            sqlQuery.setBoolean(1, paciente.isNacional());
            sqlQuery.setString(2, paciente.getCedulaPaciente());
            sqlQuery.setString(3, paciente.getNombre());
            sqlQuery.setString(4, paciente.getApellido1());
            sqlQuery.setString(5, paciente.getApellido2());
            sqlQuery.setString(6, paciente.getUsername());
            sqlQuery.setString(7, paciente.getPass());
            sqlQuery.setDate(8, paciente.getFechaNacimiento());
            sqlQuery.setInt(9, paciente.getEdad());
            sqlQuery.setBoolean(10, paciente.isSexo());
            sqlQuery.setString(11, paciente.getDireccion());
            sqlQuery.setString(12, paciente.getTelefono1());
            sqlQuery.setString(13, paciente.getEmail());
            sqlQuery.setString(14, paciente.getNombreEncargado());
            sqlQuery.setString(15, paciente.getApellidoEncargado1());
            sqlQuery.setString(16, paciente.getApellidoEncargado2());
            sqlQuery.setBoolean(17, paciente.isActivo());
            sqlQuery.setString(18, paciente.getCedulaOdontologo());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_UPDATE Exec
    public static boolean adminUpdate(Paciente paciente) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_UPDATE);
            sqlQuery.setBoolean(1, paciente.isNacional());
            sqlQuery.setString(2, paciente.getNombre());
            sqlQuery.setString(3, paciente.getApellido1());
            sqlQuery.setString(4, paciente.getApellido2());
            sqlQuery.setString(5, paciente.getUsername());
            sqlQuery.setString(6, paciente.getPass());
            sqlQuery.setDate(7, paciente.getFechaNacimiento());
            sqlQuery.setInt(8, paciente.getEdad());
            sqlQuery.setBoolean(9, paciente.isSexo());
            sqlQuery.setString(10, paciente.getDireccion());
            sqlQuery.setString(11, paciente.getTelefono1());
            sqlQuery.setString(12, paciente.getEmail());
            sqlQuery.setString(13, paciente.getNombreEncargado());
            sqlQuery.setString(14, paciente.getApellidoEncargado1());
            sqlQuery.setString(15, paciente.getApellidoEncargado2());
            sqlQuery.setBoolean(16, paciente.isActivo());
            sqlQuery.setString(17, paciente.getCedulaOdontologo());

            sqlQuery.setString(18, paciente.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    //SQL_DELETE Exec
    public static boolean adminDelete(Paciente paciente) {
        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_DELETE);
            sqlQuery.setString(1, paciente.getCedulaPaciente());

            return sqlQuery.executeUpdate() > 0;

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
