package controlador;

import gestion.EvolucionGestion;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.Field;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Evolucion;

@Named(value = "evolucionController")
@SessionScoped

public class EvolucionController extends Evolucion implements Serializable {
    //Constructor
    public EvolucionController() {
    }
    
    public String evolucionInserta() {

        if (EvolucionGestion.evolucionInsert(this)) {
            return "Odontologos.xthml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("evolucionForm:identificacion", mensaje);
            return "Odontologos.xthml";
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
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("evolucionForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }
    
}
