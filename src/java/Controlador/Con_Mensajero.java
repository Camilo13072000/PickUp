/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetActualizarCliente;
import Modelo.Mod_GetSetActualizarMensajero;
import Modelo.Mod_LoginCliente;
import Modelo.Mod_Mensajero;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Martinez
 */
@WebServlet(name = "Con_Mensajero", urlPatterns = {"/Con_Mensajero"})
@MultipartConfig
public class Con_Mensajero extends HttpServlet {
    String men_direccion,men_barrio,men_descripcion,men_telefono,men_email,usu_nombre,usu_contraseña,usu_id,men_nombre;
    int men_id;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("ActualizaMensajero")!=null){
            ActualizarMensajero(request, response);
        }
        if(request.getParameter("ActualizarFotoMensajero")!=null){
            ActualizarFotoMensajero(request, response);
        }
    }
    
    protected void ActualizarMensajero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean reg;
        
        men_id=Integer.parseInt(request.getParameter("id"));
        men_telefono=request.getParameter("telef");
        men_email=request.getParameter("correo");
        men_direccion=request.getParameter("direc");
        men_barrio=request.getParameter("barr");
        men_descripcion=request.getParameter("descr");
        usu_nombre=request.getParameter("nom");
        usu_contraseña=request.getParameter("pass");
        Mod_GetSetActualizarMensajero actmen=new Mod_GetSetActualizarMensajero(men_id,men_direccion,men_barrio,men_descripcion,men_telefono,men_email,usu_nombre,usu_contraseña);
        Mod_Mensajero logmen=new Mod_Mensajero();
        reg=logmen.ActualizarMensajero(actmen);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            response.sendRedirect("Mensajero/Vi_mensajero.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Actualizados");
        }
    }
    
    protected void ActualizarFotoMensajero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean reg;
        men_id=Integer.parseInt(request.getParameter("id"));
        men_nombre=request.getParameter("nombremen");
        Part usu_foto=request.getPart("fot");
        String nomfoto=usu_foto.getSubmittedFileName();
        String nombre=men_nombre+nomfoto;
        String url="C:\\Users\\Camilo Martinez\\Documents\\NetBeansProjects\\PickUp\\web\\Imagenes\\"+nombre;
        String url2="Imagenes/"+nombre;
        
        if(usu_foto.getContentType().equals("image/png") || usu_foto.getContentType().equals("image/jpg")
            || usu_foto.getContentType().equals("image/gif") || usu_foto.getContentType().equals("image/jpeg")){
            
            InputStream file =usu_foto.getInputStream();
            File f=new File(url);
            FileOutputStream sal= new FileOutputStream(f);
            int num=file.read();
            while (num != -1) {
                sal.write(num);
                num=file.read();
                
            }
            
        }
        Mod_GetSetActualizarMensajero actmen=new Mod_GetSetActualizarMensajero(men_id,url2);
        Mod_Mensajero logmen=new Mod_Mensajero();
        reg=logmen.ActualizarFotoMensajero(actmen);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            JOptionPane.showMessageDialog(null, men_id+men_nombre+url2);
            HttpSession fot=request.getSession(true);
            fot.setAttribute("VarFot", url2);
            response.sendRedirect("Mensajero/Vi_mensajero.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Actualizados");
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
