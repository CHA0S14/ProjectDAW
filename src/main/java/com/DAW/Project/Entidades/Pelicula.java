package com.DAW.Project.Entidades;

import javax.persistence.*;

/**
 * Created by ismael on 15/05/2017.
 */
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String url;
    @Lob
    @Column(name="descripcion", length=512)
    private String descripcion;
    private int anio;
    private String director;
    private String reparto;
    private String portada;
    private double valoracion;

    public Pelicula() {
    }

    public Pelicula(String nombre, String url, String descripcion, int anio, String director, String reparto, String portada, double valoracion) {
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
        this.anio = anio;
        this.director = director;
        this.reparto = reparto;
        this.portada = portada;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}
