package com.DAW.Project.Repositories;

import com.DAW.Project.Entidades.Pelicula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ismael on 15/05/2017.
 */
public interface PelisRepository extends CrudRepository<Pelicula, Long> {
    List<Pelicula> findByNombreContaining(String nombre);
    List<Pelicula> findByDescripcionContaining(String descripcion);
    List<Pelicula> findByDirectorContaining(String director);
    List<Pelicula> findByRepartoContaining(String reparto);
    List<Pelicula> findByValoracionIsGreaterThan(double valoracion);
    List<Pelicula> findByAnio(int anio);
    List<Pelicula> findByIdIsBetween(long ini, long fin);
}
