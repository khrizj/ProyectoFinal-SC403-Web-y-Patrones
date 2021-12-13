/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;
/**
 *
 * @author Christian Aguilar Alvarado
 */
public class Cita {
    
  private int idCita;
  private String motivoCita;
  private Date fechaCita;
  private String cedulaPaciente;

    public Cita() {
    }

  
    public Cita(String motivoCita, Date fechaCita, String cedulaPaciente) {
        this.motivoCita = motivoCita;
        this.fechaCita = fechaCita;
        this.cedulaPaciente = cedulaPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
  
  
  
}
