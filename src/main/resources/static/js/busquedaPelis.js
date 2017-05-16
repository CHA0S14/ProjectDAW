loading2 = false;
$(document).ready(function() {
    $("#buscar").submit(function(e) {
        e.preventDefault();
        busqueda = $("#busqueda").val();
        if (!loading2) {
            loading2 = true;
            $.ajax
            ({
                url: "buscaPelis",
                method: "get",
                data: {texto: busqueda},
                success: function (html) {
                    if (html) {
                        $("#listaPelis").html(html);
                    }
                    loading2 = false;
                    loading = true;
                    $('div#loadmoreajaxloader').hide();
                }
            }); // close AJAX
        }
    });
});