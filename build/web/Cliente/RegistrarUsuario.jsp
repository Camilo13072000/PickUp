<%-- 
    Document   : Registrar
    Created on : 20/01/2020, 09:33:49 PM
    Author     : Camilo Martinez
--%>

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
        <h1>PickUp</h1>
        <h3>Registrar</h1>
        <div class="container">
            <form action="../Con_Usuario" method="POST">
            <div class="form-group">
                <label for="nomb">Nombre de usuario</label>
                <input type="text" class="form-control" id="nomb" name="nom">
            </div> 
            <div class="form-group">
                <label for="passw">Contraseña</label>
                <input type="text" class="form-control" id="passw" name="pass">
            </div> 
            <div class="form-group">
                <input type="hidden" class="form-control" id="" name="rol" value="Cliente">
            </div> 
            <div class="form-group">
                <input type="hidden" class="form-control" id="" name="est" value="Activo">
            </div> 
            <div class="form-group">
                <label for="Foto">Foto</label>
                <input type="file" class="form-control" id="" name="">
                <input type="hidden" class="form-control" id="Foto" name="fot" value="Foto">
            </div> 
            
            <button type="submit" name="reg" class="btn form-control">Registrar</button>
        </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
