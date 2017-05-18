package com.DAW.Project.Repositories;

import com.DAW.Project.Entidades.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ismael on 15/05/2017.
 */
public interface PelisRepository extends CrudRepository<Pelicula, Long> {
    Page<Pelicula> findByNombreContainsOrDescripcionContainsOrDirectorContainsOrRepartoContains(String nombre,String descripcion,String director,String reparto, Pageable pageable);
    Page<Pelicula> findAll(Pageable pageable);
}
