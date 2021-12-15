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


@Named(value = "reportePacientesController")
@SessionScoped
public class ReportePacientesController extends Paciente implements Serializable{
    private static final String PACIENTEREPORTPATH = "./Pacientes/Reporte_Citas_Paciente.jasper";

    public ReportePacientesController(){
    }

    public void createReport(){
        Map<String, Object> paramReport = new HashMap<>();
        String pacienteID = this.getCedulaPaciente();
        paramReport.put("cedulaPaciente", pacienteID);

        try {
            File jReportFile = null;
            jReportFile = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(PACIENTEREPORTPATH));

            JasperPrint jPrinter = JasperFillManager.fillReport(jReportFile.getPath(), paramReport, Conexion.getConexion());
            HttpServletResponse hResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            hResponse.setContentType("application/pdf");
            hResponse.addHeader("Content-Type", "application/pdf");

            ServletOutputStream oStream = hResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jPrinter, oStream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException e) {
            Logger.getLogger(ReporteControlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}