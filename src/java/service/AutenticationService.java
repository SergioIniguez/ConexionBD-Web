
package service;

import beans.UsuarioBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author _SERGIO_
 */
public class AutenticationService {
    
    String url = "jdbc:mysql://localhost:3306:/";
    String baseDeDatos = "autenticacion";
    String useSSL = "?useSSL=false";
    String usuarioDB = "root";
    String passDB = "mysqlroot";
    
    Connection conexion = null;
    Statement st = null;
    
    
    public void conexion() throws SQLException{
        conexion = DriverManager.getConnection(url+baseDeDatos+useSSL, usuarioDB, passDB);
    }
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    /*UsuarioBean us1 = new UsuarioBean("juan@pedro.com", "123");
    UsuarioBean us2 = new UsuarioBean("checo@lalo.com", "1234");
    UsuarioBean us3 = new UsuarioBean("meli@anna.com", "12345");
    UsuarioBean us4 = new UsuarioBean("humberto@josue.com", "123456");
    
    ArrayList<UsuarioBean> us = new ArrayList();*/
    
    public AutenticationService(){
        /*us.add(us1);
        us.add(us2);
        us.add(us3);
        us.add(us4);*/
    }
    
    public boolean autentication(String correo, String contraseña){
        if(contraseña == null || contraseña.trim() == ""){
            return false;
        }return true;
    }

    public UsuarioBean getUsuarioValido(String usuario, String contraseña) throws SQLException {
        conexion();
        String query = "SELECT * FROM usuarios WHERE "
            + "usuario ='" + usuario + "' AND contraseña ='" + contraseña + "'";
        ResultSet rs;
        boolean status;
        
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            status = rs.next();
            if(status){
                UsuarioBean user = new UsuarioBean();
                user.setUsuario(usuario);
                user.setContraseña(contraseña);
                rs.close();
                cerrarConexion();
                System.out.println("entra");
                return user;
            }
            rs.close();
            cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        /*for(UsuarioBean user: us){
            if(user.getUsuario().equals(usuario) 
                && user.getContraseña().equals(contraseña)){
                return user;
            }
        }*/
        return null;
    }
}
