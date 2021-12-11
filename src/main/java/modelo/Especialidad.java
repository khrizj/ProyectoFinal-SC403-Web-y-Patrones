/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author maric
 */
public class Especialidad {
   String nombreEspecialidad; 
  int cedulaOdontologo;

    public Especialidad(String nombreEspecialidad, int cedulaOdontologo) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.cedulaOdontologo = cedulaOdontologo;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getCedulaOdontologo() {
        return cedulaOdontologo;
    }

    public void setCedulaOdontologo(int cedulaOdontologo) {
        this.cedulaOdontologo = cedulaOdontologo;
    }
  
}
