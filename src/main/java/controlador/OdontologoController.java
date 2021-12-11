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


    public List<Odontologo> getOdontologos() {
        return OdontologoGestion.getOdontologo();
    }

   
}
