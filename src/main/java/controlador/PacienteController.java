package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.PacienteGestion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Paciente;

/**
 *
 * @author Christian Aguilar Alvarado
 */
@Named(value = "pacienteController")
@SessionScoped
public class PacienteController extends Paciente implements Serializable {

    public PacienteController() {
        super("", "", "", "");
    }

    public String valida() {

        Paciente paciente1 = PacienteGestion.pacienteValida(this.getUsername(), this.getPass());

        if (paciente1 != null) {

            this.setNombre(paciente1.getNombre());
            this.setApellido1(paciente1.getApellido1());
            this.setApellido2(paciente1.getApellido2());
            this.setCedulaPaciente(paciente1.getCedulaPaciente());
            return "/Pacientes/pacientes.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o "
                    + "contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "/index.xhtml";
        }

    }

    public String pacienteInserta() {

        if (PacienteGestion.pacienteInsert(this)) {
            return "/index.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoPacienteForm:Cedula", mensaje);
            return "/Pacientes/nuevoIngreso.xhtml";
        }
    }

    public String pacienteModifica() {

        if (PacienteGestion.pacienteUpdate(this)) {
            return "/Pacientes/pacientes.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

    public String pacienteElimina() {

        if (PacienteGestion.pacienteDelete(this)) {
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }

    public String pacienteEdita(String id) {

        Paciente paciente = PacienteGestion.getPaciente(id);

        if (paciente != null) {

            this.setNacional(paciente.isNacional());
            this.setCedulaPaciente(paciente.getCedulaPaciente());
            this.setNombre(paciente.getNombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
            this.setUsername(paciente.getUsername());
            this.setPass(paciente.getPass());
            this.setFechaNacimiento(paciente.getFechaNacimiento());
            this.setEdad(paciente.getEdad());
            this.setSexo(paciente.isSexo());
            this.setDireccion(paciente.getDireccion());
            this.setTelefono1(paciente.getTelefono1());
            this.setEmail(paciente.getEmail());
            this.setNombreEncargado(paciente.getNombreEncargado());
            this.setApellidoEncargado1(paciente.getPass());
            this.setApellidoEncargado2(paciente.getPass());
            this.setActivo(paciente.isActivo());
            return "/Pacientes/pacientes.xhtml";
        } else {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("pacientesForm", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

    public List<Paciente> getPacientes() {
        return PacienteGestion.getPacientes();
    }

    private boolean noImprimir = true; // Para habilitar o deshabilitar el botón que imprime la certificación

    public boolean isNoImprimir() {
        return noImprimir;
    }

    public void setNoImprimir(boolean noImprimir) {
        this.noImprimir = noImprimir;
    }

    public void buscaPaciente(String id) {

        Paciente paciente = PacienteGestion.getPaciente(id);

        if (paciente != null) {
            this.setCedulaPaciente(paciente.getCedulaPaciente());
            this.setNombre(paciente.getNombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
            this.noImprimir = false;
        } else {

            this.setCedulaPaciente("");
            this.setNombre("");
            this.setApellido1("");
            this.setApellido2("");
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "No Encontrado",
                    "Paciente no Encontrado");
            FacesContext.getCurrentInstance().addMessage("reporteCitaForm:identificacion", mensaje);
            this.noImprimir = true;

        }

    }

}
