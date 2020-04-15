
<%@page import="Modelo.Mod_TiposProveedores"%>
<%@page import="Modelo.Mod_GetSetTiposProveedores"%>
<%@page import="Modelo.Mod_Categorias"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Mod_Productos"%>
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
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css"  href="../boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="../css/estilos.css">
        
        
    </head>
    <body>
        <%
            int UsuId,Tam_carrito;
            String foto;
            String Cli_Id;
            
            HttpSession cli=request.getSession(false);
            UsuId=(int)cli.getAttribute("VarId");
            foto=(String)cli.getAttribute("VarFot");
            Cli_Id=(String)cli.getAttribute("VarIdCli");
            Tam_carrito=(Integer)cli.getAttribute("contador");
            
            //JOptionPane.showMessageDialog(null, UsuId);
            
        %>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
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
                        <input type="hidden" name="Cli_Id" value="<%=Cli_Id%>">
                        <button type="submit" name="ActualizarCliente" class="btn btn.default">Actualizar</button>
                    </form>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                  <img src="../<%=foto%>" class="mr-sm-4  rounded-circle" width="35px">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
            
            <br><br>
            
            <div class="container">    
            <div class="row">
                <%
                    ArrayList<Mod_GetSetTiposProveedores> ListaProveedor=new ArrayList();
                    Mod_GetSetTiposProveedores gsTipo=new Mod_GetSetTiposProveedores();
                    Mod_TiposProveedores Tipo=new Mod_TiposProveedores();
                    ListaProveedor=Tipo.ConsultarTiposProveedores();
                    for(int i=0;i<ListaProveedor.size();i++){
                        gsTipo=ListaProveedor.get(i);
                %>
                <div class="col-sm-6 col-6 col-md-4 col-lg-4 col-xl-3">
                    <div class="card cat" style="width: 13rem;">
                        <!--<div class="card-header">
                            
                        </div>
                        <div class="card-body">
                            <img src="<%//=gese.getCate_foto()%>" class="card-img-bottom" width="200" height="180">
                        </div>-->
                        <div class="card-body rounded" style="margin: -18px">
                            <form action="../Con_Proveedor" method="POST">
                                <input type="hidden" value="<%=gsTipo.getTipo_codigo()%>" name="TipoCod">
                                <input type="hidden" value="<%=gsTipo.getTipo_nombre()%>" name="TipoNom">
                                <input type="hidden" value="<%=UsuId%>" name="usuid">
                                <input type="hidden" value="<%=Cli_Id%>" name="clid">
                                <input type="hidden" value="<%=foto%>" name="foto">
                                <input type="hidden" value="<%=Tam_carrito%>" name="car">
                                <button type="submit" class="btn btn-block" name="TipoPro">
                                    <img src="../<%=gsTipo.getTipo_foto()%>" class="card-img-bottom rounded" width="150" height="150">
                                </button>
                                    <h5 style="margin-left: 14px"><%=gsTipo.getTipo_nombre()%></h5>
                            </form>
                            <!--<button class="btn btn-info">Agregar al carrito</button>
                            <button class="btn btn-danger">Comprar</button>-->
                        </div>
                    </div>
                    <br>    
                </div>
                
            <% } %>
            </div>
        </div>
             
        <script src="../js/jquery-3.4.1.min.js"></script>
        <script src="../js/main.js"></script>
        <script src="../boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="../boostrap/js/popper.min.js"></script>
        <script src="../boostrap/js/bootstrap.min.js"></script>
    
    </body>
</html>