<%-- 
    Document   : Vi_mensajero
    Created on : 25/02/2020, 08:21:38 PM
    Author     : Camilo Martinez
--%>

<%@page import="Modelo.Mod_Domicilio"%>
<%@page import="Modelo.Mod_GetSetDomicilioMensajero"%>
<%@page import="Modelo.Mod_Mensajero"%>
<%@page import="Modelo.Mod_GetSetMensajero"%>
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" type="text/css"  href="../boostrap/css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%
            String foto,men_nombre;
            int UsuId,men_id;
            HttpSession men=request.getSession(false);
            UsuId=(int)men.getAttribute("VarId");
            foto=(String)men.getAttribute("VarFot");
            men_id=(int)men.getAttribute("men_id");
            men_nombre=(String)men.getAttribute("men_nombre");
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
                    <form><button class="btn btn.default" name="Ped" type="submit">Pedidos</button></form>
                </li>
                <li class="nav-item">
                    <form action="../Con_Login" method="POST">
                        <button type="submit" name="ActualizarMensajero" class="btn btn.default">Actualizar</button>
                    </form>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <img src="../<%=foto%>" class="mr-sm-4  rounded-circle" width="35px">
                <label><%=men_nombre%></label>
              </form>
            </div>
          </nav>
        
              
              
             <div class="container mt-xl-5">
                 
            
            <div id="accordion">
                
                <div class="card">
                  <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                      <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Pepidos Asignados
                      </button>
                    </h5>
                  </div>

                  <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                      <div class="row">
                        <%
                            ArrayList<Mod_GetSetDomicilioMensajero>ListaMensajero=new ArrayList();
                            Mod_GetSetDomicilioMensajero Mensajero=new Mod_GetSetDomicilioMensajero();
                            Mod_Domicilio Mod=new Mod_Domicilio();
                            ListaMensajero=Mod.DomiciliosActivos(men_id,"Solicitado");
                            for(int i=0;i<ListaMensajero.size();i++){
                                Mensajero=ListaMensajero.get(i);
                        %>

                            <div class="col-sm-6">
                                <form action="../Con_Ordenes" method="Post">
                                    <table class="table table-bordered table-striped">
                                        <thead class="bg-dark text-light">
                                            <tr>
                                                <th colspan="2">domicilio</th>
                                            </tr>
                                        </thead>
                                        <tr>
                                            <th>Id</th>
                                            <th><%=Mensajero.getDom_id()%></th>
                                        </tr>
                                        <tr>
                                            <th>Fecha Inicio</th>
                                            <th><%=Mensajero.getDom_fecha_inicio()%></th>
                                        </tr>
                                        <tr>
                                            <th>ver mas</th>
                                            <th>
                                                <input type="hidden" name="dom_id" value="<%=Mensajero.getDom_id()%>">
                                                <button type="submit" name="Ver" class="btn btn-dark form-control">Ver más</button>
                                            </th>
                                        </tr>
                                    </table>
                                </form>
                            </div>   

                        <% } %>
                     </div>
                    </div>
                  </div>
                </div>
                
                
                <div class="card">
                  <div class="card-header" id="headingTwo">
                    <h5 class="mb-0">
                      <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Pedidos Por recoger
                      </button>
                    </h5>
                  </div>
                  <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <div class="row">
                        <%  ListaMensajero=Mod.DomiciliosActivos(men_id,"Terminado");
                            for(int i=0;i<ListaMensajero.size();i++){
                                Mensajero=ListaMensajero.get(i);
                        %>
                            <div class="col-sm-6">                
                                <table class="table table-bordered table-striped">
                                    <thead class="bg-dark text-light">
                                        <tr>
                                            <th colspan="2">domicilio</th>
                                        </tr>
                                    </thead>
                                    <tr>
                                        <th>Id</th>
                                        <th><%=Mensajero.getDom_id()%></th>
                                    </tr>
                                    <tr>
                                        <th>Fecha Inicio</th>
                                        <th><%=Mensajero.getDom_fecha_inicio()%></th>
                                    </tr>
                                    <tr>
                                        <th>Ver más</th>
                                        <th>
                                            <form action="../Con_Ordenes" method="Post">
                                                <input type="hidden" name="dom_id" value="<%=Mensajero.getDom_id()%>">
                                                <button type="submit" name="Ver" class="btn btn-dark form-control">Ver más</button>
                                            </form>
                                        </th>
                                    </tr>
                                </table>
                                
                            </div>   

                        <% } %>
                     </div>
                    </div>
                  </div>
                </div>
                
                
                <div class="card">
                  <div class="card-header" id="headingThree">
                    <h5 class="mb-0">
                      <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Pedidos En Camino
                      </button>
                    </h5>
                  </div>
                  <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <div class="row">
                        <%  ListaMensajero=Mod.DomiciliosActivos(men_id,"Enviando");
                            for(int i=0;i<ListaMensajero.size();i++){
                                Mensajero=ListaMensajero.get(i);
                        %>

                            <div class="col-sm-6">
                                <table class="table table-bordered table-striped">
                                <thead class="bg-dark text-light">
                                        <tr>
                                            <th colspan="2">domicilio</th>
                                        </tr>
                                    </thead>
                                    <tr>
                                        <th>Id</th>
                                        <th><%=Mensajero.getDom_id()%></th>
                                    </tr>
                                    <tr>
                                        <th>Fecha Inicio</th>
                                        <th><%=Mensajero.getDom_fecha_inicio()%></th>
                                    </tr>
                                    <tr>
                                        <th>Fecha salida</th>
                                        <th><%=Mensajero.getDom_fecha_salida()%></th>
                                    </tr>
                                    <tr>
                                        <th>Dirección cliente</th>
                                        <th><%=Mensajero.getCli_direccion1()%></th>
                                    </tr>
                                    <tr>
                                        <th>Estado</th>
                                        <th>
                                            <form action="../Con_Domicilio" method="Post">
                                                <input type="hidden" name="dom_id" value="<%=Mensajero.getDom_id()%>">
                                                <input type="hidden" name="Dom_Estado" value="Entregado">
                                                <button type="submit" name="EstadoTerminado" class="btn btn-success form-control">Entregado</button>
                                            </form>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>ver mas</th>
                                        <th>
                                            <form action="../Con_Ordenes" method="Post">
                                                <input type="hidden" name="dom_id" value="<%=Mensajero.getDom_id()%>">
                                                <button type="submit" name="Ver" class="btn btn-dark form-control">Ver más</button>
                                            </form>
                                        </th>
                                    </tr>
                                </table>
                            </div>   

                        <% } %>
                     </div>
                    </div>
                  </div>
                </div>
                <div class="card">
                  <div class="card-header" id="headingFor">
                    <h5 class="mb-0">
                      <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseFor" aria-expanded="false" aria-controls="collapseThree">
                        Pedidos Entregados
                      </button>
                    </h5>
                  </div>
                  <div id="collapseFor" class="collapse" aria-labelledby="headingFor" data-parent="#accordion">
                    <div class="card-body">
                      <div class="row">
                        <%  ListaMensajero=Mod.DomiciliosActivos(men_id,"Entregado");
                            for(int i=0;i<ListaMensajero.size();i++){
                                Mensajero=ListaMensajero.get(i);
                        %>

                            <div class="col-sm-6">
                                <form action="../Con_Ordenes" method="Post">
                                    <table class="table table-bordered table-striped">
                                        <thead class="bg-dark text-light">
                                            <tr>
                                                <th colspan="2">domicilio</th>
                                            </tr>
                                        </thead>
                                        <tr>
                                            <th>Id</th>
                                            <th><%=Mensajero.getDom_id()%></th>
                                        </tr>
                                        <tr>
                                            <th>Fecha Inicio</th>
                                            <th><%=Mensajero.getDom_fecha_inicio()%></th>
                                        </tr>
                                        <tr>
                                            <th>Fecha salida</th>
                                            <th><%=Mensajero.getDom_fecha_salida()%></th>
                                        </tr>
                                        <tr>
                                            <th>Fecha Entrega</th>
                                            <th><%=Mensajero.getDom_fecha_entrega()%></th>
                                        </tr>
                                        <tr>
                                            <th>Direccion</th>
                                            <th><%=Mensajero.getCli_direccion1()%></th>
                                        </tr>
                                        <tr>
                                            <th>Total</th>
                                            <th><%=Mensajero.getDom_total_general()+Mensajero.getDom_costo_domicilio()%></th>
                                        </tr>
                                        <tr>
                                            <th>ver mas</th>
                                            <th>
                                                <input type="hidden" name="dom_id" value="<%=Mensajero.getDom_id()%>">
                                                <button type="submit" name="Ver" class="btn btn-dark form-control">Ver más</button>
                                            </th>
                                        </tr>
                                    </table>
                                </form>
                            </div>   

                        <% } %>
                     </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
            
        
        
        <script src="../boostrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="../boostrap/js/popper.min.js"></script>
        <script src="../boostrap/js/bootstrap.min.js"></script>
        
    </body>
</html>
