/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gestion.OdontologoGestion;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Odontologo;

/**
 *
 * @author maric
 */
@Named(value = "odontologoController")
@SessionScoped
public class OdontologoController extends Odontologo implements Serializable {


    public OdontologoController() {
        
    }
public String inserta (){
        
        if (OdontologoGestion.odontologoInsert(this)){
            return "listar-odontologos.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error","Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaOdontologoForm:identificacion", mensaje);
            return "editar-odontologos.xhtml";
        }
    }
    
    public String modifica (){
        
        if (OdontologoGestion.odontologoUpdate(this)){
            return "listar-odontologos.xhtml";
            
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaOdontologoForm:identificacion", mensaje);
            return "editar-odontologos.xhtml";
        }
        
    }
    
    public String elimina (){
        
        if (OdontologoGestion.odontologoDelete(this)){
            return "listar-odontologos.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaOdontologoForm:identificacion", mensaje);
            return "editar-odontologos.xhtml";
        }
        
    }
    
    public String edita (String cedulaOdontologo){
        
        Odontologo odontologo =  OdontologoGestion.getOdontologo(cedulaOdontologo);
        
        if (odontologo !=null){
            
            this.setCedulaOdontologo(odontologo.getCedulaOdontologo());
            this.setNombre(odontologo.getNombre());
            this.setApellido1(odontologo.getApellido1());
            this.setApellido2(odontologo.getApellido2());
            this.setUsername(odontologo.getUsername());
            this.setPassw(odontologo.getPassw());
            this.setDireccion(odontologo.getDireccion());
            this.setTelefono1(odontologo.getTelefono1());
            this.setEmail(odontologo.getEmail());
            return "editar-odontologos.xhtml";
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("tablaOdontologos", mensaje);
            return "listar-odontologos.xhtml";
        }
        
    }

    public List<Odontologo> getOdontologos() {
        return OdontologoGestion.getOdontologo();
    }

}
