/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mod_GetSetActualizarCliente;
import Modelo.Mod_GetSetLoginCliente;
import Modelo.Mod_LoginCliente;
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
@WebServlet(name = "Con_Cliente", urlPatterns = {"/Con_Cliente"})
@MultipartConfig
public class Con_Cliente extends HttpServlet {
    
    String cli_id,cli_documento,cli_nombre,cli_fecha_naci,cli_genero,cli_telefono,cli_email,cli_direccion1,cli_barrio1,cli_descripcion1,cli_direccion2,cli_barrio2,cli_descripcion2,usu_nombre,usu_contraseña,usu_id,usu_fot;
    
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
        if(request.getParameter("ActualizarFotoCliente")!=null){
            ActualizarFotoCliente(request, response);
        }
        if(request.getParameter("Pedidos")!=null){
            Pedidos(request, response);
        }
        
        
        
    }
    
    protected void Pedidos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        cli_id=request.getParameter("cli_id");
        
        HttpSession cli=request.getSession(true);
        cli.setAttribute("Cli_id", cli_id);
        response.sendRedirect("Cliente/PedidosCliente.jsp");
    }
    
    protected void InsertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        boolean reg;
        cli_documento=request.getParameter("docu");
        cli_nombre=request.getParameter("Nomb");
        cli_fecha_naci=request.getParameter("fecnac");
        cli_genero=request.getParameter("gene");
        cli_telefono=request.getParameter("telef");
        cli_email=request.getParameter("correo");
        cli_direccion1=request.getParameter("direc");
        cli_barrio1=request.getParameter("barr");
        cli_descripcion1=request.getParameter("descr");
        usu_id=request.getParameter("UsuId");
        Mod_GetSetLoginCliente gscli=new Mod_GetSetLoginCliente(cli_documento, cli_nombre, cli_fecha_naci, cli_genero, cli_telefono, cli_email, cli_direccion1, cli_barrio1, cli_descripcion1, usu_id);
        Mod_LoginCliente logcli=new Mod_LoginCliente();
        reg=logcli.insertarcliente(gscli);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Insertados");
            HttpSession cli=request.getSession(true);
            cli.setAttribute("VarId", usu_id);
            response.sendRedirect("index.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Insertados");
        }
    }
    
    protected void ActualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        boolean reg;
        
        cli_id=request.getParameter("id");
        cli_nombre=request.getParameter("Nomb");
        cli_telefono=request.getParameter("telef");
        cli_email=request.getParameter("correo");
        cli_direccion1=request.getParameter("direc");
        cli_barrio1=request.getParameter("barr");
        cli_descripcion1=request.getParameter("descr");
        cli_direccion2=request.getParameter("direc2");
        cli_barrio2=request.getParameter("barr2");
        cli_descripcion2=request.getParameter("descr2");
        usu_nombre=request.getParameter("nom");
        usu_contraseña=request.getParameter("pass");
        usu_fot=request.getParameter("fotousu");
        Mod_GetSetActualizarCliente actcli=new Mod_GetSetActualizarCliente(cli_id,cli_telefono,cli_email,cli_direccion1,cli_barrio1,cli_descripcion1,cli_direccion2,cli_barrio2,cli_descripcion2,usu_nombre,usu_contraseña,usu_fot);
        Mod_LoginCliente logcli=new Mod_LoginCliente();
        reg=logcli.ActualizarCliente(actcli);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            HttpSession cli=request.getSession(true);
            cli.setAttribute("VarIdCli", cli_id);
            response.sendRedirect("Cliente/vi_Cliente.jsp");
        }else{
            JOptionPane.showMessageDialog(null, "Datos NO Actualizados");
        }
    }
    protected void ActualizarFotoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        boolean reg;
        
        cli_id=request.getParameter("id");
        cli_nombre=request.getParameter("Nomb");
        Part usu_foto=request.getPart("fot");
        String nomfoto=usu_foto.getSubmittedFileName();
        String nombre=cli_nombre+nomfoto;
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
        Mod_GetSetActualizarCliente actcli=new Mod_GetSetActualizarCliente(cli_id,url2);
        Mod_LoginCliente logcli=new Mod_LoginCliente();
        reg=logcli.ActualizarFotoCliente(actcli);
        if(reg){
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            HttpSession fot=request.getSession(true);
            fot.setAttribute("VarFot", url2);
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
