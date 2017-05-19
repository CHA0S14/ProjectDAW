fin = false;
loading = false;
nextpage = 1;
isBusqueda = false;
textoBuscado ="";

$(window).scroll(function() {
    if (!loading && $(window).scrollTop() >= ($('#listaUsers').offset().top + $('#listaUsers').outerHeight() - window.innerHeight)) {
        loading = true;

        $('div#loadmoreajaxloader').show();
        if(!isBusqueda) {
            $.ajax
            ({
                url: "adminListUsers",
                method: "get",
                data: {pagina: nextpage},
                success: function (html) {
                    if (html) {
                        $("#listaUsers").append(html);
                        $('div#loadmoreajaxloader').hide();
                        nextpage++;
                        loading = false;
                    }
                    else {
                        $('div#loadmoreajaxloader').html('<p>No hay mas usuarios que mostrar.</p>');
                    }
                }

            }); // close AJAX
        }else{
            $.ajax
            ({
                url: "buscaAdminUsersList",
                method: "get",
                data: {pagina: nextpage, texto: busqueda},
                success: function (html) {
                    if (html) {
                        $("#listaUsers").append(html);
                        $('div#loadmoreajaxloader').hide();
                        nextpage++;
                        loading = false;
                    }
                    else {
                        $('div#loadmoreajaxloader').html('<p>No hay mas usuarios que mostrar.</p>');
                    }

                }

            }); // close AJAX
        }
    }
});