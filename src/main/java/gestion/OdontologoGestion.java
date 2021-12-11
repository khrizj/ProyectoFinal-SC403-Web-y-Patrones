/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Odontologo;

/**
 *
 * @author maric
 */
public class OdontologoGestion {

    private static final String SQL_SELECT = "SELECT * FROM odontologo WHERE cedulaOdontologo = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM odontologo";
    private static final String SQL_INSERT = "INSERT INTO odontologo (cedulaOdontologo, nombre,"
            + "apellido1, apellido2, username, pass,"
            + "direccion, telefono1,email)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE odontologo SET nacional = ?,"
            + "nombre = ?,  apellido1 = ?,  apellido2 = ?,  username = ?,  pass = ?, "
            + "fechaNacimiento = ?,  edad = ?,  sexo = ?,  direccion = ?,  telefono1 = ?, "
            + "email = ?,  nombreEncargado = ?,  apellidoEncargado1 = ?, "
            + "apellidoEncargado2 = ?,  activo = ?,  cedulaOdontologo = ?"
            + "WHERE cedulaPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE cedulaPaciente = ?";

    public static Odontologo getOdontologo(String cedulaOdontologo) {

        Odontologo odontologo = null;

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT);
            sqlQuery.setString(1, cedulaOdontologo);
            ResultSet dataSet = sqlQuery.executeQuery();

            if (dataSet.next()) {
                odontologo = new Odontologo(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getInt(8),
                        dataSet.getString(9));
            }
        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return odontologo;
    }

    //SQL_SELECT_ALL exec
    public static ArrayList<Odontologo> getOdontologo() {

        ArrayList<Odontologo> OdontologoList = new ArrayList<>();

        try {
            PreparedStatement sqlQuery = Conexion.getConexion().prepareStatement(SQL_SELECT_ALL);
            ResultSet dataSet = sqlQuery.executeQuery();

            while (dataSet != null && dataSet.next()) {
                OdontologoList.add(new Odontologo(dataSet.getInt(1),
                        dataSet.getString(2),
                        dataSet.getString(3),
                        dataSet.getString(4),
                        dataSet.getString(5),
                        dataSet.getString(6),
                        dataSet.getString(7),
                        dataSet.getInt(8),
                        dataSet.getString(9)));
            }

        } catch (SQLException e) {
            Logger.getLogger(PacienteGestion.class.getName()).log(Level.SEVERE, null, e);
        }
        return OdontologoList;
    }
}
