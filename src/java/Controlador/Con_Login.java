/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetLoginCliente;
import Modelo.Mod_GetSetMensajero;
import Modelo.Mod_GetSetUsuarios;
import Modelo.Mod_Login;
import Modelo.Mod_LoginCliente;
import Modelo.Mod_Mensajero;
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
    int usu_id;
    String usu_nombre,usu_password,usu_rol,usu_estado,usu_foto;
    String Cli_id,Cli_documento,Cli_nombre,Cli_genero,Cli_telefono,Cli_email,Cli_direccion_1,Cli_barrio_1,Cli_descripcion_1,Cli_direccion_2,Cli_barrio_2,Cli_descripcion_2,Cli_usu_id;
    int men_id,men_cedula,men_usu_id;
    String men_nombre,men_telefono,men_direccion,men_barrio,men_descripcion,men_email;
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
                    usu_id=gs.getUsu_id();
                    usu_nombre=gs.getUsu_nombre();
                    usu_password=gs.getUsu_password();
                    usu_rol=gs.getUsu_rol();
                    usu_estado=gs.getUsu_estado();
                    usu_foto=gs.getUsu_foto();
                }
            }
            ArrayList<Mod_GetSetLoginCliente>listacliente=new ArrayList<>();
            Mod_GetSetLoginCliente datoscliente=new Mod_GetSetLoginCliente();
            Mod_LoginCliente uncliente=new Mod_LoginCliente();
            listacliente=uncliente.consultaUnCliente(usu_id);
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
            ArrayList<Mod_GetSetMensajero>ListaMensajero=new ArrayList<>();
            Mod_GetSetMensajero DatosMensajero=new Mod_GetSetMensajero();
            Mod_Mensajero Mensajero=new Mod_Mensajero();
            ListaMensajero=Mensajero.DatosMensajero(usu_id);
            if(ListaMensajero.size()>0){
                for(int i=0;i<ListaMensajero.size();i++){
                    DatosMensajero=ListaMensajero.get(i);
                    men_id=DatosMensajero.getMen_id();
                    men_cedula=DatosMensajero.getMen_cedula();
                    men_nombre=DatosMensajero.getMen_nombre();
                    men_direccion=DatosMensajero.getMen_direccion();
                    men_barrio=DatosMensajero.getMen_barrio();
                    men_descripcion=DatosMensajero.getMen_descripcion();
                    men_telefono=DatosMensajero.getMen_telefono();
                    men_email=DatosMensajero.getMen_email();
                    men_usu_id=DatosMensajero.getMen_usu_id();
                }
            }
            
            
            
            if(u.equals(usu_nombre) && c.equals(usu_password)){
                if(usu_estado.equals("Activo")){
                    if(usu_rol.equals("Administrador")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", usu_id);
                        Usuario.setAttribute("VarNom", usu_nombre);
                        Usuario.setAttribute("VarPass", usu_password);
                        Usuario.setAttribute("VarRol", usu_rol);
                        Usuario.setAttribute("VarEst", usu_estado);
                        Usuario.setAttribute("VarFot", usu_foto);
                        response.sendRedirect("");
                    }else if(usu_rol.equals("Cliente")){
                        int contador = 0;
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", usu_id);
                        Usuario.setAttribute("VarNom", usu_nombre);
                        Usuario.setAttribute("VarPass", usu_password);
                        Usuario.setAttribute("VarRol", usu_rol);
                        Usuario.setAttribute("VarEst", usu_estado);
                        Usuario.setAttribute("VarFot", usu_foto);
                        Usuario.setAttribute("VarIdCli", Cli_id);
                        Usuario.setAttribute("VarDocCli", Cli_documento);
                        Usuario.setAttribute("VarNomCli", Cli_nombre);
                        Usuario.setAttribute("contador", contador);
                        response.sendRedirect("Cliente/vi_Cliente.jsp");
                    } else if(usu_rol.equals("Mensajero")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", usu_id);
                        Usuario.setAttribute("VarNom", usu_nombre);
                        Usuario.setAttribute("VarPass", usu_password);
                        Usuario.setAttribute("VarRol", usu_rol);
                        Usuario.setAttribute("VarEst", usu_estado);
                        Usuario.setAttribute("VarFot", usu_foto);
                        Usuario.setAttribute("men_id", men_id);
                        Usuario.setAttribute("men_nombre", men_nombre);
                        response.sendRedirect("Mensajero/Vi_mensajero.jsp");
                    }else if(usu_rol.equals("Proveedor")){
                        HttpSession Usuario=request.getSession(true);
                        Usuario.setAttribute("VarId", usu_id);
                        Usuario.setAttribute("VarNom", usu_nombre);
                        Usuario.setAttribute("VarPass", usu_password);
                        Usuario.setAttribute("VarRol", usu_rol);
                        Usuario.setAttribute("VarEst", usu_estado);
                        Usuario.setAttribute("VarFot", usu_foto);
                        response.sendRedirect("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su usario esta inactivo");
                    response.sendRedirect("index.jsp");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Sus datos son incorectos");
                response.sendRedirect("index.jsp");
            }
        }
        
        if(request.getParameter("ActualizarCliente")!=null){
            Cli_id=request.getParameter("Cli_Id");
            HttpSession ActualizarCliente=request.getSession(true);
            ActualizarCliente.setAttribute("VarCliId", Cli_id);
            response.sendRedirect("Cliente/ActualizarCliente.jsp");
            
        }
        if(request.getParameter("ActualizarMensajero")!=null){
            HttpSession ActualizarCliente=request.getSession(true);
            ActualizarCliente.setAttribute("Men_Id", men_id);
            response.sendRedirect("Mensajero/ActualizarMensajero.jsp");
            
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
