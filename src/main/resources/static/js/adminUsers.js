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