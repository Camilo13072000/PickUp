/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetUsuarios;
import Modelo.Mod_LoginCliente;
import Modelo.Mod_LoginUsuario;
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
@WebServlet(name = "Con_Usuario", urlPatterns = {"/Con_Usuario"})
public class Con_Usuario extends HttpServlet {
    String nu;
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
        
        if(request.getParameter("reg")!=null){
            InsertarUsuCliente(request, response);
        }
        
    }

        protected void InsertarUsuCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
        String i,p,r,es,fo;
        boolean reg;
        nu=request.getParameter("nom");
        p=request.getParameter("pass");
        r=request.getParameter("rol");
        es=request.getParameter("est");
        fo=request.getParameter("fot");
        Mod_GetSetUsuarios gsUsu=new Mod_GetSetUsuarios(nu, p, r, es, fo);
        Mod_LoginUsuario logusu=new Mod_LoginUsuario();
        reg=logusu.insertarusuario(gsUsu);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Insertados");
            HttpSession nom=request.getSession(true);
            nom.setAttribute("NomUsu", nu);
            response.sendRedirect("Cliente/RegistrarCliente.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Insertados");
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
