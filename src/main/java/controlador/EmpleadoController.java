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

    //Edit
    public String empleadoEdit(String empleadoId){
        Empleado empleado = EmpleadoGestion.getEmpleado(empleadoId);

        if(empleado != null){
            this.setCedulaEmpleado(empleado.getCedulaEmpleado());
            this.setNombre(empleado.getNombre());
            this.setApellido1(empleado.getApellido1());
            this.setUsername(empleado.getUsername());
            this.setPassw(empleado.getPassw());
            this.setDireccion(empleado.getDireccion());
            this.setTelefono1(empleado.getTelefono1());
            this.setEmail(empleado.getEmail());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Empleado posiblemente no exista");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all empleados
    public List<Empleado> getEmpleados() {
        return EmpleadoGestion.getEmpleado();
    }

    //Select empleado
    public Empleado getEmpleado(String empleadoID){
        return EmpleadoGestion.getEmpleado(empleadoID);
    }
}
