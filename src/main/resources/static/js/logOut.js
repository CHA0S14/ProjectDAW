$(document).ready(function() {
    $(".logOut").click(function (e){
        e.preventDefault();
        $("#logOutForm").submit();
    });
});