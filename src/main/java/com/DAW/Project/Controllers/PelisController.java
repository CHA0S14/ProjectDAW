package com.DAW.Project.Controllers;

import com.DAW.Project.Entidades.Pelicula;
import com.DAW.Project.Repositories.PelisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * Created by ismael on 14/05/2017.
 */
@Controller
public class PelisController {
    @Autowired
    private PelisRepository repository;

    @PostConstruct
    private void initDatabase() {
        // Create
        repository.save(new Pelicula("Alien",
                "https://www.youtube.com/embed/2jqI2DD621A",
                "Una escalofriante aventura ve a tener lugar en la nave espacial \"Nostromo\". Siete astronautas--5 hombres y 2 mujeres--serán los protagonistas. De regreso a la Tierra, después de un vuelo espacial de reconocimiento, el ordenador de a bordo recibe un mensaje de procedencia desconocida que cambiará totalmente el rumbo del regreso. Al aterrizar forzosamente para reparar la máquina, detectan una extraña forma de vida que logrará introducirse en la nave... acaba de subir el 8º pasajero. Es entonces cuando empieza una terrible pesadilla, imposible de imaginar..",
                1979,
                "Ridley Scott",
                "Ian Holm, Veronica Cartwright, John Hurt, Sigourney Weaver, Yaphet Kotto, Harry Dean Stanton, Tom Skerritt",
                "http://mm3.vistoenpantalla.com/imagenes-productos/poster-alien-portada-large2.jpg",
                9.2));
        repository.save(new Pelicula("Assassin's Creed",
                "https://www.youtube.com/embed/JFUmrnItaOc?list=PLHPTxTxtC0ibQ0rWXdmfxuVFiIGhWHn2C",
                "El nominado al Oscar® Michael Fassbender es Callum Lynch, protagonista de esta aventura basada en el famoso videojuego. Gracias a una revolucionaria tecnología que desbloquea los recuerdos genéticos, Callum descubre que es el descendiente de una sociedad secreta, los Assassins, y que posee increíbles habilidades que le permitirán enfrentarse a la poderosa organización de los Templarios.",
                2016,
                "Justin Kurzel",
                "Michael Fassbender, Marion Cotillard, Jeremy Irons, Brendan Gleeson, Charlotte Rampling, Michael K. Williams",
                "http://i267.photobucket.com/albums/ii312/fenom_photo/fenom_photo001/assassins%20creed%20pelicula.jpg",
                4.8));
    }

    @RequestMapping("/peliculas" )
    public ModelAndView peliculas() {
        return new ModelAndView( "peliculas" ).addObject("pelis", repository.findByIdIsBetween(0,5));
    }
    @RequestMapping("/listPelis" )
    public ModelAndView lista(@RequestParam Long id) {
        return new ModelAndView( "pelisList" ).addObject("pelis", repository.findByIdIsBetween(id,id+5));
    }
    @RequestMapping("/reproductor" )
    public ModelAndView reproductor() {
        return new ModelAndView( "visionado" );
    }
}
