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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
            String CliId;
            HttpSession Cliente=request.getSession(false);
            CliId=(String)Cliente.getAttribute("VarCliId");
        %>
    <body>
        <h1>3232</h1>
        
        <div class="container">
        <%
            ArrayList<Mod_GetSetActualizarCliente> DatosCliente=new ArrayList<>();
            Mod_GetSetActualizarCliente gscli=new Mod_GetSetActualizarCliente();
            Mod_LoginCliente ActuCli=new Mod_LoginCliente();
            DatosCliente=ActuCli.ConsultarDatosCliente(CliId);
            JOptionPane.showMessageDialog(null, DatosCliente.size());
            for(int i=0;i<DatosCliente.size();i++){
                gscli=DatosCliente.get(i);
        %>
        <form action="../Con_Cliente" method="POST">
            
            
            <div class="form-group">
                <label for="nomb">Nombre de usuario</label>
                <input type="text" class="form-control" id="nomb" name="nom" value="<%=gscli.getUsu_nombre()%>">
            </div> 
            <div class="form-group">
                <label for="passw">Contraseña</label>
                <input type="text" class="form-control" id="passw" name="pass" value="<%=gscli.getUsu_password()%>">
            </div> 
            <div class="form-group">
                <label for="Foto">Foto</label>
                <input type="file" class="form-control" id="" name="">
                <input type="hidden" class="form-control" id="Foto" name="fot" value="<%=gscli.getUsu_foto()%>">
            </div>
                
            <div class="form-group">
                <label for="Doc"></label>
                <input type="hidden" class="form-control" id="Doc" name="docu" value="<%=gscli.getCli_documento()%>">
            </div>
            <div class="form-group">
                <label for="IDS"></label>
                <input type="hidden" class="form-control" id="Doc" name="id" value="<%=CliId%>">
            </div>
            <div class="form-group">
                <label for="Nom">Nombre</label>
                <input type="text" class="form-control" id="Nom" name="Nomb" value="<%=gscli.getCli_nombre()%>">
            </div>
            <div class="form-group">
                <label for="Gen">Genero</label>
                <select id="Gen" name="gene" class="form-control">
                    <option><%=gscli.getCli_genero()%></option>
                    <option>Maculino</option>
                    <option>Femenino</option>
                    <option>Indesiso</option>
                </select>
            </div>
            <div class="form-group">
                <label for="Tel">Telefono</label>
                <input type="text" class="form-control" id="Tel" name="telef" value="<%=gscli.getCli_telefono()%>">
            </div>
            <div class="form-group">
                <label for="corr">Email</label>
                <input type="email" class="form-control" id="corr" name="correo" value="<%=gscli.getCli_email()%>">
            </div>
            <div class="form-group">
                <label for="Dire">Direccion</label>
                <input type="text" class="form-control" id="Dire" name="direc" value="<%=gscli.getCli_direccion_1()%>">
            </div>
            <div class="form-group">
                <label for="Bar">Barrio</label>
                <input type="text" class="form-control" id="Bar" name="barr" value="<%=gscli.getCli_barrio_1()%>">
            </div>
            <div class="form-group">
                <label for="Des">Descripcion</label>
                <input type="text" class="form-control" id="Des" name="descr" value="<%=gscli.getCli_descripcion_1()%>">
            </div>
            <div class="form-group">
                <label for="Dire">Segunda Direccion</label>
                <input type="text" class="form-control" id="Dire" name="direc2" value="<%=gscli.getCli_direccion_2()%>">
            </div>
            <div class="form-group">
                <label for="Bar">Barrio</label>
                <input type="text" class="form-control" id="Bar" name="barr2" value="<%=gscli.getCli_barrio_2()%>">
            </div>
            <div class="form-group">
                <label for="Des">Descripcion</label>
                <input type="text" class="form-control" id="Des" name="descr2" value="<%=gscli.getCli_descripcion_2()%>">
            </div>
            <% } %>
            <div class="form-group">
                <label for=""></label>
                <input type="text" class="form-control" id="" name="">
            </div> 
            
            
            <button type="submit" name="Actu" class="btn btn-dark form-control">Actualizar</button>
            </div>
            
        </form>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
