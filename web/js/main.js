
$(document).ready(function(){
    
    $('.nombre').hide();
    $('.datos').hide();
    $('.pedido').on('click',function(){
        
        $('.nombre').slideToggle();
        $('.datos').hide();
        
    });
    $('.nombre').on('click',function(){
        var x=$('.nombre').index(this);
        var y=$('.datos').eq(x);
        y.slideToggle();
    });
    
   
});


