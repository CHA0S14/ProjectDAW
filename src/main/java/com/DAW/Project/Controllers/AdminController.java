package com.DAW.Project.Controllers;

import com.DAW.Project.Entidades.Pelicula;
import com.DAW.Project.Entidades.Usuario;
import com.DAW.Project.Repositories.PelisRepository;
import com.DAW.Project.Repositories.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("/adminUsers/adminRegisterUsers" )
    public ModelAndView register(@RequestParam String username, @RequestParam String email,
                                 @RequestParam String emailConf, @RequestParam String password,
                                 @RequestParam String passwordConf) {

        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
        userRepository.save(new Usuario(username, password, email, Arrays.asList(userRoles)));

        return new ModelAndView( "redirect:/adminUsers" ).addObject("users",userRepository.findAll(new PageRequest(0,5)));
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
        try {
            if (anio.equals("")||descripcion.equals("")||portada.equals("")||valoracion.equals("")) {
                URL enlace = new URL(this.url + URLEncoder.encode(nombre, "UTF-8"));
                HttpURLConnection conn = (HttpURLConnection) enlace.openConnection();
                conn.connect();


                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
                JsonNode resultsNode = rootNode.path("results");

                JsonNode pelicula = resultsNode.get(0);
                if (anio.equals(""))
                    anio = pelicula.get("release_date").asText().substring(0, 4);
                if (descripcion.equals(""))
                    descripcion = pelicula.get("overview").asText();
                if (portada.equals(""))
                    portada = "https://image.tmdb.org/t/p/w500" + pelicula.get("poster_path").asText();
                if (valoracion.equals(""))
                    valoracion = pelicula.get("vote_average").asText();
            }

            peliRepository.save(new Pelicula(nombre, url, descripcion, Integer.parseInt(anio), director, reparto, portada, Double.parseDouble(valoracion)));

        }catch(Exception e){
            e.printStackTrace();
        }
        return new RedirectView("adminPelis");
    }
}
