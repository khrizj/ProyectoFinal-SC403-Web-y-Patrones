package controlador;

import modelo.HistoriaDental;
import gestion.HistorialDentalGestion;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "habitosDentalController")
@SessionScoped

public class HistorialDentalController extends HistoriaDental implements Serializable {
    //Constructor
    public HistorialDentalController(){
        super("", 0, false, false, "", 0, false, false, false, false, false, false, "");
    }

    //Insert
    public String historialDentInsert(){
        if(HistorialDentalGestion.historialDentalInsert(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                 "Error","Posible duplicación de historial");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Update
    public String historialDentUpdate(){
        if(HistorialDentalGestion.historialDentalUpdate(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Posible duplicación de historial");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Delete
    public String historialDentDelete(){
        if(HistorialDentalGestion.historialDentalDelete(this)){
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Historial inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Edit
    public String historialEdit(String cedulaId){
        HistoriaDental histObj = HistorialDentalGestion.getHistorial(cedulaId);

        if(histObj != null){
            this.setUltimaVisitaDentista(histObj.getUltimaVisitaDentista());
            this.setNumeroCepilladosDia(histObj.getNumeroCepilladosDia());
            this.setUsoHilo(histObj.isUsoHilo());
            this.setUsoEnjuague(histObj.isUsoEnjuague());
            this.setTipoPastaDental(histObj.getTipoPastaDental());
            this.setNumeroComidasDia(histObj.getNumeroComidasDia());
            this.setDietaMuyCariogenica(histObj.isDietaMuyCariogenica());
            this.setDietaPocoCariogenica(histObj.isDietaPocoCariogenica());
            this.setDietaNadaCariogenica(histObj.isDietaNadaCariogenica());
            this.setMasAgua(histObj.isMasAgua());
            this.setIgualAgua(histObj.isIgualAgua());
            this.setMenosAgua(histObj.isMenosAgua());
            this.setCedulaPaciente(histObj.getCedulaPaciente());
            return "";
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error","Historial inexistente");
            FacesContext.getCurrentInstance().addMessage("", message);
            return "";
        }
    }

    //Select all
    public List<HistoriaDental> getHistoriales(){
        return HistorialDentalGestion.getAllHistorial();
    }

    //Select historial
    public HistoriaDental getHistorial(String cedulaID){
        return HistorialDentalGestion.getHistorial(cedulaID);
    }
}
