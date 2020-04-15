<%-- 
    Document   : Proveedor
    Created on : 16/02/2020, 12:07:43 AM
    Author     : Camilo Martinez
--%>

<%@page import="Modelo.Mod_Proveedor"%>
<%@page import="Modelo.Mod_GetSetProveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locales</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css"  href="boostrap/css/bootstrap.css">
    </head>
    <body>
        
        <%
            int UsuId,Tam_carrito,Tipo_codigo;
            String foto,Cli_Id,Tipo_nombre;
            
            HttpSession cli=request.getSession(false);
            UsuId=(int)cli.getAttribute("Usu_id");
            foto=(String)cli.getAttribute("Usu_foto");
            Cli_Id=(String)cli.getAttribute("Cli_id");
            Tam_carrito=(Integer)cli.getAttribute("contador");
            Tipo_codigo=(Integer)cli.getAttribute("Tipo_codigo");
            Tipo_nombre=(String)cli.getAttribute("Tipo_nombre");
            
            //JOptionPane.showMessageDialog(null, UsuId);
            
        %>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="Cliente/vi_Cliente.jsp">PickUp</a>
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
                        <!--<a href="PedidosCliente.jsp" class="btn btn.default">Pedidos</a>-->
                        <form action="../Con_Cliente" method="POST">
                            <input type="hidden" name="cli_id" value="<%=Cli_Id%>">
                            <button class="btn btn.default" name="Pedidos" type="submit">Pedidos</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../Con_Carrito" method="POST">
                            <input type="hidden" value="<%=foto%>" name="Foto">
                            <input type="hidden" value="<%=Cli_Id%>" name="clid">
                            <button class="btn  btn.default" type="submit" name="Consulta">
                                <i class="fas fa-cart-plus"  style="color: #fff;margin: 3px"><label>(<%=Tam_carrito%>)</label></i>
                            </button>
                        </form>
                    </li>
                    <!--<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>-->
                    <li class="nav-item">
                        <form action="Con_Login" method="POST">
                            <input type="hidden" name="Cli_Id" value="<%=Cli_Id%>">
                            <button type="submit" name="ActualizarCliente" class="btn btn.default">Actualizar</button>
                        </form>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <img src="<%=foto%>" class="mr-sm-4  rounded-circle" width="35px">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
                    
                    
        <div class="container mt-5">
        
            <div class="row">
                
                <%
                    ArrayList<Mod_GetSetProveedor>Proveedor=new ArrayList();
                    Mod_GetSetProveedor gspro=new Mod_GetSetProveedor();
                    Mod_Proveedor DatosProveedor=new Mod_Proveedor();
                    Proveedor=DatosProveedor.ConsultarProveedor(Tipo_codigo);
                    for(int i=0;i<Proveedor.size();i++){
                        gspro=Proveedor.get(i);
                %>
                <div class="col-sm-6 col-6 col-md-4 col-lg-4 col-xl-3">
                    <div class="card cat" style="width: 13rem;">
                        
                        <div class="card-body rounded" style="margin: -18px">
                            <form action="Con_presentacion" method="POST">
                                <input type="hidden" name="usu_id" value="<%=gspro.getProve_nit()%>">
                                <input type="hidden" name="usu_foto" value="<%=foto%>">
                                <input type="hidden" name="cli_id" value="<%=Cli_Id%>">
                                <input type="hidden" name="prove_nit" value="<%=gspro.getProve_nit()%>">
                                <input type="hidden" name="prove_nombre" value="<%=gspro.getProve_nombre()%>">
                                <input type="hidden" name="Contador" value="<%=Tam_carrito%>">
                                <input type="hidden" name="prove_foto" value="<%=gspro.getProve_foto()%>">
                                <input type="hidden" name="prove_horario" value="<%=gspro.getProve_horario()%>">
                                <button type="submit" name="Presentacion" class="btn btn-block">
                                    <img src="<%=gspro.getProve_foto()%>" class="card-img-bottom rounded" width="150" height="150">
                                    <h5><%=gspro.getProve_nombre()%></h5>
                                </button>
                            </form>
                        </div>
                        
                    </div>
                </div>
                <% } %>
            </div>
            
        </div>
                    
                    
        <script src="boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="boostrap/js/popper.min.js"></script>
        <script src="boostrap/js/bootstrap.min.js"></script>
    </body>
</html>
