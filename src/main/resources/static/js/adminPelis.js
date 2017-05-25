$(document).ready(function () {
   reseteaFormularios();
});
var idPelicula = "";
$(document).on('click',".btnEliminar",function (e) {
    idPelicula = e.target.id;
    reseteaFormularios();
});
$(document).on('click',".btnModificar",function (e) {
    idPelicula = e.target.id;
    reseteaFormularios();

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
var youtube=/^https:\/\/(www.)?youtube.(com|es)\/embed\/\w+/;
var urlSimple = /^(http|https):\/\/\w+/;
$(document).on('click',"#createFormSubmit",function (e) {
    e.preventDefault();
    var vale = true;
    if($("#name").val()==""){
        $("#errorName").show();
        $("#divName").addClass("has-error");
        vale = false;
    }else{
        $("#errorName").hide();
        $("#divName").removeClass("has-error");
    }
    if($("#anio").val() != "" && !$.isNumeric($("#anio").val())){
        $("#errorAnio").show();
        $("#divAnio").addClass("has-error");
        vale = false;
    }else{
        $("#errorAnio").hide();
        $("#divAnio").removeClass("has-error");
    }
    if(!$("#url-cont").val().match(youtube)){
        $("#errorUrl-Cont").show();
        $("#divUrl-Cont").addClass("has-error");
        vale = false;
    }else{
        $("#errorUrl-Cont").hide();
        $("#divUrl-Cont").removeClass("has-error");
    }
    if($("#url-port").val() != "" && !$("#url-port").val().match(urlSimple)){
        $("#errorUrl-Port").show();
        $("#divUrl-Port").addClass("has-error");
        vale = false;
    }else{
        $("#errorUrl-Port").hide();
        $("#divUrl-Port").removeClass("has-error");
    }
    if($("#valoracion").val() != "" && !$.isNumeric($("#valoracion").val())){
        $("#errorValoracion").show();
        $("#divValoracion").addClass("has-error");
        vale = false;
    }else{
        $("#errorValoracion").hide();
        $("#divValoracion").removeClass("has-error");
    }
    if(vale){
        $("#createForm").submit();
    }
});
$(document).on('click',"#modificar",function (e) {
    e.preventDefault();
    var vale = true;
    if($("#nameForm").val()==""){
        $("#errorNameForm").show();
        $("#divNameForm").addClass("has-error");
        vale = false;
    }else{
        $("#errorNameForm").hide();
        $("#divNameForm").removeClass("has-error");
    }
    if($("#anioForm").val() != "" && !$.isNumeric($("#anioForm").val())){
        $("#errorAnioForm").show();
        $("#divAnioForm").addClass("has-error");
        vale = false;
    }else{
        $("#errorAnioForm").hide();
        $("#divAnioForm").removeClass("has-error");
    }
    if(!$("#urlForm").val().match(youtube)){
        $("#errorUrlForm").show();
        $("#divUrlForm").addClass("has-error");
        vale = false;
    }else{
        $("#errorUrlForm").hide();
        $("#divUrlForm").removeClass("has-error");
    }
    if($("#portadaForm").val() != "" && !$("#portadaForm").val().match(urlSimple)){
        $("#errorPortadaForm").show();
        $("#divPortadaForm").addClass("has-error");
        vale = false;
    }else{
        $("#errorPortadaForm").hide();
        $("#divPortadaForm").removeClass("has-error");
    }
    if($("#valoracionForm").val() != "" && !$.isNumeric($("#valoracionForm").val())){
        $("#errorValoracionForm").show();
        $("#divValoracionForm").addClass("has-error");
        vale = false;
    }else{
        $("#errorValoracionForm").hide();
        $("#divValoracionForm").removeClass("has-error");
    }
    if (vale){
        $("#modForm").submit();
    }
});

function reseteaFormularios(){
    $("#errorName").hide();
    $("#divName").removeClass("has-error");
    $("#errorAnio").hide();
    $("#divAnio").removeClass("has-error");
    $("#errorUrl-Cont").hide();
    $("#divUrl-Cont").removeClass("has-error");
    $("#errorUrl-Port").hide();
    $("#divUrl-Port").removeClass("has-error");
    $("#errorValoracion").hide();
    $("#divValoracion").removeClass("has-error");

    $("#errorNameForm").hide();
    $("#divNameForm").removeClass("has-error");
    $("#errorAnioForm").hide();
    $("#divAnioForm").removeClass("has-error");
    $("#errorUrlForm").hide();
    $("#divUrlForm").removeClass("has-error");
    $("#errorPortadaForm").hide();
    $("#divPortadaForm").removeClass("has-error");
    $("#errorValoracionForm").hide();
    $("#divValoracionForm").removeClass("has-error");
}