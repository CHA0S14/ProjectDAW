package com.DAW.Project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class PelisController {
    @RequestMapping("/peliculas" )
    public ModelAndView peliculas() {
        return new ModelAndView( "peliculas" );
    }
    @RequestMapping("/reproductor" )
    public ModelAndView reproductor() {
        return new ModelAndView( "visionado" );
    }
}
