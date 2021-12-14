package controlador;

import modelo.Clinica;
import gestion.ClinicaGestion;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "clinicaController")
@SessionScoped
public class ClinicaController extends Clinica implements Serializable{

    //Constructor
    public ClinicaController(){
        super(0, "", "", 0, "");
    }

    //Insert
    public String clinicaInsert(){
        if(ClinicaGestion.clinicaInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de clínicas");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String clinicaUpdate(){
        if(ClinicaGestion.clinicaUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de clínicas");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String clinicaDelete(){
        if(ClinicaGestion.clinicaDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de clínicas");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String clinicaEdit(String clinicaId){
        Clinica clinica = ClinicaGestion.getClinica(clinicaId);

        if(clinica != null){
            this.setIdClinica(clinica.getIdClinica());
            this.setNombreClinica(clinica.getNombreClinica());
            this.setDireccion(clinica.getDireccion());
            this.setTelefono(clinica.getTelefono());
            this.setEmail(clinica.getEmail());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Clínica no existe");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all clinicas
    public List<Clinica> getClinicas(){
        return ClinicaGestion.getClinicas();
    }

    //Select clinica
    public Clinica getClinica(String clinicaID){
        return ClinicaGestion.getClinica(clinicaID);
    }
}