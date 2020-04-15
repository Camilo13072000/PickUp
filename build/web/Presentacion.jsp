<%-- 
    Document   : Presentacion
    Created on : 16/02/2020, 12:07:20 AM
    Author     : Camilo Martinez
--%>

<%@page import="Modelo.Mod_Productos"%>
<%@page import="Modelo.Mod_GetSetProductos"%>
<%@page import="Modelo.Mod_Presentacion"%>
<%@page import="Modelo.Mod_GetSetPresentacion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css"  href="boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <%
        String prove_nombre,usu_foto,cli_id,prove_nit,prove_foto,prove_horario;
        int Tam_carrito,usu_id;
        HttpSession pro=request.getSession(false);
        cli_id=(String)pro.getAttribute("cli_id");
        usu_id=(int)pro.getAttribute("usu_id");
        usu_foto=(String)pro.getAttribute("usu_foto");
        prove_nit=(String)pro.getAttribute("prove_nit");
        prove_nombre=(String)pro.getAttribute("prove_nombre");
        prove_foto=(String)pro.getAttribute("prove_foto");
        prove_horario=(String)pro.getAttribute("prove_horario");
        Tam_carrito=(int)pro.getAttribute("contador");
        
    %>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="Cliente/vi_Cliente.jsp">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <form action="Con_Cerrar" method="POST">
                        <input class="btn btn.default" name="Cerrar" type="submit" value="Cerrar">
                    </form>
                </li>
                <li class="nav-item">
                    <form><button class="btn btn.default" name="Ped" type="submit">Pedidos</button></form>
                </li>
                <li class="nav-item">
                    <form action="Con_Carrito" method="POST">
                        <input type="hidden" value="<%=usu_foto%>" name="Foto">
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
                        <button type="submit" name="ActualizarCliente" class="btn btn.default">Actualizar</button>
                    </form>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                  <img src="<%=usu_foto%>" class="mr-sm-4  rounded-circle" width="35px">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
        </nav>
        
        <h1 class="text-center"></h1>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-md-4">
                    <img src="<%=prove_foto%>" class="card-img" width="180px">
                </div>
                <div class="col-sm-5 col-md-5">
                    <h1><%=prove_nombre%></h1>
                    <p><%=prove_horario%></p>
                </div>
            </div>
            
                <hr>
            
            <%
            
            ArrayList<Mod_GetSetPresentacion>ListaPres=new ArrayList<>();
            Mod_GetSetPresentacion gspres=new Mod_GetSetPresentacion();
            Mod_Presentacion modpres=new Mod_Presentacion();
            
            ArrayList<Mod_GetSetProductos>ListaProductos=new ArrayList<>();
            Mod_GetSetProductos gspro=new Mod_GetSetProductos();
            Mod_Productos Productos=new Mod_Productos();
            
            ListaProductos=Productos.ConsultarProductos(prove_nit);
            for(int e=0;e<ListaProductos.size();e++){
                gspro=ListaProductos.get(e);
            %>
            
            <h4><%=gspro.getPro_nombre()%></h4>
            <div class="row">
            <%
            ListaPres=modpres.ConsultarPresentacion(gspro.getPro_codigo());
                for(int i=0;i<ListaPres.size();i++){
                    gspres=ListaPres.get(i);
            %>
            
            
            
                <div class="col-sm-6 col-6 col-md-6 col-lg-6 col-xl-6">
                                
                                
                        <div class="card mb-3" style="max-width: 540px;">
                            <div class="row no-gutters">
                              <div class="col-md-4">
                                <img src="<%=gspres.getPre_foto()%>" class="card-img" alt="..." >
                              </div>
                              <div class="col-md-8">
                                <div class="card-body">
                                  <h5 class="card-title"><%=gspres.getPre_marca()%></h5>
                                  <label class="card-text"><%=gspres.getPre_descripcion()%></label><br>
                                  <label class="card-text">Unidades: <%=gspres.getPre_unidades()%></label><br>
                                  <label class="card-text">$ <%=gspres.getPre_precio()%></label><br>
                                  <p class="card-text">
                                    <form action="Con_Carrito" method="POST">
                                        <input type="hidden" value="<%=cli_id%>" name="clid">
                                        <input type="hidden" value="<%=usu_foto%>" name="Foto">
                                        <input type="hidden" value="<%=gspres.getPre_codigo()%>" name="Producto">
                                        <input type="submit" class="btn btn-info" name="Carrito" value="Añadir">
                                        <input type="submit" class="btn btn-success" name="Comprar" value="Comprar">
                                    </form>
                                  </p>
                                  
                                </div>
                              </div>
                            </div>
                        </div>
                    <br>    
                </div>
            
            <%  }  %>
            </div>
            <% } %>
            
        </div>
        
            
            
        <script src="boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="boostrap/js/popper.min.js"></script>
        <script src="boostrap/js/bootstrap.min.js"></script>
    </body>
</html>
