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
import javax.inject.Named;
import modelo.Empleado;

/**
 *
 * @author maric
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController extends Empleado implements Serializable {
    
    public EmpleadoController() {
        
    }
    public List<Empleado> getEmpleado() {
        return EmpleadoGestion.getEmpleado();
    }

}
