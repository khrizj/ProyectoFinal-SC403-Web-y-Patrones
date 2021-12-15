package controlador;

import modelo.HabitosParafuncionales;
import gestion.HabitosParafuncionalesGestion;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "habitosParafuncionalesController")
@SessionScoped
public class HabitosParafuncionalesController extends HabitosParafuncionales implements Serializable {
    //Constructor
    public HabitosParafuncionalesController(){
        super(false, false, false, false, false, false, false, "");
    }

    //Insert
    public String habitosParafInsert(){
        if(HabitosParafuncionalesGestion.habitosParafInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de habitos");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String habitosParafUpdate(){
        if(HabitosParafuncionalesGestion.habitosParafUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de habitos");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String habitosParafDelete(){
        if(HabitosParafuncionalesGestion.habitosParafDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Información de habitos inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String habitosParafEdit(String cedulaId){
        HabitosParafuncionales habitoObj = HabitosParafuncionalesGestion.getHabitoP(cedulaId);

        if(habitoObj != null){
            this.setComeUnnas(habitoObj.isComeUnnas());
            this.setBruxismo(habitoObj.isBruxismo());
            this.setRonca(habitoObj.isRonca());
            this.setDormirBocaAbierta(habitoObj.isRonca());
            this.setChuparDedo(habitoObj.isChuparDedo());
            this.setDeglusionAtipica(habitoObj.isDeglusionAtipica());   
            this.setMorderObjetos(habitoObj.isMorderObjetos());
            this.setCedulaPaciente(habitoObj.getCedulaPaciente());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error","Información de habitos inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all habitosParafuncionales
    public List<HabitosParafuncionales> getParafuncionales(){
        return HabitosParafuncionalesGestion.getHabitos();
    }

    //Select habitoParafuncional
    public HabitosParafuncionales getParafuncional(String cedulaID){
        return HabitosParafuncionalesGestion.getHabitoP(cedulaID);
    }

}
