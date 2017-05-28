package com.DAW.Project.Repositories;

import com.DAW.Project.Entidades.Pelicula;
import com.DAW.Project.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ismael on 15/05/2017.
 */
public interface UserRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
    List<Usuario> findByUsuarioContainsOrEmailContains(String usuario, String email, Pageable pageable);
    Page<Usuario> findAll(Pageable pageable);
}
