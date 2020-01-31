<%-- 
    Document   : index
    Created on : 20/01/2020, 01:43:43 AM
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
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Login">
          Login
        </button>

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
                    <input type="text" id="Cont" class="btn modal-content" name="Usucont">
                  
                </div>
                <div class="modal-footer">
                    <a  href="Cliente/RegistrarUsuario.jsp">Registrar Cuenta</a>
                 <input type="submit" class="btn btn-primary" value="Iniciar sesión" name="entrar">
                </div>
               </form>
            </div>
          </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
