<%-- 
    Document   : RegistrarCliente
    Created on : 21/01/2020, 01:48:29 AM
    Author     : Camilo Martinez
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelo.Mod_LoginUsuario"%>
<%@page import="Modelo.Mod_GetSetUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="../index.jsp">PickUp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
        
        <%
            Date dNow = new Date();
            SimpleDateFormat ft =new SimpleDateFormat ("MM-dd");
            String currentDate = ft.format(dNow);
            SimpleDateFormat aac =new SimpleDateFormat ("yyyy");
            String currentYear = aac.format(dNow);
            
            int currentYear1=Integer.parseInt(currentYear)-14;
         %>
         
         <h1></h1>
         
        <%  String UsuS;
            HttpSession UsuSe=request.getSession(false);
            UsuS=(String)UsuSe.getAttribute("NomUsu");
            JOptionPane.showMessageDialog(null, UsuS);
            
            ArrayList<Mod_GetSetUsuarios> lisunusu=new ArrayList<>();
            Mod_GetSetUsuarios gs=new Mod_GetSetUsuarios();
            Mod_LoginUsuario lgusu=new Mod_LoginUsuario();
            lisunusu=lgusu.consultarUnUsuario(UsuS);
            for(int i=0;i<lisunusu.size();i++){
                gs=lisunusu.get(i);
        %>
        
        
        <form action="../Con_Cliente" method="POST"> 
            <div class="container">
           
                 <input class="form-control" type="hidden" name="UsuId" value="<%=gs.getUsu_id()%>">
                 
            
                <% } %>
            <div class="form-group">
                <label for="Doc">Documento</label>
                <input type="number" class="form-control" id="Doc" name="docu">
            </div>
            <div class="form-group">
                <label for="Nom">Nombre</label>
                <input type="text" class="form-control" id="Nom" name="Nomb" pattern="[az-AZ ]+">
            </div>
            <div class="form-group">
                <label for="Fec">Fecha de Nacimiento</label>
                <input type="date" class="form-control" id="Fec" name="fecnac" max="<%=currentYear1%>-<%=currentDate%>" min="">
            </div>
            <div class="form-group">
                <label for="Gen">Genero</label>
                <select id="Gen" name="gene" class="form-control">
                    <option>Maculino</option>
                    <option>Femenino</option>
                    <option>Indesiso</option>
                </select>
            </div>
            <div class="form-group">
                <label for="Tel">Telefono</label>
                <input type="number" class="form-control" id="Tel" name="telef">
            </div>
            <div class="form-group">
                <label for="corr">Email</label>
                <input type="email" class="form-control" id="corr" name="correo">
            </div>
            <div class="form-group">
                <label for="Dire">Direccion</label>
                <input type="text" class="form-control" id="Dire" name="direc">
            </div>
            <div class="form-group">
                <label for="Bar">Barrio</label>
                <input type="text" class="form-control" id="Bar" name="barr">
            </div>
            <div class="form-group">
                <label for="Des">Descripcion</label>
                <input type="text" class="form-control" id="Des" name="descr">
            </div>
            
            <div class="form-group">
                <label for=""></label>
                <input type="text" class="form-control" id="" name="">
            </div> 
            </div>
            <button type="submit" name="Regi" class="btn btn-dark form-control">Registrar</button>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
