package modelo;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class HabitosParafuncionales {
    
  private int idhabitosParafuncionales;
  private boolean comeUnnas;
  private boolean bruxismo;
  private boolean ronca;
  private boolean dormirBocaAbierta;
  private boolean chuparDedo;
  private boolean deglusionAtipica;
  private boolean morderObjetos;
  private String cedulaPaciente;

    public HabitosParafuncionales(boolean comeUnnas, boolean bruxismo, boolean ronca, boolean dormirBocaAbierta, boolean chuparDedo, boolean deglusionAtipica, boolean morderObjetos, String cedulaPaciente) {
        this.comeUnnas = comeUnnas;
        this.bruxismo = bruxismo;
        this.ronca = ronca;
        this.dormirBocaAbierta = dormirBocaAbierta;
        this.chuparDedo = chuparDedo;
        this.deglusionAtipica = deglusionAtipica;
        this.morderObjetos = morderObjetos;
        this.cedulaPaciente = cedulaPaciente;
    }

    public HabitosParafuncionales(int idhabitosParafuncionales, boolean comeUnnas, boolean bruxismo, boolean ronca, boolean dormirBocaAbierta, boolean chuparDedo, boolean deglusionAtipica, boolean morderObjetos, String cedulaPaciente) {
        this.idhabitosParafuncionales = idhabitosParafuncionales;
        this.comeUnnas = comeUnnas;
        this.bruxismo = bruxismo;
        this.ronca = ronca;
        this.dormirBocaAbierta = dormirBocaAbierta;
        this.chuparDedo = chuparDedo;
        this.deglusionAtipica = deglusionAtipica;
        this.morderObjetos = morderObjetos;
        this.cedulaPaciente = cedulaPaciente;
    }
    
    

    public int getIdhabitosParafuncionales() {
        return idhabitosParafuncionales;
    }

    public void setIdhabitosParafuncionales(int idhabitosParafuncionales) {
        this.idhabitosParafuncionales = idhabitosParafuncionales;
    }

    public boolean isComeUnnas() {
        return comeUnnas;
    }

    public void setComeUnnas(boolean comeUnnas) {
        this.comeUnnas = comeUnnas;
    }

    public boolean isBruxismo() {
        return bruxismo;
    }

    public void setBruxismo(boolean bruxismo) {
        this.bruxismo = bruxismo;
    }

    public boolean isRonca() {
        return ronca;
    }

    public void setRonca(boolean ronca) {
        this.ronca = ronca;
    }

    public boolean isDormirBocaAbierta() {
        return dormirBocaAbierta;
    }

    public void setDormirBocaAbierta(boolean dormirBocaAbierta) {
        this.dormirBocaAbierta = dormirBocaAbierta;
    }

    public boolean isChuparDedo() {
        return chuparDedo;
    }

    public void setChuparDedo(boolean chuparDedo) {
        this.chuparDedo = chuparDedo;
    }

    public boolean isDeglusionAtipica() {
        return deglusionAtipica;
    }

    public void setDeglusionAtipica(boolean deglusionAtipica) {
        this.deglusionAtipica = deglusionAtipica;
    }

    public boolean isMorderObjetos() {
        return morderObjetos;
    }

    public void setMorderObjetos(boolean morderObjetos) {
        this.morderObjetos = morderObjetos;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
  
  
  
}
