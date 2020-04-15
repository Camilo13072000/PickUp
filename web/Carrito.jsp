<%-- 
    Document   : Carrito
    Created on : 20/02/2020, 02:43:42 AM
    Author     : Camilo Martinez
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_GetSetCarrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
            String foto,cli_id;
            ArrayList ConsultaCarrito;
            int totalapagar;
            HttpSession car=request.getSession(false);
            foto=(String)car.getAttribute("carritofoto");
            totalapagar=(int)car.getAttribute("totalapagar");
            ConsultaCarrito=(ArrayList)car.getAttribute("carritocon");
            cli_id=(String)car.getAttribute("cli_id");
            JOptionPane.showMessageDialog(null, cli_id);
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
                    <a class="btn  btn.default" href="Presentacion.jsp">
                        Seguir Comprando
                    </a>
                    
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
                  <img src="<%=foto%>" class="mr-sm-4  rounded-circle" width="35px">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
          </nav>
        
        <div class="container mt-4">
            <div class="row">
            <div class="col-sm-8">
                <div class="table-responsive">
                    <form action="Con_Carrito" method="POST">
                <table class="table">
                    <tr class="text-center">
                    <thead class="table-dark text-center">
                        <th width="5%">Item</th>
                        <th width="15%">Nombres</th>
                        <th width="35%">Descripcion</th>
                        <th width="15%">Precio</th>
                        <th width="5%">Cantidad</th>
                        <th width="15%">Subtotal</th>
                        <th width="10%">Accion</th>
                        </thead>
                    </tr>
                    
                        <%  
                            ArrayList<Mod_GetSetCarrito> carr=new ArrayList();
                            Mod_GetSetCarrito c=new Mod_GetSetCarrito();
                            carr=ConsultaCarrito;
                            for(int i=0;i<ConsultaCarrito.size();i++){
                                c=carr.get(i);

                        %>
                        
                        <tr class="text-center">
                            <td><%=c.getItem()%></td>
                            <td><%=c.getNombres()%></td>
                            <td><%=c.getDescripcion()%></td>
                            <td><%=c.getPrecioCompra()%></td>
                            <td width="5%">
                                <input type="hidden" id="Idpre" value="<%=c.getIdproducto()%>">
                                <input type="number" id="cantidad" value="<%=c.getCantidad()%>" min="1" class=" form-control-plaintext text-center" width="40px">
                            </td>
                            <td><%=c.getSubTotal()%></td>
                            <td>     
                                <input type="hidden" name="Idpre" value="<%=c.getIdproducto()%>">
                                <input type="hidden" name="Subtotal" value="<%=c.getSubTotal()%>">
                                <button>Editar</button><br>
                                <button type="submit" name="Eliminar" class="btn btn-block">Eliminar</button>
                            </td>
                            
                        </tr>
                        
                        <% } %>
                    
                        </table>
                    </form>
                </div>
            </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <label>Generar Compra</label>
                        </div>
                        <div class="card-body">
                            <label>subtotal:</label>
                            <input type="text" readonly="" class="form-control" value="<%=totalapagar%>">
                            <label>Costo domicilio:</label>
                            <input type="text" readonly="" class="form-control" value="3000">
                            <label>Total a pagar:</label>
                            <input type="text" readonly="" class="form-control" value="<%=totalapagar+3000%>">
                        </div>
                        <div class="card-footer">
                            <form action="Con_Carrito" method="POST">
                                <input type="hidden" name="idpre" value="<%=c.getIdproducto()%>">
                                <input type="hidden" name="clid" value="<%=cli_id%>">
                                <button class="btn btn-info btn-block">Realizar pago</button>
                                <button class="btn btn-danger btn-block" name="GenerarCompra" type="submit">Generar Compra</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/Modificar.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
                
    </body>
</html>
