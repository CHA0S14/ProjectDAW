package com.DAW.Project.Controllers;

import com.DAW.Project.Entidades.Usuario;
import com.DAW.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;

/**
 * Created by ismael on 12/05/2017.
 */
@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView( "index" );
    }

    @RequestMapping("/registerUsers" )
    public RedirectView añadirUser(@RequestParam String username, @RequestParam String email,
                                 @RequestParam String emailConf, @RequestParam String password,
                                 @RequestParam String passwordConf) {

        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
        try {
            userRepository.save(new Usuario(username, password, email, Arrays.asList(userRoles)));
        }catch(Exception e){
            return new RedirectView( "/?regError" );
        }

        return new RedirectView( "/?registered" );
    }
}
