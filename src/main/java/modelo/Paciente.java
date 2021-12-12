package modelo;

import java.sql.Date;
import javax.validation.constraints.Email;

public class Paciente {
    
    //Attributes
    private boolean nacional;
    private String cedulaPaciente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String username;
    private String pass;
    private Date fechaNacimiento;
    private int edad;
    private boolean sexo;
    private String direccion;
    private String telefono1;
    private String email;
    private String nombreEncargado;
    private String apellidoEncargado1;
    private String apellidoEncargado2;
    private boolean activo;
    private String cedulaOdontologo;

    //Constructors
    public Paciente(){
    }

    public Paciente(boolean nacional, String cedulaPaciente, String nombre, String apellido1, String apellido2, String username, String pass, Date fechaNacimiento, int edad, boolean sexo, String direccion, String telefono1, String email, String nombreEncargado, String apellidoEncargado1, String apellidoEncargado2, boolean activo, String cedulaOdontologo) {
        this.nacional = nacional;
        this.cedulaPaciente = cedulaPaciente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.pass = pass;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.email = email;
        this.nombreEncargado = nombreEncargado;
        this.apellidoEncargado1 = apellidoEncargado1;
        this.apellidoEncargado2 = apellidoEncargado2;
        this.activo = activo;
        this.cedulaOdontologo = cedulaOdontologo;
    }

    public Paciente(String nombre, String apellido1, String apellido2,String cedulaPaciente) {

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedulaPaciente = cedulaPaciente;
    }

 

    
    //Getter and Setters
    public boolean isNacional() {
        return this.nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }

    public String getCedulaPaciente() {
        return this.cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isSexo() {
        return this.sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono1() {
        return this.telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEncargado() {
        return this.nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getApellidoEncargado1() {
        return this.apellidoEncargado1;
    }

    public void setApellidoEncargado1(String apellidoEncargado1) {
        this.apellidoEncargado1 = apellidoEncargado1;
    }

    public String getApellidoEncargado2() {
        return this.apellidoEncargado2;
    }

    public void setApellidoEncargado2(String apellidoEncargado2) {
        this.apellidoEncargado2 = apellidoEncargado2;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCedulaOdontologo() {
        return this.cedulaOdontologo;
    }

    public void setCedulaOdontologo(String cedulaOdontologo) {
        this.cedulaOdontologo = cedulaOdontologo;
    }



}
