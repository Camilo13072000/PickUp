/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
@WebServlet(name = "Con_presentacion", urlPatterns = {"/Con_presentacion"})
public class Con_presentacion extends HttpServlet {

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
        if(request.getParameter("Presentacion")!=null){
            Presentacion(request, response);
        }
    }
    
    protected void Presentacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
        
        String usu_foto,prove_nit,prove_nombre,cli_id,prove_foto,prove_horario;
        int usu_id,contadorcarrito;
        usu_id=Integer.parseInt(request.getParameter("usu_id"));
        usu_foto=request.getParameter("usu_foto");
        cli_id=request.getParameter("cli_id");
        prove_nit=request.getParameter("prove_nit");
        prove_nombre=request.getParameter("prove_nombre");
        prove_foto=request.getParameter("prove_foto");
        prove_horario=request.getParameter("prove_horario");
        contadorcarrito=Integer.parseInt(request.getParameter("Contador"));
        
        HttpSession pre=request.getSession(true);
        pre.setAttribute("usu_id", usu_id);
        pre.setAttribute("usu_foto", usu_foto);
        pre.setAttribute("cli_id", cli_id);
        pre.setAttribute("prove_nit", prove_nit);
        pre.setAttribute("prove_nombre", prove_nombre);
        pre.setAttribute("prove_foto", prove_foto);
        pre.setAttribute("prove_horario", prove_horario);
        pre.setAttribute("Contador", contadorcarrito);
        response.sendRedirect("Presentacion.jsp");
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
