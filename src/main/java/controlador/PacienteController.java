package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import gestion.PacienteGestion;
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

        Paciente paciente = PacienteGestion.pacienteValida(this.getUsername(), this.getPass());

        if (paciente != null) {

            this.setCedulaPaciente(paciente.getCedulaPaciente());
            this.setNombre(paciente.getNombre());
            this.setApellido1(paciente.getApellido1());
            this.setApellido2(paciente.getApellido2());
            return "pacientes.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o "
                    + "contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "/index.xhtml";
        }

    }

}
