/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Movie;
import ch.hearc.ig.odi.peopleMovie.business.Person;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "showPeopleBean")
@RequestScoped
public class ShowPeopleMoviesBean implements Serializable{
    
    @Inject Services service;
    private List<Person> people;
    private List<Movie> movies;
    /**
     * Creates a new instance of ShowPeopleBean
     */
    public ShowPeopleMoviesBean() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    /**
     * Initialisation de toutes les personnes et tous les films.
     * 
     * Permet de les afficher sur la pas d'accueil
     */
    public void initEntities() {
        this.people = service.getPeopleList();
        this.movies = service.getMoviesList();
    }

}
