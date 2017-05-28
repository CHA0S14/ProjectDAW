package com.DAW.Project.Configuration;

import com.DAW.Project.Entidades.Pelicula;
import com.DAW.Project.Entidades.Usuario;
import com.DAW.Project.Repositories.PelisRepository;
import com.DAW.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by ismael on 16/05/2017.
 */
@Component
public class DatabaseLoader {
    @Autowired
    private PelisRepository peliRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabasePelis() {
        if(!peliRepository.findAll().iterator().hasNext()) {
            // Create
            peliRepository.save(new Pelicula("Alien",
                    "https://www.youtube.com/embed/2jqI2DD621A",
                    "Una escalofriante aventura ve a tener lugar en la nave espacial \"Nostromo\". Siete astronautas--5 hombres y 2 mujeres--serán los protagonistas. De regreso a la Tierra, después de un vuelo espacial de reconocimiento, el ordenador de a bordo recibe un mensaje de procedencia desconocida que cambiará totalmente el rumbo del regreso. Al aterrizar forzosamente para reparar la máquina, detectan una extraña forma de vida que logrará introducirse en la nave... acaba de subir el 8º pasajero. Es entonces cuando empieza una terrible pesadilla, imposible de imaginar..",
                    1979,
                    "Ridley Scott",
                    "Ian Holm, Veronica Cartwright, John Hurt, Sigourney Weaver, Yaphet Kotto, Harry Dean Stanton, Tom Skerritt",
                    "http://mm3.vistoenpantalla.com/imagenes-productos/poster-alien-portada-large2.jpg",
                    9.2));
            peliRepository.save(new Pelicula("Assassin's Creed",
                    "https://www.youtube.com/embed/JFUmrnItaOc",
                    "El nominado al Oscar® Michael Fassbender es Callum Lynch, protagonista de esta aventura basada en el famoso videojuego. Gracias a una revolucionaria tecnología que desbloquea los recuerdos genéticos, Callum descubre que es el descendiente de una sociedad secreta, los Assassins, y que posee increíbles habilidades que le permitirán enfrentarse a la poderosa organización de los Templarios.",
                    2016,
                    "Justin Kurzel",
                    "Michael Fassbender, Marion Cotillard, Jeremy Irons, Brendan Gleeson, Charlotte Rampling, Michael K. Williams",
                    "http://i267.photobucket.com/albums/ii312/fenom_photo/fenom_photo001/assassins%20creed%20pelicula.jpg",
                    4.8));
            peliRepository.save(new Pelicula("Vaiana",
                    "https://www.youtube.com/embed/j0c9XRtizww",
                    "Walt Disney Animation Studios presenta Vaiana, una aventura épica sobre una intrépida adolescente que emprende una arriesgada misión para demostrar que es una navegante consagrada y llevar a término el viaje que nunca concluyeron sus ancestros. En el trayecto, Vaiana conoce al semidiós Maui —muy poderoso en el pasado— y juntos cruzan el océano en un viaje rebosante de acción y diversión en el que se toparán con inmensos animales marinos, submundos sobrecogedores y situaciones inverosímiles. Por el camino, Vaiana descubre lo único que siempre buscó: su identidad.",
                    2016,
                    "John Musker, Ron Clements",
                    "Cristal Barreyro, Marc Ullod, Enriqueta Linares, Eduard Doncos, Eduardo Bosch, Thais Buforn, Pedro José Martos, David Jenner, Cesc Martínez, Meritxell Sota, María Montalà",
                    "http://es.web.img2.acsta.net/pictures/16/09/21/11/18/187024.jpg",
                    7.3));
            peliRepository.save(new Pelicula("Belleza oculta",
                    "https://www.youtube.com/embed/rubNG9tiOkA",
                    "Cuando un exitoso ejecutivo de publicidad de Nueva York sufre una tragedia personal y se retira de su vida, sus amigos crean un plan drástico para llegar a él antes de que lo pierda todo. Al empujarle hasta el fin de sus límites, le obligan a enfrentarse a la verdad de una forma sorprendente y profundamente humana. Del director ganador de un Óscar, David Frankel, este inspirador drama explora cómo hasta la pérdida más profunda puede revelar momentos de belleza, y cómo las constantes de amor, tiempo y muerte se entrelazan en una existencia vivida en plenitud.",
                    2016,
                    "David Frankel",
                    "Will Smith, Edward Norton, Keira Knightley, Michael Peña, Naomie Harris, Jacob Latimore, Kate Winslet, Helen Mirren",
                    "http://www.lahiguera.net/cinemania/pelicula/7768/belleza_oculta-cartel-7157.jpg",
                    5.0));
            peliRepository.save(new Pelicula("Matrix",
                    "https://www.youtube.com/embed/B_Od9VjKdJY",
                    "Neo es el nick en la red que un aparentemente tranquilo trabajador de una empresa de software utiliza en sus pirateos informáticos varios. Su doble vida se ve alterada cuando unas misteriosas frases aparecen en su ordenador entabla contacto telefónico con el que cree que es otro hacker y unos misteriosos agentes comienzan a seguirle. Toda la concepción de la vida que tenía se irá al traste cuando Morfeo le explica que lo que realmente está viviendo no es más que un largo sueño apoyado en realidades virtuales, que no vive en el siglo que cree y que la vida en la Tierra ha cambiado \"un poquito\". (Título original - THE MATRIX) © 1999 Warner Bros. Entertainment Inc. All Rights Reserved.",
                    1999,
                    "Andy Wachowski, Larry Wachowski",
                    "Belinda Mc Clory, Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, Joe Pantoliano, Gloria Foster, Marcus Chong, Julian Arahanga",
                    "http://vignette3.wikia.nocookie.net/doblaje/images/7/7a/Matrix.jpg/revision/latest?cb=20090903030047&path-prefix=es",
                    10));
            peliRepository.save(new Pelicula("Origen",
                    "https://www.youtube.com/embed/8PIPJWei6Hw",
                    "Dom Cobb es un calificado ladrón que roba secretos valiosos de lo más profundo del subconsciente durante el sueño. La rara habilidad de Cobb lo ha convertido en un codiciado jugador en el mundo del espionaje corporativo, pero también lo ha convertido en un fugitivo que le ha costado todo lo que alguna vez ha amado. Ahora a Cobb le ofrecieron una oportunidad de redención. Un último trabajo podría devolverle su vida. (Título original - Inception) Inception © 2010 Warner Bros. Entertainment Inc. and Legendary Pictures.",
                    2010,
                    "Christopher Nolan",
                    "Leonardo Dicaprio, Ken Watanabe, Joseph Gordon-Levitt, Marion Cotillard, Ellen Page, Tom Hardy, Cillian Murphy, Tom Berenger, Michael Caine",
                    "http://www.lashorasperdidas.com/wp-content/uploads//2010/08/critica-de-origen-cartel.jpg",
                    8.9));
        }
    }

    @PostConstruct
    private void initDatabaseUsers() {
        try {
            GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
            GrantedAuthority[] adminRoles = {new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")};
            userRepository.save(new Usuario("root", "toor", "admin@admin.com", Arrays.asList(adminRoles)));
            userRepository.save(new Usuario("user", "pass", "user@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user1", "pass", "user1@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user2", "pass", "user2@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user3", "pass", "user3@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user4", "pass", "user4@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user5", "pass", "user5@user.com", Arrays.asList(userRoles)));
            userRepository.save(new Usuario("user6", "pass", "user6@user.com", Arrays.asList(userRoles)));
        }catch (Exception e){}
    }
}
