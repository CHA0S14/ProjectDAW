/**
 * Created by Fran on 24/05/2017.
 */
$(document).ready(function () {
    reseteaFormularios();
});

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

var emailPattern= /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
$(document).on('click',"#crearUsuario",function (e) {
    e.preventDefault();
    var vale = true;
    if($("#usernameForm").val()===""){
        $("#errorName").show();
        $("#divName").addClass("has-error");
        vale = false;
    }else{
        $("#errorName").hide();
        $("#divName").removeClass("has-error");
    }
    if($("#emailFormCreate").val() === "" || !$("#emailFormCreate").val().match(emailPattern)){
        $("#errorMail").show();
        $("#divMail").addClass("has-error");
        vale = false;
    }else{
        $("#errorMail").hide();
        $("#divMail").removeClass("has-error");
    }
    if($("#emailFormCreate2").val() === "" || $("#emailFormCreate").val() !== $("#emailFormCreate2").val()){
        $("#errorMail2").show();
        $("#divMail2").addClass("has-error");
        vale = false;
    }else{
        $("#errorMail2").hide();
        $("#divMail2").removeClass("has-error");
    }
    if($("#passForm").val() === ""){
        $("#errorPass").show();
        $("#divPass").addClass("has-error");
        vale = false;
    }else{
        $("#errorPass").hide();
        $("#divPass").removeClass("has-error");
    }
    if($("#passForm2").val() === "" || $("#passForm").val() !== $("#passForm2").val()){
        $("#errorPass2").show();
        $("#divPass2").addClass("has-error");
        vale = false;
    }else{
        $("#errorPass2").hide();
        $("#divPass").removeClass("has-error");
    }
    if(vale){
        $("#createUserForm").submit();
    }
});

$(document).on('click',"#modificar",function (e) {
    e.preventDefault();
    var vale = true;
    if($("#pwdForm").val() !== $("#pwdForm2").val()){
        $("#errorPassword2").show();
        $("#divPassword2").addClass("has-error");
        vale = false;
    }else{
        $("#errorPassword2").hide();
        $("#divPassword2").removeClass("has-error");
    }
    if (vale) {
        $("#modForm").submit();
    }
});

function reseteaFormularios(){
    $("#errorName").hide();
    $("#divName").removeClass("has-error");
    $("#errorMail").hide();
    $("#divMail").removeClass("has-error");
    $("#errorMail2").hide();
    $("#divMail2").removeClass("has-error");
    $("#errorPass").hide();
    $("#divPass").removeClass("has-error");
    $("#errorPass2").hide();
    $("#divPass2").removeClass("has-error");
    $("#errorPassword").hide();
    $("#divPassword").removeClass("has-error");
    $("#errorPassword2").hide();
    $("#divPassword2").removeClass("has-error");
}