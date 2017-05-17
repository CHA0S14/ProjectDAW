package com.DAW.Project.Controllers;

import com.DAW.Project.Repositories.PelisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    private PelisRepository userRepository;

    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminPelis" )
    public ModelAndView peliculas() {
        return new ModelAndView( "adminMovies" ).addObject("pelis",peliRepository.findByIdIsBetween(0,5));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminListPelis")
    public ModelAndView listPelis(@RequestParam Long id){
        return new ModelAndView( "adminPeliList" ).addObject("pelis",peliRepository.findByIdIsBetween(id,id + 5));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/buscaAdminPelis" )
    public ModelAndView lista(@RequestParam String texto) {
        return new ModelAndView( "adminPeliList" ).addObject("pelis", peliRepository.findTop10ByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(texto,texto,texto,texto));
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/adminUsers" )
    public ModelAndView usuarios() {
        return new ModelAndView( "adminUsers" ).addObject("users",userRepository.findAll());
    }
}
