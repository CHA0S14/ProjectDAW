package com.DAW.Project.RestClientObjects;

/**
 * Created by ismael on 23/05/2017.
 */
public class Busqueda {
    private int page, total_results, total_pages;
    private PeliRest[] results;

    public Busqueda() {
    }

    public Busqueda(int page, int total_results, int total_pages, PeliRest[] results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public PeliRest[] getResults() {
        return results;
    }

    public void setPeliculas(PeliRest[] results) {
        this.results = results;
    }
}
