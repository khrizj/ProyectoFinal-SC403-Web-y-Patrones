package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        super("","","",false,"","","");
    }
    
     public String datosMedInserta() {

        if (DatosMedicosGestion.datosInsert(this)) {
            return "/index.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoPacienteForm:Cedula", mensaje);
            return "/Pacientes/nuevoIngreso.xhtml";
        }
    }

    public String datosMedModifica() {

        if (DatosMedicosGestion.datosUpdate(this)) {
            return "/Pacientes/pacientes.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible Identificación Duplicada");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }

    public String datosMedElimina() {

        if (DatosMedicosGestion.datosDelete(this)) {
            return "/Doctores/Odontologos.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaPacienteForm:identificacion", mensaje);
            return "/Doctores/Odontologos.xhtml";
        }

    }

    public String datosMedEdita(String cedPaciente) {

        DatosMedicos datosMed = DatosMedicosGestion.getDato(cedPaciente);

        if (datosMed != null) {

            this.setAntecedentesPatologicosPersonales(datosMed.getAntecedentesPatologicosPersonales());
            this.setAntecedentesPatologicosFamiliares(datosMed.getAntecedentesPatologicosFamiliares());
            this.setAntecedentesQuirurgicos(datosMed.getAntecedentesQuirurgicos());
            this.setAlergia(datosMed.isAlergia());
            this.setAlergiaDetalle(datosMed.getAlergiaDetalle());
            this.setMedicamentosConsumidos(datosMed.getMedicamentosConsumidos());
            this.setCedulaPaciente(datosMed.getCedulaPaciente());
            return "/Pacientes/pacientes.xhtml";
        } else {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el id no exista");
            FacesContext.getCurrentInstance().addMessage("pacientesForm", mensaje);
            return "/Pacientes/pacientes.xhtml";
        }

    }
    //TODO: Este método se puede ir, pero ocupa revisión antes de cambio final
    /*******************************************************************************
     * 
     * 
     * El siguiente método permite el ingreso de datos médicos para el odontólogo.
     * En caso de que la información exista en la base de datos, solo actualiza
     * los cambios hechos.
     * 
     * Caso contrario ingresa nuevos datos a la DB
     * 
     *******************************************************************************/
    public String datosMedToSave(String cedPaciente){
        DatosMedicos datosToSave = this;
        DatosMedicos datosToCompare = DatosMedicosGestion.getDato(cedPaciente);
        
        //Este objeto es el que se salva a la DB
        DatosMedicos datosSaved = null;

        try {
            if(datosToCompare != null && datosToSave.equals(datosToCompare)){
                //No hay datos nuevos que guardar, ni actualizar
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Información", "No hay cambios en los datos del paciente");
                FacesContext.getCurrentInstance().addMessage("", message);
                return "/Doctores/DatosMedicos.xhtml";
            }else if(datosToCompare != null){
                /**
                 * Encuentra las diferencias entre lo que tienen en común entre los dos objetos
                 * y sus diferencias y se salvan en un tercer objeto
                 * 
                 * Código basado en: https://stackoverflow.com/questions/55294391/how-to-compare-two-objects-and-get-the-changed-fields
                 */
    
                 List<Object> objFields = new ArrayList<>();
                 for(Field objField: datosToSave.getClass().getDeclaredFields()){
                     objField.setAccessible(true);
                     Object obj1 = objField.get(datosToSave);
                     Object obj2 = objField.get(datosToCompare);
    
                     if(obj1 != null && obj2 != null){
                         if(!Objects.equals(obj1, obj2)){
                            //Campos son diferentes 
                            objFields.add(obj1);
                         }else{
                             //Campos son iguales
                             objFields.add(obj2);
                         }
                     }
                 }
    
                 //Añade objetos en la lista anterior al objeto a guardar
                 for(int i = 0; i < objFields.size(); i++){
                    switch (i) {
                        case 0: datosSaved.setAntecedentesPatologicosPersonales((String) objFields.get(i));
                        case 1: datosSaved.setAntecedentesPatologicosFamiliares((String) objFields.get(i));
                        case 2: datosSaved.setAntecedentesQuirurgicos((String) objFields.get(i));
                        case 3: datosSaved.setAlergia((Boolean) objFields.get(i));
                        case 4: datosSaved.setAlergiaDetalle((String) objFields.get(i));
                        case 5: datosSaved.setMedicamentosConsumidos((String) objFields.get(i));
                        case 6: datosSaved.setCedulaPaciente((String) objFields.get(i));
                    }
                 }

                 //Actualiza DB
                 DatosMedicosGestion.datosUpdate(datosSaved);

                 return "/Doctores/DatosMedicos.xhtml";
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            Logger.getLogger(DatosMedicosController.class.getName()).log(Level.SEVERE, null, e);
        }

        return "";
    }

}
