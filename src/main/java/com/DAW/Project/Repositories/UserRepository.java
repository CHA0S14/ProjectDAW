package com.DAW.Project.Repositories;

import com.DAW.Project.Entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ismael on 15/05/2017.
 */
public interface UserRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByEmailAndPass(String email, String pass);
    List<Usuario> findByUsuarioAndPass(String usuario, String pass);
}
