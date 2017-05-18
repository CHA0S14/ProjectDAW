loading2 = false;
$(document).ready(function() {
    $("#buscar").submit(function(e) {
        e.preventDefault();
        busqueda = $("#busqueda").val();
        if (!loading2) {
            loading2 = true;
            if (busqueda != ""){
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
                        loading = false;
                        isBusqueda=true;
                        nextpage = 1;
                        $('div#loadmoreajaxloader').html('');
                        $('div#loadmoreajaxloader').hide();
                    }
                }); // close AJAX
            }else if (isBusqueda){
                $(location).attr('href', 'peliculas')
            }
        }
    });
});