
$(function (){
   $('#ingresar').click(function () {
      Ingresar($('#txtusuario').val(),$('#txtcontra').val());
   });
   function Ingresar(val1,val2){
       var parametros ={
           "txtusuario":val1,
           "txtcontra":val2
       }
       $.ajax({
           data:parametros,
           url:"../Controlador.Controlador_Login",
           type:'Post',
           beforeSend:function () {
                console.log("Se estan prosesando parametros");
           }
       })
           .done(function(data){
                $('#Error').html(data);
           });
   }
});

$(document).ready(function () {
    $('#submit').click(function (event) {

        var correo_rec = $('#correo').val();

        $.post('../controlador_Ajax', {

            CorreoAjax: correo_rec

        }, function (responseText) {
            $('#Alert').html(responseText);
        });
    });
});

function showPassword() {
    var key_attr = $('#key').attr('type');
    if (key_attr !== 'text') {
        $('.checkbox').addClass('show');
        $('#key').attr('type', 'text');
    } else {
        $('.checkbox').removeClass('show');
        $('#key').attr('type', 'password');
    }
}



