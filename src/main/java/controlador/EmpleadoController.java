/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gestion.EmpleadoGestion;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Empleado;

/**
 *
 * @author maric
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {
    
    //Constructor
    public EmpleadoController() {
        
    }

    //Insert
    public String empleadoInsert(){
        if(EmpleadoGestion.empleadoInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de empleados");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String empleadoUpdate(){
        if(EmpleadoGestion.empleadoUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de empleados");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    } 
    
    //Delete
    public String empleadoDelete(){
        if(EmpleadoGestion.empleadoDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Empleado posiblemente no exista");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }
}
