/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetActualizarCliente;
import Modelo.Mod_GetSetLoginCliente;
import Modelo.Mod_LoginCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Martinez
 */
@WebServlet(name = "Con_Cliente", urlPatterns = {"/Con_Cliente"})
public class Con_Cliente extends HttpServlet {

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
        processRequest(request, response);
        
        if(request.getParameter("Regi")!=null){
            InsertarCliente(request, response);
        }
        if(request.getParameter("Actu")!=null){
            ActualizarCliente(request, response);
        }
        
        
    }
    
    protected void InsertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String Cli_documento,Cli_nombre,Cli_fecha_naci,Cli_genero, Cli_telefono,Cli_email,Cli_direccion_1,Cli_barrio_1,Cli_descripcion_1,d2,b2,des2 ,UI;
        
        boolean reg;
        Cli_documento=request.getParameter("docu");
        Cli_nombre=request.getParameter("Nomb");
        Cli_fecha_naci=request.getParameter("fecnac");
        Cli_genero=request.getParameter("gene");
        Cli_telefono=request.getParameter("telef");
        Cli_email=request.getParameter("correo");
        Cli_direccion_1=request.getParameter("direc");
        Cli_barrio_1=request.getParameter("barr");
        Cli_descripcion_1=request.getParameter("descr");
        UI=request.getParameter("UsuId");
        JOptionPane.showMessageDialog(null, "VAriable hp "+UI);
        Mod_GetSetLoginCliente gscli=new Mod_GetSetLoginCliente(Cli_documento, Cli_nombre, Cli_fecha_naci, Cli_genero, Cli_telefono, Cli_email, Cli_direccion_1, Cli_barrio_1, Cli_descripcion_1, UI);
        Mod_LoginCliente logcli=new Mod_LoginCliente();
        reg=logcli.insertarcliente(gscli);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Insertados");
            HttpSession cli=request.getSession(true);
            cli.setAttribute("VarId", UI);
            response.sendRedirect("Cliente/vi_Cliente.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Insertados");
        }
    }
    
    protected void ActualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String i,d,n,g,t,e,d1,b1,des1,d2,b2,des2,nu,p,fo;
        boolean reg;
        
        i=request.getParameter("id");
        d=request.getParameter("docu");
        n=request.getParameter("Nomb");
        g=request.getParameter("gene");
        t=request.getParameter("telef");
        e=request.getParameter("correo");
        d1=request.getParameter("direc");
        b1=request.getParameter("barr");
        des1=request.getParameter("descr");
        d2=request.getParameter("direc2");
        b2=request.getParameter("barr2");
        des2=request.getParameter("descr2");
        nu=request.getParameter("nom");
        p=request.getParameter("pass");
        fo=request.getParameter("fot");
        Mod_GetSetActualizarCliente actcli=new Mod_GetSetActualizarCliente(i ,d, n, g, t, e, d1, b1, des1, d2, b2, des2, nu,p,fo);
        Mod_LoginCliente logcli=new Mod_LoginCliente();
        reg=logcli.ActualizarCliente(actcli);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            response.sendRedirect("Cliente/vi_Cliente.jsp");
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
