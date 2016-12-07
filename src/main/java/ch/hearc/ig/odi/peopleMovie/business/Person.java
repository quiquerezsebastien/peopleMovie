/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.business;

import ch.hearc.ig.odi.peopleMovie.exception.NullParameterException;
import ch.hearc.ig.odi.peopleMovie.exception.UniqueException;
import java.util.List;

/**
 *
 * @author sebastie.quiquere
 */
public class Person {
    
    private Long id;
    private String firstName;
    private String lastName;
    private List<Movie> movies;

    public Person() {
    }
    
    
    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) throws UniqueException, NullParameterException{
        
//        if (movie == null) {
//            throw new NullParameterException("Le paramètre est null");
//        }
//        else{
//            if (movies.get(movie.getId().intValue()) != null) {
//                movies.add(movie);
//            }
//            else{
//                throw new UniqueException("Le film existe déjà dans la liste");
//            }
//            
//        }
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
    
}
