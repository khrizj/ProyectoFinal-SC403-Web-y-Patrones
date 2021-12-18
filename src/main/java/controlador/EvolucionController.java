package controlador;

import gestion.EvolucionGestion;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import modelo.Evolucion;

@Named(value = "evolucionController")
@SessionScoped

public class EvolucionController extends Evolucion implements Serializable {
    //Constructor
    public EvolucionController() {
    }
    
    public String evolucionInserta() {

        if (EvolucionGestion.evolucionInsert(this)) {
            return "Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("evolucionForm:identificacion", mensaje);
            return "Odontologos.xhtml";
        }
    }
   
    public String evolucionModifica() {

        if (EvolucionGestion.evolucionUpdate(this)) {
            return "/Doctores/Odontologos.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("evolucionForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }

    public String evolucionElimina() {

        if (EvolucionGestion.evolucionDelete(this)) {
            return "Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("evolucionForm:identificacion", mensaje);
            return "Odontologos.xhtml";
        }

    }
    
}
