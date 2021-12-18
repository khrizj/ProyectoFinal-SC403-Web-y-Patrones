package controlador;

import modelo.HistoriaDental;
import gestion.HistorialDentalGestion;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "historialDentalController")
@SessionScoped

public class HistorialDentalController extends HistoriaDental implements Serializable {
    //Constructor
    public HistorialDentalController(){
        super("", 0, false, false, "", 0, false, false, false, false, false, false, "");
    }

    //Insert
    public String historialDentInsert(){
        if(HistorialDentalGestion.historialDentalInsert(this)){
            return "Odontologos.xhtml";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Error","Posible duplicación de historial");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "Odontologos.xhtml";
        }
    }

    //Update
    public String historialDentUpdate(){
        if(HistorialDentalGestion.historialDentalUpdate(this)){
            return "Odontologos.xhtml";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de historial");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "Odontologos.xhtml";
        }
    }

    //Delete
    public String historialDentDelete(){
        if(HistorialDentalGestion.historialDentalDelete(this)){
            return "Odontologos.xhtml";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Historial inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "Odontologos.xhtml";
        }
    }
    
}
