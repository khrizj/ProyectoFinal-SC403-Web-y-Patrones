package modelo;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class Evolucion {
    
  private int idEvolucion;
  private String motivoConsulta;
  private boolean presenciaDolor;
  private String descripcion;
  private boolean satisfechoConDentadura;
  private String cedulaPaciente;

    public Evolucion(String motivoConsulta, boolean presenciaDolor, String descripcion, boolean satisfechoConDentadura, String cedulaPaciente) {
        this.motivoConsulta = motivoConsulta;
        this.presenciaDolor = presenciaDolor;
        this.descripcion = descripcion;
        this.satisfechoConDentadura = satisfechoConDentadura;
        this.cedulaPaciente = cedulaPaciente;
    }

    public int getIdEvolucion() {
        return idEvolucion;
    }

    public void setIdEvolucion(int idEvolucion) {
        this.idEvolucion = idEvolucion;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public boolean isPresenciaDolor() {
        return presenciaDolor;
    }

    public void setPresenciaDolor(boolean presenciaDolor) {
        this.presenciaDolor = presenciaDolor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isSatisfechoConDentadura() {
        return satisfechoConDentadura;
    }

    public void setSatisfechoConDentadura(boolean satisfechoConDentadura) {
        this.satisfechoConDentadura = satisfechoConDentadura;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
  
  
  
}
