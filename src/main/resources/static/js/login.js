$(document).ready(function(){
    reseteaFormularios();
	var exTime = 400;
	$('#changeRegister').click(function(event){
		event.preventDefault();		
        $('#login').fadeOut(exTime,function(){
        	$('#register').fadeIn(exTime);
        });
	});	


	$('#changeLogin').click(function(event){
		event.preventDefault();
		$('#register').fadeOut(exTime, function(){
        	$('#login').fadeIn(exTime);
		});
	});

	$('#log-modal').click(function(event){
        event.preventDefault();
        $('#register').fadeOut(exTime, function(){
            $('#login').fadeIn(exTime);
        });
	});

    $('#reg-modal').click(function(event){
        event.preventDefault();
        $('#login').fadeOut(exTime, function(){
            $('#register').fadeIn(exTime);
        });
    });
});

var emailPattern= /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
$(document).on('click',"#createFormSubmit",function (e) {
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
        $("#createForm").submit();
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
}