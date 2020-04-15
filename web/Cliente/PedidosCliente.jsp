
<%@page import="Modelo.Mod_LoginCliente"%>
<%@page import="Modelo.Mod_GetSetDomicilio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body>
        
        <%
            String Cli_Id;
            HttpSession cli=request.getSession(false);
            Cli_Id=(String)cli.getAttribute("Cli_id");
        %>
        
        
            <div class="pedido" id="pedido">Pedidos</div>
            <%
                ArrayList<Mod_GetSetDomicilio> ListaDomi=new ArrayList();
                Mod_GetSetDomicilio gs=new Mod_GetSetDomicilio(); 
                Mod_LoginCliente dom=new Mod_LoginCliente();
                ListaDomi=dom.ConsultarDomicilios(Cli_Id);
                
                for(int i=0;i<ListaDomi.size();i++){
                    gs=ListaDomi.get(i);
            %>
            
            <div class="nombre" id="nombre">Pedido n° <%=gs.getDom_id()%></div>

            <div class="datos" id="datos">
                
                    <label>Total: </label><%=gs.getDom_total_general()%><br>
                    <label>Estado: </label><%=gs.getDom_estado()%><br>
                    <label>Costo domicilio: </label><%=gs.getDom_costo_domicilio()%><br>
                    <label>Fecha inicio: </label><%=gs.getDom_fecha_inicio()%><br>
                    <label>Fecha Salida: </label><%=gs.getDom_fecha_salida()%><br>
                    <label>Fecha entrega: </label><%=gs.getDom_fecha_entrega()%><br>
                    <label>Id cliente: </label><%=gs.getDom_cli_id()%><br>
                    <label>Nombre mensajero: </label><%=gs.getDom_men_id()%><br>
                
            </div>
            
        <% } %>
    </body>
</html>
