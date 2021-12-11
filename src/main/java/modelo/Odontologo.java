/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author maric
 */
public class Odontologo {

    int cedulaOdontologo;
    String nombre;
    String apellido1;
    String apellido2;
    String username;
    String passw;
    String direccion;
    int telefono1;
    String email;

    public Odontologo() {
    }

    public Odontologo(int cedulaOdontologo, String nombre, String apellido1, String apellido2, String username, String passw, String direccion, int telefono1, String email) {
        this.cedulaOdontologo = cedulaOdontologo;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.passw = passw;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.email = email;
    }

    public int getCedulaOdontologo() {
        return cedulaOdontologo;
    }

    public void setCedulaOdontologo(int cedulaOdontologo) {
        this.cedulaOdontologo = cedulaOdontologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
