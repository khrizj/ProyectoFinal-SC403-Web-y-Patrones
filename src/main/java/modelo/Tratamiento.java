package modelo;

public class Tratamiento {
    
    //Attributes
    private String nombreTratamiento;
    private float costoTratamiento;
    private String descripcionTratamiento;
    private String cedulaPaciente;


    //Constructors
    public Tratamiento() {
    }


    public Tratamiento(String nombreTratamiento, float costoTratamiento, String descripcionTratamiento, String cedulaPaciente) {
        this.nombreTratamiento = nombreTratamiento;
        this.costoTratamiento = costoTratamiento;
        this.descripcionTratamiento = descripcionTratamiento;
        this.cedulaPaciente = cedulaPaciente;
    }

    //Getter and Setter
    public String getNombreTratamiento() {
        return this.nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public float getCostoTratamiento() {
        return this.costoTratamiento;
    }

    public void setCostoTratamiento(float costoTratamiento) {
        this.costoTratamiento = costoTratamiento;
    }

    public String getDescripcionTratamiento() {
        return this.descripcionTratamiento;
    }

    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }

    public String getCedulaPaciente() {
        return this.cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }


}
