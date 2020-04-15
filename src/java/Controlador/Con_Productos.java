/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetLoginCliente;
import Modelo.Mod_LoginCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Con_Productos", urlPatterns = {"/Con_Productos"})
public class Con_Productos extends HttpServlet {
    
    String CodCate,NomCate,usufot,clicod,cliu;
        int usucli,numcar;

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
        
        if(request.getParameter("Cate")!=null || request.getParameter("Categ")!=null){
            ConsultarProductos(request, response);
        }
    }
    
    protected void ConsultarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        CodCate=request.getParameter("catcod");
        NomCate=request.getParameter("catnom");
        usucli=Integer.parseInt(request.getParameter("usuid"));
        clicod=request.getParameter("clid");
        numcar=Integer.parseInt(request.getParameter("car"));
        usufot=request.getParameter("foto");
        
        /*ArrayList<Mod_GetSetLoginCliente>listacliente=new ArrayList<>();
        Mod_GetSetLoginCliente datoscli=new Mod_GetSetLoginCliente();
        Mod_LoginCliente cli=new Mod_LoginCliente();
        listacliente=cli.consultaUnCliente(usucli);
        if(listacliente.size()>0){
            for(int i=0;i<=listacliente.size();i++){
                datoscli=listacliente.get(i);
                cliu=datoscli.getCli_usu_id();
            }
        }*/
        
        HttpSession cat=request.getSession(true);
        cat.setAttribute("Codcat", CodCate);
        cat.setAttribute("Nomcat", NomCate);
        cat.setAttribute("Usucli", cliu);
        cat.setAttribute("Clicod", clicod);
        cat.setAttribute("Usufot", usufot);
        cat.setAttribute("NumCar", numcar);
        response.sendRedirect("Productos.jsp");
        
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
