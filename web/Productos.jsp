<%-- 
    Document   : Productos
    Created on : 14/02/2020, 02:01:46 AM
    Author     : Camilo Martinez
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_Productos"%>
<%@page import="Modelo.Mod_GetSetProductos"%>
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
    <body>
        
        <%
            String Foto,cli,Usua,foto;
            String codcat,nomcat;
            int Tam_carrito;
            HttpSession cat=request.getSession(false);
            Usua=(String)cat.getAttribute("Usucli");
            codcat=(String)cat.getAttribute("Codcat");
            nomcat=(String)cat.getAttribute("Nomcat");
            cli=(String)cat.getAttribute("Clicod");
            Foto=(String)cat.getAttribute("Usufot");
            Tam_carrito=(Integer)cat.getAttribute("NumCar");
            
            //JOptionPane.showMessageDialog(null, nomcat);
        %>
        
        
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
                        <input type="hidden" value="<%=cli%>" name="Foto">
                        <input type="hidden" value="<%=Foto%>" name="Foto">
                        <button class="btn  btn.default" type="submit" name="Consulta">
                            <i class="fas fa-cart-plus"  style="color: #fff;margin: 3px"><label>(<%=Tam_carrito%>)</label></i>
                        </button>
                    </form>
                    
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
                    <form action="Con_Login" method="POST">
                        <button type="submit" name="ActualizarCliente" class="btn btn.default">Actualizar</button>
                    </form>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                  <img src="<%=Foto%>" class="mr-sm-4  rounded-circle" width="35px">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
        
        <h1 class="titulo"><%=nomcat%></h1>
                
        <div class="container">
            <div class="row">
                
            
            <% 
                ArrayList<Mod_GetSetProductos> ListaProd=new ArrayList();
                Mod_GetSetProductos ges=new Mod_GetSetProductos();
                Mod_Productos pro=new Mod_Productos();
                ListaProd=pro.ConsultarProductos(codcat);
                for(int i=0;i<ListaProd.size();i++){
                    ges=ListaProd.get(i);
            %>
            
                    
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                        <%//=gese.getCate_foto()%>
                            <img src="<%=ges.getPro_foto()%>" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"><%=ges.getPro_nombre()%></h5>
                                <!--<h5 class="card-title"><%=ges.getPro_codigo()%></h5>-->
                                <!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                <a href="#" class="btn btn-primary">Go somewhere</a>-->
                                <form action="Con_presentacion" method="POST">
                                    <input type="hidden" value="<%=Usua%>" name="usuid">
                                    <input type="hidden" value="<%=cli%>" name="clid">
                                    <input type="hidden" value="<%=Foto%>" name="foto">
                                    <input type="hidden" value="<%=Tam_carrito%>" name="car">
                                    <input type="hidden" value="<%=ges.getPro_codigo()%>" name="Producto">
                                    <input type="hidden" value="<%=ges.getPro_nombre()%>" name="nomProducto">
                                    <input type="submit" class="btn btn-block" name="Presentacion">
                                </form>
                            </div>
                        </div>
                        <br>    
                    </div>            
            <% } %>
        
            </div>
        </div>
        
        
        
        <script src="boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="boostrap/js/popper.min.js"></script>
        <script src="boostrap/js/bootstrap.min.js"></script>
        
    </body>
</html>