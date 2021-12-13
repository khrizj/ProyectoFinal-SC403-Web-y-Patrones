package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.PacienteGestion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Paciente;


@Named(value = "pacienteController")
@SessionScoped
public class PacienteController extends Paciente implements Serializable {

    public PacienteController() {
        super("", "", "", "");
    }

    public String valida() {

        Paciente paciente = PacienteGestion.pacienteValida(this.getUsername(), this.getPass());

        if (paciente != null) {

            this.setCedulaPaciente(paciente.getCedulaPaciente());
            this.setNombre(paciente.getNombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
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
            return "/Pacientes/nuevoIngreso.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", mensaje);
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

    }
