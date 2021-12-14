package controlador;

import modelo.Administrador;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import gestion.AdministradorGestion;

@Named(value = "administradorController")
@SessionScoped
public class AdministradorController extends Administrador implements Serializable {
    
    //Constructor
    public AdministradorController(){
    }

    //Insert
    public String adminInsert(){
        if(AdministradorGestion.adminInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de administradores");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String adminUpdate(){
        if(AdministradorGestion.adminUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de administradores");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String adminDelete(){
        if(AdministradorGestion.adminDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","El administrador posiblemente no exista");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }  

    //Edit
    public String adminEdit(String adminId){
        Administrador admin = AdministradorGestion.getAdmin(adminId);

        if(admin != null){
            this.setCedulaAdmin(admin.getCedulaAdmin());
            this.setNombre(admin.getNombre());
            this.setApellido1(admin.getApellido1());
            this.setApellido2(admin.getApellido2());
            this.setUsername(admin.getUsername());
            this.setPass(admin.getPass());
            this.setDireccion(admin.getDireccion());
            this.setTelefono1(admin.getTelefono1());
            this.setEmail(admin.getEmail());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Error","El administrador posiblemente no exista");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all admins
    public List<Administrador> getAdmins(){
        return AdministradorGestion.getAdmins();
    }

    //Select admin
    public Administrador getAdmin(String adminID){
        return AdministradorGestion.getAdmin(adminID);
    }
}
