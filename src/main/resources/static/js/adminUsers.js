/**
 * Created by Fran on 24/05/2017.
 */
var idUsuario = "";
$(document).on('click',".btnEliminar",function (e) {
    idUsuario = e.target.id;
});
$(document).on('click',"#eliminar",function () {
    $("#eliminarForm" + idUsuario).submit();
});

$(document).on('click',".btnModificar",function (e) {
    idUsuario = e.target.id;
    //reseteaFormularios();

    $("#idForm").val(idUsuario);
    $("#usrForm").val( $("#usuario" + idUsuario).text().split(":")[1]);
    $("#emailForm").val($("#email" + idUsuario).text().split(":")[1]);
    var valor = 1;
    if ($("#tipo" + idUsuario).text().split(":")[1] === "Administrador"){
        valor = 2;
    }
    $("#tipoForm").val(valor);
});