
package Controlador;

import Modelo.Mod_Domicilio;
import Modelo.Mod_GetSetCarrito;
import Modelo.Mod_GetSetDomicilio;
import Modelo.Mod_GetSetOrden;
import Modelo.Mod_GetSetPresentacion;
import Modelo.Mod_Orden;
import Modelo.Mod_Presentacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "Con_Carrito", urlPatterns = {"/Con_Carrito"})
public class Con_Carrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Mod_Presentacion prese=new Mod_Presentacion();
    Mod_GetSetPresentacion p=new Mod_GetSetPresentacion();
    List<Mod_GetSetPresentacion> presentacion=new ArrayList<>();
    
    ArrayList<Mod_GetSetCarrito> carrito=new ArrayList<>();
    
    
    int dom_totalgeneral,dom_costo_domicilio;
    String dom_estado,dom_fecha_inicio,dom_fecha_salida,dom_fecha_entrega,dom_men_id,dom_cli_id;
    int or_dom_id, or_cli_id, or_pre_id, or_total, or_unid;
    int item;
    int totalapargar;
    int cantidad=1;
    int codipre;
    int idpre;
    //Mod_GetSetCarrito car;
    String foto;
    String cli_id;
    
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
        
        if(request.getParameter("Carrito")!=null || request.getParameter("Comprar")!=null || request.getParameter("Eliminar")!=null){
            Carr(request, response);
        }
        if(request.getParameter("Consulta")!=null){
            Consulta(request, response);
            //JOptionPane.showMessageDialog(null, "Ok");
        }
        if(request.getParameter("GenerarCompra")!=null){
            Compra(request, response);
        }
        if(request.getParameter("ActualizarCantidad")!=null){
            ActualizarCantidad(request, response);
        }
        
        //
        
    }
    
    protected void Consulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
                JOptionPane.showMessageDialog(null, "Ok");
                //cli_id=request.getParameter("clid");
                //foto=request.getParameter("Foto");
                totalapargar=0;
                HttpSession cons=request.getSession(true);
               // cons.setAttribute("carritofoto", foto);
                cons.setAttribute("carritocon", carrito);
                //cons.setAttribute("cli_id", cli_id);
                for(int i=0;i<carrito.size();i++){
                    totalapargar=totalapargar+carrito.get(i).getSubTotal();
                }
                cons.setAttribute("totalapagar", totalapargar);
                response.sendRedirect("Carrito.jsp");   
    }
    
    protected void ActualizarCantidad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idpres=Integer.parseInt(request.getParameter("Idpre"));
        int Cant=Integer.parseInt(request.getParameter("cantidad"));
        for (int i = 0; i < carrito.size(); i++) {
            if(carrito.get(i).getIdproducto()==idpres){
                carrito.get(i).setCantidad(Cant);
                int st=carrito.get(i).getPrecioCompra()*Cant;
                carrito.get(i).setSubTotal(st);
            }
        }
        
    }
    protected void Compra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        boolean reg;
        cli_id=request.getParameter("clid");
        dom_totalgeneral=totalapargar;
        dom_estado="Solicitado";
        dom_costo_domicilio=3000;
        dom_cli_id=cli_id;
        
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String currentDate = ft.format(dNow);
        
        dom_fecha_inicio=currentDate;
        Mod_Domicilio dom=new Mod_Domicilio();
        Mod_GetSetDomicilio Domi=new Mod_GetSetDomicilio(dom_totalgeneral, dom_estado, dom_costo_domicilio, dom_fecha_inicio, dom_fecha_salida, dom_fecha_entrega, dom_cli_id, dom_men_id);
        reg=dom.GenerarDomicilio(Domi);
        
        ArrayList<Mod_GetSetDomicilio>IdDom=new ArrayList();
        Mod_GetSetDomicilio datodom=new Mod_GetSetDomicilio();
        IdDom=dom.DomId();
        
        for(int i=0;i<IdDom.size();i++){
            or_dom_id=IdDom.get(i).getDom_id();
        }
        
        or_cli_id =Integer.parseInt(cli_id);
        for(int i=0;i<carrito.size();i++){
            or_pre_id =carrito.get(i).getIdproducto();
            or_total=carrito.get(i).getSubTotal();
            or_unid=carrito.get(i).getCantidad();
            Mod_Orden Insertarorden=new Mod_Orden();
            Mod_GetSetOrden datosOrden=new Mod_GetSetOrden(or_dom_id, or_cli_id, or_pre_id, or_total, or_unid);
            reg=Insertarorden.InsertarOrden(datosOrden);
            
        }
        carrito.clear();
        
        HttpSession cerr=request.getSession(false);
        cerr.removeAttribute("contador");
        cerr.removeAttribute("carritocon");
        
        HttpSession con=request.getSession(true);
        
        con.setAttribute("contador", carrito.size());
        response.sendRedirect("Cliente/vi_Cliente.jsp");
        
    }
    protected void Carr(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        cli_id=request.getParameter("clid");
        presentacion=prese.ConsultarPresentaciones();
        if(request.getParameter("Carrito")!=null){
            int pos=0;
            cantidad=1; 
            codipre=Integer.parseInt(request.getParameter("Producto"));
            p=prese.ConsultarPresentacioncod(codipre);
            if(carrito.size()>0){
                for (int i = 0; i < carrito.size(); i++) {
                    if(codipre==carrito.get(i).getIdproducto()){
                        pos=i;
                        JOptionPane.showMessageDialog(null, pos);
                    }
                }
                if(codipre==carrito.get(pos).getIdproducto()){
                    cantidad=carrito.get(pos).getCantidad()+cantidad;
                    int subtotal=carrito.get(pos).getPrecioCompra()*cantidad;
                    carrito.get(pos).setCantidad(cantidad);
                    carrito.get(pos).setSubTotal(subtotal);
                }else{
                    item=item+1;
                    Mod_GetSetCarrito car=new Mod_GetSetCarrito();
                    car.setItem(item);
                    car.setIdproducto(p.getPre_codigo());
                    car.setNombres(p.getPre_marca());
                    car.setDescripcion(p.getPre_descripcion());
                    car.setPrecioCompra(p.getPre_precio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*p.getPre_precio());
                    carrito.add(car);
                }
            }else{
            item=item+1;
            Mod_GetSetCarrito car=new Mod_GetSetCarrito();
            car.setItem(item);
            car.setIdproducto(p.getPre_codigo());
            car.setNombres(p.getPre_marca());
            car.setDescripcion(p.getPre_descripcion());
            car.setPrecioCompra(p.getPre_precio());
            car.setCantidad(cantidad);
            car.setSubTotal(cantidad*p.getPre_precio());
            carrito.add(car);
            }
            HttpSession contador=request.getSession(true);
            contador.setAttribute("cli_id", cli_id);
            contador.setAttribute("contador", carrito.size());
            response.sendRedirect("Cliente/vi_Cliente.jsp"); 
             
        }else if(request.getParameter("Consulta")!=null){
                cli_id=request.getParameter("clid");
                foto=request.getParameter("Foto");
                totalapargar=0;
                HttpSession cons=request.getSession(true);
                cons.setAttribute("carritofoto", foto);
                cons.setAttribute("carritocon", carrito);
                cons.setAttribute("cli_id", cli_id);
                for(int i=0;i<carrito.size();i++){
                    totalapargar=totalapargar+carrito.get(i).getSubTotal();
                }
                cons.setAttribute("totalapagar", totalapargar);
                response.sendRedirect("Carrito.jsp");
                
        }else if(request.getParameter("Comprar")!=null){
            cli_id=request.getParameter("clid");
            totalapargar=0;
            int pos=0;
            cantidad=1;
            foto=request.getParameter("Foto");
            codipre=Integer.parseInt(request.getParameter("Producto"));
            p=prese.ConsultarPresentacioncod(codipre);
            
            if(carrito.size()>0){
                for (int i = 0; i < carrito.size(); i++) {
                    if(codipre==carrito.get(i).getIdproducto()){
                        pos=i;
                        JOptionPane.showMessageDialog(null, pos);
                    }
                }
                if(codipre==carrito.get(pos).getIdproducto()){
                    cantidad=carrito.get(pos).getCantidad()+cantidad;
                    int subtotal=carrito.get(pos).getPrecioCompra()*cantidad;
                    carrito.get(pos).setCantidad(cantidad);
                    carrito.get(pos).setSubTotal(subtotal);
                }else{
                    item=item+1;
                    Mod_GetSetCarrito car=new Mod_GetSetCarrito();
                    car.setItem(item);
                    car.setIdproducto(p.getPre_codigo());
                    car.setNombres(p.getPre_marca());
                    car.setDescripcion(p.getPre_descripcion());
                    car.setPrecioCompra(p.getPre_precio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*p.getPre_precio());
                    carrito.add(car);
                }
            }else{
            item=item+1;
            Mod_GetSetCarrito car=new Mod_GetSetCarrito();
            car.setItem(item);
            car.setIdproducto(p.getPre_codigo());
            car.setNombres(p.getPre_marca());
            car.setDescripcion(p.getPre_descripcion());
            car.setPrecioCompra(p.getPre_precio());
            car.setCantidad(cantidad);
            car.setSubTotal(cantidad*p.getPre_precio());
            carrito.add(car);
            }
            
            for(int i=0;i<carrito.size();i++){
                totalapargar=totalapargar+carrito.get(i).getSubTotal();
            }
            HttpSession comp=request.getSession(true);
            comp.setAttribute("totalapagar", totalapargar);
            comp.setAttribute("carritofoto", foto);
            comp.setAttribute("carritocon", carrito);
            comp.setAttribute("contador", carrito.size());
            comp.setAttribute("cli_id", cli_id);
            response.sendRedirect("Carrito.jsp");
            
        }else if(request.getParameter("Eliminar")!=null){
            idpre=Integer.parseInt(request.getParameter("Idpre"));
            int sub=Integer.parseInt(request.getParameter("Subtotal"));
            for(int i=0;i<carrito.size();i++){
                if(carrito.get(i).getIdproducto()==idpre){
                    totalapargar=totalapargar-sub;
                    carrito.remove(i);
                    
                    HttpSession comp=request.getSession(true);
                    comp.setAttribute("totalapagar", totalapargar);
                    comp.setAttribute("carritofoto", foto);
                    comp.setAttribute("carritocon", carrito);
                    comp.setAttribute("contador", carrito.size());
                    response.sendRedirect("Carrito.jsp");
                }
            }
            
        }else{
            HttpSession carpro=request.getSession(true);
            carpro.setAttribute("ProductoCar", presentacion);
            response.sendRedirect("Cliente/vi_Cliente.jsp");
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
