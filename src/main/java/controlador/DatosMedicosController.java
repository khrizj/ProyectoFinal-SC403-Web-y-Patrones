package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.DatosMedicos;
import gestion.DatosMedicosGestion;

/**
 *
 * @author Christian Aguilar Alvarado
 */
@Named(value = "datosMedicosController")
@SessionScoped
public class DatosMedicosController extends DatosMedicos implements Serializable {

    public DatosMedicosController() {
    }
    
     public String datosMedInserta() {

        if (DatosMedicosGestion.datosInsert(this)) {
            return "Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoPacienteForm:Cedula", mensaje);
            return "Odontologos.xhtml";
        }
    }

    public String datosMedModifica() {

        if (DatosMedicosGestion.datosUpdate(this)) {
            return "Odontologos.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "Odontologos.xhtml";
        }

    }

    public String datosMedElimina() {

        if (DatosMedicosGestion.datosDelete(this)) {
            return "Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "Odontologos.xhtml";
        }

    }
}
