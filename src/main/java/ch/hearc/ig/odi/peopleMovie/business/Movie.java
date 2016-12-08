/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.business;

import ch.hearc.ig.odi.peopleMovie.exception.NullParameterException;
import ch.hearc.ig.odi.peopleMovie.exception.UniqueException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastie.quiquere
 */
public class Movie implements Serializable{
    
    private Long id;
    private String name;
    private String producer;
    private List<Person> people;

    public Movie(String producer) {
        this.producer = producer;
        this.people = new ArrayList<>();
    }

    public Movie(Long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.people = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    public void addPerson(Person person) throws UniqueException, NullParameterException {

        if (person == null) {
            throw new NullParameterException("Le paramètre est null");
        } else {
            if (people.size() > 0) {
                for (Person pers : people) {
                    if (pers.getId() == person.getId()) {
                        throw new UniqueException("Le film existe déjà dans la liste");
                    }
                }
            }
            people.add(person);
        }
    }
    
}
