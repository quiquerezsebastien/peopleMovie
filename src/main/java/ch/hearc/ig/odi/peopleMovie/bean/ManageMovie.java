/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Movie;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "manageMovie")
@RequestScoped
public class ManageMovie {
    
    int currentMovieId;
    Movie currentMovie;
    
    @Inject Services service;
    /**
     * Creates a new instance of ManageMovie
     */
    public ManageMovie() {
    }

    public int getCurrentMovieId() {
        return currentMovieId;
    }

    public void setCurrentMovieId(int currentMovieId) {
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
            currentMovie = service.getMovieWithId(new Long(currentMovieId));
    }
}
