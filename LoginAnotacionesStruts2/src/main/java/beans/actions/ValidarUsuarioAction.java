/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.actions;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({ //usando anotaciones, se puede sustutir los direccionamientos de struts.xml para 2 resultados
      
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"), //para efecto de success
    @Result(name="input", location="/WEB-INF/content/login.jsp", type="redirectAction") //para efectos de fail en input
})
public class ValidarUsuarioAction extends ActionSupport {
    
    Logger log = LogManager.getLogger(LoginAction.class); // envia informacion a la consola
    
    //atributo para mandar informacion desde el cliente
    
    private String usuario;
     private String password;
    
//notacion que define a strut, sin struts.xml es llamado desde login.jsp  
   @Action("validarUsuario")
     public String execute(){
        
    if("admin".equals(this.usuario)){
        
        return SUCCESS; // proporciona correcto y continua
    }else{
       return INPUT; //regresa a pjsp default es decir login.jsp
        
    }
        
    }

//gets y sets    

    public String getUsuario() {
        return usuario;
    }

        public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
        public String getPassword() {
        return password;
    }

        public void setPassword(String password) {
        this.password = password;
    }
    
}
