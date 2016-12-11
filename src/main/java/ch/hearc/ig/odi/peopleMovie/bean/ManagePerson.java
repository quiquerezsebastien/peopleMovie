/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Movie;
import ch.hearc.ig.odi.peopleMovie.business.Person;
import ch.hearc.ig.odi.peopleMovie.exception.InvalidParameterException;
import ch.hearc.ig.odi.peopleMovie.exception.NullParameterException;
import ch.hearc.ig.odi.peopleMovie.exception.UniqueException;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@ManagedBean(name = "managePerson")
@ViewScoped
public class ManagePerson implements Serializable{
    
    @Inject Services service;
    
    Long currentPersonID;
    Person currentPerson;
    Movie movieToBook;

    /**
     * Creates a new instance of ManagePerson
     */
    public ManagePerson() {
        if (currentPerson == null) {
            currentPerson = new Person();
        }
    }

    public Long getCurrentPersonID() {
        return currentPersonID;
    }

    public void setCurrentPersonID(Long currentPersonID) {
        this.currentPersonID = currentPersonID;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public Movie getMovieToBook() {
        return movieToBook;
    }

    public void setMovieToBook(Movie movieToBook) {
        this.movieToBook = movieToBook;
    }
    
    /**
     * Permet d'initialiser une personne par rapport à l'Id reçu en paramètre
     */
    public void initPerson() {
        if (currentPersonID == null) {
            currentPerson = new Person();
        }else{
            currentPerson = service.getPersonWithId(currentPersonID);
        }
    }
    
    /**
     * Permet de d'ajouter une nouvelle personne dans la "base de données"
     *
     * @return
     * @throws NullParameterException
     */
    public String addPerson() throws NullParameterException {
        service.savePerson(currentPerson);
        return "/index.xhtml?faces-redirect=true";
    }

    /**
     * Permet de modifier une personne
     *
     * @return
     */
    public String savePerson() {
        service.getPersonWithId(currentPersonID).setFirstName(currentPerson.getFirstName());
        service.getPersonWithId(currentPersonID).setLastName(currentPerson.getLastName());
        return "/index.xhtml?faces-redirect=true";
    }
    
    /**
     * Permet de supprimer un film d'une personne
     * @param movie Le film à supprimer
     * @throws NullParameterException
     * @throws InvalidParameterException 
     */
    public void deleteMovie(Movie movie) throws NullParameterException, InvalidParameterException{
        service.removeMovieFromPerson(currentPerson, movie);
    }
    
    /**
     * Permet de retourner la liste des films par encore ajoutés à une persone.
     * @return 
     */
    public List<Movie> getMovieToAdd(){
        List<Movie> moviesToReturn = service.getMoviesList();
        
        for(Movie movie : currentPerson.getMovies()){
            moviesToReturn.remove(movie);
        }
        
        return moviesToReturn;
    }
    
    /**
     * Permet d'ajouter un film à une personne.
     */
    public void addMovie() throws NullParameterException, UniqueException{
        service.addMovieToPerson(currentPerson, movieToBook);
    }
}
