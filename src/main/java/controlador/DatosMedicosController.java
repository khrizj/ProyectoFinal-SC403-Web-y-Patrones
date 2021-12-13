package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.DatosMedicos;
import gestion.DatosMedicosGestion;

/**
 *
 * @author Christian Aguilar Alvarado
 */
@Named(value = "datosMedicosController")
@SessionScoped
public class DatosMedicosController extends DatosMedicos implements Serializable {

    public DatosMedicosController() {
    }
    
}
