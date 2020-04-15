<%-- 
    Document   : ActualizarMensajero
    Created on : 25/02/2020, 08:21:58 PM
    Author     : Camilo Martinez
--%>

<%@page import="Modelo.Mod_Mensajero"%>
<%@page import="Modelo.Mod_GetSetActualizarMensajero"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-control", "muts-revalidate");
            response.setHeader("Cache.control", "no-cache");
            response.setHeader("Cache-control", "no.store");
            
            if(session.getAttribute("men_id")==null){
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
        <title>Mensajero</title>
        <link rel="stylesheet" type="text/css"  href="../boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            int id_men;
            HttpSession men=request.getSession(false);
            id_men=(int)men.getAttribute("men_id");
        %>
        
              <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="Vi_mensajero.jsp">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
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
            </div>
          </nav>
        <br>
        <div class="container">    
                <form action="../Con_Mensajero" method="POST" enctype="multipart/form-data">
                    <div class="form-row">
                <%
                    ArrayList<Mod_GetSetActualizarMensajero> DatosCliente=new ArrayList<>();
                    Mod_GetSetActualizarMensajero Mensajero=new Mod_GetSetActualizarMensajero();
                    Mod_Mensajero ActualizarMensajero=new Mod_Mensajero();
                    DatosCliente=ActualizarMensajero.DatosUsuarioMensajero(id_men); 
                    for(int i=0;i<DatosCliente.size();i++){
                        Mensajero=DatosCliente.get(i);
                %>
                    

                    <div class="form-group col-sm-4">
                        <center>
                        <img src="../<%=Mensajero.getUsu_foto()%>" width="180px" rounded-circle>
                        </center>
                        <div class="row">
                            <div class="col-md-6">
                                <button type="submit" name="ActualizarFotoMensajero" class="btn btn-dark form-control">Actualizar foto</button>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <!--<input type="file" class="form-control" id="" name="">-->
                                    <input type="file" class="form-control-file btn" id="Foto" name="fot">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-sm-8">
                        <div class="form-group">
                            <label for="nomb">Nombre de usuario</label>
                            <input type="text" class="form-control" id="nomb" name="nom" value="<%=Mensajero.getUsu_nombre()%>">
                        </div> 
                        <div class="form-group">
                            <label for="passw">Contraseña</label>
                            <input type="password" class="form-control" id="passw" name="pass" value="<%=Mensajero.getUsu_password()%>">
                        </div> 
                        
                    </div>   
                    <hr class="bg-dark">
                            
                        <input type="hidden" class="form-control" id="id" name="id" value="<%=Mensajero.getMen_id()%>">
                        <input type="hidden" class="form-control" id="Doc" name="nombremen" value="<%=Mensajero.getMen_nombre()%>">
                    
                    <div class="form-group col-sm-6">
                        
                        <div class="form-group">
                            <label for="Tel">Telefono</label>
                            <input type="number" class="form-control" id="Tel" name="telef" value="<%=Mensajero.getMen_telefono()%>">
                        </div>
                        
                        <div class="form-group">
                            <label for="corr">Email</label>
                            <input type="email" class="form-control" id="corr" name="correo" value="<%=Mensajero.getMen_email()%>">
                        </div>
                    </div>
                    <hr>
                    <div class="form-group col-sm-6">  
                        <div class="form-group">
                            <label for="Dire">Direccion</label>
                            <input type="text" class="form-control" id="Dire" name="direc" value="<%=Mensajero.getMen_direccion_1()%>">
                        </div>
                        <div class="form-group">
                            <label for="Bar">Barrio</label>
                            <input type="text" class="form-control" id="Bar" name="barr" value="<%=Mensajero.getMen_barrio_1()%>" pattern="[a-zA-Z ]{1,15}">
                        </div>
                        <div class="form-group">
                            <label for="Des">Descripcion</label>
                            <input type="text" class="form-control" id="Des" name="descr" value="<%=Mensajero.getMen_descripcion_1()%>">
                        </div>
                    </div> 
                <% } %>
                <!--<div class="form-group">
                    <label for=""></label>
                    <input type="text" class="form-control" id="" name="">
                </div> -->
            
            
            <button type="submit" name="ActualizaMensajero" class="btn btn-dark form-control">Actualizar</button>
                </div>
            </form>
        </div>
              
        <script src="../boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="../boostrap/js/popper.min.js"></script>
        <script src="../boostrap/js/bootstrap.min.js"></script>
        
    </body>
</html>
