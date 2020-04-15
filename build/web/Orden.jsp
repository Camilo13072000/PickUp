<%-- 
    Document   : Orden
    Created on : 4/04/2020, 03:41:43 AM
    Author     : Camilo Martinez
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_Orden"%>
<%@page import="Modelo.Mod_GetSetOrdenDomicilio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" type="text/css"  href="boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body>
        
        <%
            int dom_id;
            HttpSession orden=request.getSession(false);
            dom_id=(int)orden.getAttribute("dom_id");
        %>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="Mensajero/Vi_mensajero.jsp">PickUp</a>
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
              </ul>
            </div>
          </nav>
        <div class="container">
        <%
            int n=0;
            ArrayList<Mod_GetSetOrdenDomicilio>ListaOrden=new ArrayList<>();
            Mod_GetSetOrdenDomicilio Orden=new Mod_GetSetOrdenDomicilio();
            Mod_Orden Mod=new Mod_Orden();
            ListaOrden=Mod.OrdenDomicilio(dom_id);
            for(int i=0;i<ListaOrden.size();i++){
                Orden=ListaOrden.get(i);
                
        %>
            <table class="table table-bordered table-striped mt-3">
                <thead>
                    <tr class="thead-dark">
                        <th colspan="2">Orden <%=i+1%></th>
                    </tr>
                </thead>
                <tr>
                    <th colspan="2"><img src="<%=Orden.getPre_foto()%>" width="80px"></th>
                </tr>
                <tr>
                    <th>Orden</th>
                    <td><%=Orden.getOr_id()%></th>
                </tr>
                <tr>
                    <th>producto</th>
                    <td><%=Orden.getPre_marca()%></th>
                </tr>
                <tr>
                    <th>Unidades</th>
                    <td><%=Orden.getOr_unid()%></th>
                </tr>
                <tr>
                    <th>Total</th>
                    <td><%=Orden.getOr_total()%></th>
                </tr>
                <tr>
                    <th>Descripcion</th>
                    <td><%=Orden.getOr_descripcion()%></th>
                </tr>
                <tr>
                    <th>Estado</th>
                    <td><%=Orden.getOr_estado()%></th>
                </tr>
                <tr>
                    <th>Dir-proveedor</th>
                    <td><%=Orden.getProve_direccion()%></th>
                </tr>
                <% if(Orden.getOr_estado().equals("Terminado")){ %>
                <tr>
                    <th colspan="2">
                        <form action="Con_Ordenes" method="POST">
                            <input type="hidden" name="dom_id" value="<%=dom_id%>">
                            <input type="hidden" name="or_id" value="<%=Orden.getOr_id()%>">
                            <button class="form-control btn btn-success" name="OrEstado">Recogido</button>
                        </form>
                    </th>
                </tr>
                <% } %>
            </table>
            <% if(Orden.getOr_estado().equals("Recogido")){ 
                n++;
                if(n==ListaOrden.size()){
            %>
                <form action="Con_Domicilio" method="Post">
                    <input type="hidden" name="dom_id" value="<%=dom_id%>">
                    <input type="hidden" name="Dom_Estado" value="Enviando">
                    <button type="submit" name="EstadoTerminado" class="form-control btn btn-primary">En camino</button>
                </form>
            <%     }
                } 
            %>
        <% } %>
        </div>
        <script src="boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="boostrap/js/popper.min.js"></script>
        <script src="boostrap/js/bootstrap.min.js"></script>
        
    </body>
</html>
