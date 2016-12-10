/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Movie;
import ch.hearc.ig.odi.peopleMovie.exception.NullParameterException;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@ManagedBean(name = "manageMovie")
@ViewScoped
public class ManageMovie implements Serializable{

    private Long currentMovieId;
    private Movie currentMovie;

    @Inject
    Services service;

    /**
     * Creates a new instance of ManageMovie
     */
    public ManageMovie() {
        if (currentMovie == null) {
            currentMovie = new Movie();
        }
    }

    public Long getCurrentMovieId() {
        return currentMovieId;
    }

    public void setCurrentMovieId(Long currentMovieId) {
        this.currentMovieId = currentMovieId;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    /**
     * Permet d'initialiser un film afin de l'afficher.
     */
    public void initMovie() {
        if (currentMovieId == null) {
            currentMovie = new Movie();
        } else {
            currentMovie = service.getMovieWithId(currentMovieId);
        }

    }

    /**
     * Permet de d'ajouter un nouveau film dans la "base de données"
     *
     * @return
     * @throws NullParameterException
     */
    public String addMovie() throws NullParameterException {
        service.saveMovie(currentMovie);
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * Permet de modifier un film
     *
     * @return
     */
    public String saveMovie() {
        service.getMovieWithId(currentMovieId).setName(currentMovie.getName());
        service.getMovieWithId(currentMovieId).setProducer(currentMovie.getProducer());
        return "/index.xhtml?faces-redirect=true";
    }
}
