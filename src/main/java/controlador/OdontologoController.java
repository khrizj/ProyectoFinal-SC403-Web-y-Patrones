package controlador;

import gestion.OdontologoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Odontologo;


@Named(value = "odontologoController")
@SessionScoped
public class OdontologoController extends Odontologo implements Serializable {

    public OdontologoController() {
        super("", "", "", 0);
    }
    
    public String valida() {

        Odontologo odontologo = OdontologoGestion.odontoValida(this.getUsername(), this.getPassw());
        
        if (odontologo != null) {

            this.setNombre(odontologo.getNombre());
            this.setApellido1(odontologo.getApellido1());
            this.setApellido2(odontologo.getApellido2());
            this.setCedulaOdontologo(odontologo.getCedulaOdontologo());
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o "
                    + "contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "/login.xhtml";
        }

    }
}
