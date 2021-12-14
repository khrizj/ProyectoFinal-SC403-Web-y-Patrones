package controlador;

import gestion.EvolucionGestion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.Field;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Evolucion;

@Named(value = "evolucionController")
@SessionScoped

public class EvolucionController extends Evolucion implements Serializable {
    //Constructor
    public EvolucionController() {
        super("", false, "", false, "");
    }
    
    //Insert
    public String evolucionInsert(){
        if(EvolucionGestion.evolucionInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de evolución");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String evolucionUpdate(){
        if(EvolucionGestion.evolucionUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de evolución");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String evolucionDelete(){
        if(EvolucionGestion.evolucionInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Información de evolución inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String evolucionEdit(String cedulaId){
        Evolucion evoObj = EvolucionGestion.getEvolucionXPaciene(cedulaId);

        if(evoObj != null){
            this.setMotivoConsulta(evoObj.getMotivoConsulta());
            this.setPresenciaDolor(evoObj.isPresenciaDolor());
            this.setDescripcion(evoObj.getDescripcion());
            this.setSatisfechoConDentadura(evoObj.isSatisfechoConDentadura());
            this.setCedulaPaciente(evoObj.getCedulaPaciente());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Información de evolución inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }


    //TODO: Arreglar este código que sigue, posiblemente necesite eliminarse
    /********************************************************************************
     * 
     * El siguiente método permite el ingreso de datos médicos para el odontólogo.
     * En caso de que la información exista en la base de datos, solo actualiza
     * los cambios hechos.
     * 
     * Caso contrario ingresa nuevos datos a la DB
     * 
     *******************************************************************************/
    public String evoToSave(String cedPaciente){
        Evolucion datosToSave = this;
        Evolucion datosToCompare = EvolucionGestion.getEvolucionXPaciene(cedPaciente);
        
        //Este objeto es el que se salva a la DB
        Evolucion datosSaved = null;

        try {
            if(datosToCompare != null && datosToSave.equals(datosToCompare)){
                //No hay datos nuevos que guardar, ni actualizar
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Información", "No hay cambios en los datos del paciente");
                FacesContext.getCurrentInstance().addMessage("", message);
                return "/Doctores/Evolucion.xhtml";
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
                        case 0: datosSaved.setMotivoConsulta((String) objFields.get(i));
                        case 1: datosSaved.setPresenciaDolor((Boolean) objFields.get(i));
                        case 2: datosSaved.setDescripcion((String) objFields.get(i));
                        case 3: datosSaved.setSatisfechoConDentadura((Boolean) objFields.get(i));
                        case 4: datosSaved.setCedulaPaciente((String) objFields.get(i));
                    }
                 }

                 //Actualiza DB
                 EvolucionGestion.evolucionUpdate(datosSaved);

                 return "/Doctores/Evolucion.xhtml";
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            Logger.getLogger(DatosMedicosController.class.getName()).log(Level.SEVERE, null, e);
        }

        return "";
    }
}
