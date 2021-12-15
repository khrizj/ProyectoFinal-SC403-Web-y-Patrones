package controlador;

import gestion.TratamientoGestion;
import modelo.Tratamiento;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "tratamientoController")
@SessionScoped
public class TratamientoController extends Tratamiento implements Serializable{

    //Constructor
    public TratamientoController(){
    }

    //Insert
    public String tratamientoInsert(){
        if(TratamientoGestion.tratamientoInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de tratamientos");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String tratamientoUpdate(){
        if(TratamientoGestion.tratamientoUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de tratamientos");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String tratamientoDelete(){
        if(TratamientoGestion.tratamientoDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de tratamientos");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String tratamientoEdit(String cedulaID){
        Tratamiento tratObj = TratamientoGestion.getTratamiento(cedulaID);

        if(tratObj != null){
            this.setNombreTratamiento(tratObj.getNombreTratamiento());
            this.setCostoTratamiento(tratObj.getCostoTratamiento());
            this.setDescripcionTratamiento(tratObj.getDescripcionTratamiento());
            this.setCedulaPaciente(tratObj.getCedulaPaciente());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Tratamiento posiblemente no exista");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all tratamientos
    public List<Tratamiento> getTratamientos(){
        return TratamientoGestion.getTratamientos();
    }

    //Select tratamiento
    public Tratamiento getTratamiento(String cedulaID){
        return TratamientoGestion.getTratamiento(cedulaID);
    }
}
