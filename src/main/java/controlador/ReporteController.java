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

@Named(value = "reporteController")
@SessionScoped
public class ReporteController implements Serializable {

    public ReporteController() {
    }

    public void citasVerPdf(Paciente paciente) {

        Map<String, Object> parametro = new HashMap<>();
        parametro.put("cedulaPaciente", paciente.getCedulaPaciente());

        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("/Pacientes/MisCitas.jasper"));

            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), parametro, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void citasDescargarPdf(Paciente paciente) {

        Map<String, Object> parametro = new HashMap<>();
        parametro.put("cedulaPaciente", paciente.getCedulaPaciente());

        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("/Pacientes/MisCitas.jasper"));

            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), parametro, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            respuesta.addHeader("Content-disposition", "attachement;filename=reporte.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createOdontologoReport(Paciente paciente) {

        Map<String, Object> parametro = new HashMap<>();
        parametro.put("cedulaPaciente", paciente.getCedulaPaciente());

        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("/Doctores/DetalleCitaPaciente.jasper"));

            JasperPrint reporteJasper = JasperFillManager.fillReport(jasper.getPath(), parametro, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
