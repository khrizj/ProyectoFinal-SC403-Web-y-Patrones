package modelo;


public class Administrador {
    
    //Attributes
    private String cedulaAdmin;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String username;
    private String pass;
    private String direccion;
    private String telefono1;
    private String email;
    private int idClinica;

    //Constructors
    public Administrador(){
    }

    public Administrador(String cedulaAdmin, String nombre, String apellido1, String apellido2, String username, String pass, String direccion, String telefono1, String email, int idClinica) {
        this.cedulaAdmin = cedulaAdmin;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.pass = pass;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.email = email;
        this.idClinica = idClinica;
    }

    //Getters and Setters
    public String getCedulaAdmin() {
        return this.cedulaAdmin;
    }

    public void setCedulaAdmin(String cedulaAdmin) {
        this.cedulaAdmin = cedulaAdmin;
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

    public int getIdClinica() {
        return this.idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }
}
