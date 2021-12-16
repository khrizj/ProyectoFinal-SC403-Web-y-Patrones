package controlador;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import modelo.Conexion;
import modelo.Paciente;

//Jasper imports
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Named(value = "reporteOdontologoController")
@SessionScoped
public class ReporteOdontologoController implements Serializable {

    //Constructor
    public ReporteOdontologoController() {
    }
    
    
public void createReport(Paciente paciente){
        
        Map<String, Object> paramReport = new HashMap<>();
        String pacienteID = paciente.getCedulaPaciente();
        paramReport.put("cedulaPaciente", pacienteID);

        try {
            File jReportFile;
            jReportFile = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("./Doctores/Reporte_Citas_Odontologo.jasper"));

            JasperPrint jPrinter = JasperFillManager.fillReport(jReportFile.getPath(), paramReport, Conexion.getConexion());
            HttpServletResponse hResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            hResponse.setContentType("application/pdf");
            hResponse.addHeader("Content-Type", "application/pdf");

            ServletOutputStream oStream = hResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jPrinter, oStream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException e) {
            Logger.getLogger(ReporteOdontologoController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
