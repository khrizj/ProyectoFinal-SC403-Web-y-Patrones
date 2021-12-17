package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        super("","","",false,"","","");
    }
    
     public String datosMedInserta() {

        if (DatosMedicosGestion.datosInsert(this)) {
            return "/index.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoPacienteForm:Cedula", mensaje);
            return "/Pacientes/nuevoIngreso.xhtml";
        }
    }

    public String datosMedModifica() {

        if (DatosMedicosGestion.datosUpdate(this)) {
            return "/Pacientes/pacientes.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

    public String datosMedElimina() {

        if (DatosMedicosGestion.datosDelete(this)) {
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }

    public String datosMedEdita(String cedPaciente) {

        DatosMedicos datosMed = DatosMedicosGestion.getDato(cedPaciente);

        if (datosMed != null) {

            this.setAntecedentesPatologicosPersonales(datosMed.getAntecedentesPatologicosPersonales());
            this.setAntecedentesPatologicosFamiliares(datosMed.getAntecedentesPatologicosFamiliares());
            this.setAntecedentesQuirurgicos(datosMed.getAntecedentesQuirurgicos());
            this.setAlergia(datosMed.isAlergia());
            this.setAlergiaDetalle(datosMed.getAlergiaDetalle());
            this.setMedicamentosConsumidos(datosMed.getMedicamentosConsumidos());
            this.setCedulaPaciente(datosMed.getCedulaPaciente());
            return "/Pacientes/pacientes.xhtml";
        } else {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("pacientesForm", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

}
