<%-- 
    Document   : index
    Created on : 20/01/2020, 01:43:43 AM
    Author     : Camilo Martinez
--%>

<%@page import="Modelo.Mod_TiposProveedores"%>
<%@page import="Modelo.Mod_GetSetTiposProveedores"%>
<%@page import="Modelo.Mod_Categorias"%>
<%@page import="Modelo.Mod_LoginCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Mod_GetSetCategorias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PickUp</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="#">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <!--<li class="nav-item active">
                  <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Link</a>
                </li>-->
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Buscar por
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Categorias</a>
                    <a class="dropdown-item" href="#">Productos</a>
                    <a class="dropdown-item" href="#">Locales</a>
                  <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Inicio</a>
                  </div>
                </li>
                <!--
                <li class="nav-item">
                  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
                -->
              </ul>
                <ul class="navbar-nav mr-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </ul>
                
                    <form class="form-inline my-2 my-lg-0">
                      <button type="button" class="form-control btn btn.default" data-toggle="modal" data-target="#Login">
                      Login
                      </button>
                    </form>
                <!--<ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Login
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="#">Categorias</a>
                          <a class="dropdown-item" href="#">Productos</a>
                          <a class="dropdown-item" href="#">Locales</a>
                        <div class="dropdown-divider"></div>
                          <a class="dropdown-item" href="#">Inicio</a>
                        </div>
                    </li>
                </ul>-->
            </div>
          </nav>
        
        
        
        <div class="modal fade" id="Login" tabindex="-1" role="dialog" aria-labelledby="LoginL" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="LoginL">Inicio de sesión</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
                <form action="Con_Login" method="POST">
                <div class="modal-body">
                  
                    <label for="NumUsu">Nombre de usuario</label>
                    <input type="text" id="NomUsu" class="btn modal-content" name="Usunom">
                    <label for="Cont">Contraseña</label>
                    <input type="password" id="Cont" class="btn modal-content" name="Usucont">
                  
                </div>
                <div class="modal-footer">
                    <a  href="Cliente/RegistrarUsuario.jsp">Registrar Cuenta</a>
                 <input type="submit" class="btn btn-primary" value="Iniciar sesión" name="entrar">
                </div>
               </form>
            </div>
          </div>
        </div>
        <br>
        
        
        
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
                            <form action="Con_Proveedor" method="POST">
                                <input type="hidden" value="<%=gsTipo.getTipo_codigo()%>" name="TipoCod">
                                <input type="hidden" value="<%=gsTipo.getTipo_nombre()%>" name="TipoNom">
                                <button type="button" class="btn btn-block" name="Cate" data-toggle="modal" data-target="#Login">
                                    <img src="<%=gsTipo.getTipo_foto()%>" class="card-img-bottom rounded" width="150" height="150">
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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>