<%-- 
    Document   : ActualizarCliente
    Created on : 21/01/2020, 11:28:40 PM
    Author     : Camilo Martinez
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_LoginCliente"%>
<%@page import="Modelo.Mod_GetSetActualizarCliente"%>
<%@page import="Modelo.Mod_GetSetLoginCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="../boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String CliId;
        HttpSession Cliente=request.getSession(false);
        CliId=(String)Cliente.getAttribute("VarCliId");
    %>
    <body>
        
                <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="vi_Cliente.jsp">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <form action="../Con_Cerrar" method="POST">
                        <input class="btn btn.default" name="Cerrar" type="submit" value="Cerrar">
                    </form>
                </li>
            </ul>
            
            <!--<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
                
              </ul>
                <ul class="navbar-nav mr-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </ul>
            </div>-->
          </nav>
            
        <br>
        
        
        <div class="container">    
                <form action="../Con_Cliente" method="POST"  enctype="multipart/form-data">
                    <div class="form-row">
                <%
                    ArrayList<Mod_GetSetActualizarCliente> DatosCliente=new ArrayList<>();
                    Mod_GetSetActualizarCliente gscli=new Mod_GetSetActualizarCliente();
                    Mod_LoginCliente ActuCli=new Mod_LoginCliente();
                    DatosCliente=ActuCli.ConsultarDatosCliente(CliId);
                    //JOptionPane.showMessageDialog(null, DatosCliente.size());
                    for(int i=0;i<DatosCliente.size();i++){
                        gscli=DatosCliente.get(i);
                %>
                    

                    <div class="form-group col-sm-4">
                        <img src="../<%=gscli.getUsu_foto()%>" width="180px" class="rounded-circle">
                        <div class="row">
                            <div class="col-md-6">
                                <button type="submit" name="ActualizarFotoCliente" class="btn btn-dark form-control">Actualizar foto</button>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="file" class="form-control-file btn" id="Foto" name="fot" value="<%=gscli.getUsu_foto()%>">
                                </div>
                            </div>
                        </div>
                    </div>
                        <input name="Nomb" type="hidden" value="<%=gscli.getCli_nombre()%>">
                        <input name="fotousu" type="hidden" value="<%=gscli.getUsu_foto()%>">
                        
                    <div class="form-group col-sm-8">
                        <div class="form-group">
                            <label for="nomb">Nombre de usuario</label>
                            <input type="text" class="form-control" id="nomb" name="nom" value="<%=gscli.getUsu_nombre()%>">
                        </div> 
                        <div class="form-group">
                            <label for="passw">Contraseña</label>
                            <input type="password" class="form-control" id="passw" name="pass" value="<%=gscli.getUsu_password()%>">
                        </div> 
                        
                    </div>   
                    <hr class="bg-dark">
                    <div class="form-group col-sm-6">
                            
                        <input type="hidden" class="form-control" id="Doc" name="docu" value="<%=gscli.getCli_documento()%>">
                        <input type="hidden" class="form-control" id="Doc" name="id" value="<%=CliId%>">
                        
                        <div class="form-group">
                            <label for="Tel">Telefono</label>
                            <input type="number" class="form-control" id="Tel" name="telef" value="<%=gscli.getCli_telefono()%>">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">    
                        
                        <div class="form-group">
                            <label for="corr">Email</label>
                            <input type="email" class="form-control" id="corr" name="correo" value="<%=gscli.getCli_email()%>">
                        </div>
                    </div>
                    <hr>
                    <div class="form-group col-sm-6">  
                        <div class="form-group">
                            <label for="Dire">Direccion</label>
                            <input type="text" class="form-control" id="Dire" name="direc" value="<%=gscli.getCli_direccion_1()%>">
                        </div>
                        <div class="form-group">
                            <label for="Bar">Barrio</label>
                            <input type="text" class="form-control" id="Bar" name="barr" value="<%=gscli.getCli_barrio_1()%>" pattern="[a-zA-Z ]{1,15}">
                        </div>
                        <div class="form-group">
                            <label for="Des">Descripcion</label>
                            <input type="text" class="form-control" id="Des" name="descr" value="<%=gscli.getCli_descripcion_1()%>">
                        </div>
                    </div>
                    <div class="form-group col-sm-6">
                        <div class="form-group">
                            <label for="Dire">Segunda Direccion (Opcional)</label>
                            <input type="text" class="form-control" id="Dire" name="direc2" value="<%=gscli.getCli_direccion_2()%>">
                        </div>
                        <div class="form-group">
                            <label for="Bar">Barrio2 (Opcional)</label>
                            <input type="text" class="form-control" id="Bar" name="barr2" value="<%=gscli.getCli_barrio_2()%>">
                        </div>
                        <div class="form-group">
                            <label for="Des">Descripcion2 (Opcional)</label>
                            <input type="text" class="form-control" id="Des" name="descr2" value="<%=gscli.getCli_descripcion_2()%>">
                        </div>
                    </div>  
                <% } %>
                <!--<div class="form-group">
                    <label for=""></label>
                    <input type="text" class="form-control" id="" name="">
                </div> -->
            
            
            <button type="submit" name="Actu" class="btn btn-dark form-control">Actualizar</button>
                </div>
            </form>
        </div>
              
        <script src="../boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="../boostrap/js/popper.min.js"></script>
        <script src="../boostrap/js/bootstrap.min.js"></script>
    </body>
</html>