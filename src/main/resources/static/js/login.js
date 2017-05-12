$(document).ready(function(){
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