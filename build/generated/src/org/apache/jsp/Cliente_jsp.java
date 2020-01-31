package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Mod_GetSetProductos;
import Modelo.LoginCliente;
import Modelo.GetSetLoginCliente;
import Modelo.Mod_GetSetDomicilio;
import java.util.ArrayList;

public final class Cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Id</th>\n");
      out.write("                <th>Total</th>\n");
      out.write("                <th>Estado</th>\n");
      out.write("                <th>Costo</th>\n");
      out.write("                <th>Fecha inicio</th>\n");
      out.write("                <th>Fecha Salida</th>\n");
      out.write("                <th>Fecha Entrega</th>\n");
      out.write("                <th>Id Cliente</th>\n");
      out.write("                <th>Id Mensajero</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Mod_GetSetDomicilio> ListaDomi=new ArrayList();
                Mod_GetSetDomicilio gs=new Mod_GetSetDomicilio();
                LoginCliente dom=new LoginCliente();
                ListaDomi=dom.ConsultarDomicilios();
                
                for(int i=0;i<ListaDomi.size();i++){
                    gs=ListaDomi.get(i);
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(gs.getDom_id());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_total_general());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_estado());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_costo_domicilio());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_fecha_inicio());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_fecha_salida());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_fecha_entrega());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_cli_id());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(gs.getDom_men_id());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Foto</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Mod_GetSetProductos> ListaProd=new ArrayList();
                Mod_GetSetProductos ges=new Mod_GetSetProductos();
                LoginCliente pro=new LoginCliente();
                ListaProd=pro.ConsultarProductos();
                for(int i=0;i<ListaProd.size();i++){
                    ges=ListaProd.get(i);
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(ges.getPro_nombre());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(ges.getPro_foto());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
