package com.DAW.Project.Controllers;

import com.DAW.Project.Entidades.Pelicula;
import com.DAW.Project.Entidades.Usuario;
import com.DAW.Project.Repositories.PelisRepository;
import com.DAW.Project.Repositories.UserRepository;
import com.DAW.Project.RestClientObjects.Busqueda;
import com.DAW.Project.RestClientObjects.PeliRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class AdminController {
    @Autowired
    private PelisRepository peliRepository;
    @Autowired
    private UserRepository userRepository;

    private String url = "https://api.themoviedb.org/3/search/movie?api_key=30db4544dd07b18cf6e20ebdddcb5eb3&language=es-ES&query=";

    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminPelis" )
    public ModelAndView peliculas() {
        return new ModelAndView( "adminMovies" ).addObject("pelis",peliRepository.findAll(new PageRequest(0,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminListPelis")
    public ModelAndView listPelis(@RequestParam int pagina){
        return new ModelAndView( "adminPeliList" ).addObject("pelis",peliRepository.findAll(new PageRequest(pagina,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/buscaAdminPelis" )
    public ModelAndView lista(@RequestParam String texto) {
        return new ModelAndView( "adminPeliList" ).addObject("pelis", peliRepository.findByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(texto,texto,texto,texto,new PageRequest(0,5)));
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/buscaAdminPelisList" )
    public ModelAndView busquedaLista(@RequestParam int pagina, @RequestParam String texto) {
        return new ModelAndView( "adminPeliList" ).addObject("pelis", peliRepository.findByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(texto,texto,texto,texto, new PageRequest(pagina,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminUsers" )
    public ModelAndView usuarios() {
        return new ModelAndView( "adminUsers" ).addObject("users",userRepository.findAll(new PageRequest(0,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminListUsers" )
    public ModelAndView usuariosList(@RequestParam int pagina) {
        return new ModelAndView( "adminUserList" ).addObject("users",userRepository.findAll(new PageRequest(pagina,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/buscaAdminUsers" )
    public ModelAndView busquedaUsuarios(@RequestParam String texto) {
        return new ModelAndView( "adminUserList" ).addObject("users",userRepository.findByUsuarioContainsOrEmailContains(texto, texto, new PageRequest(0,5)));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/buscaAdminUsersList" )
    public ModelAndView busquedaUsuarios(@RequestParam int pagina, @RequestParam String texto) {
        return new ModelAndView( "adminUserList" ).addObject("users",userRepository.findByUsuarioContainsOrEmailContains(texto, texto, new PageRequest(pagina,5)));
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/addPeli" )
    public RedirectView añadirPelicula(@RequestParam String nombre, @RequestParam String url, @RequestParam String anio, @RequestParam String director, @RequestParam String reparto, @RequestParam String portada, @RequestParam String valoracion, @RequestParam String descripcion) {
        peliRepository.save(rellenarPelicula(nombre, url, anio, director, reparto, portada, valoracion, descripcion));
        return new RedirectView("adminPelis");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/modificarPelicula" )
    public RedirectView modPelicula(@RequestParam long id, @RequestParam String nombre, @RequestParam String url, @RequestParam String anio, @RequestParam String director, @RequestParam String reparto, @RequestParam String portada, @RequestParam String valoracion, @RequestParam String descripcion) {
        Pelicula peli = rellenarPelicula(nombre, url, anio, director, reparto, portada, valoracion, descripcion);
        peli.setId(id);
        peliRepository.save(peli);

        return new RedirectView("adminPelis");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("eliminaPeli" )
    public RedirectView eliminarPeli(@RequestParam long id){
        peliRepository.delete(id);
        return new RedirectView("adminPelis");
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("eliminaUser" )
    public RedirectView eliminarUser(@RequestParam long id){
        if (userRepository.findOne(id).getUsuario() == "root") {
            userRepository.delete(id);
            return new RedirectView("adminUsers");
        } else {

        }

    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("adminRegisterUsers" )
    public RedirectView register(@RequestParam String username, @RequestParam String email,
                                 @RequestParam String emailConf, @RequestParam String password,
                                 @RequestParam String passwordConf) {

        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
        userRepository.save(new Usuario(username, password, email, Arrays.asList(userRoles)));

        return new RedirectView( "adminUsers" );
    }

    private Pelicula rellenarPelicula(String nombre, String url, String anio, String director, String reparto, String portada, String valoracion, String descripcion){
        try {
            if (anio.equals("")||descripcion.equals("")||portada.equals("")||valoracion.equals("")) {

                RestTemplate restTemplate = new RestTemplate();
                Busqueda busqueda = restTemplate.getForObject( this.url + URLEncoder.encode(nombre, "UTF-8"),Busqueda.class);

                PeliRest peli = busqueda.getResults()[0];
                if (anio.equals("") || anio.equals("0"))
                    anio = peli.getRelease_date().substring(0, 4);
                if (descripcion.equals(""))
                    descripcion = peli.getOverview();
                if (portada.equals(""))
                    portada = "https://image.tmdb.org/t/p/w500" + peli.getPoster_path();
                if (valoracion.equals("") || valoracion.equals("0.0"))
                    valoracion = peli.getVote_average() + "";
            }

            return new Pelicula(nombre, url, descripcion, Integer.parseInt(anio), director, reparto, portada, Double.parseDouble(valoracion));

        }catch(UnsupportedEncodingException | ArrayIndexOutOfBoundsException e){
        }
        return new Pelicula(nombre,url, descripcion, anio.equals("") ? 0 : Integer.parseInt(anio), director, reparto, portada, valoracion.equals("") ? 0 : Integer.parseInt(valoracion));
    }
}
