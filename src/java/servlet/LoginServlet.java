/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AutenticationService;

/**
 *
 * @author _SERGIO_
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario, contraseña;
        usuario = request.getParameter("email");
        contraseña = request.getParameter("pass");
        
        AutenticationService aut = new AutenticationService();
        
        boolean loginSuccess = aut.autentication(usuario, contraseña);
        System.out.println("esntra servlet");
        if(loginSuccess){
            try {
                UsuarioBean us = aut.getUsuarioValido(usuario, contraseña);
                if(us != null){
                    request.setAttribute("us", us);
                    //Dispatcher manda la petición
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Exito.jsp");
                    dispatcher.forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Usuario o contraseña inválido...patrañoso')");
                    out.println("location='Login.jsp';");//response.sendRedirect("Login.jsp");
                    out.println("</script>");
                    
                }
                //System.out.println(us);           
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            /*String hackea = request.getRemoteAddr();
            System.out.println(hackea);
            if (hackea.equals("192.168.66.26")){
                PrintWriter auch = response.getWriter();
                auch.print("Ah pinshi tracalas");
            }*/
            response.sendRedirect("Login.jsp");
        }
    }


}
