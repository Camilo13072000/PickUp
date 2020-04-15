$(document).ready(function (){
    
    $("tr #cantidad").keyup(function(){
        var idpre= $(this).parent().find("#Idpre").val();
        var cantidad= $(this).parent().find("#cantidad").val();
        var url="Con_Carrito?ActualizarCantidad=Act";
        
        $.ajax({
            
            type:'POST',
            url: url,
            data: "Idpre="+idpre+"&cantidad="+cantidad,
            
            success: function (data, textStatus, jqXHR) {
                location.href="Con_Carrito?Consulta=Act";
            }
        });
    }); 
});


