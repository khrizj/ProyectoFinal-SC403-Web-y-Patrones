package controlador;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import modelo.Paciente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Named(value = "reportePacientesController")
@SessionScoped
public class ReportePacientesController implements Serializable {

    
    public ReportePacientesController() {
    }

    private final String PACIENTEREPORTPATH = "/Pacientes/Reporte_Citas_Paciente.jasper";

    public void createReport(Paciente paciente) {
       
        
        Map<String, Object> paramReport = new HashMap<>();
        String pacienteID = paciente.getCedulaPaciente();
        paramReport.put("cedulaPaciente", pacienteID);

        try {
            File jReportFile;
            jReportFile = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(PACIENTEREPORTPATH));

            JasperPrint reporteJasper = JasperFillManager.fillReport(jReportFile.getPath(), paramReport, Conexion.getConexion());
            HttpServletResponse hresponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            hresponse.setContentType("application/pdf");
            hresponse.addHeader("Content-Type", "application/pdf");

            ServletOutputStream oStream = hresponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, oStream);
            
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException | IOException e) {
            Logger.getLogger(ReporteControlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
