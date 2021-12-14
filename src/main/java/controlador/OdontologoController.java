package controlador;

import gestion.OdontologoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

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

    //Insert
    public String odontoInsert(){
        if(OdontologoGestion.odontologoInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error","Posible duplicación de odontólogo");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String odontoUpdate(){
        if(OdontologoGestion.odontologoUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error","Posible duplicación de odontólogo");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String odontoDelete(){
        if(OdontologoGestion.odontologoDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Error","Odontólogo inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String odontoEdit(String cedulaId){
        Odontologo odontoObj = OdontologoGestion.getOdontologo(cedulaId);

        if(odontoObj != null){
            this.setCedulaOdontologo(odontoObj.getCedulaOdontologo());
            this.setNombre(odontoObj.getNombre());
            this.setApellido1(odontoObj.getApellido1());
            this.setApellido2(odontoObj.getApellido2());
            this.setUsername(odontoObj.getUsername());
            this.setPassw(odontoObj.getPassw());
            this.setTelefono1(odontoObj.getTelefono1());
            this.setEmail(odontoObj.getEmail());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Odontólogo inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select ALL
    public List<Odontologo> getOdontologos(){
        return OdontologoGestion.getOdontologos();
    }

    //Select odontologo
    public Odontologo getOdontologo(String cedulaID){
        return OdontologoGestion.getOdontologo(cedulaID);
    }
}
