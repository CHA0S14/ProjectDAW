package com.DAW.Project.Controllers;

import com.DAW.Project.Repositories.PelisRepository;
import com.DAW.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class AdminController {
    @Autowired
    private PelisRepository peliRepository;
    @Autowired
    private UserRepository userRepository;

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
    @RequestMapping("/adminUsersList" )
    public ModelAndView usuariosList(@RequestParam int pagina) {
        return new ModelAndView( "adminUsersList" ).addObject("users",userRepository.findAll(new PageRequest(pagina,5)));
    }
}
