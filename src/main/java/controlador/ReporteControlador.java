package controlador;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

//Modelo imports, por el momento global
import modelo.*;

//Jasper imports
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Named(value = "ReporteControlador")
@SessionScoped
public class ReporteControlador implements Serializable{
    //Este bean controla la descarga de los reportes de Jasper de un solo lugar

    //TODO: Modificar esta linea para incluir el path donde irían los distintos reportes
    private final static String REPORTPATH = "";

    //Constructor
    public ReporteControlador() {
    }

    public void createReport(String reportName, int action) throws IOException{
        //El método permite crear el reporte en PDF para descarga o vista dependiendo de cómo se ocupe
        //Para vista action = 0, para descargar action = 1
        try {
            File jReportFile = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(REPORTPATH + reportName));
            JasperPrint jPrinter = JasperFillManager.fillReport(jReportFile.getPath(), null, Conexion.getConexion());
            HttpServletResponse hResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            if(action == 0){
                hResponse.setContentType("application/pdf");
                hResponse.addHeader("Content-Type", "application/pdf");
            }else if(action == 1){
                hResponse.addHeader("Content-Disposition", "attachment;filename="+ reportName +".pdf");
            }

            ServletOutputStream oStream = hResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jPrinter, oStream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException e) {
            Logger.getLogger(ReporteControlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
