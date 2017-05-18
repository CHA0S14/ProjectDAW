fin = false;
loading = false;
nextpage = 1;

$(window).scroll(function() {
    if (!loading && $(window).scrollTop() >= ($('#listaPelis').offset().top + $('#listaPelis').outerHeight() - window.innerHeight)) {
        loading = true;

        $('div#loadmoreajaxloader').show();
        $.ajax
        ({
            url: "adminListPelis",
            method: "get",
            data: {id: nextpage},
            success: function(html)
            {
                if(html)
                {
                    $("#listaPelis").append(html);
                    $('div#loadmoreajaxloader').hide();
                    nextpage ++;
                    loading = false;
                }
                else
                {
                    $('div#loadmoreajaxloader').html('<p>No hay mas pelis que mostrar.</p>');
                }

            }

        }); // close AJAX
    }
});