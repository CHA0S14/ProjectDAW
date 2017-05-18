loading = false;
nextpage = 1;
isBusqueda = false;
textoBuscado ="";

$(window).scroll(function() {
    if (!loading && $(window).scrollTop() >= ($('#listaPelis').offset().top + $('#listaPelis').outerHeight() - window.innerHeight)) {
        loading = true;

        $('div#loadmoreajaxloader').show();
        if(!isBusqueda) {
            $.ajax
            ({
                url: "listPelis",
                method: "get",
                data: {pagina: nextpage},
                success: function (html) {
                    if (html) {
                        $("#listaPelis").append(html);
                        $('div#loadmoreajaxloader').hide();
                        nextpage++;
                        loading = false;
                    }
                    else {
                        $('div#loadmoreajaxloader').html('<p>No hay mas pelis que mostrar.</p>');
                    }
                }

            }); // close AJAX
        }else{
            $.ajax
            ({
                url: "buscaPelisList",
                method: "get",
                data: {pagina: nextpage, texto: busqueda},
                success: function (html) {
                    if (html) {
                        $("#listaPelis").append(html);
                        $('div#loadmoreajaxloader').hide();
                        nextpage++;
                        loading = false;
                    }
                    else {
                        $('div#loadmoreajaxloader').html('<p>No hay mas pelis que mostrar.</p>');
                    }

                }

            }); // close AJAX
        }
    }
});