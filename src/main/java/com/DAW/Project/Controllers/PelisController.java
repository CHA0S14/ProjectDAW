package com.DAW.Project.Controllers;

import com.DAW.Project.Repositories.PelisRepository;
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

import javax.annotation.PostConstruct;
import java.awt.print.Pageable;
import java.util.*;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class PelisController {
    @Autowired
    private PelisRepository repository;

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/peliculas" )
    public ModelAndView peliculas() {
        return new ModelAndView( "peliculas" ).addObject("pelis", repository.findAll(new PageRequest(0,5)))
                .addObject("admin", hasRole("ROLE_ADMIN"));
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/listPelis" )
    public ModelAndView lista(@RequestParam int pagina) {
        return new ModelAndView( "pelisList" ).addObject("pelis", repository.findAll(new PageRequest(pagina,5)));
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/buscaPelis" )
    public ModelAndView busqueda(@RequestParam String texto) {
        return new ModelAndView( "pelisList" ).addObject("pelis", repository.findByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(texto,texto,texto,texto, new PageRequest(0,5)));
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/buscaPelisList" )
    public ModelAndView busquedaLista(@RequestParam String texto, @RequestParam int pagina) {
        return new ModelAndView( "pelisList" ).addObject("pelis", repository.findByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(texto,texto,texto,texto, new PageRequest(pagina,5)));
    }
    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping("/reproductor" )
    public ModelAndView reproductor(@RequestParam Long id) {
        return new ModelAndView( "reproductor" ).addObject("peli", repository.findOne(id)).addObject("pelis", repository.findAll(new PageRequest(0,5)))
                .addObject("admin", hasRole("ROLE_ADMIN"));
    }

    protected boolean hasRole(String role) {
        // get security context from thread local
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null)
            return false;

        Authentication authentication = context.getAuthentication();
        if (authentication == null)
            return false;

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (role.equals(auth.getAuthority()))
                return true;
        }

        return false;
    }
}
