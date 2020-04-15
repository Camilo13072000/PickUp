/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_Orden;
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
@WebServlet(name = "Con_Ordenes", urlPatterns = {"/Con_Ordenes"})
public class Con_Ordenes extends HttpServlet {

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
        if(request.getParameter("Ver")!=null){
            ConsultarOrdenes(request, response);
        }
        if(request.getParameter("OrEstado")!=null){
            ActualizarEstadoOrden(request, response);
        }
        if(request.getParameter("DomEstado")!=null){
            ActualizarEstadoDomicilio(request, response);
        }
        
        
    }
    protected void ActualizarEstadoOrden(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        boolean reg;
        int dom_id=Integer.parseInt(request.getParameter("dom_id"));
        int or_id=Integer.parseInt(request.getParameter("or_id"));
        String Or_Estado="Recogido";
        Mod_Orden Orden=new Mod_Orden();
        reg=Orden.ActualizarEstadoOrden(or_id, Or_Estado);
        if(reg){
            JOptionPane.showMessageDialog(null, "Estado actualizado controlador");
            HttpSession orden=request.getSession(true);
            orden.setAttribute("dom_id", dom_id);
            response.sendRedirect("Orden.jsp");
        }
        
    }
    protected void ActualizarEstadoDomicilio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }
    protected void ConsultarOrdenes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int dom_id=Integer.parseInt(request.getParameter("dom_id"));
        
        HttpSession orden=request.getSession(true);
        orden.setAttribute("dom_id", dom_id);
        response.sendRedirect("Orden.jsp");
        
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
