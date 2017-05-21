package com.DAW.Project.Controllers;

import com.DAW.Project.Entidades.Usuario;
import com.DAW.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView register(@RequestParam String username, @RequestParam String email,
                                 @RequestParam String emailConf, @RequestParam String password,
                                 @RequestParam String passwordConf) {

        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
        userRepository.save(new Usuario(username, password, email, Arrays.asList(userRoles)));

        return new ModelAndView( "redirect:/index" );
    }
}
