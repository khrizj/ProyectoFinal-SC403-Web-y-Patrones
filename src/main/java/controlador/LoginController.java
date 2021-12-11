/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import gestion.LoginGestion;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Login;

/**
 *
 * @author maric
 */
 
@Named(value = "loginController")
@SessionScoped

public class LoginController extends Login implements Serializable {

  
    public LoginController() {
        super("","","");
    }
    
    public String valida(){
        
        Login login = LoginGestion.Valida(this.getUsername(), this.getPassw());
        
        if (login!=null){
            
            this.setUsername(login.getUsername());
            this.setPassw(login.getPassw());
            return "index.xhtml";
        }else{ 
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario o "
                    + "contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "Login.xhtml";
        }
        
        
        
    }
}
