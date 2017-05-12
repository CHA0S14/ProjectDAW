package com.DAW.Project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ismael on 12/05/2017.
 */
@Controller
public class IndexController {
    @RequestMapping("/" )
    public ModelAndView index() {
        return new ModelAndView( "index" );
    }
}
