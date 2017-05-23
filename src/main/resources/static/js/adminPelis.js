
var idPelicula = "";
$(document).on('click',".btnEliminar",function (e) {
    idPelicula = e.target.id;
});
$(document).on('click',".btnModificar",function (e) {
    idPelicula = e.target.id;

    $("#idForm").val(idPelicula);
    $("#nameForm").val( $("#nombre" + idPelicula).text());
    var url =  $("#url" + idPelicula).text().split(":");
    $("#urlForm").val( url[1]+":"+url[2]);
    $("#anioForm").val( $("#anio" + idPelicula).text().split(":")[1]);
    var director = $("#director" + idPelicula).text().split(":")[1];
    $("#directorForm").val(director == " -" ? "" : director);
    var reparto = $("#reparto" + idPelicula).text().split(":")[1];
    $("#repartoForm").val( reparto == " -" ? "" : reparto);
    var url =  $("#portada" + idPelicula).attr('src').split(":");
    $("#portadaForm").val( url[0] + (url[1] != undefined ? ":"+url[1] : ""));
    $("#valoracionForm").val( $("#valoracion" + idPelicula).text().split(":")[1]);
    $("#descripcionForm").val( $("#descripcion" + idPelicula).text().split(":")[1]);
});
$(document).on('click',"#eliminar",function () {
    $("#eliminarForm" + idPelicula).submit();
});
$(document).on('click',"#modificar",function () {
    console.log(arr[1]);
});