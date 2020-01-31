/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetLoginCliente;
import Modelo.Mod_GetSetUsuarios;
import Modelo.Mod_Login;
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
@WebServlet(name = "Con_Login", urlPatterns = {"/Con_Login"})
public class Con_Login extends HttpServlet {
    int id;
    String nom,pass,rol,est,fot;
    String Cli_id,Cli_documento,Cli_nombre,Cli_genero,Cli_telefono,Cli_email,Cli_direccion_1,Cli_barrio_1,Cli_descripcion_1,Cli_direccion_2,Cli_barrio_2,Cli_descripcion_2,Cli_usu_id;
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
        
        if(request.getParameter("entrar")!=null){
            ArrayList<Mod_GetSetUsuarios> arr=new ArrayList<>();
            String u,c;
            u=request.getParameter("Usunom");
            c=request.getParameter("Usucont");
            Mod_GetSetUsuarios gs=new Mod_GetSetUsuarios(u, c);
            Mod_Login lo=new Mod_Login();
            arr=lo.Login(gs);
            if(arr.size()>0){
                for(int i=0;i<arr.size();i++){
                    gs=arr.get(i);
                    id=gs.getUsu_id();
                    nom=gs.getUsu_nombre();
                    pass=gs.getUsu_password();
                    rol=gs.getUsu_rol();
                    est=gs.getUsu_estado();
                    fot=gs.getUsu_foto();
                }
            }
            ArrayList<Mod_GetSetLoginCliente>listacliente=new ArrayList<>();
            Mod_GetSetLoginCliente datoscliente=new Mod_GetSetLoginCliente();
            Mod_LoginCliente uncliente=new Mod_LoginCliente();
            listacliente=uncliente.consultaUnCliente(id);
            if(listacliente.size()>0){
                for(int i=0;i<listacliente.size();i++){
                    datoscliente=listacliente.get(i);
                    Cli_id=datoscliente.getCli_id();
                    Cli_documento=datoscliente.getCli_documento();
                    Cli_nombre=datoscliente.getCli_nombre();
                    Cli_genero=datoscliente.getCli_genero();
                    Cli_telefono=datoscliente.getCli_telefono();
                    Cli_email=datoscliente.getCli_email();
                    Cli_direccion_1=datoscliente.getCli_direccion_1();
                    Cli_barrio_1=datoscliente.getCli_barrio_1();
                    Cli_descripcion_1=datoscliente.getCli_descripcion_1();
                    Cli_direccion_2=datoscliente.getCli_direccion_2();
                    Cli_barrio_2=datoscliente.getCli_barrio_2();
                    Cli_descripcion_2=datoscliente.getCli_descripcion_2();
                }
            }
            
            if(u.equals(nom) && c.equals(pass)){
                if(est.equals("Activo")){
                    if(rol.equals("Administrador")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", id);
                        Usuario.setAttribute("VarNom", nom);
                        Usuario.setAttribute("VarPass", pass);
                        Usuario.setAttribute("VarRol", rol);
                        Usuario.setAttribute("VarEst", est);
                        Usuario.setAttribute("VarFot", fot);
                        response.sendRedirect("");
                    }else if(rol.equals("Cliente")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", id);
                        Usuario.setAttribute("VarNom", nom);
                        Usuario.setAttribute("VarPass", pass);
                        Usuario.setAttribute("VarRol", rol);
                        Usuario.setAttribute("VarEst", est);
                        Usuario.setAttribute("VarFot", fot);
                        Usuario.setAttribute("VarIdCli", Cli_id);
                        Usuario.setAttribute("VarDocCli", Cli_documento);
                        Usuario.setAttribute("VarNomCli", Cli_nombre);
                        response.sendRedirect("Cliente/vi_Cliente.jsp");
                    } else if(rol.equals("Mensajero")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", id);
                        Usuario.setAttribute("VarNom", nom);
                        Usuario.setAttribute("VarPass", pass);
                        Usuario.setAttribute("VarRol", rol);
                        Usuario.setAttribute("VarEst", est);
                        Usuario.setAttribute("VarFot", fot);
                        response.sendRedirect("");
                    }else if(rol.equals("Proveedor")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", id);
                        Usuario.setAttribute("VarNom", nom);
                        Usuario.setAttribute("VarPass", pass);
                        Usuario.setAttribute("VarRol", rol);
                        Usuario.setAttribute("VarEst", est);
                        Usuario.setAttribute("VarFot", fot);
                        response.sendRedirect("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su usario esta inactivo");
                    response.sendRedirect("index");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Sus datos son incorectos");
                response.sendRedirect("index");
            }
        }
        
        if(request.getParameter("Actu")!=null){
            HttpSession ActualizarCliente=request.getSession(true);
            /*ActualizarCliente.setAttribute("VarUsuNom", nom);
            ActualizarCliente.setAttribute("VarUsuPass", pass);
            ActualizarCliente.setAttribute("VarUsuFoto", fot);*/
            ActualizarCliente.setAttribute("VarCliId", Cli_id);
            /*ActualizarCliente.setAttribute("VarCliDoc", Cli_documento);
            ActualizarCliente.setAttribute("VarCliNom", Cli_nombre);
            ActualizarCliente.setAttribute("VarCliGen", Cli_genero);
            ActualizarCliente.setAttribute("VarCliTel", Cli_telefono);
            ActualizarCliente.setAttribute("VarCliEma", Cli_email);
            ActualizarCliente.setAttribute("VarCliDir", Cli_direccion_1);
            ActualizarCliente.setAttribute("VarCliBar", Cli_barrio_1);
            ActualizarCliente.setAttribute("VarCliDes", Cli_descripcion_1);
            ActualizarCliente.setAttribute("VarCliDir2", Cli_direccion_2);
            ActualizarCliente.setAttribute("VarCliBar2", Cli_barrio_2);
            ActualizarCliente.setAttribute("VarCliDes2", Cli_descripcion_2);*/
            response.sendRedirect("Cliente/ActualizarCliente.jsp");
            
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
