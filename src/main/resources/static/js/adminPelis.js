$(document).ready(function() {
    idPelicula = "";
    $(".btnEliminar").click(function (e) {
        idPelicula = e.target.id;
    });
    $("#eliminar").click(function () {
        $("#eliminarForm" + idPelicula).submit();
    });
});