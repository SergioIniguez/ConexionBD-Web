/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author _SERGIO_
 */
public class UsuarioBean {
    private String usuario;
    private String contraseña;
    
    public UsuarioBean(){}
    
    public UsuarioBean(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
