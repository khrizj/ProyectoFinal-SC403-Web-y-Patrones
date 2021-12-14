/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gestion.CitaGestion;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Cita;

/**
 *
 * @author maric
 */
@Named(value = "citaController")
@SessionScoped
public class CitaController extends Cita implements Serializable {

    public CitaController() {
    }

    public String inserta() {

        if (CitaGestion.citaInsert(this)) {
            return "/Pacientes/pacientes.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
            return "pacientes.xhtml";
        }
    }

    public String citaModifica() {

        if (CitaGestion.citaUpdate(this)) {
            return "/Pacientes/pacientes.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

    public String citaElimina() {

        if (CitaGestion.citaDelete(this)) {
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }

    public String citaEdita(String cedulaPaciente) {

        Cita cita = CitaGestion.getCita(cedulaPaciente);

        if (cita != null) {

            this.setMotivoCita(cita.getMotivoCita());
            this.setFechaCita(cita.getFechaCita());
            this.setCedulaPaciente(cita.getCedulaPaciente());
            return "/Pacientes/pacientes.xhtml";
        } else {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("pacientesForm", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }
}
