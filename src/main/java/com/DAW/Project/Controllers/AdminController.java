package com.DAW.Project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class AdminController {
    @RequestMapping("/adminPelis" )
    public ModelAndView peliculas() {
        return new ModelAndView( "adminMovies" );
    }
    @RequestMapping("/adminUser" )
    public ModelAndView usuarios() {
        return new ModelAndView( "adminUsers" );
    }
}
