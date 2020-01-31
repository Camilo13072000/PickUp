
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_GetSetCategorias"%>
<%@page import="Modelo.Mod_LoginCliente"%>
<%@page import="Modelo.Mod_GetSetProductos"%>
<%@page import="Modelo.Mod_GetSetLoginCliente"%>
<%@page import="Modelo.Mod_GetSetDomicilio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-control", "muts-revalidate");
            response.setHeader("Cache.control", "no-cache");
            response.setHeader("Cache-control", "no.store");
            
            if(session.getAttribute("VarId")==null){
                request.getRequestDispatcher("../index.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            request.getRequestDispatcher("../index.jsp").forward(request, response);
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PickUp</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            int UsuId;
            String Cli_Id;
            HttpSession cli=request.getSession(false);
            UsuId=(int)cli.getAttribute("VarId");
            Cli_Id=(String)cli.getAttribute("VarIdCli");
            JOptionPane.showMessageDialog(null, Cli_Id);
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <form action="../Con_Cerrar" method="POST">
                        <input class="btn btn.default" name="Cerrar" type="submit" value="Cerrar">
                    </form>
                </li>
                <li class="nav-item">
                    <form><button class="btn btn.default" name="Ped" type="submit">Pedidos</button></form>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </div>
                </li>
                <li class="nav-item">
                    <form action="../Con_Login" method="POST">
                        <button type="submit" name="Actu" class="btn btn.default">Actualizar</button>
                    </form>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
        <% if(request.getParameter("Ped")!=null){ %>
        <table class="table">
            <tr>
                <thead class="thead-dark">
                    <th scope="col">Id</th>
                    <th scope="col">Total</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Fecha inicio</th>
                    <th scope="col">Fecha Salida</th>
                    <th scope="col">Fecha Entrega</th>
                    <th scope="col">Id Cliente</th>
                    <th scope="col">Id Mensajero</th>
                </thead>
            </tr>
            <%
                ArrayList<Mod_GetSetDomicilio> ListaDomi=new ArrayList();
                Mod_GetSetDomicilio gs=new Mod_GetSetDomicilio(Cli_Id);
                Mod_LoginCliente dom=new Mod_LoginCliente();
                ListaDomi=dom.ConsultarDomicilios(gs);
                
                for(int i=0;i<ListaDomi.size();i++){
                    gs=ListaDomi.get(i);
            %>
            <tr>
                <tbody>
                    <td scope="row"><%=gs.getDom_id()%></td>
                    <td><%=gs.getDom_total_general()%></td>
                    <td><%=gs.getDom_estado()%></td>
                    <td><%=gs.getDom_costo_domicilio()%></td>
                    <td><%=gs.getDom_fecha_inicio()%></td>
                    <td><%=gs.getDom_fecha_salida()%></td>
                    <td><%=gs.getDom_fecha_entrega()%></td>
                    <td><%=gs.getDom_cli_id()%></td>
                    <td><%=gs.getDom_men_id()%></td>
                </tbody>
            </tr>
            <% } %>
        </table>
        <% } %>
        <table class="table">
            <tr>
                <thead class="thead-dark">
                    <th>Nombre</th>
                    <th>Foto</th>
                </thead>
            </tr>
            <%
                ArrayList<Mod_GetSetProductos> ListaProd=new ArrayList();
                Mod_GetSetProductos ges=new Mod_GetSetProductos();
                Mod_LoginCliente pro=new Mod_LoginCliente();
                ListaProd=pro.ConsultarProductos();
                for(int i=0;i<ListaProd.size();i++){
                    ges=ListaProd.get(i);
            %>
            <tr>
                <tbody>
                    <td><%=ges.getPro_nombre()%></td>
                    <td><%=ges.getPro_foto()%></td>
                </tbody>
            </tr>
            <% } %>
        </table>
        <table class="table">
            <tr>
                <thead class="thead-dark">
                    <th scope="col">Nombre</th>
                    <th scope="col">Foto</th>
                </thead>
            </tr>
            <%
                ArrayList<Mod_GetSetCategorias> ListaCate=new ArrayList();
                Mod_GetSetCategorias gese=new Mod_GetSetCategorias();
                Mod_LoginCliente cate=new Mod_LoginCliente();
                ListaCate=cate.ConsultarCategorias();
                for(int i=0;i<ListaCate.size();i++){
                    gese=ListaCate.get(i);
            %>
            <tr>
                <tbody>
                    <td><%=gese.getCate_nombre()%></td>
                    <td><%=gese.getCate_foto()%></td>
                </tbody>
            </tr>
            <% } %>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
