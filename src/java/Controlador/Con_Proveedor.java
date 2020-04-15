
package Controlador;

import Modelo.Mod_GetSetProveedor;
import Modelo.Mod_Proveedor;
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
@WebServlet(name = "Con_Proveedor", urlPatterns = {"/Con_Proveedor"})
public class Con_Proveedor extends HttpServlet {

    String Foto,Cli_id,Tipo_nombre,prove_nit,prove_nombre,prove_foto,prove_horario;
    int Usu_id,TamCarrito,Tipo_codigo;
    
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
        
        if(request.getParameter("TipoPro")!=null){
            LocalesTipo(request, response);
        }
        
    }
    
    protected void LocalesTipo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Tipo_codigo=Integer.parseInt(request.getParameter("TipoCod"));
        Tipo_nombre=request.getParameter("TipoNom");
        
        Cli_id=request.getParameter("clid");
        Usu_id=Integer.parseInt(request.getParameter("usuid"));
        Foto=request.getParameter("foto");
        TamCarrito=Integer.parseInt(request.getParameter("car"));
        
        if(Tipo_nombre.equals("Restaurantes")){
            HttpSession prov=request.getSession(true);
            prov.setAttribute("Tipo_codigo", Tipo_codigo);
            prov.setAttribute("Tipo_nombre", Tipo_nombre);
            prov.setAttribute("Cli_id", Cli_id);
            prov.setAttribute("Usu_id", Usu_id);
            prov.setAttribute("Usu_foto", Foto);
            prov.setAttribute("contador", TamCarrito);
            response.sendRedirect("Proveedor.jsp");
        }else{
            ArrayList<Mod_GetSetProveedor>Prove=new ArrayList<>();
            Mod_GetSetProveedor gsprove=new Mod_GetSetProveedor();
            Mod_Proveedor provee=new Mod_Proveedor();
            Prove=provee.ConsultarProductosNombreProveedor(Tipo_nombre);
            for(int i=0;i<Prove.size();i++){
                gsprove=Prove.get(i);
                prove_nit=gsprove.getProve_nit();
                prove_nombre=gsprove.getProve_nombre();
                prove_foto=gsprove.getProve_foto();
                prove_horario=gsprove.getProve_horario();
            }
            JOptionPane.showMessageDialog(null, prove_nit);
            HttpSession prov=request.getSession(true);
            
            prov.setAttribute("prove_nit", prove_nit);
            prov.setAttribute("prove_nombre", prove_nombre);
            prov.setAttribute("prove_foto", prove_foto);
            prov.setAttribute("prove_horario", prove_horario);
            prov.setAttribute("Tipo_codigo", Tipo_codigo);
            prov.setAttribute("Tipo_nombre", Tipo_nombre);
            prov.setAttribute("cli_id", Cli_id);
            prov.setAttribute("usu_id", Usu_id);
            prov.setAttribute("usu_foto", Foto);
            prov.setAttribute("contador", TamCarrito);
            response.sendRedirect("Presentacion.jsp");
        }
        
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
